package com.lihong.dao;

import java.util.List;

import com.lihong.common.bean.PageBean;

public interface BaseDao<T> {
	
	public T getById(Long id);
	
	public void add(T t);
	
	public List<T> getAll();
	
	public void delete(Long id);
	
	public PageBean<T> getPage(int currentPage,int pageSize);
	
	public long getAllCount();
	
}
