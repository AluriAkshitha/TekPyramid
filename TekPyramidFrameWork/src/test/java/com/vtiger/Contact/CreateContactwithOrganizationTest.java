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
import com.vtiger.PageRepository.CreatingNewOrganizationPage;
import com.vtiger.PageRepository.HomePage;
import com.vtiger.PageRepository.OrganizationInfoPage;
import com.vtiger.PageRepository.OrganizationsPage;
import com.vtiger.PageRepository.TabSwitch;


@Listeners(com.vtiger.ListenorUtility.Listener.class)

public class CreateContactwithOrganizationTest extends BaseTest {
	
	
	@Test(groups = "RT")
	public void CreateContactWithOrg() throws IOException, Throwable {
		
		
		//Reading data from excel
				String data=elib.getDataFromExcel("VTIGER", 1, 1)+jlib.getRandomNumber();
				
		    	//Navigating to Organization Module
				HomePage hp=new HomePage(driver);
				hp.getOrglnk().click();
				
		       //Creating New Organiztion
				OrganizationsPage Or=new OrganizationsPage(driver);
				Or.getCreateOrgButton().click();
				
				//Entering All the Details& Creating New organization
				CreatingNewOrganizationPage cn=new CreatingNewOrganizationPage(driver);
				cn.getUn().sendKeys(data);
				cn.getSave().click();
				
				//Verifying the Headermsg  and Expected Result
				
				OrganizationInfoPage info=new OrganizationInfoPage(driver);
				String Orgname=info.getHeadermsg().getText();
				if(Orgname.contains(data))
				{
					System.out.println(data+"name is verified ==>pass");
				}
				else
				{
					System.out.println(data+"name is not verified ==>Fail");
				}
				
				
				/**
				 * @author Kallem Akshitha
				 * This is Creating Contact
				 * 
				 * */
				// Reading data from excel
				String ContactName = elib.getDataFromExcel("VTIGER", 4, 1) + jlib.getRandomNumber();

				// Navigating to Organization Module
				
				hp.getContlnk().click();

				// Creating New Contact
				ContactsPage cp = new ContactsPage(driver);
				cp.getCreateContactButton().click();

				// Entering All the Details& Creating New Contact with organization

				CreateNewContactPage cnp = new CreateNewContactPage(driver);
				cnp.getLastName().sendKeys(ContactName);
				cnp.getLookupbutton().click();
				
				//Switch the tab to childwindow
				wlib.switchToBrowserTabOnUrl(driver, "module=Accounts");
				TabSwitch tb=new TabSwitch(driver);
				tb.getSearch().sendKeys(data);
				
				 wlib.selectDropDownByText(tb.getSearchField(), "Organization Name");
				 tb.getSearchButt().click();
				 
				driver.findElement(By.xpath("//a[text()='"+data+"']")).click();
				
				wlib.switchToBrowserTabOnUrl(driver, "module=Contacts");
				
				
				cnp.getSaveBtn().click();

				// Verifying the Headermsg and Expected Result

				ContactInfoPage info1 = new ContactInfoPage(driver);

				String headerText = info1.getHeaderMsg().getText();
				boolean status = headerText.contains(ContactName);
				Assert.assertTrue(status);

				String actlastNameTxt = info1.getActLastName().getText();
				SoftAssert soft = new SoftAssert();
				soft.assertEquals(actlastNameTxt, ContactName);
				soft.assertAll();

	}
}
