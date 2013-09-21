package com.krakentouch.action;


import java.util.Map;

import com.krakentouch.bean.User;
import com.krakentouch.utils.PropertisHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		String ret = "";
		String userName = user.getUserName();
		String password = user.getPassword();
		//管理员用户
		if(userName.equals("administrator")){
			PropertisHelper phelper = new PropertisHelper("itemAccreditUser.properties");
			String adminPassword = phelper.getPropertiesValue("adminPassword");
			if(password.equals(adminPassword)){
				ret = "success";
			}else{
				ret = "passwordError";
			}
		}else{
			ActionContext context = ActionContext.getContext();
			Map<String,Object> application = context.getApplication();
			if(application.containsKey(userName)){
				String appPassword = application.get(userName).toString();
				if(appPassword.equals(password)){
					ret = "success";
				}else{
					ret = "passwordError";
				}
			}else{
				ret = "success";
				application.put(userName, password);
			}
		}
		return ret;
	}
	
}
