package com.vtiger.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;

	
	@FindBy(className = "dvHeaderText")
	private WebElement Headermsg;
	
	public OrganizationInfoPage(WebDriver driver)
	{
	this.driver=driver;
		PageFactory.initElements(driver, this);

}

	public WebElement getHeadermsg() {
		return Headermsg;
	}
}
