package com.ssh.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.ssh.entities.User;
import com.ssh.exception.UsernameException;
import com.ssh.service.UserService;

public class UserAction extends ActionSupport implements RequestAware,ModelDriven<User>,Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private Map<String, Object> request;
	private InputStream inputStream;
	private Integer id;
	private UserService userService;
	private String username;
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public void prepare() throws Exception {
		
	}

	@Override
	public User getModel() {
		
		return user;
	}
	public void setModel(User user) {
		this.user = user;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}
	
	public InputStream getInputStream(){
		return inputStream;
	}

	public void prepareSave(){
		if(id==null){
			user=new User();
		}else{
			
		}
	}
	public String save(){
		String msg;
		if(id==null){
			user.setCreateTime(new Date());
			if(userService.usernameIsValid(username)){
				userService.saveOrUpdate(user);
				msg="注册成功！";
			}else{
				msg="用户名已被占用!";
				request.put("message", msg);
				throw new UsernameException(msg);
			}
		}else{
			msg="修改成功";
		}
		request.put("message", msg);
		userService.saveOrUpdate(user);
		return "message";
	}
	public String toRegister(){
		return "toRegister";
	}
	public String validateUsername() throws UnsupportedEncodingException{
		if(userService.usernameIsValid(username)){
			inputStream=new ByteArrayInputStream("1".getBytes("UTF-8"));
		}else{
			inputStream=new ByteArrayInputStream("0".getBytes("UTF-8"));
		}
		return "ajax-success";
	}
}
