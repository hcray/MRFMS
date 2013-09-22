package com.krakentouch.action;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PropertyResourceBundle;

import com.krakentouch.bean.FileBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private List<FileBean> fileList; //文件列表

	public List<FileBean> getFileList() {
		return fileList;
	}
	public void setFileList(List<FileBean> fileList) {
		this.fileList = fileList;
	}
	@Override
	public String execute() throws Exception {
		
		ActionContext context = ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		String username = session.get("curUser").toString();
		fileList = getFileByName(username);
		return "success";
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
				//如果是管理员用户，显示所有的文件
				if("administrator".equals(username)){
					fileBean.setFileName(fileName);
					fileBean.setFilePath(filePath);
					fileBean.setFileOwner(username);
					retList.add(fileBean);
				}else if(fileName.split("_")[0].equals(username)){//不是管理员，只显示自己上传的文件
					fileBean.setFileName(fileName);
					fileBean.setFilePath(filePath);
					fileBean.setFileOwner(username);
					retList.add(fileBean);
				}
			}
		}
		return retList;
	}
	
}
