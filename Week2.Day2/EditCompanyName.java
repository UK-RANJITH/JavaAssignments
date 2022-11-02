package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditCompanyName {

	public static void main(String[] args) throws InterruptedException {
		//Set path for browser
		WebDriverManager.chromedriver().setup();

		//To launch the chrome browser
		ChromeDriver driver=new ChromeDriver();

		//return type of get : void
		driver.get("http://leaftaps.com/opentaps/control/main");

		//how to maximize the browser
		driver.manage().window().maximize();


		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Democsr2");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();


		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();


		driver.findElement(By.xpath("(//a[contains(text(),'Lead')])[2]")).click();


		driver.findElement(By.xpath("(//input[contains(@name,'company')])[2]")).sendKeys("OLD Company");



		String firstName = "Ranjith";
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Kishore");

		driver.findElement(By.xpath("//input[@name='submitButton']")).click();

		Thread.sleep(6000);
		WebElement findFirstName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']"));
		String findF_Name = findFirstName.getText();

		if(firstName.equals(findF_Name))
			System.out.println("Account is created successfully");
		else
			System.out.println("Account creation is failed");



		driver.findElement(By.xpath("//a[text()='Edit']")).click();


		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		String changeCompanyName = "New Company";
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys(changeCompanyName);


		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
