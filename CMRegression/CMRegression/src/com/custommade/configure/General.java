package com.custommade.configure;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.custommade.utility.ApplicationUtility;
import com.custommade.utility.ExcelUtility;
import com.custommade.utility.PropertyUtility;

public class General {

	public static final String ACCOUNT_CREDENTIALS = "Accountcredentials";
	public static final String MESSAGES = "Messages";
	public static final String LOCATORS = "Locators";
	public static final String URLS = "urls";
	public static final String PRIORITY_HIGH = "high";
	public static final String KEY_HOME_PG_TITLE = "homePageTitle";
	public static final String KEY_LOGIN_BTN_HOME_PAGE = "loginButtonInHomePage";
	public static final String KEY_USER_SIGNUP_BTN_IN_LOGIN_MODEL = "userSignupButtonInLoginModal";
	public static final String KEY_FB_SIGNUP_BTN_IN_REG_MODEL = "facebookSignupButtonInRegistrationModal";
	public static final String KEY_FB_LOGIN_USERNAME_FR_REG = "facebookloginusernameforreg";
	public static final String KEY_FB_LOGIN_PSWD_FR_REG = "facebookloginpasswordforreg";
	public static final String KEY_FB_LOGIN_USERNAME = "facebookloginusername";
	public static final String KEY_EMAIL_FIELD_IN_FB = "emailFieldInFacebook";
	public static final String KEY_PSWD_FIELD_IN_FB = "passwordFieldInFacebook";
	public static final String KEY_SIGNIN_BTN_IN_FB = "signInButtonInFacebook";
	public static final String KEY_FB_PAGE_TITLE_FR_SIGNUP = "facebookPageTitleForSignUpPage";
	public static final String KEY_LOGIN_WT_FB_BTN = "loginWithFacebookButton";
	public static final String KEY_ALLOW_BTN_IN_FB_SIGNUP = "allowButtonInsideFacebookSignUp";
	public static final String KEY_FB_PAGE_TITLE_FR_ALLOW_DECISION = "facebookPageTitleForAllowDecision";
	public static final String KEY_WEL_MSG_TXT_ELEMENT_IN_BUYER_WEL_PAGE = "welcomeMessageTextElementInBuyerWelcomePage";
	public static final String KEY_UNVERIFIED_USER_PRE_MSG = "unverifiedUserPreMessage";
	public static final String KEY_UNVERIFIED_USER_POST_MSG = "unverifiedUserPostMessage";
	public static final String KEY_REG_USERNAME = "registrationusername";
	public static final String KEY_REG_FIRSTNAME = "registrationfirstname";
	public static final String KEY_REG_PSWD = "registrationpassword";
	public static final String KEY_USERNAME_FIELD_IN_LOGIN_MODEL = "usernameFieldInLoginModal";
	public static final String KEY_PARTIAL_REGSTRD_USERNAME = "partialregisteredusername";
	public static final String KEY_LOGIN_BTN_IN_LOGIN_MODEL = "loginButtonInLoginModal";
	public static final String KEY_REG_MODEL = "registrationModal";
	public static final String KEY_PARTIAL_REG_FIRSTNAME = "partialregisteredfirstname";
	public static final String KEY_PARTIAL_REG_PSWD = "partialregisteredpassword";
	public static final String KEY_PARTIAL_REG_FIRSTNAME_WT_P = "partialregisteredfirstnamewithp";
	public static final String KEY_USERNAME_TXT_FLD_IN_CMPLT_REG_MODEL = "usernameTextFieldInCompleteRegistrationModal";
	public static final String KEY_PSWD_TXT_FLD_IN_CMPLT_REG_MODEL = "passwordTextFieldInCompleteRegistrationModal";
	public static final String KEY_BTN_IN_CMPLT_REG_MODEL = "buttonInCompleteRegistrationModal";
	public static final String KEY_UNVERIFIED_BUYER_USERNAME = "unverifiedbuyerusername";
	public static final String KEY_UNVERIFIED_BUYER_PSWD = "unverifiedbuyerpassword";
	public static final String KEY_UNVERIFIED_BUYER_FIRSTNAME = "unverifiedbuyerfirstname";
	public static final String KEY_EMAIL_SIGNUP_TXT_FR_UNVERIFIED_USER = "emailSignupTextForUnverifiedUser";
	public static final String KEY_CHECK_YR_EMAIL_TXT = "checkYourEmailText";
	public static final String KEY_BUYER_USERNAME = "buyerusername";
	public static final String KEY_BUYER_PSWD = "buyerpassword";
	public static final String KEY_BUYER_FIRSTNAME = "buyerfirstname";
	public static final String KEY_VERIFIED_USER_PRE_MSG = "verifiedUserPreMessage";
	public static final String KEY_VERIFIED_USER_POST_MSG = "verifiedUserPostMessage";
	public static final String KEY_EMAILID_IN_PARTIAL_REG_MODEL_WT_USERNAME = "emaiIdInPartialRegistrationModalWithUsername";
	public static final String KEY_PARTIAL_REG_USERNAME_WT_P = "partialregisteredusernamewithp";
	public static final String KEY_SIGNUP_BTN_IN_PARTIAL_REG_MODEL_WT_USERNAME = "signupButtonInPartialRegistrationModalWithUsername";
	public static final String KEY_FIRSTNAME_FLD_IN_BUYER_WEL_PAGE = "firstnameFieldInBuyerWelcomePage";
	public static final String KEY_PSWD_FLD_IN_BUYER_WEL_PAGE = "pswdFieldInBuyerWelcomePage";
	public static final String KEY_ZIP_FLD_IN_BUYER_WEL_PAGE = "zipFieldInBuyerWelcomePage";
	public static final String KEY_BUYER_WEL_FIRSTNAME = "buyerWelcomeFirstname";
	public static final String KEY_BUYER_WEL_PSWD = "buyerWelcomePswd";
	public static final String KEY_BUYER_WEL_ZIPCODE = "buyerWelcomeZipCode";
	public static final String KEY_GETIT_CUSTOMMADE_BTN_IN_BUYER_WEL_PAGE = "getItCustomMadeButtonInBuyerWelcomePage";
	public static final String KEY_GET_CUSTOMMADE_BTN = "getCustomMadeBtn";
	public static final String KEY_GET_CUSTOMMADE_BTN_IN_BUYER_WEL_PAGE = "getCustomMadeBtnInBuyerWelPage";
	public static final String KEY_DOWN_ARROW_BTN_IN_BUYER_WEL_PAGE = "downArrowButtonInBuyerWelcomePage";
	public static final String KEY_PSWD_FIELD_IN_LOGIN_MODEL = "passwordFieldInLoginModal";
	public static final String KEY_MAKER_USERNAME = "makerusername";
	public static final String KEY_MAKER_PSWD = "makerpassword";
	public static final String KEY_WORK_WITH_MAKER_BTN = "workwithmaker";
	public static final String KEY_WORK_MAKER_PAGE_URL = "pageForWorkmaker";
	public static final String KEY_TITLE_FIELD_IN_PRIVATE_POST = "titleFieldInPrivatePost";
	public static final String KEY_TEST_TITLE_IN_PRIVATE_POST = "testTitle";
	public static final String KEY_DETAIL_FIELD_IN_PRIVATE_POST = "detailFieldInPrivatePost";
	public static final String KEY_TEST_DETAIL_IN_PRIVATE_POST = "testDetails";
	public static final String KEY_ZIP_FIELD_IN_PRIVATE_POST = "zipFieldInPrivatePost";
	public static final String KEY_ZIP_IN_PRIVATE_POST = "zipcode";
	public static final String KEY_BUDGET_OPTION_IN_PRIVATE_POST = "budgetOptionInPrivatePost";
	public static final String KEY_PROJECT_POST_BTN_IN_PRIVATE_POST = "projectPostBtnInPrivatePost";
	public static final String KEY_GET_CUSTOM_MADE_MAKER_ERROR_MSG_ELEMENT = "errorMsgElementForMakerGetCustomMade";
	public static final String KEY_MAKER_SIGNUP_BTN_IN_HOME_PAGE = "makerSignupButtonInHomePage";
	public static final String KEY_JOIN_IN_MAKER_SIGN_UP_PAGE = "joinButtonInMakerSignUpPage";
	public static final String KEY_CONTINUE_MAKER_REGISTRATION = "continueButtonInMakerSignUpPopUp";
	public static final String KEY_CONTINUE_MAKER__PAID_REGISTRATION = "continueButtonInMakerPaidSignUpPage";
	public static final String KEY_ERR_MSG_TXT_ELEMENT_IN_MKR_REG_PAGE = "errorMessageTextElementInMakerRegistrationPage";
	public static final String KEY_MAKER_REG_ERROR_MSG = "makerRegErrorMessage";
	public static final String KEY_BUYER_ERR_MSG_TXT_ELEMENT_IN_MKR_REG_PAGE = "buyerErrorMessageTextElementInMakerRegistrationPage";
	public static final String KEY_MAKER_REG_ERROR_MSG_FOR_BUYER = "makerRegErrorMessageForBuyer";

