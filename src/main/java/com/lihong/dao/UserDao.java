package com.lihong.dao;

import com.lihong.bean.User;

public interface UserDao extends BaseDao<User>{
    /**
     * 根据用户名获取用户
     * @param username
     * @return 
     */
	User getUser(String username);


}
