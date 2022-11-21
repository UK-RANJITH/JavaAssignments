package week4.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame(0);
		
		
	    //Create an object for Actions class
		Actions builder = new Actions(driver);
		
		WebElement sortable = driver.findElement(By.xpath("//li[text()='Item 2']"));
		
		builder.clickAndHold(sortable).moveByOffset(0, 100).release().build().perform();
		
		Thread.sleep(4000);
		
		driver.switchTo().defaultContent();
		
		driver.close();
		
		
	}

}