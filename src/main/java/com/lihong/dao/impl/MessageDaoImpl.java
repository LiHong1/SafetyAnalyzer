package com.lihong.dao.impl;

import java.util.List;

import com.lihong.bean.Message;
import com.lihong.common.bean.PageBean;
import com.lihong.common.daoImpl.BaseDaoImpl;
import com.lihong.dao.MessageDao;
import com.lihong.dto.MessageDto;

public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao {

	public MessageDaoImpl() {
		super(MessageDao.class);
	}

	 public PageBean<Message> getPage(int currentPage, int pageSize,Message Message) {
         /*long beginPosition = (long)(currentPage-1)*pageSize;
         casePageBeanDto.setBeginPosition(beginPosition);
         casePageBeanDto.setEndPosition(beginPosition+pageSize); 
         List<Case> data =  this.getSqlSession().selectList(getMethodPath("getPageByParam"),casePageBeanDto);
         Long allCount = this.getSqlSession().selectOne(getMethodPath("getCountByParam"),casePageBeanDto);
         PageBean<Case> page = new EPageBean<Case>(pageSize,data,allCount,currentPage);*/
         return null;
     }

    public List<Message> getMessage(MessageDto messageDto) {
        List<Message> data =  this.getSqlSession().selectList(getMethodPath("getMessageByParam"),messageDto);
        return data;
    }
}