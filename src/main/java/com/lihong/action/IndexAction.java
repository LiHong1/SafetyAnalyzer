package com.lihong.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lihong.bean.User;
import com.lihong.common.bean.ResultObj;
import com.lihong.common.util.CacheUtil;
import com.lihong.dto.MenuItemDto;
import com.lihong.dto.UserDto;
import com.lihong.service.MenuItemService;
import com.lihong.service.UserService;
@Controller
public class IndexAction{
	@Autowired
    private UserService userService;
	@Autowired
	private MenuItemService menuItemService;
	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String index(Model model,HttpServletRequest request){
	    List<MenuItemDto> allMenuItemDtos = CacheUtil.getMenuCatche(menuItemService);
        List<MenuItemDto> menuItemDtos = new ArrayList<MenuItemDto>();
        
        for(MenuItemDto menuItem: allMenuItemDtos){
            if (menuItem.getPId() == null ) {
                  menuItemDtos.add(menuItem);
            }
        }
        
        model.addAttribute("menuItems",menuItemDtos);
	
		return "index";
	}
	
	@RequestMapping(value="/index",method = RequestMethod.POST)
	public String indexPost(Model model,HttpServletRequest request){
		model.addAttribute("menuItems",menuItemService.getAll());
		return "index";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(Model model,HttpServletRequest request){
	    ServletContext servletContext = request.getServletContext();
		return "login";
	}
	


}
