package com.lihong.service.impl;

import java.util.List;

import com.lihong.dao.MenuItemDao;
import com.lihong.dto.MenuItemDto;
import com.lihong.service.MenuItemService;
/**
 * 菜单类的实现
 * @author lihong2-ext
 *
 */
public class MenuItemServiceImpl extends BaseServiceImpl<MenuItemDto> implements MenuItemService{
    


	public List<MenuItemDto> getChildren(Long parentId) {
		return ((MenuItemDao)baseDao).getChildren(parentId);
	}

	public List<MenuItemDto> getSiblingMenu(String url) {
		return ((MenuItemDao)baseDao).getSiblingMenu(url);
	}
	
}
