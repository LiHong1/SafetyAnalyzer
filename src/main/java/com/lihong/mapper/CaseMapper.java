package com.lihong.mapper;

import java.util.List;

import com.lihong.bean.User;

public interface CaseMapper {
	
	public User getById(Long id);
	
	public void add(User User);
	
	public List <User> getAll();
	
	public void delete();
	
	public void delete(Long id);
}
