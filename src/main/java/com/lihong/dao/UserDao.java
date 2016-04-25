package com.lihong.dao;

import com.lihong.bean.User;
import com.lihong.common.bean.PageBean;
import com.lihong.common.dao.BaseDao;
import com.lihong.dto.UserPageBeanDto;

public interface UserDao extends BaseDao<User>{
    /**
     * 根据用户名获取用户
     * @param username
     * @return 
     */
	User getUser(String username);

	PageBean<User> getPage(Integer page, Integer rows, UserPageBeanDto userPageBeanDto);
}
