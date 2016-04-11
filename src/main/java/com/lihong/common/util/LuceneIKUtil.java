package com.lihong.common.util;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import net.paoding.analysis.analyzer.PaodingAnalyzer;


import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.lihong.bean.Case;
import com.lihong.servlet.InitKeywordServlet;




public class LuceneIKUtil {
    
    private static Logger log = Logger.getLogger(LuceneIKUtil.class); 
    
    private static Directory directory ;
    private static Analyzer analyzer ;
    
    static {
    	 try {
			directory = FSDirectory.open(new File("/luence/index"));
			 analyzer = new IKAnalyzer(true);//
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 带参数构造,参数用来指定索引文件目录
     * @param indexFilePath
     */
    public LuceneIKUtil(String indexFilePath){
        try {
        	 directory = FSDirectory.open(new File(indexFilePath));
            //analyzer = new StandardAnalyzer(Version.LUCENE_31);
            //analyzer = new IKAnalyzer(true);//
            //analyzer =  new PaodingAnalyzer(indexFilePath); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 默认构造,使用系统默认的路径作为索引
     */
    public LuceneIKUtil(){
    }
    
    
    /**
     * 创建索引
     * Description：
     * @throws Exception
     */
    public static void createIndex(List<Case> list)throws Exception{
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_31, analyzer);
        IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
        indexWriter.deleteAll();
        for(int i=0; i<list.size(); i++){
            Case c = list.get(i);
            Document document = addDocument(c.getId(), c.getTitle(),c.getKeyWords(),c.getContent());
            indexWriter.addDocument(document);
        }
        
        indexWriter.close();
    }
    
    /**
     * 
     * Description：
     * @param id
     * @param title
     * @param content
     * @return
     */
    public static Document addDocument(Long id, String title,String keywords,String content){
        Document doc = new Document();
        //Field.Index.NO 表示不索引         
        //Field.Index.ANALYZED 表示分词且索引         
        //Field.Index.NOT_ANALYZED 表示不分词且索引
//        doc.add(new StringField("id", id.toString(), Field.Store.YES));
//        doc.add(new StringField("title", title, Field.Store.YES));
//        doc.add(new StringField("keywords",keywords,Field.Store.YES));
        doc.add(new Field("id",String.valueOf(id),Field.Store.YES,Field.Index.NOT_ANALYZED));
        doc.add(new Field("title",title,Field.Store.YES,Field.Index.ANALYZED));
        doc.add(new Field("keywords",keywords,Field.Store.YES,Field.Index.ANALYZED));
        doc.add(new Field("content",content,Field.Store.YES,Field.Index.ANALYZED));
        return doc;
    }
    
    /**
     * 
     * Description： 更新索引
     * @param id
     * @param title
     * @param content
     */
    public static void update(Long id,String title, String keywords,String content){
        try {
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_31, analyzer);
            IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
            Document document = addDocument(id, title, keywords,content);
            Term term = new Term("id",String.valueOf(id));
            indexWriter.updateDocument(term, document);
            indexWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * Description：按照ID进行索引
     * @param id
     */
    public static void delete(Long id){
        try {
        	IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_31, analyzer);
            IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
            Term term = new Term("id",String.valueOf(id));
            indexWriter.deleteDocuments(term);
            indexWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * Description：查询
     * @param where 查询条件
     * @param scoreDoc 分页时用
     * @throws IOException 
     */
    public static List<Case> search(String[] fields,String keyword) throws IOException{
        
        IndexSearcher indexSearcher = null;
        List<Case> result = new ArrayList<Case>();
        
        try {
            //创建索引搜索器,且只读
        	// IndexReader indexReader = DirectoryReader.open(directory);
            indexSearcher = new IndexSearcher(directory);

            MultiFieldQueryParser queryParser =new MultiFieldQueryParser(Version.LUCENE_31,fields,analyzer);
            Query query = queryParser.parse(keyword);
            
            //返回前number条记录
            TopDocs topDocs = indexSearcher.search(query, 4);
            //信息展示
            int totalCount = topDocs.totalHits;
            log.info("共检索出 "+totalCount+" 条记录");
            
            
            //高亮显示
            /*  
                  创建高亮器,使搜索的结果高亮显示
                SimpleHTMLFormatter：用来控制你要加亮的关键字的高亮方式
                此类有2个构造方法
                1：SimpleHTMLFormatter()默认的构造方法.加亮方式：<B>关键字</B>
                2：SimpleHTMLFormatter(String preTag, String postTag).加亮方式：preTag关键字postTag
             */
            Formatter formatter = new SimpleHTMLFormatter("<font color='red'>","</font>");    
            /*
                 QueryScorer
                QueryScorer  是内置的计分器。计分器的工作首先是将片段排序。QueryScorer使用的项是从用户输入的查询中得到的；
						                它会从原始输入的单词、词组和布尔查询中提取项，并且基于相应的加权因子（boost factor）给它们加权。
						                为了便于QueryScoere使用，还必须对查询的原始形式进行重写。
						                比如，带通配符查询、模糊查询、前缀查询以及范围查询 等，都被重写为BoolenaQuery中所使用的项。
						                在将Query实例传递到QueryScorer之前，可以调用Query.rewrite (IndexReader)方法来重写Query对象 
             */
            Scorer fragmentScorer = new QueryScorer(query);
            Highlighter highlighter = new Highlighter(formatter,fragmentScorer);
            Fragmenter fragmenter = new SimpleFragmenter(100);
            /*    
                Highlighter利用Fragmenter将原始文本分割成多个片段。
                      内置的SimpleFragmenter将原始文本分割成相同大小的片段，片段默认的大小为100个字符。这个大小是可控制的。
             */
            highlighter.setTextFragmenter(fragmenter);
            
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            
            for(ScoreDoc scDoc : scoreDocs){
                Document  document = indexSearcher.doc(scDoc.doc);
                Long id = Long.parseLong(document.get("id"));
                String title = document.get("title");
                String keywords = document.get("keywords");
                String content = document.get("content");
                float score = scDoc.score; //相似度
                String lighterTitle = highlighter.getBestFragment(analyzer, "title", title);
                if(null==lighterTitle){
                    lighterTitle = title;
                }
                
                String lighterKeywords = highlighter.getBestFragment(analyzer, "keywords", keywords);
                if(null==lighterKeywords){
                    lighterKeywords = keywords;
                }
                String lighterContent = highlighter.getBestFragment(analyzer, "content", content);
                if(null==lighterContent){
                	lighterContent = content;
                }
                
                Case c = new Case(); 
                
                c.setId(id);
                c.setTitle(lighterTitle);
                c.setKeywords(lighterKeywords);
                c.setContent(lighterContent);
                result.add(c);
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            indexSearcher.close();
        }
    
        return result;
    }
   
    public static Case search(Map<String,Integer> map){
    	 StringBuffer keyword = new StringBuffer();
	     for(String s:map.keySet())
	    	 keyword.append(s);
    	 //LuceneIKUtil luceneProcess = new LuceneIKUtil ("d:/luence/index");
         /*try {
             luceneProcess.createIndex();
         } catch (Exception e) {
             e.printStackTrace();
         }*/
         //修改测试
        // luceneProcess.update(2, "测试内容", "修改测试。。。");
         
         //查询测试
         String [] fields = {"content"};
         List<Case> list;
        try {
            list = LuceneIKUtil.search(fields,keyword.toString());
            for(int i=0; i<list.size(); i++){
                Case c = list.get(i);
                log.info("("+c.getId()+")" +c.getKeyWords());
            }
            return evaluate(list,map);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
       
         //删除测试
         //luenceProcess.delete(1);
    }
    public static Case evaluate(List<Case> list,Map<String,Integer> map){
    	Map<Integer,Case> cases = new HashMap<Integer, Case>();
    	if(list != null){
    		for(int i = 0; i < list.size() ;i++){
    			Case c = list.get(list.size()-i-1);
        		String keywords = c.getContent();  //这里需修改
        		int count = 0;
        		for(String s:map.keySet()){
        			if(keywords.contains(s))
        				count ++;		
        		}
        			if(count >= 2){
        				cases.put(count, c);
        			}
        	}
    		if(cases.size()>0){
    			 int count = 0;
    			 for(Integer key :cases.keySet())
    		    	 if(key > count)
    		    		 count = key;
    			 return cases.get(count);
    		}
    	}
    	
   
    	 return null;
    }
}