package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://www.facebook.com");		

		driver.manage().window().maximize();

		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Ranjith");
		driver.findElement(By.name("lastname")).sendKeys("Kishore");
		driver.findElement(By.name("reg_email__")).sendKeys("07424155086");
		driver.findElement(By.id("password_step_input")).sendKeys("Pass@#$%^&*()");

		WebElement select1 = driver.findElement(By.id("day"));
		Select obj1 =new Select(select1);
		obj1.selectByValue("28");

		WebElement select2 = driver.findElement(By.id("month"));
		Select obj2 =new Select(select2);
		obj2.selectByVisibleText("Mar");

		WebElement select3 = driver.findElement(By.id("year"));
		Select obj3 =new Select(select3);
		obj3.selectByIndex(31);

		driver.findElement(By.name("sex")).click();
	}
}
