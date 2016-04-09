package com.lihong.service;

import com.lihong.bean.User;

/**
 * 管理用户的service
 * @author lihong2-ext
 *
 */
public interface UserService extends BaseService{
   
	Object getUser(String username, String password);
	
}
