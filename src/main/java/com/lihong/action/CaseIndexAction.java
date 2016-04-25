package com.lihong.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lihong.bean.CaseIndex;
import com.lihong.common.bean.DPageBean;
import com.lihong.common.bean.PageBean;
import com.lihong.common.bean.ResultObj;
import com.lihong.dto.CaseIndexPageBeanDto;
import com.lihong.service.CaseIndexService;
@Controller
public class CaseIndexAction{
    
    private static Logger logger = Logger.getLogger(CaseIndexAction.class);
	
    @Autowired
    private CaseIndexService caseIndexService;
    
    private Long finished;
    private Long caseIndexCount;
	

	@RequestMapping(value="/rebuildIndex",method = RequestMethod.GET)
	public @ResponseBody ResultObj caseIndexs(){
	    ResultObj resultObj;
	    if(caseIndexCount == null) {
	        caseIndexCount = caseIndexService.getAllCount();
	        List<CaseIndex> caseIndexs = caseIndexService.getAll();
	        for(CaseIndex caseIndex : caseIndexs){
	            long caseId = caseIndex.getCaseId();
	            finished++;
	            if(finished == caseIndexCount){
	                caseIndexCount = null;
	            }
	        }
	        resultObj = new ResultObj(0, "重建成功");
	    }else{
	        resultObj = new ResultObj(0, "重建成功");
	    }
	   
	    
		return resultObj;
	}
	

    @RequestMapping(value="/caseIndexs",method = RequestMethod.POST)
    @ResponseBody
    public  PageBean<CaseIndex> caseIndexs(CaseIndexPageBeanDto caseIndexPageBeanDto,@RequestParam Integer draw,@RequestParam Integer length){
        PageBean<CaseIndex> caseBean =  caseIndexService.getPage(draw,length,caseIndexPageBeanDto);
        return caseBean;
    }
    
    @RequestMapping(value="/unfinishCaseIndexs",method = RequestMethod.POST)
    @ResponseBody
    public  PageBean<CaseIndex> unfinishCaseIndexs(CaseIndex caseIndex,@RequestParam Integer currentPage,@RequestParam Integer pageSize){
        DPageBean<CaseIndex> pages = (DPageBean<CaseIndex>) caseIndexService.getPage(currentPage, pageSize);
        return pages;
    }

}
