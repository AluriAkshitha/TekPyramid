package com.vtiger.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateContactButton;
	
	public ContactsPage(WebDriver driver)
	{
     this.driver=driver;
     PageFactory.initElements(driver,this);
     }

	public WebElement getCreateContactButton() {
		return CreateContactButton;
	}
	
	
}
