package week4day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**Assignment 4:
		  1. Launch URL "http://leaftaps.com/opentaps/control/login"
		  2. Enter UserName and Password Using Id Locator
		  3. Click on Login Button using Class Locator
		  4. Click on CRM/SFA Link
		  5. Click on contacts Button
		  6. Click on Merge Contacts using Xpath Locator
		  7. Click on Widget of From Contact
		  8. Click on First Resulting Contact
		  9. Click on Widget of To Contact
		  10. Click on Second Resulting Contact
		  11. Click on Merge button using Xpath Locator
		  12. Accept the Alert
		  13. Verify the title of the page 
 */
public class Assignment4_OnLeafapps {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/main");

		//2. Enter UserName and Password Using Id Locator
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		Thread.sleep(2000);

		//3. Click on Login Button using Class Locator
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		Thread.sleep(2000);

		//4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		Thread.sleep(2000);

		//5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Thread.sleep(2000);

		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		Thread.sleep(2000);

		//7. Click on Widget of From Contact
		driver.findElement(By.xpath("//a[contains(@href,'partyIdFrom')]")).click();
		Thread.sleep(2000);

		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(list.get(1));

		//8. Click on First Resulting Contact
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		Thread.sleep(2000);

		//9. Click on Widget of To Contact
		driver.switchTo().window(list.get(0));
		driver.findElement(By.xpath("//a[contains(@href,'partyIdTo')]")).click();
		Thread.sleep(2000);
		System.out.println(list.size());

		//10. Click on Second Resulting Contact
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(list1.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		Thread.sleep(2000);

		//11. Click on Merge button using Xpath Locator
		driver.switchTo().window(list.get(0));
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Thread.sleep(2000);

		//12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);

		//13. Verify the title of the page 
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(2000);
		driver.close();
	}

}