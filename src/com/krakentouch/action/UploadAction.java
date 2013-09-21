package com.krakentouch.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.PropertyResourceBundle;

import com.krakentouch.utils.PropertisHelper;
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
	    //����myFile����һ���ļ�������  
		InputStream is = new FileInputStream(uploadfile);  
		  
		// �����ϴ��ļ�Ŀ¼  
		PropertyResourceBundle prb=(PropertyResourceBundle) PropertyResourceBundle
				.getBundle("config");
		String uploadPath = prb.getString("filesavePath");
		  
		// ����Ŀ���ļ�  
		File toFile = new File(uploadPath, this.getUploadfileFileName());  
		  
		// ����һ�������  
		OutputStream os = new FileOutputStream(toFile);  
		
		//���û���  
		byte[] buffer = new byte[1024];  
		
		int length = 0;  
		
		//��ȡmyFile�ļ������toFile�ļ���  
		while ((length = is.read(buffer)) > 0) {  
		    os.write(buffer, 0, length);  
		}  
		//�ر�������  
		is.close();  
		  
		//�ر������  
		os.close();

		return "success";
	}
	
}
