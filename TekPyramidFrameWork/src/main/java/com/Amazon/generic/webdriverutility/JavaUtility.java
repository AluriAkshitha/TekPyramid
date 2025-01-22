package com.Amazon.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random random=new Random();
		int randomnumber=random.nextInt(5000);
		return randomnumber; 
	}
    public String getSystemDateYYYYDDMM()
{
	    Date dateobj=new Date();
	    SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
	    String date=sdf.format(dateobj);
	    return date;
}

    public String getRequiredDateYYYYDDMM(int days)
{
    	
  	    SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
  	    Calendar cal=sdf.getCalendar();
  	    cal.add(Calendar.DAY_OF_MONTH, days);
  	    String reqDate=sdf.format(cal.getTime());
  	    return reqDate;
  	    
}

	}


