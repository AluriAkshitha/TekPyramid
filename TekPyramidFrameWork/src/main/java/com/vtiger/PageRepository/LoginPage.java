package com.vtiger.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.generic.webdriverutility.WedDriverUtility;

public class LoginPage extends WedDriverUtility {
	
	 WebDriver driver;
	
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement UN;
	
	@FindBy(name="user_password")
	private WebElement PWD;
	
	@FindBy(id="submitButton")
	private WebElement Submit;

	
	//Intialization
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//Object Encapsulation
  
	public WebElement getUN() {
		return UN;
	}

	public WebElement getPWD() {
		return PWD;
	}

	public WebElement getSubmit() {
		return Submit;
	}
	
	public void LoginToApp(String url,String username,String password) throws InterruptedException
	{
     waitForPageToLoad(driver);
     driver.get(url);
     maximizeTheBrowser(driver);
	 UN.sendKeys(username);	
	 PWD.sendKeys(password);
	 Submit.click();
	}
	}

