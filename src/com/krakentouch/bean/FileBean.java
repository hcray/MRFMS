package com.krakentouch.bean;

public class FileBean {
	private String fileName;
	private String fileOwner;
	private String filePath;
	
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
