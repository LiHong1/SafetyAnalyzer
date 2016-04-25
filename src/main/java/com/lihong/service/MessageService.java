package com.lihong.service;

import java.io.InputStream;
import java.util.List;

import com.lihong.bean.Message;
import com.lihong.common.bean.PageBean;
import com.lihong.dao.MessageDao;
import com.lihong.dto.CaseDto;
import com.lihong.dto.CasePageBeanDto;
import com.lihong.dto.MessageDto;
/**
 * 案例的service
 * @author lihong2-ext
 *
 */
public interface MessageService extends BaseService<Message>{
    
	/**
	 * 获取案例与案例相连两篇的案例
	 * @param id
	 * @return
	 */
	List<Message> getMessage(MessageDto messageDto);
	

}
