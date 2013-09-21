package com.krakentouch.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
/**
 * properties文件读取的帮助类
 * @author 21829
 *
 */
public class PropertisHelper {
	
	private Properties properties = new Properties();
	
	/**
	 * 构造函数初始化
	 * @param name 文件名
	 */
	public PropertisHelper(String name) {
		InputStream fis = null;
		try {
			fis = new FileInputStream(name);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(fis != null){
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取文件，根据key得到value
	 * @param strProperty key值
	 * @return
	 */
	public String getPropertiesValue(String strProperty) {
		return properties.getProperty(strProperty);
	}

	/**
	 * 设置key 和 value
	 * @param key
	 * @param value
	 */
	public void setPropertiesValue(String key, String value) {
		properties.setProperty(key, value);
	}

	
	/**
	 * 把所有的键值对写入到文件中
	 * @param fileAdress
	 * @throws IOException
	 */
	public void write(String fileAdress) throws IOException {
		File file = new File(fileAdress);
		PrintWriter writer = new PrintWriter(new FileOutputStream(file));

		Collection<?> values = properties.values();
		Collection<?> keys = properties.keySet();

		Iterator<?> k = keys.iterator();
		Iterator<?> v = values.iterator();

		while (k.hasNext()) {
			String key = k.next().toString();
			String value = v.next().toString();
			writer.println(key + "=" + value);
		}
		writer.flush();
		writer.close();
	}
	
	/***
	 * 获得所有的键值集合
	 * @return 所有的keys
	 */
	public Set<?> getpropertiesKeys(){
		Set<?> keys = properties.keySet();
		return keys;
	}
	
	/***
	 * 获得所有的values
	 * @return 所有的values
	 */
	public Collection<?> getPropertiesValues(){
		Collection<?> values = properties.values();
		return values;
	}
	
}
