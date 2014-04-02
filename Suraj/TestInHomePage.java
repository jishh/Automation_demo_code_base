package Suraj;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class TestInHomePage extends General {
	
	public static void main(String[] args) throws InterruptedException {
		driver = new FirefoxDriver();
        // Create a new instance of the search page class and initialize any WebElement fields in it.
		homePage = PageFactory.initElements(driver, HomePage.class);
		searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
		homePage.navigateTo(driver);
		homePage.searchKeyword();
		Thread.sleep(5000);
		String actualKeyword = searchResultsPage.getActualKeyword().toLowerCase();
		String expectedKeyword = homePage.searchKeyword.toLowerCase();
		Assert.assertEquals(actualKeyword, expectedKeyword);
		driver.close();
		
	}
	

}
