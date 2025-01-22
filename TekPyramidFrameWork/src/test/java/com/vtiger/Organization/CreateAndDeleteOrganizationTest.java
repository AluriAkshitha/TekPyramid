package com.vtiger.Organization;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.BaseClassUtility.BaseTest;
import com.vtiger.PageRepository.CreatingNewOrganizationPage;
import com.vtiger.PageRepository.HomePage;
import com.vtiger.PageRepository.OrganizationInfoPage;
import com.vtiger.PageRepository.OrganizationsPage;


@Listeners(com.vtiger.ListenorUtility.Listener.class)

public class CreateAndDeleteOrganizationTest extends BaseTest{
	
	@Test
	public void createOrg() throws Throwable {
		
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
		
		//Go back to Oeganization page
		 hp.getOrglnk().click();
		 
		//search for organization
		 Or.getSearchEdt().sendKeys(data);
		 wlib.selectDropDownByText(Or.getSearchDropDown(), "Organization Name");
		 Or.getSearchNow().click();
		
		//In dynamic webtable select and delete organization
		 
		 driver.findElement(By.xpath("//a[text()='"+data+"']/../../td[8]/a[text()='del']"));
//		 wlib.switchToAlertAndAccept(driver);
		 
		

}
}
