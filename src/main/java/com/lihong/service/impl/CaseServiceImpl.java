package com.lihong.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.transaction.annotation.Transactional;

import com.lihong.bean.Case;
import com.lihong.bean.CaseIndex;
import com.lihong.bean.Dictionary;
import com.lihong.common.bean.PageBean;
import com.lihong.common.util.ExcelUtil;
import com.lihong.dao.CaseDao;
import com.lihong.dao.CaseIndexDao;
import com.lihong.dao.DictionaryDao;
import com.lihong.dto.CaseDto;
import com.lihong.dto.CasePageBeanDto;
import com.lihong.service.CaseService;

public class CaseServiceImpl extends BaseServiceImpl<Case> implements CaseService{
    private final Integer cols = 3;
    private DictionaryDao dictionaryDao;
    private CaseIndexDao caseIndexDao;
    
	public DictionaryDao getDictionaryDao() {
        return dictionaryDao;
    }

    public void setDictionaryDao(DictionaryDao dictionaryDao) {
        this.dictionaryDao = dictionaryDao;
    }

    public CaseIndexDao getCaseIndexDao() {
        return caseIndexDao;
    }

    public void setCaseIndexDao(CaseIndexDao caseIndexDao) {
        this.caseIndexDao = caseIndexDao;
    }

    /**
     * 删除对象
     */
    public void delete(Long id) {
        baseDao.delete(id);
        caseIndexDao.add(new CaseIndex(id, '2',Calendar.getInstance().getTime(),null));
    }
    
    public void add(Case t){
        baseDao.add(t);
        caseIndexDao.add(new CaseIndex(t, '0'));
    }
    
    
    public List<Case> getCase(Long id) {
		Case c;
		List<Case> cases = ((CaseDao)baseDao).getCase(id);
		if(cases.size()==3){
			c = cases.get(1);
			cases.set(1, cases.get(0));
			cases.set(0, c);
		}else if(cases.size()==2){
			if(cases.get(1).getId()==id){
				c = cases.get(1);
				cases.set(1, cases.get(0));
				cases.set(0, c);
			}
		}
		return cases;
	}

    public List<CaseDto> getCase(InputStream inputStream) {
        String [][] datas =  ExcelUtil.readExcel(inputStream, null, cols);
  
        List<CaseDto> cases = new ArrayList<CaseDto>();
        for(int i = 1 ; i < datas.length ; i++){
            String title = datas[i][0].trim();
            String content = datas[i][1].trim();
            String type = datas[i][2].trim();
            
            if(!title.equals("") || !content.equals("") || !type.equals("") ){
                
                CaseDto c = new CaseDto(title,content,type);
                cases.add(c);
            }
        }
        return cases;
    }
    
    public PageBean<Case> getPage(int currentPage, int pageSize, CasePageBeanDto casePageBeanDto) {
        return ((CaseDao)baseDao).getPage(currentPage, pageSize, casePageBeanDto);
    }
    
 
    /**
     * 增加合法的Case
     * @param caseDtos
     * @return
     */
    public int addCase(List<CaseDto> caseDtos){
        List<Dictionary> dictionaries;
        dictionaries = dictionaryDao.getByName("case_type");
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum;
        int count = 0;
        for(CaseDto caseDto:caseDtos){
           caseDto.setCreatedDate(Calendar.getInstance().getTime());  
           isNum =  pattern.matcher(caseDto.getType());
           if(isNum.matches() && isExist(dictionaries, caseDto.getType())){
               Integer caseType = Integer.parseInt(caseDto.getType());
               Case c = new Case(caseDto.title,caseDto.content,caseType);
               this.add(c);
               count++;
           }      
        }
        
        return count;
    }

    public void add(List<Case> cases) {
       for(Case c : cases){
           this.add(c);
       }
    }

    
    /**
     * 判断 Case type 是否存在
     * @param dictionaries
     * @param value
     * @return
     */
    public boolean isExist(List<Dictionary> dictionaries, String value) {
            for(Dictionary dictionary : dictionaries){
                if (dictionary.getId()==Integer.parseInt(value)) {
                    return true;
                }
            }
            return false;
    }
 
}
