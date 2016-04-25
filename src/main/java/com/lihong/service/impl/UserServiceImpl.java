package com.lihong.service.impl;

import com.lihong.bean.User;
import com.lihong.common.bean.ErrorCode;
import com.lihong.common.bean.PageBean;
import com.lihong.common.bean.SafeAnError;
import com.lihong.dao.UserDao;
import com.lihong.dto.UserPageBeanDto;
import com.lihong.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	public Object getUser(String username, String password) {
		User user = ((UserDao) baseDao).getUser(username);
		if (user!=null &&user.getPassword().equals(password)) {
			return user;
		}else if(user!=null){
			return new SafeAnError(0, "密码错误");
		}
		return new SafeAnError(1, "用户名不存在");
	}

    public User getUser(String username) {
        return ((UserDao) baseDao).getUser(username);
    }

    public PageBean<User> getPage(Integer currentPage, Integer pageSize, UserPageBeanDto userPageBeanDto) {
        return ((UserDao)baseDao).getPage(currentPage, pageSize,userPageBeanDto);
    }


}
