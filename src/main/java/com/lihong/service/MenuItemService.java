package com.lihong.service;

import java.util.List;

import com.lihong.dto.MenuItemDto;
/**
 * 菜单的service
 * @author lihong2-ext
 *
 */
public interface MenuItemService extends BaseService<MenuItemDto>{
	
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