	public static final String KEY_MAKER_FIRST_NAME_TXT_FIELD = "makerFirstNameTxtFieldOnSignUp";
	public static final String KEY_MAKER_SECOND_NAME_TXT_FIELD = "makerSecondNameTxtFieldOnSignUp";
	public static final String KEY_MAKER_EMAIL_ID_TXT_FIELD = "makerEmailId";
	public static final String KEY_MAKER_CONFIRMATION_EMAIL_ID_TXT_FIELD = "makerConfirmationEmailId";
	public static final String KEY_MAKER_COMPANY_NAME_TXT_FIELD = "makerCompanyName";
	public static final String KEY_MAKER_PHONE_NUMBER_TXT_FIELD = "makerPhoneNumber";
	public static final String KEY_MAKER_COMPANY_DESCRIPTION_TXT_FIELD = "makerCompanyDescription";
	public static final String KEY_MAKER_CARD_NUMBER_TXT_FIELD = "makerCardNumber";
	public static final String KEY_MAKER_SECURITY_CODE_TXT_FIELD = "makerSecurityCode";
	public static final String KEY_MAKER_EXPIRATION_MONTH_TXT_FIELD = "makerExpirationMonth";
	public static final String KEY_MAKER_EXPIRATION_YEAR_TXT_FIELD = "makerExpirationYear";
	public static final String KEY_MAKER_STREET_ADDRESS_TXT_FIELD = "makerStreetAddress";
	public static final String KEY_MAKER_CITY_TXT_FIELD = "makerCity";
	public static final String KEY_MAKER_STATE_TXT_FIELD = "makerState";
	public static final String KEY_MAKER_ZIP_CODE_TXT_FIELD = "makerZipCode";
	public static final String KEY_MAKER_PASSWORD_TXT_FIELD = "makerPassword";
	public static final String KEY_MAKER_CONFIRM_PASSWORD_TXT_FIELD = "makerConfirmPassword";

