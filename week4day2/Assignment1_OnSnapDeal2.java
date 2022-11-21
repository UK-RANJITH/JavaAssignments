package week4day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
1. Launch https://www.snapdeal.com/
2. Go to Mens Fashion
3. Go to Sports Shoes
4. Get the count of the sports shoes
5. Click Training shoes
6. Sort by Low to High
7. Check if the items displayed are sorted correctly
8.Select the price range (900-1200)
9.Filter with color yellow 
10 verify the all applied filters 
11. Mouse Hover on first resulting Training shoes
12. click QuickView button
13. Print the cost and the discount percentage
14. Take the snapshot of the shoes. */
public class Assignment1_OnSnapDeal2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Disable browser notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		//1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");

		//Using Actions class for user interactions
		Actions builder = new Actions(driver);

		//2. Go to Mens Fashion by mouse hover 
		WebElement mensFashion = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
		builder.moveToElement(mensFashion).perform();
		Thread.sleep(2000);

		//3. Go to Sports Shoes by normal click
		driver.findElement(By.xpath("//span[contains(text(),'Sports Shoes')]")).click();
		Thread.sleep(2000);

		//4. Get the count of the sports shoes
		List<WebElement> sportsShoe = driver.findElements(By.xpath("//picture[@class='picture-elem']"));
		int sportsShoeCount = sportsShoe.size();
		System.out.println("Sports Shoe count is: "+sportsShoeCount);

		//5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(2000);

		//6. Sort by Low to High
		List<WebElement> trainingShoePrice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		int numOfTrainingShoe = trainingShoePrice.size();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<numOfTrainingShoe;i++)
		{
			String replace1 = trainingShoePrice.get(i).getText().replace("Rs. ", "").replaceAll(",","");
			System.out.println(replace1);
			int parseInt = Integer.parseInt(replace1);
			list.add(parseInt);
		}
		Collections.sort(list);
		System.out.println("Price list low to high: "+list);

		//7. Check if the items displayed are sorted correctly
		boolean sorted = false;
		for(int i=0;i<list.size()-1;i++)
		{
			if(list.get(i)<=list.get(i+1))
				sorted = true;
			else
			{
				sorted = false;
				break;
			}
		}
		if(sorted)
			System.out.println("Price is Sorted");
		else
			System.out.println("Price is not sorted");

		//8.Select the price range (900-1200)
		System.out.println("Price between 600 and 900 are: ");
		for(int i=0;i<list.size()-1;i++)
		{
			if((list.get(i)>=600)&&(list.get(i)<=900))
				System.out.println(list.get(i));
			else
				continue;
		}
		Thread.sleep(5000);
		//9.Filter with color yellow 
		WebElement filter = driver.findElement(By.xpath("//label[@for='Color_s-Yellow']/span"));
		driver.executeScript("arguments[0].click()",filter);
		Thread.sleep(3000);
		//filter.click();

		//10 verify the all applied filters 
		String verifyColor = driver.findElement(By.xpath("//a[text()='Yellow']")).getText();
		System.out.println("Your filtered color is: "+verifyColor);

		//11. Mouse Hover on first resulting Training shoes
		WebElement trainingShoe = driver.findElement(By.xpath("//img[contains(@class,'product-image ')]"));
		builder.moveToElement(trainingShoe).perform();
		Thread.sleep(6000);

		//12. click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick')]")).click();
		Thread.sleep(3000);

		//13. Print the cost and the discount percentage 
		String price = driver.findElement(By.xpath("(//div[@class='product-price pdp-e-i-PAY-l clearfix']/span)[1]")).getText();
		System.out.println("Price of the selected show is: "+price);
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Discount is: "+discount);

		//14. Take the snapshot of the shoes.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/quick.png");
		FileUtils.copyFile(source, dest);
		Thread.sleep(2000);
		driver.close(); 
	}

}