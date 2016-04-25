package com.lihong.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 *
 * 
 * @author li hong
 * 
 */
public class CasePageBeanDto extends CaseDto{

	public Long beginPosition;
	public Long endPosition;
    //用于页面显示的创建时间
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date createdDate;
    //用于页面显示更新时间
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date updatedDate;


	public CasePageBeanDto(String title, String content, String type) {
        this.title = title;
        this.content = content;
        this.type = type;
    }
	
	

    public CasePageBeanDto(){
		
	}

    public Long getBeginPosition() {
        return beginPosition;
    }

    public void setBeginPosition(Long beginPosition) {
        this.beginPosition = beginPosition;
    }

    public Long getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Long endPosition) {
        this.endPosition = endPosition;
    }

  

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

  


}