	public static final String KEY_MAKER_FIRST_NAME = "newMakerFirstName";
	public static final String KEY_MAKER_SECOND_NAME = "newMakerSecondName";
	public static final String KEY_NEW_MAKER_EMAIL_ID = "newMakerEmailId";
	public static final String KEY_MAKER_COMPANY_NAME = "newmakerCompanyName";
	public static final String KEY_MAKER_PHONE_NUMBER = "newmakerPhoneNumber";
	public static final String KEY_MAKER_COMPANY_DESCRIPTION = "newmakerCompanyDescription";
	public static final String KEY_MAKER_CARD_NUMBER = "newmakerCardNumber";
	public static final String KEY_MAKER_SECURITY_CODE = "newmakerSecurityCode";
	public static final String KEY_MAKER_EXPIRATION_MONTH = "newmakerExpirationMonth";
	public static final String KEY_MAKER_EXPIRATION_YEAR = "newmakerExpirationYear";
	public static final String KEY_MAKER_STREET_ADDRESS = "newmakerStreetAddress";
	public static final String KEY_MAKER_CITY = "newmakerCity";
	public static final String KEY_MAKER_STATE = "newmakerState";
	public static final String KEY_MAKER_ZIP_CODE = "newmakerZipCode";
	public static final String KEY_MAKER_PASSWORD = "newmakerPassword";
	public static final String KEY_ACTIVE_MAKER_EMAIL_ID = "activeMakerEmailId";


