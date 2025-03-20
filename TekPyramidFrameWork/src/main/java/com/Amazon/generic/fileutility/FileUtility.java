package com.Amazon.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromProperties(String key) 
	{
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\Kallem Akshitha\\git\\repository\\TekPyramidFrameWork\\src\\test\\resources\\CommonData.Properties");
			Properties pr=new Properties();
			
			pr.load(fis);
	
	
		String data=pr.getProperty(key);
			return data;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;
		
	}

}
