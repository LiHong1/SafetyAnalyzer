package com.lihong.bean;

/**
 *
 * 
 * @author li hong
 * 
 */
public class Case extends DomainObject{


	public String keywords;
	public String content;
	public String title;
	
	public String getKeyWords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Case(String keywords, String content, String title) {
		super();
		this.keywords = keywords;
		this.content = content;
		this.title = title;
	}
	public Case(){
		
	}



}