	public static final String KEY_SIZE_CUSTOMIZATION_CHECK_BOX = "sizeCustomizationCheckBox";
	public static final String KEY_SIZE_CUSTOMIZATION_TEXT_FIELD = "sizeCustomizationTextField";
	public static final String KEY_SIZE_CUSTOMIZATION_DATA = "sizeCustomization";
	public static final String KEY_MATERIALS_CUSTOMIZATION_CHECK_BOX = "materialsCustomizationCheckBox";
	public static final String KEY_MATERIALS_CUSTOMIZATION_TEXT_FIELD = "materialsCustomizationTextField";
	public static final String KEY_MATERIALS_CUSTOMIZATION_DATA = "materialsCustomization";
	public static final String KEY_DESIGN_CUSTOMIZATION_CHECK_BOX = "designCustomizationCheckBox";
	public static final String KEY_DESIGN_CUSTOMIZATION_TEXT_FIELD = "designCustomizationTextField";
	public static final String KEY_DESIGN_CUSTOMIZATION_DATA = "designCustomization";
	public static final String KEY_OTHER_CUSTOMIZATION_CHECK_BOX = "otherCustomizationCheckBox";
	public static final String KEY_OTHER_CUSTOMIZATION_TEXT_FIELD = "otherCustomizationTextField";
	public static final String KEY_OTHER_CUSTOMIZATION_DATA = "otherCustomization";

	public static final String TXT_LOGIN = "log in";
	public static final String SAMPLE_EMAIL_PREFIX = "user_n";
	public static final String SAMPLE_EMAIL_SUFFIX = "a.com";
	public static final String URL_MEMBER_MY_PROJECTS = "/member/my-projects/";
	public static final String EXT_PNG = ".png";
	public static final String EXT_TXT = ".txt";
	public static final String CONFIG_REPORTS = "ReportsFolder";
	public static final String CONFIG_FF_NODE_URL = "FirefoxNodeUrl";
	public static final String CONFIG_CHROME_NODE_URL = "ChromeUrl";
	public static final String CONFIG_IE_NODE_URL = "IENodeUrl";
	public static final String CONFIG_SAFARI_NODE_URL = "SafariNodeUrl";
	public static final long WAIT_MICRO = 500;
	public static final long WAIT_MIN = 2000;
	public static final long WAIT_AVG = 5000;
	public static final long WAIT_MAX = 5500;
	public static String baseUrl = PropertyUtility.getProperty("Baseurl");
	public static String projectFolder = PropertyUtility.getProperty("Projecthomefolder");
	public static Workbook workbook = ExcelUtility.getWorkbook();
	public static String stepsToReproduce = "";
	
	public static final String GRID = "grid";
	public static final String SAUCE = "sauce";
	public static final String FF = "firefox";
	public static final String CHROME = "chrome";
	public static final String IE = "iexplore";
	public static final String SAFARI = "safari";
	public static String testStartTime = "";
	public WebDriver driver;
	public String runningEnv;

