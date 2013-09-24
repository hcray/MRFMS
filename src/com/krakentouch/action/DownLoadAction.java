package com.krakentouch.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

public class DownLoadAction extends BaseAction {

	// 下载文件原始存放路径
	private final static String DOWNLOADFILEPATH = "/upload/";
	// 文件名参数变量
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	// 从下载文件原始存放路径读取得到文件输出流
	public String downloadFile() throws Exception{
		System.out.println("fileName: " + fileName);
		
        String uploadPath = ServletActionContext.getServletContext()  
                .getRealPath("upload");
        String fName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		OutputStream fos = null;
		InputStream fis = null;
		String filePath = uploadPath +"\\"+ fName; 
		System.out.println("下载路径： " + filePath);
		File upLoadFile = new File(filePath);
		fis = new FileInputStream(upLoadFile);
		bis = new BufferedInputStream(fis);
		fos = response.getOutputStream();
		bos = new BufferedOutputStream(fos);
		///response.setHeader("Content-disposition","attachment;filename="+URLEncoder.encode(fileName,"utf-8"));  
		response.setHeader("Content-disposition","attachment;filename="+fileName);  
		int byteRead = 0;
		byte[] buffer = new byte[8192];
		while((byteRead=bis.read(buffer,0,8192))!=-1){
			bos.write(buffer,0,byteRead);
		}
		bos.flush();
		fis.close();
		bis.close();
		fos.close();
		bos.close();
		return "success";
	}

}
