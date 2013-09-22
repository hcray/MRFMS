package com.krakentouch.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.PropertyResourceBundle;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	// myFile����������װ�ϴ����ļ�  
	private File uploadfile;  
	  
	// myFileContentType����������װ�ϴ��ļ�������  
	private String uploadfileContentType;  
	
	// myFileFileName����������װ�ϴ��ļ����ļ���  
	private String uploadfileFileName;
	
	public File getUploadfile() {
		return uploadfile;
	}


	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}


	public String getUploadfileContentType() {
		return uploadfileContentType;
	}


	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}


	public String getUploadfileFileName() {
		return uploadfileFileName;
	}


	public void setUploadfileFileName(String uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}


	@Override
	public String execute() throws Exception {
		System.out.println("uploadfile: " + uploadfile);
		ActionContext context = ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		
		String curUser = session.get("curUser").toString();
	    //得到上传的文件
		InputStream is = new FileInputStream(uploadfile);  
		  
		//上传文件的存储路径
		PropertyResourceBundle prb=(PropertyResourceBundle) PropertyResourceBundle
				.getBundle("config");
		String uploadPath = prb.getString("filesavePath");
		  
		//上传的文件
		File toFile = new File(uploadPath, curUser+"_"+this.getUploadfileFileName());  
		  
		//输入流
		OutputStream os = new FileOutputStream(toFile);  
		
		//
		byte[] buffer = new byte[1024];  
		
		int length = 0;  
		
		//输出到指定路径
		while ((length = is.read(buffer)) > 0) {  
		    os.write(buffer, 0, length);  
		}  
		//关闭输入流
		is.close();  
		  
		//关闭输出流
		os.close();
		

		return "success";
	}
	
}
