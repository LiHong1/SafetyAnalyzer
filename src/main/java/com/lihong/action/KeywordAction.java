package com.lihong.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lihong.bean.Case;
import com.lihong.bean.Keyword;
import com.lihong.common.bean.PageBean;
import com.lihong.service.KeywordService;

@Controller
public class KeywordAction{
	@Autowired
	private KeywordService keywordService;
	@RequestMapping(value="/keyword",method = RequestMethod.GET)
	public String keywordList(HttpServletRequest request){
		return "keyword/keyword";
	}
	
	@RequestMapping(value="/keyword",method = RequestMethod.POST)
	public @ResponseBody PageBean getPageBean(@RequestParam Integer page,@RequestParam Integer rows){
       PageBean<Keyword> pageBean = keywordService.getPage(page, rows);
		return pageBean;
	}
	
}
