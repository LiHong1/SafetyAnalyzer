package com.lihong.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lihong.bean.User;
import com.lihong.service.UserService;
@Controller
public class UserAction{
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String index(@RequestParam String username,@RequestParam String password,HttpServletRequest request,Model model){
 
		Object o =  userService.getUser(username,password);
		if(o instanceof Error){
            model.addAttribute("error", o);			
			return "login";
		}else{
			request.getSession().setAttribute("user",o);
			return "redirect:/index";
		}
		
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
			request.getSession().removeAttribute("user");
			return "redirect:/login";
	}
			
}
