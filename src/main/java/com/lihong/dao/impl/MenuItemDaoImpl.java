package com.lihong.dao.impl;

import java.util.List;

import com.lihong.common.daoImpl.BaseDaoImpl;
import com.lihong.dto.MenuItemDto;
import com.lihong.dao.MenuItemDao;

public class MenuItemDaoImpl extends BaseDaoImpl<MenuItemDto> implements MenuItemDao {

	public MenuItemDaoImpl() {
		super(MenuItemDao.class);
	}

	public List<MenuItemDto> getChildren(Long parentId) {
		return this.getSqlSession().selectList(MenuItemDao.class.getName()+".getChildren",parentId);
	}

	public List<MenuItemDto> getSiblingMenu(String url) {
		return this.getSqlSession().selectList(MenuItemDao.class.getName()+".getSiblingMenu",url);
	}


	
}
