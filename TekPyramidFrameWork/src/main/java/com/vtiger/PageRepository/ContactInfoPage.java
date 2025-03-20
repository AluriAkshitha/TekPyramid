package com.vtiger.PageRepository;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	WebDriver driver;

	public ContactInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class='dvHeaderText'])[1]")
	private WebElement headerMsg;

	@FindBy(id = "dtlview_Last Name")
	private WebElement actLastName;

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getActLastName() {
		return actLastName;
	}
}
