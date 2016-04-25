package com.lihong.dao;

import java.util.List;

import com.lihong.common.dao.BaseDao;
import com.lihong.dto.MenuItemDto;

public interface MenuItemDao extends BaseDao<MenuItemDto>{
    
	/**
	 * 获取子菜单
	 * @param parentId
	 * @return
	 */
	List<MenuItemDto> getChildren(Long parentId);

	/**
	 * 获取子菜单
	 * @param url
	 * @return
	 */
	List<MenuItemDto> getSiblingMenu(String url);
	

}
