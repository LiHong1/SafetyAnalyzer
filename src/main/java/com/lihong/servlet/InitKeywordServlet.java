package com.lihong.servlet;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lihong.bean.AllKeywords;
import com.lihong.bean.Keyword;
import com.lihong.service.KeywordService;

public class InitKeywordServlet extends HttpServlet {
	private KeywordService keywordService;
	
	public void init() throws ServletException {
		Logger log = Logger.getLogger(InitKeywordServlet.class);  
		ApplicationContext app = new  ClassPathXmlApplicationContext("spring/applicationContext.xml");
		keywordService = app.getBean(KeywordService.class);
		List<Keyword> keywords = keywordService.getAll();
		AllKeywords allKeywords = new AllKeywords();
		allKeywords.setKeywords(keywords);
		allKeywords.setAllKeyword();
		log.info("init Keywords");
		
		
	}

}
