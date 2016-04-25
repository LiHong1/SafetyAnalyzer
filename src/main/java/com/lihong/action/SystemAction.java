package com.lihong.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lihong.bean.CaseIndex;
import com.lihong.common.bean.PageBean;
import com.lihong.common.bean.ResultObj;
import com.lihong.dto.CaseIndexPageBeanDto;
import com.lihong.service.CaseIndexService;
@Controller
public class SystemAction {
    @Autowired
    private CaseIndexService caseIndexService;
    
    @RequestMapping(value="/keyword",method = RequestMethod.GET)
    public String keywordList(HttpServletRequest request){
        return "keyword/keyword";
    }
    
    @RequestMapping(value="/indexSet",method = RequestMethod.GET)
    public String indexSet(Model model){
        return "system/indexSet";
    }
    
    @RequestMapping(value="/quartzSet",method = RequestMethod.GET)
    public String quartzSet(Model model){
        return "system/quartzSet";
    }
    
    @RequestMapping(value="/quartzSet",method = RequestMethod.POST)
    public String quartzSet(){
        return "system/quartzSet";
    }
    
}
