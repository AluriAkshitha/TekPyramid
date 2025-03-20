package PracticeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IRCTCTrainBooking {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		try {
			// Navigate to the IRCTC website
			driver.get("https://www.irctc.co.in/nget/train-search");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			// Enter "From" station
			WebElement fromStation = driver.findElement(By.xpath("//p-autocomplete[@id='origin']"));
			fromStation.sendKeys("Delhi"); // Replace with your "From" station

			// Enter "To" station
			WebElement toStation = driver.findElement(By.xpath("//p-autocomplete[@id='destination']"));
			toStation.sendKeys("Mumbai"); // Replace with your "To" station

			// Select the date
			WebElement dateField = driver.findElement(By.id("jDate"));
			dateField.click();
			WebElement dateToSelect = driver.findElement(By.xpath("//a[text()='29']")); // Replace with the required
																						// date
			dateToSelect.click();

			// Click the search button
			WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));
			searchButton.click();

			// Wait for the train list to load
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='train-list']")));

			// Get all trains displayed
			List<WebElement> trains = driver.findElements(By.xpath("//div[@class='train']"));

			String selectedTrain = null;
			int lowestPrice = Integer.MAX_VALUE;

			for (WebElement train : trains) {
				
				// Get the departure time
				String departureTime = train.findElement(By.xpath(".//span[@class='departure-time']")).getText();
				String[] timeParts = departureTime.split(":");
				int hour = Integer.parseInt(timeParts[0]);

				// Check if the train's departure time is between 6 AM and 9 AM
				if (hour >= 6 && hour <= 9) {
					
					// Get the price of the train
					String priceText = train.findElement(By.xpath(".//span[@class='price']")).getText();
					int price = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));

					// Check for the lowest price
					if (price < lowestPrice) {
						lowestPrice = price;
						selectedTrain = train.findElement(By.xpath(".//span[@class='train-name']")).getText();
					}
				}
			}

			if (selectedTrain != null) {
				System.out.println("Train with lowest price: " + selectedTrain + " | Price: " + lowestPrice);
			} else {
				System.out.println("No trains found within the specified time range.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}

}
