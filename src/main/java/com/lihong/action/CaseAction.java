package com.lihong.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lihong.bean.Case;
import com.lihong.common.bean.PageBean;
import com.lihong.service.CaseService;
@Controller
public class CaseAction{
	@Autowired
	private CaseService caseService;
	
	
	@RequestMapping(value="/case/{id}",method = RequestMethod.GET)
	public String index(@PathVariable Long id,Model model){
        List<Case> cs = caseService.getCase(id);
		model.addAttribute("cases",cs); 
		return "case/caseShow";
	}

	@RequestMapping(value="/cases",method = RequestMethod.GET)
	public String casesList(HttpServletRequest request){
		return "case/cases";
	}
	
	@RequestMapping(value="/casess",method = RequestMethod.GET)
	public @ResponseBody PageBean cases(@RequestParam Integer page,@RequestParam Integer rows){
       PageBean<Case> pageBean = caseService.getPage(page, rows);
		return pageBean;
	}
}
