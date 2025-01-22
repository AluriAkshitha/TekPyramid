package com.vtiger.PageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.generic.webdriverutility.WedDriverUtility;

public class CreateNewContactPage extends WedDriverUtility{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement LastName;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement lookupbutton;
	
	@FindBy(name="mobile")
	private WebElement Phone;
	
	
	@FindBy(name="search_text")
	private WebElement searchTextBox;

	@FindBy(name="search")
	private WebElement searchButn;
	
	@FindBy(name = "support_start_date")
	private WebElement supportStartDate;

	@FindBy(xpath="//td[@class='day selected weekend']/ancestor::div[@class='calendar']//descendant::td[.='January, 2026']")
	private WebElement supportEndDate;
	
	
	
	public CreateNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLastName() {
		return LastName;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getLookupbutton() {
		return lookupbutton;
	}
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}
	public WebElement getSearchButn() {
		return searchButn;
	}
	public WebElement getSupportStartDate() {
		return supportStartDate;
	}
	public WebElement getSupportEndDate() {
		return supportEndDate;
	}
	
	public WebElement getPhone() {
		return Phone;
	}
	
	
	public void CreateContact(String firstName,String startDate,String endDate) {
		LastName.sendKeys(firstName);
		supportStartDate.clear();
		supportStartDate.sendKeys(startDate);
		supportEndDate.clear();
		supportEndDate.sendKeys(endDate);
		saveBtn.click();
	}
	public void CreateContact(String lastName,String orgName) {
		LastName.sendKeys(lastName);
		getLookupbutton().click();
		switchToBrowserTabOnUrl(driver, "module=Accounts");
		searchTextBox.sendKeys(orgName);
		searchButn.click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		switchToBrowserTabOnUrl(driver, "module=Contacts");
		saveBtn.click();
	}
	
	
	}



