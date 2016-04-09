package com.lihong.bean;

import java.util.ArrayList;
import java.util.List;

public class AllKeywords {
     public static String allKeyword;
     private static List<Keyword> keywords = new ArrayList<Keyword>() ;
     
	public static String getAllKeyword() {
		return allKeyword;
	}
	
	
	
	public static void setAllKeyword() {
		StringBuffer s = new StringBuffer();
		for(Keyword keyword:keywords)
			s.append(keyword.getWord());
		  allKeyword = s.toString();
	}
	
	public List<Keyword> getKeywords() {
		return keywords;
	}
	
	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}



	public static void init(List<Keyword> ks) {
		keywords = ks;
		setAllKeyword();
	}
	
	
     
}
