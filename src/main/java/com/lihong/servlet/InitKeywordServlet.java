package com.lihong.servlet;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lihong.bean.AllKeywords;
import com.lihong.bean.Keyword;
import com.lihong.netty.NettyServer;
import com.lihong.service.KeywordService;

public class InitKeywordServlet extends HttpServlet {
	private KeywordService keywordService;
	private NettyServer nettyServer;
	
	public void init() throws ServletException {
		Logger log = Logger.getLogger(InitKeywordServlet.class);  
		ApplicationContext app = new  ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		keywordService = app.getBean(KeywordService.class);
		if (keywordService == null){
		    log.error("keywords init failure....");
		}else{
		    List<Keyword> keywords = keywordService.getAll();
	        AllKeywords.init(keywordService.getAll());
	        log.info("init Keywords Success.............");
		}
		
		nettyServer = app.getBean(NettyServer.class);
		if (nettyServer == null){
		    log.error("nettyServer start failure....");
		}else{
		   // nettyServer.start();
        }
		
		
	}

}
