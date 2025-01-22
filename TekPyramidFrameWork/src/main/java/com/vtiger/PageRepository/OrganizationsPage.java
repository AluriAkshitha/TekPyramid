package com.vtiger.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateOrgButton;
	
	@FindBy(name="search_text")
	private WebElement SearchEdt;
	
	@FindBy(name="search_field")
	private WebElement SearchDropDown;
	
	@FindBy(name="submit")
	private WebElement SearchNow;
	
	
	
	
	public WebElement getSearchNow() {
		return SearchNow;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchDropDown() {
		return SearchDropDown;
	}

	public OrganizationsPage(WebDriver driver)
	{
	this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateOrgButton() {
		return CreateOrgButton;
	}


}
