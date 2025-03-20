package PracticeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drawin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://practice.expandtesting.com/dynamic-table");
		List<WebElement> row = driver.findElements(By.xpath("//table//tbody//tr"));
		int size = row.size();
		
		for(int i=1;i<=size;i++)
		{
			WebElement data = driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[1]"));
			if(data.getText().equals("Chrome"))
			{
				String Percentage = driver.findElement(By.xpath("//table//tbody//tr//td[text()='Chrome']//following-sibling::*[contains(text(),'%')]")).getText();
				System.out.println(Percentage);
				String text = driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
				System.out.println(text);
				if(text.contains(Percentage))
				{
					System.out.println("Both are equal");
				}
				else
				{
					System.out.println("not equal");
				}
				break;
				
			}
			
			
		}
        
       
	}

}
