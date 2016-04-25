package com.lihong.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.lihong.bean.DomainObject;
/**
 *
 * 
 * @author li hong
 * 
 */
public class CaseDto extends DomainObject{


	public String keywords;
	public String content;
	public String title;
	public String type;
	
	
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


	public CaseDto(String title, String content, String type) {
        this.title = title;
        this.content = content;
        this.type = type;
    }
	
	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CaseDto(){
		
	}



}
