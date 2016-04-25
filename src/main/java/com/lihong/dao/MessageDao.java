package com.lihong.dao;

import java.util.List;

import com.lihong.bean.Case;
import com.lihong.bean.Message;
import com.lihong.common.bean.PageBean;
import com.lihong.common.dao.BaseDao;
import com.lihong.dto.CasePageBeanDto;
import com.lihong.dto.MessageDto;

public interface MessageDao extends BaseDao<Message>{

	/**
     * 带参数的查询
     * @param currentPage
     * @param pageSize
     * @param t
     * @return
     */
    public PageBean<Message> getPage(int currentPage,int pageSize,Message message);
    
    /**
     * 
     * @param messageDto
     * @return
     */
    public List<Message> getMessage(MessageDto messageDto);
    
  
}
