package com.krakentouch.action;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PropertyResourceBundle;

import com.krakentouch.bean.FileBean;
import com.krakentouch.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user; //登录用户
	private List<FileBean> fileList; //文件列表

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public List<FileBean> getFileList() {
		return fileList;
	}
	public void setFileList(List<FileBean> fileList) {
		this.fileList = fileList;
	}
	@Override
	public String execute() throws Exception {
		String ret = "";
		String userName = user.getUserName();
		String password = user.getPassword();
		//管理员用户
		if(userName.equals("administrator")){
			PropertyResourceBundle prb=(PropertyResourceBundle) PropertyResourceBundle
					.getBundle("config");
			String adminPassword = prb.getString("adminPassword");
			if(password.equals(adminPassword)){
				fileList = getFileByName(userName);
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
					fileList = getFileByName(userName);
					ret = "success";
				}else{
					ret = "passwordError";
				}
			}else{
				ret = "success";
				application.put(userName, password);
			}
		}
		System.out.println("fileList: " + fileList.size());
		return ret;
	}
	
	/***
	 * 根据用户名得到其所有的文件
	 * @param name
	 * @return
	 */
	private List<FileBean> getFileByName(String username){
		List<FileBean> retList = new ArrayList<FileBean>();
		PropertyResourceBundle prb=(PropertyResourceBundle) PropertyResourceBundle
				.getBundle("config");
		String filesavePath = prb.getString("filesavePath");
		File saveFile = new File(filesavePath);
		File[] files = saveFile.listFiles();
		//遍历所有的文件
		for(File file:files){
			if(file.isFile()){
				FileBean fileBean = new FileBean();
				String fileName = file.getName();
				String filePath = file.getAbsolutePath();
				fileBean.setFileName(fileName);
				fileBean.setFilePath(filePath);
				fileBean.setFileOwner(username);
				retList.add(fileBean);
			}
		}
		return retList;
	}
	
}
