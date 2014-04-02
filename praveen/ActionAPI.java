package praveen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActionAPI {
	
		 WebDriver driver;
		 Actions act ;
		
		 //Application Under Test Launch
		public void autLaunch(String aut) throws Exception{
			driver = new FirefoxDriver();
			driver.get(aut);
			act = new Actions(driver);
			driver.manage().window().maximize();
			Thread.sleep(3000);
		}
	
		public void moveToElement(){
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement reqElement = driver.findElement(By.xpath("//span[text()='COMPANY']"));
			act.moveToElement(reqElement).build().perform();
		}
		
		public void clickOnElement(){
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement reqElement = driver.findElement(By.xpath("//span[text()='COMPANY']"));
			act.click(reqElement).build().perform();
		}

		public void dragAndDropAUTLaunch(){
			//** switch to frame
			//driver.switchTo().frame(0);
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			WebElement source = driver.findElement(By.id("draggable"));
			WebElement dest = driver.findElement(By.id("droppable"));
			act.dragAndDrop(source, dest).build().perform();
		}
		
		public void sendKeysTrial(){
			WebElement element = driver.findElement(By.name("q"));
		    Actions action = new Actions(driver);
		    element.sendKeys("qburst");
		    action.sendKeys(element,Keys.ENTER).perform();
		}
		
}

