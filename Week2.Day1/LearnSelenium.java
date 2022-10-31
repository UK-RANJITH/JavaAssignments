package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSelenium {

	public static void main(String[] args)  {

		// set path for browser

		WebDriverManager.chromedriver().setup();

		//print driver path
		// String path = System.getProperty("webdriver.chrome.driver");
		// System.out.println(path);


		// Launch the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// return type of get method -- void/null
		//driver.get("http://leaftaps.com/opentaps/control/main");


		// maximize the browser
		driver.manage().window().maximize();


		// minimize the browser
		//driver.manage().window().minimize();

		//close the browser

		//driver.close();


		//driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		//driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		//driver.findElement(By.className("decorativeSubmit")).click();



		//	driver.findElement(By.className("decorativeSubmit")).click();

		driver.get("https://www.facebook.com/");

		// wait time added


		driver.findElement(By.partialLinkText("New")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement select1 = driver.findElement(By.id("day"));
		Select obj= new Select(select1);
		obj.selectByValue("11");


		
		WebElement select2 = driver.findElement(By.id("month"));
		Select obj2= new Select(select2);
		obj2.selectByVisibleText("Sep");

		WebElement select3 = driver.findElement(By.id("year"));
		Select obj3=new Select(select3);
		obj3.selectByIndex(3);

		//close the browser
		//driver.close();
	}
}
