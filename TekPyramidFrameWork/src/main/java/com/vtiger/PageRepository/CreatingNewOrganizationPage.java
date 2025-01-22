package com.vtiger.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
WebDriver driver;
	
	@FindBy(name="accountname")
	private WebElement un;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement Save;
	
	

	@FindBy(name="industry")
	private WebElement Industry;
	
	@FindBy(name="phone")
	private WebElement PhoneNumber;

	public WebElement getUn() {
		return un;
	}

	public WebElement getIndustry() {
		return Industry;
	}

	public WebElement getPhoneNumber() {
		return PhoneNumber;
	}
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
	this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSave() {
		return Save;
	}
	
	public void CreateWithIndustry()
	{
		Select s=new Select(Industry);
		s.selectByVisibleText("Engineering");
		Save.click();
	}
	
	public void WithPhone(String Phone)
	{
		PhoneNumber.sendKeys(Phone);
		Save.click();
	}
	
	
	
	
}
