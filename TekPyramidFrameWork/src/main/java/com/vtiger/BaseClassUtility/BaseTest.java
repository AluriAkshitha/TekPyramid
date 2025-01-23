package com.vtiger.BaseClassUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Amazon.generic.databaseutility.DataBaseUtility;
import com.Amazon.generic.fileutility.ExcelUtility;
import com.Amazon.generic.fileutility.FileUtility;
import com.Amazon.generic.webdriverutility.JavaUtility;
import com.Amazon.generic.webdriverutility.WedDriverUtility;
import com.vtiger.PageRepository.HomePage;
import com.vtiger.PageRepository.LoginPage;

/**
 * This Class is used for Configure All PreCondition and PostCondition For
 * TestScript And Also initializing All The Library-Utility class
 * 
 * 
 * @author Kallem Akshitha
 **/

public class BaseTest {

	// Creating an objects for Utilities
	public static WebDriver driver;
	public static WebDriver sdriver = null;

	public WedDriverUtility wlib = new WedDriverUtility();
	public FileUtility flib = new FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public ExcelUtility elib = new ExcelUtility();
	public DataBaseUtility dlib = new DataBaseUtility();

//	@BeforeSuite
//	public void DataBaseConnection() throws Throwable {
//		System.out.println("===connect to DB , Report config===");
//		dlib.getDbconnection("jdbc:mysql:106.51.90.215:3333/projects", "root@%", "root");
//	}
	//String browser
	//@Parameters("BROWSER")
	@BeforeClass(groups = { "ST", "RT" })
	public void Configuration() throws Throwable {

		System.out.println("----launch the browser-----");
	     String BROWSER = flib.getDataFromProperties("browser");
		//String BROWSER = browser;
//		String BROWSER=System.getProperty("browser");
		if (BROWSER.equals("chrome")) {

			driver = new ChromeDriver();

		} else if (BROWSER.equals("firefox")) {

			driver = new FirefoxDriver();

		} else if (BROWSER.equals("edge")) {

			driver = new EdgeDriver();

		} else {

			driver = new ChromeDriver();

		}
		sdriver = driver;
	}

	// Login To The Application
	@BeforeMethod(groups = { "ST", "RT" })
	public void Login() throws Throwable {
		System.out.println("---login to the application----");

		String URL = flib.getDataFromProperties("url");
		String USERNAME = flib.getDataFromProperties("username");
		String PASSWORD = flib.getDataFromProperties("password");
		System.out.println(URL);
		System.out.println(USERNAME);

//		String URL=System.getProperty("url");
//		String USERNAME=System.getProperty("username");
//		String PASSWORD=System.getProperty("password");

		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);

		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(URL, USERNAME, PASSWORD);

	}

	@AfterMethod(groups = { "ST", "RT" })
	public void SignOut() {
		System.out.println("----logout-----");
		HomePage hp = new HomePage(driver);
		hp.LogOut();
	}

	@AfterClass(groups = { "ST", "RT" })
	public void CloseTheBrowser() {
		System.out.println("---close browser----");
		driver.close();
	}

//	@AfterSuite
//	public void CloseDBConnection() throws SQLException {
//		System.out.println("===close connection===");
//		dlib.closeDbconnection();
//	}
}
