package com.Amazon.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName,int rownum,int cellNum) throws Throwable, IOException
	{
	
	FileInputStream fis=new FileInputStream("C:\\Users\\Kallem Akshitha\\OneDrive\\Desktop\\Selinium\\TekPyramidFrameWork\\TestData\\Tekpyramid.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String data=wb.getSheet(sheetName).getRow(rownum).getCell(cellNum).getStringCellValue();
	 wb.close();
    return data;
   
}
	public int getRowCount(String sheetName) throws Throwable
	
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Kallem Akshitha\\OneDrive\\Desktop\\Selinium\\TekPyramidFrameWork\\TestData\\Tekpyramid.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(sheetName).getLastRowNum();
		 wb.close();
		return rowcount;
		 
		
	}
	
	public void setDataIntoExcel(String sheetName,int rownum,int cellNum,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Kallem Akshitha\\OneDrive\\Desktop\\Selinium\\TekPyramidFrameWork\\TestData\\Tekpyramid.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
	     wb.getSheet(sheetName).getRow(rownum).getCell(cellNum);
		
	     FileOutputStream fos=new FileOutputStream("C:\\Users\\Kallem Akshitha\\OneDrive\\Desktop\\Selinium\\TekPyramidFrameWork\\TestData\\Tekpyramid.xlsx");
	     wb.write(fos);
	     wb.close();
	}
}
