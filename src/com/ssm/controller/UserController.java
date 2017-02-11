package com.ssm.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.domain.User;
import com.ssm.domain.UserCondition;
import com.ssm.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUserList")
	public ModelAndView getUserList() {
		List<User> userList = userService.getUserList();	
		ModelAndView model = new ModelAndView();
		model.addObject("userList", userList);
		model.setViewName("user");
		return model;
	}
	//跳转到增加页面,指定请求方式get
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String input(Map<String,Object> map){
		//指定form表单绑定的模型属性
		map.put("user",new User());
		return "input";		
	}
	//点击保存事件是POST请求
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String save(User user,HttpServletRequest request) throws Exception{
		//解决中文乱码
	    String userName = new String(request.getParameter("userName").getBytes("ISO-8859-1"), "UTF-8"); 
	    String address= new String(request.getParameter("address").getBytes("ISO-8859-1"), "UTF-8");
	    String nation= new String(request.getParameter("nation").getBytes("ISO-8859-1"), "UTF-8");
	    
	    user.setUserName(userName);
	    user.setAddress(address);
	    user.setNation(nation);
	    
		userService.insert(user);
		return "redirect:/getUserList";		
	}

	//执行修改的操作,调转到输入框页面时Get请求,包含该行记录的值
	@RequestMapping(value="/insert/{userId}",method=RequestMethod.GET)
	public String input(@PathVariable("userId") Integer userId,Map<String,Object> map){		
		map.put("user",userService.getById(userId));
		return "input";		
	}
	
	//修改完数据后提交是put请求
	@RequestMapping(value="/insert",method=RequestMethod.PUT)
	public String update(User user,HttpServletRequest request) throws Exception{
		//解决中文乱码
	    String userName = new String(request.getParameter("userName").getBytes("ISO-8859-1"), "UTF-8"); 
	    String address= new String(request.getParameter("address").getBytes("ISO-8859-1"), "UTF-8");
	    String nation= new String(request.getParameter("nation").getBytes("ISO-8859-1"), "UTF-8");
	    
	    user.setUserName(userName);
	    user.setAddress(address);
	    user.setNation(nation);
	    userService.update(user);
	    
		return "redirect:/getUserList";	
		
	}
	
	/*
	 * 如何将超链接转换成delete请求?
	 * 而web.xml中的配置只能将POST请求转换成DELETE或PUT请求
	 * 超链接只是一般得get请求,此时需要借助js实现转换成post请求
	 */
	//执行删除操作
	@RequestMapping(value="/delete/{userId}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("userId") Integer userId){
		userService.delete(userId);
		return "redirect:/getUserList";	
	}
	
	//查询
		@RequestMapping(value="/find",method=RequestMethod.GET)
		public ModelAndView find(Map<String,Object> map,HttpServletRequest request) throws Exception{	
			//解决中文乱码
		    String userName = new String(request.getParameter("userName").getBytes("ISO-8859-1"), "UTF-8"); 
		    String address= new String(request.getParameter("address").getBytes("ISO-8859-1"), "UTF-8");
		     int minAge=0;
		    if(request.getParameter("minAge")!=null&&request.getParameter("minAge").length()>0){
		    	minAge=Integer.parseInt(request.getParameter("minAge"));
		    }
		    int maxAge=0;
		    if(request.getParameter("maxAge")!=null&&request.getParameter("maxAge").length()>0){
		    	 maxAge=Integer.parseInt(request.getParameter("maxAge"));
		    }
		    
		    System.out.println(userName+";"+address+";"+minAge+";"+maxAge);
		    UserCondition u=new UserCondition("%"+userName+"%","%"+address+"%",minAge,maxAge);
			List<User> userList = userService.findUser(u);	
			ModelAndView model = new ModelAndView();
			model.addObject("userList", userList);
			model.setViewName("user");
			return model;	
		}
}
