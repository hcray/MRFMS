package com.krakentouch.bean;

public class FileBean {
	private String fileName; //文件名
	private String fileOwner;//文件所有者
	private String filePath; //文件路径
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileOwner() {
		return fileOwner;
	}
	public void setFileOwner(String fileOwner) {
		this.fileOwner = fileOwner;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("fileName: ").append(fileName)
			.append(" fileOwner: ").append(fileOwner)
			.append(" filePath: ").append(filePath);
		return sb.toString();
	}
}
