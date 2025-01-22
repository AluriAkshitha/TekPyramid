package com.vtiger.Contact;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.BaseClassUtility.BaseTest;
import com.vtiger.PageRepository.ContactInfoPage;
import com.vtiger.PageRepository.ContactsPage;
import com.vtiger.PageRepository.CreateNewContactPage;
import com.vtiger.PageRepository.HomePage;

@Listeners(com.vtiger.ListenorUtility.Listener.class)

public class CreateContactWithDates extends BaseTest{
	
	//@Test
	public void CreateContact() throws IOException, Throwable {
		// Reading data from excel
		String data = elib.getDataFromExcel("VTIGER", 4, 1) + jlib.getRandomNumber();
		

		// Navigating to Organization Module
		HomePage hp = new HomePage(driver);
		hp.getContlnk().click();

		// Creating New Contact
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactButton().click();

		// Entering All the Details& Creating New organization

		CreateNewContactPage cnp = new CreateNewContactPage(driver);
//		cnp.getLastName().sendKeys(data);
		
		String StartDate=jlib.getSystemDateYYYYDDMM();
    	String EndDate=jlib.getRequiredDateYYYYDDMM(30);
		Thread.sleep(2000);
//		wlib.switchToAlertAndAccept(driver);
		cnp.CreateContact(data, StartDate, EndDate);
//		wlib.switchToAlertAndAccept(driver);
		cnp.getSaveBtn().click();

		// Verifying the Headermsg and Expected Result

		ContactInfoPage info = new ContactInfoPage(driver);

		String headerText = info.getHeaderMsg().getText();
		boolean status = headerText.contains(data);
		Assert.assertTrue(status);

		String actlastNameTxt = info.getActLastName().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actlastNameTxt, data);
		soft.assertAll();
		
		//verify start and end date
		String actStartDate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actStartDate.equals(StartDate)) {
			System.out.println(StartDate+" is verified==pass");
		}
		else {
			System.out.println(StartDate+" is not verified==fail");
		}
		String actEndDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actEndDate.equals(EndDate)) {
			System.out.println(EndDate+" is verified==pass");
		}
		else {
			System.out.println(EndDate+" is not verified==fail");
		}
	}


}

