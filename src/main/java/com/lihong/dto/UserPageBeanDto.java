package com.lihong.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.lihong.bean.User;

public class UserPageBeanDto extends User{
    public Long beginPosition;
    public Long endPosition;
    //用于页面显示的创建时间
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date createdDateBegin;
    //用于页面显示更新时间
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date createdDateEnd;
    
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
    public Date getCreatedDateBegin() {
        return createdDateBegin;
    }
    public void setCreatedDateBegin(Date createdDateBegin) {
        this.createdDateBegin = createdDateBegin;
    }
    public Date getCreatedDateEnd() {
        return createdDateEnd;
    }
    public void setCreatedDateEnd(Date createdDateEnd) {
        this.createdDateEnd = createdDateEnd;
    }
    
}
