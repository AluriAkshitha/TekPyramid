package com.vtiger.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v115.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(linkText = "Organizations")
	private WebElement Orglnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement Contlnk;
	
	@FindBy(linkText = "More")
	private WebElement Morelnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement CampaignLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOut;
	
	
	
	

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getCampaignLnk() {
		return CampaignLnk;
	}

	public WebElement getOrglnk() {
		return Orglnk;
	}

	public WebElement getContlnk() {
		return Contlnk;
	}

	public WebElement getMorelnk() {
		return Morelnk;
	}
	
	public WebElement getSignOut() {
		return SignOut;
	}
	
	public void navigateToCampagainPage()
	{
		Actions a=new Actions(driver);
		a.moveToElement(Morelnk).perform();
		CampaignLnk.click();
		
	}
  public void LogOut()
  {
	  Actions a1=new Actions(driver);
	  a1.moveToElement(adminImg).perform();
	  a1.moveToElement(SignOut).perform();
  }
	
	

}
