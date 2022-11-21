package week4day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**Assignment 2:
1) Go to https://www.nykaa.com/
2) Mouseover on Brands and Search L'Oreal Paris
3) Click L'Oreal Paris
4) Check the title contains L'Oreal Paris(Hint-GetTitle)
5) Click sort By and select customer top rated
6) Click Category and click Hair->Click haircare->Shampoo
7) Click->Concern->Color Protection
8)check whether the Filter is applied with Shampoo
9) Click on L'Oreal Paris Colour Protect Shampoo
10) GO to the new window and select size as 175ml
11) Print the MRP of the product
12) Click on ADD to BAG
13) Go to Shopping Bag 
14) Print the Grand Total amount
15) Click Proceed
16) Click on Continue as Guest
17) Check if this grand total is the same in step 14
18) Close all windows
 */
public class Assignment2_OnNykaa2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");

		Actions builder = new Actions(driver);
		//2) Mouseover on Brands and Search L'Oreal Paris
		WebElement brandElement = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brandElement).perform();
		Thread.sleep(5000);
		//3) Click L'Oreal Paris
		WebElement lorealElement = driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]"));
		lorealElement.click();
		Thread.sleep(3000);
		//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String title = driver.getTitle();
		System.out.println("Title of the page is: "+title);
		//5) Click sort By and select customer top rated
		driver.findElement(By.className("sort-name")).click();
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");            //Scroll Down(+ve)
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(5000); 

		//6) Click Category and click Hair->Click haircare->Shampoo
		js.executeScript("window.scrollBy(0,200)");            //Scroll Down(+ve)
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(5000);

		js.executeScript("window.scrollBy(0,200)");            //Scroll Down(+ve)
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		Thread.sleep(3000);

		WebElement selectShampoo = driver.findElement(By.xpath("//span[text()='Shampoo']/ancestor::label"));
		String textShampoo = selectShampoo.getText();
		selectShampoo.click();
		Thread.sleep(5000);

		//7) Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)");            //Scroll Down(+ve)
		Thread.sleep(3000);

		String selectFilter = driver.findElement(By.xpath("//span[text()='Color Protection']")).getText();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(3000);
		String verifyFilter = driver.findElement(By.xpath("//span[@class='filter-value' and text()='Color Protection']")).getText();

		if(verifyFilter.contains(selectFilter))
			System.out.println(verifyFilter+" has been selected");
		else
			System.out.println(verifyFilter+" has not been selected");

		Thread.sleep(2000);
		//8)check whether the Filter is applied with Shampoo
		String filterShampoo = driver.findElement(By.xpath("//span[@class='filter-value' and text()='Shampoo']")).getText();
		if(textShampoo.contains(filterShampoo))
			System.out.println(filterShampoo+" has been selected");
		else
			System.out.println(filterShampoo+" has not been selected");

		//9) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.className("css-43m2vm")).click();

		//navigate to another window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));

		//10) GO to the new window and select size as 175ml
		WebElement shampooSize = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select select = new Select(shampooSize);
		select.selectByVisibleText("704ml");
		Thread.sleep(3000);

		String shampooPrice1 = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]/parent::div")).getText();
		System.out.println("Shampoo price of 704ml is : "+shampooPrice1);
		Thread.sleep(3000);
		select.selectByIndex(1);
		Thread.sleep(3000);

		//11) Print the MRP of the product
		String shampooPrice2 = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]/parent::div")).getText();
		System.out.println("Shampoo price of 175ml is "+shampooPrice2);

		//12) Click on ADD to BAG
		driver.findElement(By.className("btn-text")).click();
		Thread.sleep(4000);

		//13) Go to Shopping Bag
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		Thread.sleep(5000);

		/**by default we can give frame index as 0 if it does not work,
		 * give frame id or
		 * give frame name or
		 * give xpath
		 */
		driver.switchTo().frame(0);

		//14) Print the Grand Total amount
		String grandTotal = driver.findElement(By.xpath("//div[contains(@class,'css-i1x59x')]/preceding-sibling::div/span")).getText();
		System.out.println("Grand total is: "+grandTotal);

		//15) Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		//come back from frame
		driver.switchTo().defaultContent();

		//16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[@class='css-110s749 e8tshxd1' and text()='Continue as guest']")).click();
		driver.findElement(By.xpath("(//img[@class='css-16z7tzi ek8d9s80'])[2]")).click();

		//17) Check if this grand total is the same in step 14
		String grandtot = driver.findElement(By.xpath("//p[@class='css-5t7v9l eka6zu20']")).getText();
		if(grandTotal.equals(grandtot))
			System.out.println("Verified same grand total is displaying is guest page too: "+grandtot);

		//18) Close all windows
		driver.quit();

	}

}