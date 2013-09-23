package com.krakentouch.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownLoadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
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
	public InputStream getDownloadFile() {
		String path = "";
		try {
			path = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
			path = path.replace("\\", "\\\\");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("fileName: " + fileName +" path: " +path);
		
		InputStream inputStream = ServletActionContext.getServletContext().getResourceAsStream(
				path); 
		System.out.println("inputStream: " + inputStream);
		return inputStream;
	}

	// 如果下载文件名为中文，进行字符编码转换
	public String getDownloadChineseFileName() {
		String downloadChineseFileName = fileName;
		try {
			downloadChineseFileName = new String(
					downloadChineseFileName.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return downloadChineseFileName;
	}

	public String execute() {
		return SUCCESS;
	}

}
