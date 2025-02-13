package com.vtiger.Contact;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Amazon.generic.fileutility.ExcelUtility;
import com.Amazon.generic.fileutility.FileUtility;
import com.Amazon.generic.webdriverutility.JavaUtility;

public class CreateContactDate {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		// create object
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();

		String BROWSER = flib.getDataFromProperties("browser");
		String URL = flib.getDataFromProperties("url");
		String UN = flib.getDataFromProperties("username");
		String PWD = flib.getDataFromProperties("password");

		// read the testScript data from excel file
		String lastName = elib.getDataFromExcel("VTIGER", 4, 1) + jLib.getRandomNumber();

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
//login to app
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
//navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();
		
//click on new contact  button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		WebElement lastname = driver.findElement(By.name("lastname"));
		lastname.sendKeys(lastName);
		
//Support date 
		String startDate = jLib.getSystemDateYYYYDDMM();

		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
//End date 
		String endDate = jLib.getRequiredDateYYYYDDMM(30);

		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@class,'crmbutton small save')]")).click();

//verify lastname  info expected result
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.equals(lastName)) {
			System.out.println(lastName + " is verified==pass");
		} else {
			System.out.println(lastName + " is not verified==fail");
		}
//verify start and end date
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.equals(startDate)) {
			System.out.println(startDate + " is verified==pass");
		} else {
			System.out.println(startDate + " is not verified==fail");
		}
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.equals(endDate)) {
			System.out.println(endDate + " is verified==pass");
		} else {
			System.out.println(endDate + " is not verified==fail");
		}
		driver.close();

	}

}
