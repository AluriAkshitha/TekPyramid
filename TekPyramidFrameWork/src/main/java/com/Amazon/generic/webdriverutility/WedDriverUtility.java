package com.Amazon.generic.webdriverutility;

import java.time.Duration;


import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.BaseClassUtility.BaseTest;


public class WedDriverUtility {
  
	
	/**
	 * @author Kallem Akshitha This method is used to WaitImplicitly
	 * 
	 */
     public void waitForPageToLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * @author Kallem Akshitha This method is used to Maximize the browser
	 * 
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * @author Kallem Akshitha This method is used to WaitExplicitly
	 * @param WebElement element
	 * 
	 */
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * @author Kallem Akshitha This method is used to SwitchTheBrowser based on Url
	 * @param url
	 * 
	 */
	public void switchToBrowserTabOnUrl(WebDriver driver, String partialUrl) {
		Set<String> set = driver.getWindowHandles();
		for (String ids : set) {
			String actUrl = driver.switchTo().window(ids).getCurrentUrl();
			if (actUrl.contains(partialUrl)) {
				break;
			}
//	 	Iterator<String>it=set.iterator();
//	 	while(it.hasNext()) {
//	 		String windowId=it.next();
//	 		driver.switchTo().window(windowId);
//	 		String actUrl=driver.getCurrentUrl();
//	 		if(actUrl.contains(partialUrl)) {
//	 			break;
//	 		}
		}
	}

	/**
	 * @author Kallem Akshitha This method is used to SwitchTheBrowser based on Title
	 * @param title
	 * 
	 */
	public void switchToBrowserTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String actUrl = driver.getTitle();
			if (actUrl.contains(partialTitle)) {
				break;
			}
		}
	}

	/**
	 * @author Kallem Akshitha This method is used to SwitchToFrame Based on Index
	 * @param index value
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * @author Kallem Akshitha This method is used to SwitchToFrame Based on name
	 * @param name id
	 */
	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}

	/**
	 * @author Kallem Akshitha This method is used to SwitchToFrame Based on Index
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * @author Kallem Akshitha This method is used to Accept the Alert
	 * 
	 */
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * @author Kallem Akshitha This method is used to Dismiss the Alert
	 * 
	 */
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * @author Kallem Akshitha This method is used to SelectValue From Dropdown
	 *         based on Index value
	 * @param index
	 * 
	 */
	public void selectDropDownByIndex(WebElement element, int index) {
		Select st = new Select(element);
		st.selectByIndex(index);
	}

	/**
	 * @author Kallem Akshitha This method is used to SelectValue From Dropdown
	 *         based on text value
	 * @param text
	 * 
	 */
	public void selectDropDownByText(WebElement element, String text) {
		Select st = new Select(element);
		st.selectByVisibleText(text);
	}

	/**
	 * @author Kallem Akshitha This method is used to SelectValue From Dropdown
	 *         based on value
	 * @param value
	 * 
	 */
	public void selectDropDownByValue(WebElement element, String value) {
		Select st = new Select(element);
		st.selectByValue(value);
	}

	/**
	 * @author Kallem Akshitha This method is used to mousehover/movetoelement
	 * @param index
	 * 
	 */
	public void actionMouseHover(WebDriver driver, WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}

	/**
	 * @author Kallem Akshitha This method is used to dragandDrop
	 * @param index
	 * 
	 */
	public void performDragAndDrop(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, targetElement).perform();
	}

	/**
	 * @author Kallem Akshitha This method is used to perform doubleClick actions
	 * @param index
	 * 
	 */
	public void actionDoubleClick(WebDriver driver, WebElement element) {
		Actions ac = new Actions(driver);
		ac.doubleClick(element).perform();

		/**
		 * @author Kallem Akshitha This method is used to take Screenshot
		 * @param index
		 * 
		 */
	}

	public String getScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) BaseTest.driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}

}
