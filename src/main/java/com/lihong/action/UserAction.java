package com.lihong.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lihong.bean.Message;
import com.lihong.bean.User;
import com.lihong.common.bean.PageBean;
import com.lihong.common.bean.ResultObj;
import com.lihong.dto.MessageDto;
import com.lihong.dto.UserDto;
import com.lihong.dto.UserPageBeanDto;
import com.lihong.service.MessageService;
import com.lihong.service.UserService;

@Controller
public class UserAction {

    private static Logger logger = Logger.getLogger(UserAction.class);
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String index(@RequestParam String username,
            @RequestParam String password, HttpServletRequest request,
            Model model) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:/index";
        }

        Object o = userService.getUser(username, password);
        if (o instanceof Error) {
            model.addAttribute("error", o);
            return "login";
        } else {
            boolean rememberMe = ServletRequestUtils.getBooleanParameter(
                    request, "rememberMe", false);
            UsernamePasswordToken token = new UsernamePasswordToken(
                    ((User) o).getUsername(), ((User) o).getPassword(),
                    rememberMe);
            subject.login(token); // 登录
            return "redirect:/index";
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        Subject user = SecurityUtils.getSubject();
        user.getSession().removeAttribute("user");
        if (user.isAuthenticated()) {
            user.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResultObj register(@Valid UserDto userDto, BindingResult br) {
        if (br.hasErrors()) {
            return new ResultObj(1, br.getFieldError().getDefaultMessage());
        }
        User user = new User(userDto.getPhone(), userDto.getUsername(),
                userDto.getPassword1(), 0);
        userService.add(user);
        return new ResultObj(0, "用户注册成功");
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users() {
        return "user/users";
    }
    
    @RequestMapping(value="/users",method = RequestMethod.POST)
    public @ResponseBody PageBean users(UserPageBeanDto userPageBeanDto,@RequestParam Integer draw,@RequestParam Integer length){
       PageBean<User> pageBean = userService.getPage(draw, length,userPageBeanDto);
        return pageBean;
    }
    
 
    @RequiresRoles("admin")
    @RequestMapping(value="/user/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResultObj deleteUser(@PathVariable Long id){
        userService.delete(id);
        ResultObj resultObj = new ResultObj(0, "删除成功");
        return resultObj;
    }
    
    @RequiresRoles("admin")
    @RequestMapping(value="/user/messages",method = RequestMethod.GET)
    public String getMessages(){
       return "user/message";
    }
    
    @RequiresRoles("admin")
    @RequestMapping(value="/user/{userId}/messages",method = RequestMethod.GET)
    @ResponseBody
    public ResultObj getMessages(@PathVariable Long userId,MessageDto messageDto){
        if(messageDto == null){
            messageDto = new MessageDto();
        }
        messageDto.setUserId(userId);
        ResultObj resultObj;
        List<Message> messages = messageService.getMessage(messageDto);
        if(messages == null || messages.size() == 0){
            resultObj  = new ResultObj(0, "沒有记录了");
        }else{
            resultObj = new ResultObj(0, "刷新成功");
            resultObj.setData(messages);
        }
         return resultObj;
    }
    
}
