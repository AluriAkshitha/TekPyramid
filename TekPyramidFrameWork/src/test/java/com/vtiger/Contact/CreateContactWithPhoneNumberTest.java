package com.vtiger.Contact;

import java.io.IOException;

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

public class CreateContactWithPhoneNumberTest extends BaseTest {
	
	@Test
	public void CreateContact() throws IOException, Throwable {
		// Reading data from excel
		String data = elib.getDataFromExcel("VTIGER", 4, 1) + jlib.getRandomNumber();
		String phone = elib.getDataFromExcel("VTIGER", 4, 2) + jlib.getRandomNumber();

		// Navigating to Organization Module
		HomePage hp = new HomePage(driver);
		hp.getContlnk().click();

		// Creating New Contact
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactButton().click();

		// Entering All the Details& Creating New organization

		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.getLastName().sendKeys(data);
		cnp.getPhone().sendKeys(phone);
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


}
}
