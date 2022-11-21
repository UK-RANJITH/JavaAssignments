package week4day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**Assignment 3 :
https://jqueryui.com/sortable/ - https://www.vinsguru.com/selenium-webdriver-automating-custom-controls-jquery-sortable-elements/
https://jqueryui.com/droppable/
https://jqueryui.com/resizable/
https://jqueryui.com/selectable/*/
public class Assignment3_OnjqueryUI {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions action = new Actions(driver);

		driver.get("https://jqueryui.com/sortable/");
		driver.switchTo().frame(0);
		WebElement sortable1 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		//action.dragAndDropBy(sortable, 110, 70); - will not work this 
		//action.clickAndHold(sortable).moveByOffset(80, 180).perform(); - just hold it, will not release
		action.clickAndHold(sortable1).moveByOffset(80, 180).release().build().perform();
		Thread.sleep(4000);
		WebElement sortable2 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		action.clickAndHold(sortable2).moveByOffset(90, 140).release().build().perform();
		Thread.sleep(4000);

		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		action.dragAndDrop(drag, drop).perform();
		Thread.sleep(2000);

		driver.get("https://jqueryui.com/resizable/");
		driver.switchTo().frame(0);
		WebElement resizable =  driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		action.clickAndHold(resizable).moveByOffset(67, 200).release().build().perform();
		Thread.sleep(4000);
		//action.clickAndHold(resizable).moveByOffset(100, 150).perform(); - need to release the mouse holder
		Thread.sleep(4000);

		driver.get("https://jqueryui.com/selectable/");
		driver.switchTo().frame(0);
		WebElement selectable = driver.findElement(By.xpath("//ol[@id='selectable']"));
		action.clickAndHold(selectable).moveByOffset(50, 80).release().build().perform();

		driver.close();
	}

}