package com.vtiger.ListenorUtility;

import org.testng.ITestResult;

public class RetryListenerImpCls {
	
	
	//Intial Count 
	int count=0;
	
//	//If any t.c get fail i want to execute it 5 times i created limit
	int limitCount=5;
	public boolean retry(ITestResult result) {
		if(count<limitCount) {
			count++;
			return true;
		}
		return false;
	}
//if i want to use this RetryListenerImpCls functionality in our test case ,we have to go to test case and in order to use 
	//retry analyzer ,i have to use keyword called retryAnalyzer="packageName.clname.class",it will execute 6 times
	//and failure =1 and skips 5
}


