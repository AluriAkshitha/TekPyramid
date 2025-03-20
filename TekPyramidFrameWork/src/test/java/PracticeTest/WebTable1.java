package PracticeTest;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable1 {
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Kallem%20Akshitha/Downloads/Webtable.html");
List<WebElement> Table = driver.findElements(By.xpath("//table[1]/tbody/tr//td[ position()=1 or position()=4]"));
		
		Iterator<WebElement> ir=Table.iterator();
		  while(ir.hasNext())
		  {
		     System.out.println(ir.next().getText());
			   
		
	}

}
}
