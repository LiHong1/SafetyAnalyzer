package com.lihong.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lihong.service.MenuItemService;
@Controller
public class indexAction extends BaseAction{
	
	@Autowired
	private MenuItemService menuItemService;
	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String index(Model model,HttpServletRequest request){
		model.addAttribute("menuItems",menuItemService.getAll());
		model.addAttribute(CONTEXT_PATH, request.getRequestURI());
		return "index";
	}
	
	@RequestMapping(value="/index",method = RequestMethod.POST)
	public String indexPost(Model model,HttpServletRequest request){
		model.addAttribute("menuItems",menuItemService.getAll());
		model.addAttribute(CONTEXT_PATH, request.getRequestURI());
		return "index";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(Model model,HttpServletRequest request){
		model.addAttribute(CONTEXT_PATH, request.getRequestURI());
		return "login";
	}
	

}
