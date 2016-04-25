package com.lihong.service.impl;

import java.util.List;

import com.lihong.common.bean.PageBean;
import com.lihong.common.dao.BaseDao;
import com.lihong.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T>{
	public BaseDao<T> baseDao;
	
	public void setBaseDao(BaseDao<T> baseDao){
		this.baseDao = baseDao;
	}
	
	public T getById(Long id){
		return (T) baseDao.getById(id);
	}
	
	public void delete(Long id){
		baseDao.delete(id);
	}
	
	public void add(T t){
		baseDao.add(t);
	}

	public List<T> getAll(){
		return baseDao.getAll();
	}
	
	public PageBean<T> getPage(int currentPage, int pageSize) {
		return baseDao.getPage(currentPage, pageSize);
	}
	
	public long getAllCount() {
		return baseDao.getAllCount();
	}
	



}
