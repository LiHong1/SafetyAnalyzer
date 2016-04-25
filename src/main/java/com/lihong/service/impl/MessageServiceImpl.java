package com.lihong.service.impl;

import java.util.List;

import com.lihong.bean.Message;
import com.lihong.dao.MessageDao;
import com.lihong.dto.MessageDto;
import com.lihong.service.MessageService;

public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService{
    
    /**
     * 删除对象
     */
    public void delete(Long id) {
        baseDao.delete(id);
    }

    public void add(Message message) {
       baseDao.add(message);
    }

    public List<Message> getMessage(MessageDto messageDto) {
        return ((MessageDao)baseDao).getMessage(messageDto);
    }
    

}
