package week4.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame(0);
		
		WebElement resize = driver.findElement(By.xpath("(//div[@id='resizable']/div)[3]"));
		
		
		
	    //Create an object for Actions class
		Actions builder = new Actions(driver);
		
		builder.clickAndHold(resize).moveByOffset(40, 20).release().build().perform();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		driver.close();
		
		
	}}