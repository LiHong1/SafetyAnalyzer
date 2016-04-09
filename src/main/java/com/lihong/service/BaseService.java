package com.lihong.service;

import java.util.List;

import com.lihong.common.bean.PageBean;

public interface BaseService<T> {
	
    public T getById(Long id);
	
	public void add(T t);
	
	public List<T> getAll();
	
	public void delete(Long id);
	
    public PageBean<T> getPage(int currentPage,int pageSize);
	
	public long getAllCount();
}
