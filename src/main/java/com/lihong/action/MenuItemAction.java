package com.lihong.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lihong.dto.MenuItemDto;
import com.lihong.service.MenuItemService;
@Controller
public class MenuItemAction extends BaseAction{
	@Autowired
	private MenuItemService menuItemService;
	
	
	@RequestMapping(value="/menus",method = RequestMethod.GET)
	public String getMenu(Model model,HttpServletRequest request){
		model.addAttribute("menuItemDtos",menuItemService.getAll());
		model.addAttribute(CONTEXT_PATH, request.getRequestURI());
		return "menu";
	}
	
	/**
	 * 根据父id获取子菜单
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="/menus/{parentId}",method = RequestMethod.GET)
	public @ResponseBody List<MenuItemDto> getMenu(@PathVariable Long parentId){
		List<MenuItemDto> menuItemDtos = menuItemService.getChildren(parentId);
		return menuItemDtos;
	}
	
	
	/**
	 * 获取url获取子菜单
	 * @param url
	 * @return
	 */
	@RequestMapping(value="/siblingMenus",method = RequestMethod.POST)
	public @ResponseBody List<MenuItemDto> getSiblingMenu(@RequestParam String url){
		List<MenuItemDto> menuItemDtos = menuItemService.getSiblingMenu(url);
		return menuItemDtos;
	}

}
