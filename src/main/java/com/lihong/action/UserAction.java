package com.lihong.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lihong.bean.User;
import com.lihong.service.UserService;
import com.lihong.web.shiro.MyRealm;
@Controller
public class UserAction{
    
    private static Logger logger = Logger.getLogger(MyRealm.class);
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String index(@RequestParam String username,@RequestParam String password,HttpServletRequest request,Model model){
	    Subject subject= SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:/index";
        }
        
		Object o =  userService.getUser(username,password);
		if(o instanceof Error){
            model.addAttribute("error", o);			
			return "login";
		}else{
		    boolean rememberMe = ServletRequestUtils.getBooleanParameter(request, "rememberMe", false);
	        UsernamePasswordToken token = new UsernamePasswordToken( ((User) o).getUsername(), ((User)o).getPassword(), rememberMe);
	        subject.login(token); // 登录
			return "redirect:/index";
		}
		
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
			Subject user = SecurityUtils.getSubject();  
		    user.getSession().removeAttribute("user");
		    if (user.isAuthenticated()) {
		        user.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
		    }
			return "redirect:/login";
	}
			
}
