package com.lihong.dao.impl;


import com.lihong.bean.User;
import com.lihong.dao.UserDao;

public class UserDaoImpl extends BaseDaoImpl<User>  implements UserDao   {

	public UserDaoImpl() {
		super(UserDao.class);
	}

	public User getUser(String username) {
		return this.getSqlSession().selectOne(this.getMethodPath("getByName"),username);
	}


}
