package com.krakentouch.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	// myFile属性用来封装上传的文件  
	private File uploadfile;  
	  
	// myFileContentType属性用来封装上传文件的类型  
	private String uploadfileContentType;  
	
	// myFileFileName属性用来封装上传文件的文件名  
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
	    //基于myFile创建一个文件输入流  
		InputStream is = new FileInputStream(uploadfile);  
		  
		// 设置上传文件目录  
		String uploadPath = "D://fileManage";
		  
		// 设置目标文件  
		File toFile = new File(uploadPath, this.getUploadfileFileName());  
		  
		// 创建一个输出流  
		OutputStream os = new FileOutputStream(toFile);  
		
		//设置缓存  
		byte[] buffer = new byte[1024];  
		
		int length = 0;  
		
		//读取myFile文件输出到toFile文件中  
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
