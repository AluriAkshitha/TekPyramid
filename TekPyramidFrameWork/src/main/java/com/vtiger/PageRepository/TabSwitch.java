package com.vtiger.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabSwitch {
	
	WebDriver driver;
	
	@FindBy(name="search_text")
	private WebElement Search;
	
	@FindBy(name="search_field")
	private WebElement SearchField;
	
	@FindBy(name="search")
	private WebElement SearchButt;
	
	    public TabSwitch(WebDriver driver)
	    {
	    	this.driver=driver;
	    	PageFactory.initElements(driver,this);
	    }
	    

	public WebElement getSearch() {
		return Search;
	}

	public WebElement getSearchField() {
		return SearchField;
	}

	public WebElement getSearchButt() {
		return SearchButt;
	}

}
