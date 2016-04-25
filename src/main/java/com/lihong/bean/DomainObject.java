package com.lihong.bean;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;


/**
 * 领域对象
 *
 * @author lihong
 */

public class DomainObject implements Serializable {


    private Long id;
    
    //用于页面显示的创建时间
    //用于页面显示的创建时间
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
    private Date createdDate;
    //用于页面显示更新时间
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
    private Date updatedDate;


  

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date date) {
        this.createdDate = date;
    }

    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(Date date) {
        this.updatedDate = date;
    }
}