package AnuPriya;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AutomationDemo {

	WebDriver driver = new FirefoxDriver();

		public void fetchPage(String pageUrl) throws InterruptedException{
	
			driver.manage().window().maximize();
			// Fetch a Page
			driver.get(pageUrl);
			Thread.sleep(500);
		}
		
		public void clickElement(String elementIdentifier) throws InterruptedException{
			Thread.sleep(3000);
			WebElement dropElement = driver.findElement(By.xpath(elementIdentifier));
			driver.manage().timeouts().implicitlyWait( 60, TimeUnit.SECONDS );
			dropElement.click();
			
		}
		
		public void switchToIframe(String iframeIdentifier) throws InterruptedException{
		
			WebElement iFrame = driver.findElement(By.tagName(iframeIdentifier));
			driver.switchTo().frame(iFrame);
			driver.manage().timeouts().implicitlyWait( 60, TimeUnit.SECONDS );
			Thread.sleep(500);
			
		}
		
		public void navigateToPage(String pageUrl) throws InterruptedException{
			
			driver.navigate().to(pageUrl);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait( 120, TimeUnit.SECONDS );
			//driver.close();
			
		}
}