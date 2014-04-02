package Suraj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultsPage {
	
	@FindBy(how = How.XPATH, using = "//div[@id='tf_search_info_content_main_top_bottom']/ul/li/h1")
    @CacheLookup
    private WebElement searchKeywordText;
	
	public String getActualKeyword() {
		String actualKeyword = searchKeywordText.getText();
		return actualKeyword;
	}
	
	

}
