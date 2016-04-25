package com.lihong.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 *
 * 
 * @author li hong
 * 
 */
public class Case extends DomainObject{


	private String keywords;
	@NotNull(message="{javax.validation.constraints.NotNull.message}")  
    @Size(max=20,message="{maxlength}") 
	private String content;
	@NotNull(message="{javax.validation.constraints.NotNull.message}") 
	private String title;
	@NotNull(message="{javax.validation.constraints.NotNull.message}") 
	private Integer type;
	
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
	
	public Case(String title, String content, Integer type) {
        super();
        this.title = title;
        this.content = content;
        this.type = type;
    }
	
	public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Case(){
		
	}



}
