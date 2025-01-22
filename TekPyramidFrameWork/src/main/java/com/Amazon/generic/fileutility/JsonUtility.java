package com.Amazon.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public String getDataFromJson(String key) throws Throwable, ParseException
	{
		FileReader fileR=new FileReader("/TekPyramidFrameWork/AmazonAppData/Data.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(fileR);
		JSONObject map=(JSONObject)obj;
		String data=(String) map.get(key);
		return data;
	}

}