	/**
	 * Creates and sets up web-driver and its environment.
	 * Runs before the execution of test suite.
	 *
	 * @param browser
	 *        The name of the browser opened
	 *    
	 * @param node
	 *        The url of the node instance that is opened and accessed
	 */
	//suraj on 14/3
	@Parameters({"browser", "node", "username", "key", "os", "browserVersion", "sauceLabsUrl", "name", "receipientMailid", "buildNumber"})
	//suraj on 14/3
	@BeforeClass
	public void setUp(String browser, 
			@Optional("http://localhost:5555/wd/hub") String node, 
			@Optional("") String username, 
			@Optional("") String key, 
			@Optional("") String os, 
			@Optional("") String browserVersion, 
			@Optional("@ondemand.saucelabs.com:80/wd/hub") String sauceLabsUrl,
			@Optional("CM Regression Suite") String name, 
			@Optional("receipientMailid") String receipientMailid,
			@Optional("buildNumber") String buildNumber) throws IOException {
		//suraj on 14/3
		Properties prop = new Properties();
		String FILE_CONFIG = "config.properties";
		prop.load(new FileInputStream(FILE_CONFIG));
		PropertyUtility.setPropertyValue("Receipientmailid", receipientMailid);
		System.out.println("buildnumber:"+buildNumber);
		//suraj on 14/3
		DesiredCapabilities capabilities = null;
		if (!key.equalsIgnoreCase("") && !username.equalsIgnoreCase("")) {//sauce labs
			capabilities = new DesiredCapabilities();

			capabilities.setBrowserName(browser);
			capabilities.setCapability("version", browserVersion);
			capabilities.setCapability("platform", os);
			capabilities.setCapability("name", name + " - " + getClass().getSimpleName());
			capabilities.setCapability("record-screenshots", false);
			//suraj on 14/3
			capabilities.setCapability("build", buildNumber);
			driver = new RemoteWebDriver(
					new URL("http://" + username + ":" + key + sauceLabsUrl),
					capabilities);
			runningEnv = SAUCE;
		} else {//grid
			runningEnv = GRID;
			if (browser.equalsIgnoreCase(FF)) {
				capabilities = DesiredCapabilities.firefox();
				capabilities.setPlatform(Platform.ANY);
				capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, false);
			}
			if (browser.equalsIgnoreCase(CHROME)) {
				capabilities = DesiredCapabilities.chrome();
				capabilities.setPlatform(Platform.ANY);
				capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, false);
			}
			if(browser.equalsIgnoreCase(IE)) {
				capabilities= DesiredCapabilities.internetExplorer();
				capabilities.setBrowserName(IE);
				capabilities.setPlatform(Platform.WINDOWS);
				capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, false);
				capabilities.setJavascriptEnabled(true);
			}
			if (browser.equalsIgnoreCase(SAFARI)) {
				capabilities = DesiredCapabilities.safari();
				capabilities.setPlatform(Platform.MAC);
				capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, false);
			}
			driver = new RemoteWebDriver(new URL(node),capabilities);
		}
		init();
	}

	/**
	 * Gets the current instance of WebDriver: FF, Chrome, IE or Safari (Remote/Grid)
	 * Or a driver for Sauce labs or local firefex-webdriver
	 *
	 * @return WebDriver
	 *        The webdriver of current thread.
	 *    
	 */
	public WebDriver getDriver() {
		if (runningEnv.equalsIgnoreCase(GRID) || runningEnv.equalsIgnoreCase(SAUCE)) {
			return driver;
		} else {//local
			return new FirefoxDriver();
		}
	}

	/**
	 * Forces the user to logout 
	 * if the user is already logged in at
	 * the start of the test.
	 * Runs before each test method
	 * 
	 */
	//@BeforeMethod
	public void checkPrerequisiteConditionForLoginTest() throws BiffException,
	IOException {
		ApplicationUtility.logout(getDriver());
	}

	/**
	 * Closes the browser
	 * instance after execution of a class.
	 * 
	 */
	@AfterClass
	public void tearDown() {
		getDriver().quit();
	}

	/**
	 * Initialises the environment for running tests
	 * 
	 */
	public void init() {
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		testStartTime = getCurrentTimeStamp(true);
	}

	/**
	 * Loads the home/index page url
	 * 
	 */
	public static void loadBaseUrl(WebDriver driver){
		driver.get(baseUrl);
	}

	/**
	 * Returns the current time stamp as a string
	 * 
	 * @return formatteDate
	 *        The current timestamp.
	 *        
	 */
	public static String getCurrentTimeStamp() {
		Date date = new Date();
		String dateFormat = "MMddyyyyhmmS";
		SimpleDateFormat simpleDateFormatObject = new SimpleDateFormat(dateFormat);
		String formattedDate = simpleDateFormatObject.format(date);
		return formattedDate;
	}

	/**
	 * Returns the current time stamp as a string
	 * 
	 * @param correctFormat
	 *        true/false to show in exact date-time format.
	 *        
	 * @return formattedDate
	 *        The current timestamp.
	 *        
	 */
	public static String getCurrentTimeStamp(boolean correctFormat) {
		Date date = new Date();
		String dateFormat = "MMddyyyyhmmS";
		if (correctFormat) {
			dateFormat = "MM/dd/yyyy h:mm:S";
		}
		SimpleDateFormat simpleDateFormatObject = new SimpleDateFormat(dateFormat);
		String formattedDate = simpleDateFormatObject.format(date);
		return formattedDate;
	}

	/**
	 * Splits the string after '@' and 
	 * appends the time stamp before @ and rejoins it.
	 * 
	 * @param stringWord
	 *        EmailId that is used to generate random EmailId
	 *        
	 * @return emailId
	 *        Randomly generated emailID
	 */
	public static String getRandomEmailId(String stringWord) {
		String formattedDate = getCurrentTimeStamp();
		String returnString = "";
		if (stringWord != null) {
			String[] strArray = stringWord.split("\\@");
			returnString = strArray[0] + formattedDate + "@" + strArray[1];
		} else {
			returnString = SAMPLE_EMAIL_PREFIX + formattedDate + SAMPLE_EMAIL_SUFFIX;
		}
		return returnString;
	}

	/**
	 * Waits for the component to load
	 * 
	 * @param milliSeconds
	 *        milliseconds to wait
	 */
	public static void waitToLoad(long milliSeconds) throws InterruptedException {
		Thread.sleep(milliSeconds);
	}

}
