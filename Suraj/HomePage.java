package Suraj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;


public class HomePage extends General{

	@FindBy(how = How.NAME, using = "query")
    @CacheLookup
    private WebElement searchBox;
	
	
	//@FindBy(how = How.XPATH, using = "//*[@class='tf_search_input_box']/button")
	@FindBy(xpath="//*[@class='tf_search_input_box']/button")
	@CacheLookup
	private WebElement searchButton;
	
	public String searchKeyword = "iPad";
	
	

	
	public void navigateTo(WebDriver driver) {
		driver.get(BASE_URL+"");
      	
	}
	
	public void searchKeyword() {
		searchBox.click();
		searchBox.clear();
		searchBox.sendKeys(searchKeyword);
		searchButton.click();
	}
	
	
	
}
