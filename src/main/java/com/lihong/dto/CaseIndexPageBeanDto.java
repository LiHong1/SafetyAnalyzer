package com.lihong.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.lihong.bean.CaseIndex;
/**
 *
 * 
 * @author li hong
 * 
 */
public class CaseIndexPageBeanDto extends CaseIndex{

	public Long beginPosition;
	public Long endPosition;

	

    public CaseIndexPageBeanDto(){
		
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



}
