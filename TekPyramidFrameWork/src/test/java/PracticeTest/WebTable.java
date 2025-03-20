package PracticeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		// Maximize the browser window
					driver.manage().window().maximize();

		try {
			// Navigate to the webpage with the table
			driver.get("file:///C:/Users/Lenovo/Downloads/Webtable%20(1)%20(1).html"); // Replace with your webpage URL

			

			// Locate the table element
			WebElement table = driver.findElement(By.xpath("//table[1]")); // Adjust XPath if needed

			// Fetch all rows of the table (excluding the header row)
			List<WebElement> rows = table.findElements(By.xpath(".//tr[position()>1]"));

			// Iterate through the rows
			for (WebElement row : rows) {
				
				// Fetch the Country Name, Population, and Male to Female Ratio from the columns
				String countryName = row.findElement(By.xpath(".//td[2]")).getText(); // 2nd column
				String population = row.findElement(By.xpath(".//td[3]")).getText(); // 3rd column
				String maleToFemaleRatio = row.findElement(By.xpath(".//td[4]")).getText(); // 4th column

				// Print Country Name - Population
				System.out.println(countryName + " - Population: " + population);

				// Print Country Name - Male to Female Ratio
				System.out.println(countryName + " - Male to Female Ratio: " + maleToFemaleRatio);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}

	}

}
