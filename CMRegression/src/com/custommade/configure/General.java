package com.custommade.configure;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class General {

	public static final String SAUCE = "sauce";
	public WebDriver driver;

	/**
	 * Creates and sets up web-driver and its environment. Runs before the
	 * execution of test suite.
	 * 
	 * @param browser
	 *            The name of the browser opened
	 * 
	 * @param node
	 *            The url of the node instance that is opened and accessed
	 */
	@Parameters({ "browser", "username", "key", "os", "browserVersion",
			"sauceLabsUrl", "name" })
	@BeforeClass
	public void setUp(@Optional("") String browser,
			@Optional("") String username, @Optional("") String key,
			@Optional("") String os, @Optional("") String browserVersion,
			@Optional("") String sauceLabsUrl,
			@Optional("") String name) throws IOException {
		DesiredCapabilities capabilities;
		capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browser);
		capabilities.setCapability("version", browserVersion);
		capabilities.setCapability("platform", os);
		capabilities.setCapability("name", name + " - "
				+ getClass().getSimpleName());
		driver = new RemoteWebDriver(new URL("http://" + username + ":" + key
				+ sauceLabsUrl), capabilities);
	}

	/**
	 * Closes the browser instance after execution of a class.
	 * 
	 */
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
