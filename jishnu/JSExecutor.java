package jishnu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class JSExecutor {
	
	WebDriver driver;

	public void autLaunch(String aut) throws Exception{
		driver = new FirefoxDriver();
		driver.get(aut);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	public void jsExecutor(){
		  JavascriptExecutor js=(JavascriptExecutor) driver;  
		  
		  String readyState=(String)js.executeScript("return document.readyState");  
		  System.out.println("readyState  : "+readyState); 
		  
		  String searchQuery=(String)js.executeScript("var a = document.querySelector('#search_form_input_homepage');var b = document.querySelector('#search_button_homepage'); a.value = 'demo'; b.click(); return 'done';");  
		  System.out.println("SearchStatus  : "+searchQuery); 
		  	            	            
		  String URL=(String)js.executeScript("return document.URL");  
		  System.out.println("Full URL  : "+URL);  
	}
}
