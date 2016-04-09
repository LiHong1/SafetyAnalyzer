package com.lihong.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;


/**
 * 领域对象
 *
 * @author leizhenchun
 */
@MappedSuperclass
public class DomainObject implements Serializable {


    private Long id;
   
    // 创建时间
    private Calendar createdDate = Calendar.getInstance();
    // 最后更新时间
    private Calendar updatedDate;

    //用于页面显示的创建时间
    private Date createTime;
    //用于页面显示更新时间
    private Date updateTime;


  

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
     * 获取创建日期
     *
     * @return
     */
    public Calendar getCreatedDate() {
        return createdDate;
    }

    /**
     * 设置创建日期，<p><b>直接保存对象时不需要调用此方法</b>
     * <p>
     * 此方法无效，对象创建日期在保存的时候由系统自动设置，不需要重复设置
     * <p>
     *
     * @param createdDate
     */
    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
        if(createdDate!=null)
            this.setCreateTime(createdDate.getTime());
    }

  
    /**
     * 获取最后更新日期
     *
     * @return
     */
    public Calendar getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 设置最后更新日期，<p><b>直接更新对象时不需要调用此方法</b>
     * <p>
     * 此方法无效，对象更新日期在保存的时候由系统自动设置，不需要重复设置
     * <p>
     *
     * @param updatedDate
     */
    public void setUpdatedDate(Calendar updatedDate) {
        this.updatedDate = updatedDate;
        if(updatedDate !=null)
            this.setUpdateTime(updatedDate.getTime());
    }


    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date date) {
        this.createTime = date;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date date) {
        this.updateTime = date;
    }
}