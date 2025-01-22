package com.vtiger.Organization;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.BaseClassUtility.BaseTest;
import com.vtiger.PageRepository.CreatingNewOrganizationPage;
import com.vtiger.PageRepository.HomePage;
import com.vtiger.PageRepository.OrganizationInfoPage;
import com.vtiger.PageRepository.OrganizationsPage;

@Listeners(com.vtiger.ListenorUtility.Listener.class)

public class CreateOrganizationWithPhoneNumberTest extends BaseTest{
	
	@Test
	public void createOrgWithIndustries() throws IOException, Throwable
	{
		
	//Reading data from excel
			String data=elib.getDataFromExcel("VTIGER", 1, 1)+jlib.getRandomNumber();
			String Phone=elib.getDataFromExcel("VTIGER", 1, 2);
			
	    	//Navigating to Organization Module
			HomePage hp=new HomePage(driver);
		    hp.getOrglnk().click();
		
			
	       //Creating New Organiztion
			OrganizationsPage Or=new OrganizationsPage(driver);
			Or.getCreateOrgButton().click();
			
			//Entering All the Details& Creating New organization
			CreatingNewOrganizationPage cn=new CreatingNewOrganizationPage(driver);
			cn.getUn().sendKeys(data);
			cn.WithPhone(Phone);
			
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
			}

}
