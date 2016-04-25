package com.lihong.dao.impl;


import java.util.List;

import com.lihong.bean.User;
import com.lihong.common.bean.DPageBean;
import com.lihong.common.bean.PageBean;
import com.lihong.common.daoImpl.BaseDaoImpl;
import com.lihong.dao.UserDao;
import com.lihong.dto.UserPageBeanDto;

public class UserDaoImpl extends BaseDaoImpl<User>  implements UserDao   {

	public UserDaoImpl() {
		super(UserDao.class);
	}

	public User getUser(String username) {
		return this.getSqlSession().selectOne(this.getMethodPath("getByName"),username);
	}

    public PageBean<User> getPage(Integer currentPage, Integer pageSize, UserPageBeanDto userPageBeanDto) {
        long beginPosition = (long)(currentPage-1)*pageSize;
        userPageBeanDto.setBeginPosition(beginPosition);
        userPageBeanDto.setEndPosition(beginPosition+pageSize); 
        List<User> data =  this.getSqlSession().selectList(getMethodPath("getPageByParam"),userPageBeanDto);
        Long allCount = this.getSqlSession().selectOne(getMethodPath("getCountByParam"),userPageBeanDto);
        PageBean<User> page = new DPageBean<User>(pageSize,data,allCount,currentPage);
        return page;
    }



}
