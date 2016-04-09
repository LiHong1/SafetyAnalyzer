package com.lihong.common.util;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.wltea.analyzer.IKSegmentation;
import org.wltea.analyzer.Lexeme;

import com.lihong.bean.AllKeywords;


public class SegmentUtil {
	 public static Map<String,Integer> Segment(String text){
		    IKSegmentation seg = null;  
	        StringReader reader = new StringReader(text);  
	        seg = new IKSegmentation(reader,true);  
	        Lexeme lex= new Lexeme(0, 0, 0, 0);  
	        Map<String,Integer> words = new HashMap<String, Integer>();
	        Map<String,Integer> AfterfilterWords = new HashMap<String,Integer>(); 
	        try {  
	            while((lex = seg.next()) != null)  
	            {   
	            	String word = lex.getLexemeText();
	            	if(word.length()>1){
	            		if(words.containsKey(word))
	            			words.put(word, words.get(word)+1);
	            		else
	            			words.put(word, 1);
	            	}
	            }  
	       
	          
	            String allKeywords=AllKeywords.getAllKeyword();
	          for(Entry<String, Integer> entry:words.entrySet()){
	            	if(allKeywords != null&&allKeywords.contains(entry.getKey()))
	            		AfterfilterWords.put(entry.getKey(), entry.getValue());      
	            }
	            	
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	        return AfterfilterWords;
	 }
	
	
}
