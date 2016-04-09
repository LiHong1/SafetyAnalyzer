package com.lihong.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lihong.common.bean.PageBean;
import com.lihong.dao.BaseDao;

public class BaseDaoImpl<T> extends SqlSessionDaoSupport  implements BaseDao<T>   {
	private Class persistentClass;

	public BaseDaoImpl(Class s){
		persistentClass = s;
	}
    /**
     * 获取Statement id
     * @param method
     * @return
     */
	public String getMethodPath(String method){
		return persistentClass.getName()+"."+method;
	}
	
	/**
	 * 根据id获取对象
	 */
	public T getById(Long id) {
		System.out.println(getMethodPath("getById"));
		return  this.getSqlSession().selectOne(getMethodPath("getById"),id);
	}

	/**
	 * 增加对象
	 */
	public void add(T t) {
		this.getSqlSession().insert(getMethodPath("add"),t);
	}
    
	/**
	 * 获取所有对象
	 */
	public List<T> getAll() {
		return this.getSqlSession().selectList(getMethodPath("getAll"));
	}
	/**
	 * 删除对象
	 */
	public void delete(Long id) {
		this.getSqlSession().delete(getMethodPath("delete"),id);
	}
	
	/**
	 * 获取分页
	 */
	public PageBean<T> getPage(int currentPage, int pageSize) {
		long beginPosition = (long)(currentPage-1)*pageSize;
		List<Long> param = new ArrayList<Long>();
		param.add(beginPosition);
		param.add(beginPosition+pageSize);
		List<T> data =  this.getSqlSession().selectList(getMethodPath("getPage"),param);
		Long allCount = this.getSqlSession().selectOne(getMethodPath("getAllCount"));
		return new PageBean(pageSize,data,allCount,currentPage);
	}
	
	/**
	 * 获取总数
	 */
	public long getAllCount() {
		
		return this.getSqlSession().selectOne(getMethodPath("getAllCount"));
	}

}
