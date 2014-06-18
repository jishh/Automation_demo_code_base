package com.custommade.utility;

import java.io.IOException;
import java.util.List;

import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.custommade.configure.General;

/**
 * 
 * @author anokh 
 * ClassName: ApplicationUtility 
 * Description: This class is to
 *              keep the common functionalities used through out the tests such as
 *              login, logout,etc.
 */
@SuppressWarnings("unchecked")
public class ApplicationUtility extends ExcelUtility {

	/*
	 * Method Name: customMadeLogin
	 * 
	 * Description: This function is for logging
	 * in to the site with custom username and password
	 */
	public static void customMadeLogin(WebDriver driver, String username,
			String password) throws BiffException, IOException, InterruptedException {
		General.waitToLoad(General.WAIT_MIN);
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                "usernameFieldInLoginModal", General.LOCATORS), username);
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                "passwordFieldInLoginModal", General.LOCATORS), password);
		WebElement loginButtonInLoginModal = driver.findElement(By
				.id(ExcelUtility.getValueForKeyword("loginButtonInLoginModal",
						General.LOCATORS)));
		loginButtonInLoginModal.click();
		General.waitToLoad(General.WAIT_MIN);
	}

	/*
	 * Method Name: customMadeLogout 
	 * 
	 * Description: This function is for logging
	 * out from the site
	 */
	public static void customMadeLogout(WebDriver driver) throws BiffException,
	IOException, InterruptedException {

		waitTillClickable(driver, By.xpath(ExcelUtility.getValueForKeyword(
				General.KEY_DOWN_ARROW_BTN_IN_BUYER_WEL_PAGE, General.LOCATORS))).click();
		General.waitToLoad(General.WAIT_MIN);
		WebElement logoutButtonInBuyerWelcomePage = waitTillClickable(driver, By
				.xpath(ExcelUtility.getValueForKeyword(
						"logoutButtonInBuyerWelcomePage", General.LOCATORS)));
		logoutButtonInBuyerWelcomePage.click();
		General.waitToLoad(General.WAIT_AVG);
	}

	/*
	 * Method Name: customMadeRegistration
	 * 
	 * Description: This function is for
	 * registering to the site with custom username, firstname and password
	 */
	public static void customMadeRegistration(WebDriver driver, String username, String firstname, String password)
	throws BiffException, IOException, InterruptedException {
		WebElement loginButtonInHomePage = waitTillClickable(driver, By
				.xpath(ExcelUtility.getValueForKeyword("loginButtonInHomePage",
						General.LOCATORS)));
		loginButtonInHomePage.click();
		
		WebElement userSignupButtonInLoginModal = waitTillClickable(driver, By
				.xpath(ExcelUtility.getValueForKeyword(
						"userSignupButtonInLoginModal", General.LOCATORS)));
		userSignupButtonInLoginModal.click();
		General.waitToLoad(General.WAIT_MIN);
		inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                "emailFieldInRegistrationModal", General.LOCATORS), username);
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                "firstnameFieldInRegistrationModal", General.LOCATORS), firstname);
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                "passwordFieldInRegistrationModal", General.LOCATORS), password);
        
        General.waitToLoad(General.WAIT_MIN);
		
		WebElement signupButtonInRegistrationModal = driver.findElement(By
				.id(ExcelUtility.getValueForKeyword(
						"signupButtonInRegistrationModal", General.LOCATORS)));
		signupButtonInRegistrationModal.click();
	}

	/*
	 * Method Name:facebookLogin
	 * 
	 * Description: This function is for logging in
	 * to the facebook with facebook credentials
	 */
	/*public static void facebookLogin(String facebookUsername,
			String facebookPassword) throws BiffException, IOException {
		Set handles = General.driver.getWindowHandles();
		General.driver.switchTo().window((String) handles.toArray()[1]);
		WebElement myDynamicElement = (new WebDriverWait(General.driver, 10))
		.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.id("email"));
			}
		});
		WebElement emailFieldInFacebook = General.driver.findElement(By.id(ExcelUtility
				.getValueForKeyword("emailFieldInFacebook", General.LOCATORS)));
		emailFieldInFacebook.click();
		emailFieldInFacebook.clear();
		emailFieldInFacebook.sendKeys(facebookUsername);
		WebElement passwordFieldInFacebook = General.driver.findElement(By
				.id(ExcelUtility.getValueForKeyword("passwordFieldInFacebook",
						General.LOCATORS)));
		passwordFieldInFacebook.click();
		passwordFieldInFacebook.clear();
		passwordFieldInFacebook.sendKeys(facebookPassword);
		WebElement signInButtonInFacebook = General.driver.findElement(By
				.id(ExcelUtility.getValueForKeyword("signInButtonInFacebook",
						General.LOCATORS)));
		signInButtonInFacebook.click();
	}*/

	/*
	 * Method Name:startProjectCards
	 * 
	 * Description: This function is completing
	 * the 4 cards shown during start a project
	 */
	public static void startProjectCards(WebDriver driver, String projectName,
			String zipcode, String description) throws BiffException,
			IOException, InterruptedException {
		General.waitToLoad(General.WAIT_MIN);
		
		//suraj
		WebElement projectDescriptionFieldInsideCard2 = waitTillClickable(driver, By
				.id(ExcelUtility.getValueForKeyword(
						"projectDescriptionFieldInsideCard2", General.LOCATORS)));
		projectDescriptionFieldInsideCard2.click();
		projectDescriptionFieldInsideCard2.clear();
		projectDescriptionFieldInsideCard2.sendKeys(description);
		WebElement continueButtonInsideCard = driver.findElement(By
				.id(ExcelUtility.getValueForKeyword("continueButtonInsideCard",
						General.LOCATORS)));
		continueButtonInsideCard.click();
		
		int randomNumberForProjectAmountRadioButton = 0 + (int) (Math.random() * (8));
		WebElement projectAmountRadioButtonInCard3 = waitTillClickable(driver, By
				.id(ExcelUtility.getValueForKeyword(
						"projectAmountRadioButtonInCard3", General.LOCATORS)
						+ randomNumberForProjectAmountRadioButton));
		projectAmountRadioButtonInCard3.click();
		continueButtonInsideCard.click();
		
		WebElement projectNameTextFieldInsideCard1 = waitTillClickable(driver, By
				.id(ExcelUtility.getValueForKeyword(
						"projectNameTextFieldInsideCard1", General.LOCATORS)));
		projectNameTextFieldInsideCard1.click();
		projectNameTextFieldInsideCard1.clear();
		projectNameTextFieldInsideCard1.sendKeys(projectName);
		WebElement zipcodeTextFieldInsideCard1 = driver.findElement(By
				.id(ExcelUtility.getValueForKeyword(
						"zipcodeTextFieldInsideCard1", General.LOCATORS)));
		zipcodeTextFieldInsideCard1.click();
		zipcodeTextFieldInsideCard1.clear();
		zipcodeTextFieldInsideCard1.sendKeys(zipcode);
		continueButtonInsideCard.click();
		int randomNumberForMakerContactRadioButton = 1;
        WebElement findingMakersRadioButtonInsideCard4 = driver.findElement(By
                        .id(ExcelUtility.getValueForKeyword(
                                        "findingMakersRadioButtonInsideCard4", General.LOCATORS)
                                        + randomNumberForMakerContactRadioButton));
        findingMakersRadioButtonInsideCard4.click();
		continueButtonInsideCard.click();
		//suraj
		
		
		General.waitToLoad(General.WAIT_AVG);
	}

	/*
	 * Method Name:partialRegistrationFormSubmittingWithUsername
	 * 
	 * Description:
	 * This function is for filling the partial registration form by entering
	 * the mailid only
	 */
	public static void partialRegistrationFormSubmittingWithUsername(WebDriver driver, String registrationMailId) 
	throws BiffException,IOException, InterruptedException {
		General.waitToLoad(General.WAIT_MIN);
	    
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                "emaiIdInPartialRegistrationModalWithUsername",
                General.LOCATORS), registrationMailId);
        
		WebElement signupButtonInPartialRegistrationModalWithUsername = driver
		.findElement(By.id(ExcelUtility.getValueForKeyword(
				"signupButtonInPartialRegistrationModalWithUsername",
				General.LOCATORS)));
		signupButtonInPartialRegistrationModalWithUsername.click();
		General.waitToLoad(General.WAIT_AVG);
	}

	/*
	 * Method Name:partialRegisteredUserLogin
	 * 
	 * Description: This function
	 * allows the user login as a partial registered buyer.
	 */
	public static void partialRegistration(WebDriver driver, String partialRegisteredUsername) 
	throws BiffException, IOException, InterruptedException {

		driver.get(General.baseUrl +ExcelUtility.getValueForKeyword("pageForPartialRegistration",
				General.URLS));
		WebElement getItCustomMadeButtonInProjectDetailsPage = waitTillClickable(driver, By.xpath(ExcelUtility.getValueForKeyword(
				General.KEY_GET_CUSTOMMADE_BTN_IN_BUYER_WEL_PAGE, General.LOCATORS)));
		getItCustomMadeButtonInProjectDetailsPage.click();
		General.waitToLoad(General.WAIT_AVG);
		partialRegistrationFormSubmittingWithUsername(driver, partialRegisteredUsername);

	}

	/*
	 * Method Name:completeRegistrationFormSubmit
	 * 
	 * Description: This function
	 * allows the user to submit the complete registration form.
	 */
	public static void completeRegistrationFormSubmit(WebDriver driver, String firstname, String password) 
	throws BiffException, IOException, InterruptedException {
		General.waitToLoad(General.WAIT_MIN);

        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                "usernameTextFieldInCompleteRegistrationModal",
                General.LOCATORS), firstname);
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                "passwordTextFieldInCompleteRegistrationModal",
                General.LOCATORS), password);

        WebElement buttonInCompleteRegistrationModal = waitTillClickable(driver, By
				.id(ExcelUtility.getValueForKeyword(
						"buttonInCompleteRegistrationModal", General.LOCATORS)));
		buttonInCompleteRegistrationModal.click();
		General.waitToLoad(General.WAIT_AVG);
	}

	/*
	 * Method Name:logout
	 * 
	 * Description: This function
	 * allows the user to submit the complete registration form.
	 */
	public static void logout(WebDriver driver) {
		try {
			//General.loadBaseUrl(driver);
			driver.get(General.baseUrl);
			String loginText = driver.findElement(By
					.xpath("//div[2]/section[1]/aside/nav/ul/li[2]")).getText();
			if (!loginText.equalsIgnoreCase(General.TXT_LOGIN)) {
				customMadeLogout(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method Name: waitTillBuyerLoginComplete 
	 * 
	 * Description: This function waits
	 * till the buyer is successfully logged in by waiting till My projects text
	 * is available inside the buyer welcome page after logging in .
	 */
	public static void waitTillBuyerLoginComplete(WebDriver driver)
	throws BiffException, IOException {
		final String myProjectLinkInBuyerWelcomePage = ExcelUtility
		.getValueForKeyword("myProjectLinkInBuyerWelcomePage", General.LOCATORS);
		WebElement myProjectLinkInBuyerWelcomePageElement = (new WebDriverWait(
				driver, 20)).until(new ExpectedCondition<WebElement>() {
					@Override
					public WebElement apply(WebDriver d) {
						return d.findElement(By
								.partialLinkText(myProjectLinkInBuyerWelcomePage));
					}
				});
	}

	/*
	 * Method Name: waitTillMakerLoginComplete
	 * 
	 * Description: This function
	 * waits till the maker is successfully logged in by waiting till My
	 * projects text is available inside the buyer welcome page after logging in
	 * .
	 */
	public static void waitTillMakerLoginComplete(WebDriver driver)
	throws BiffException, IOException {
		final String portfolioTextInMakerWelcomePage = ExcelUtility
		.getValueForKeyword("portfolioTextInMakerWelcomePage", General.LOCATORS);
		WebElement portfolioTextInMakerWelcomePageElement = (new WebDriverWait(
				driver, 10)).until(new ExpectedCondition<WebElement>() {
					@Override
					public WebElement apply(WebDriver d) {
						return d.findElement(By
								.partialLinkText(portfolioTextInMakerWelcomePage));
					}
				});
	}

	/*
	 * Method Name: projectPageAssertion 
	 * 
	 * Description: This function will check
	 * whether the user has successfully reached the project home page.
	 */
	public static void projectPageAssertion(WebDriver driver, String projectName)
	throws BiffException, IOException {
		WebElement projectNameInProjectHomePage = driver.findElement(By
				.xpath(ExcelUtility.getValueForKeyword(
						"projectNameInProjectHomePage", General.LOCATORS)));
		String expectedProjectNameInProjectHomePage = projectName
		+ ExcelUtility.getValueForKeyword(
				"postProjectNameMessageInProjectHomePage", General.MESSAGES);
		String actualProjectName = projectNameInProjectHomePage.getText();
		Assert.assertEquals(actualProjectName,
				expectedProjectNameInProjectHomePage);
	}

	/*
	 * Method Name: launchGetStartedOnCustomMadeModel 
	 * 
	 * Description: This function will launch the 
	 * partial-reg model from GetItCustommade page.
	 */
	public static void launchGetStartedOnCustomMadeModel(WebDriver driver) 
	throws BiffException, IOException {
		driver.get( General.baseUrl + 
				ExcelUtility.getValueForKeyword( "pageForPartialRegistration",
						General.URLS ) );

		WebElement getItCustomMadeButtonInProjectDetailsPage = ApplicationUtility.waitTillClickable(driver, By.xpath( ExcelUtility.getValueForKeyword(
				General.KEY_GET_CUSTOMMADE_BTN_IN_BUYER_WEL_PAGE, General.LOCATORS ) ) );
		getItCustomMadeButtonInProjectDetailsPage.click();
	}
	
	
	/*
	 * Method Name: launchGetStartedOnCustomMadeModelWithCustomizations//Anokh 
	 * 
	 * Description: This function will launch the 
	 * partial-reg model from GetItCustommade page after specifying customization data.
	 */
	public static void launchGetStartedOnCustomMadeModelWithCustomizations(WebDriver driver) 
	throws BiffException, IOException, InterruptedException {
		driver.get( General.baseUrl + 
				ExcelUtility.getValueForKeyword( "pageForPartialRegistration",
						General.URLS ) );	
		
		WebElement sizeCheckBox=driver.findElement(By
				.id(ExcelUtility.getValueForKeyword(General.KEY_SIZE_CUSTOMIZATION_CHECK_BOX,
						General.LOCATORS)));
		sizeCheckBox.click();
		
		WebElement sizeCustomizationTextField=driver.findElement(By
				.name(ExcelUtility.getValueForKeyword(General.KEY_SIZE_CUSTOMIZATION_TEXT_FIELD,
						General.LOCATORS)));
	
		sizeCustomizationTextField.click();
		sizeCustomizationTextField.clear();		
		sizeCustomizationTextField.sendKeys(ExcelUtility.getValueForKeyword(General.KEY_SIZE_CUSTOMIZATION_DATA,
				General.ACCOUNT_CREDENTIALS));
				
		
		WebElement materialsCheckBox=driver.findElement(By
				.xpath(ExcelUtility.getValueForKeyword(General.KEY_MATERIALS_CUSTOMIZATION_CHECK_BOX,
						General.LOCATORS)));
		materialsCheckBox.click();
		
		WebElement materialsCustomizationTextField=driver.findElement(By
				.name(ExcelUtility.getValueForKeyword(General.KEY_MATERIALS_CUSTOMIZATION_TEXT_FIELD,
						General.LOCATORS)));
	
		materialsCustomizationTextField.click();
		materialsCustomizationTextField.clear();		
		materialsCustomizationTextField.sendKeys(ExcelUtility.getValueForKeyword(General.KEY_MATERIALS_CUSTOMIZATION_DATA,
				General.ACCOUNT_CREDENTIALS));
		
		
		WebElement designCheckBox=driver.findElement(By
				.id(ExcelUtility.getValueForKeyword(General.KEY_DESIGN_CUSTOMIZATION_CHECK_BOX,
						General.LOCATORS)));
		designCheckBox.click();
		
		WebElement designCustomizationTextField=driver.findElement(By
				.name(ExcelUtility.getValueForKeyword(General.KEY_DESIGN_CUSTOMIZATION_TEXT_FIELD,
						General.LOCATORS)));
	
		designCustomizationTextField.click();
		designCustomizationTextField.clear();		
		designCustomizationTextField.sendKeys(ExcelUtility.getValueForKeyword(General.KEY_DESIGN_CUSTOMIZATION_DATA,
				General.ACCOUNT_CREDENTIALS));			
		
		
		WebElement otherCustomizationCheckBox=driver.findElement(By
				.id(ExcelUtility.getValueForKeyword(General.KEY_OTHER_CUSTOMIZATION_CHECK_BOX,
						General.LOCATORS)));
		otherCustomizationCheckBox.click();
		
		WebElement otherCustomizationTextField=driver.findElement(By
				.xpath(ExcelUtility.getValueForKeyword(General.KEY_OTHER_CUSTOMIZATION_TEXT_FIELD,
						General.LOCATORS)));
	
		otherCustomizationTextField.click();
		otherCustomizationTextField.clear();		
		otherCustomizationTextField.sendKeys(ExcelUtility.getValueForKeyword(General.KEY_OTHER_CUSTOMIZATION_DATA,
				General.ACCOUNT_CREDENTIALS));
		
		
		
		WebElement getItCustomMadeButtonInProjectDetailsPage = driver
		.findElement( By.xpath( ExcelUtility.getValueForKeyword(
				General.KEY_GET_CUSTOMMADE_BTN_IN_BUYER_WEL_PAGE, General.LOCATORS ) ) );
		getItCustomMadeButtonInProjectDetailsPage.click();
	}


	/*
	 * Method Name: launchMakerRegistrationModel 
	 * 
	 * Description: This function will launch the 
	 * Maker-registration model from Custommade home page.
	 */
	public static void launchMakerRegistrationModel(WebDriver driver) 
	throws BiffException, IOException, InterruptedException {
		driver.get(General.baseUrl);	
		driver.findElement(By
				.xpath(ExcelUtility.getValueForKeyword(General.KEY_MAKER_SIGNUP_BTN_IN_HOME_PAGE,
						General.LOCATORS))).click();
		Thread.sleep(3000);
		driver.findElement(By
				.xpath(ExcelUtility.getValueForKeyword(General.KEY_JOIN_IN_MAKER_SIGN_UP_PAGE,
						General.LOCATORS))).click();

		WebElement makerFirstName = driver.findElement(By
				.id(ExcelUtility.getValueForKeyword(General.KEY_MAKER_FIRST_NAME_TXT_FIELD,
						General.LOCATORS)));
		makerFirstName.click();
		makerFirstName.clear();
		makerFirstName.sendKeys(ExcelUtility.getValueForKeyword(General.KEY_MAKER_FIRST_NAME,
				General.ACCOUNT_CREDENTIALS));
		WebElement makerSecondName = driver.findElement(By
				.id(ExcelUtility.getValueForKeyword(General.KEY_MAKER_SECOND_NAME_TXT_FIELD,
						General.LOCATORS)));
		makerSecondName.click();
		makerSecondName.clear();
		makerSecondName.sendKeys(ExcelUtility.getValueForKeyword(General.KEY_MAKER_SECOND_NAME,
				General.ACCOUNT_CREDENTIALS));
	}



	/*
	 * Method Name: checkYourEmailAssert 
	 * 
	 * Description: This function will check
	 * whether the user has successfully getting the email verify pop-up.
	 */
	public static void checkYourEmailAssert(WebDriver driver) throws BiffException, IOException {
		WebElement emailSignupTextForUnverifiedUser = driver.findElement(By
				.xpath(ExcelUtility.getValueForKeyword(
						General.KEY_EMAIL_SIGNUP_TXT_FR_UNVERIFIED_USER, General.LOCATORS)));
		String actualTitleOfEmailVerifyPopup = emailSignupTextForUnverifiedUser
		.getText();
		String expectedTitleOfEmailVerifyPopup = ExcelUtility
		.getValueForKeyword(General.KEY_CHECK_YR_EMAIL_TXT, General.MESSAGES);
		Assert.assertEquals(actualTitleOfEmailVerifyPopup,
				expectedTitleOfEmailVerifyPopup);
	}

	/*
	 * Method Name: fillBuyerWelcomePage 
	 * 
	 * Description: This function will fill-up 
	 * the inputs on buyer-welcome page and submit the form.
	 */
	public static void fillBuyerWelcomePage(WebDriver driver) throws BiffException, IOException, InterruptedException {
		
        String buyerWelFirstname = ExcelUtility.getValueForKeyword(
                General.KEY_BUYER_WEL_FIRSTNAME, General.ACCOUNT_CREDENTIALS );
        String buyerWelPswd = ExcelUtility.getValueForKeyword(
                General.KEY_BUYER_WEL_PSWD, General.ACCOUNT_CREDENTIALS );
        String buyerWelZipCode = ExcelUtility.getValueForKeyword(
                General.KEY_BUYER_WEL_ZIPCODE, General.ACCOUNT_CREDENTIALS );
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                General.KEY_FIRSTNAME_FLD_IN_BUYER_WEL_PAGE,
                General.LOCATORS ), buyerWelFirstname);
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                General.KEY_PSWD_FLD_IN_BUYER_WEL_PAGE,
                General.LOCATORS ), buyerWelPswd);
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                General.KEY_ZIP_FLD_IN_BUYER_WEL_PAGE,
                General.LOCATORS ), buyerWelZipCode);
        
		driver.findElement( By.xpath( ExcelUtility.getValueForKeyword(
				General.KEY_GET_CUSTOMMADE_BTN,
				General.LOCATORS ) ) ).click();

		General.waitToLoad(General.WAIT_AVG);
	}

	/*
	 * Method Name: fillZipInBuyerWelcomePage 
	 * 
	 * Description: This function will fill-up 
	 * the zip code input on buyer-welcome page and submit the form.
	 */
	public static void fillZipInBuyerWelcomePage(WebDriver driver) throws BiffException, IOException, InterruptedException {

        String buyerWelZipCode = ExcelUtility.getValueForKeyword(
                General.KEY_BUYER_WEL_ZIPCODE, General.ACCOUNT_CREDENTIALS );
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                "zipFieldAloneInBuyerWelcomePage",
                General.LOCATORS ), buyerWelZipCode);

		waitTillClickable(driver, By.xpath( ExcelUtility.getValueForKeyword(
				General.KEY_GET_CUSTOMMADE_BTN,
				General.LOCATORS ) ) ).click();
		General.waitToLoad(General.WAIT_AVG);
	}

	/*
	 * Method Name: loginThroughPartialRegModel 
	 * 
	 * Description: This function will fill-up 
	 * the zip code input on buyer-welcome page and submit the form.
	 */
	public static void loginThroughPartialRegModel(WebDriver driver, String username, String pswd) throws BiffException, IOException, InterruptedException {
		General.waitToLoad(General.WAIT_MIN);
		
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                General.KEY_EMAILID_IN_PARTIAL_REG_MODEL_WT_USERNAME,
                General.LOCATORS ), username);
        
        waitTillClickable(driver, By.id( ExcelUtility.getValueForKeyword(
				General.KEY_SIGNUP_BTN_IN_PARTIAL_REG_MODEL_WT_USERNAME,
				General.LOCATORS ) ) ).click();
		General.waitToLoad(General.WAIT_AVG);
		
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                General.KEY_PSWD_FIELD_IN_LOGIN_MODEL, General.LOCATORS), pswd);
        
		WebElement loginButtonInLoginModal = driver.findElement(By
				.id(ExcelUtility.getValueForKeyword(General.KEY_LOGIN_BTN_IN_LOGIN_MODEL,
						General.LOCATORS)));
		loginButtonInLoginModal.click();
	}

	/*
     * Method Name: login 
     * 
     * Description: This function will click the login button in Home page.
     */
	public static void login(WebDriver driver, String username, String pswd) throws BiffException, IOException, InterruptedException {
		WebElement loginButtonInHomePage = driver.findElement(By
				.xpath(ExcelUtility.getValueForKeyword(General.KEY_LOGIN_BTN_HOME_PAGE,
						General.LOCATORS)));
		loginButtonInHomePage.click();
		customMadeLogin(driver, username, pswd);
	}

	/*
     * Method Name: myProjectAssertion 
     * 
     * Description: This function will assert the welcome text message in buyer welcome page.
     */
	public static void myProjectPageAssertion(WebDriver driver) throws BiffException, IOException {
		WebElement actualWelcomeMessageTextElement = driver.findElement(By
				.xpath(ExcelUtility
						.getValueForKeyword(
								General.KEY_WEL_MSG_TXT_ELEMENT_IN_BUYER_WEL_PAGE,
								General.LOCATORS)));
		String actualWelcomeMessageText = actualWelcomeMessageTextElement.getText();
		Assert.assertTrue(actualWelcomeMessageText.contains(
				ExcelUtility.getValueForKeyword(General.KEY_VERIFIED_USER_PRE_MSG, General.MESSAGES)) && 
				actualWelcomeMessageText.contains(
						ExcelUtility.getValueForKeyword(General.KEY_VERIFIED_USER_POST_MSG, General.MESSAGES)));
	}

	 /*
     * Method Name: launchWorkWithMaker 
     * 
     * Description: This function will launch the work with maker page.
     */
	public static void launchWorkWithMaker(WebDriver driver) throws BiffException, IOException, InterruptedException {
		driver.get( General.baseUrl + ExcelUtility.getValueForKeyword(General.KEY_WORK_MAKER_PAGE_URL,
				General.URLS ) );
		General.waitToLoad(General.WAIT_AVG);
		WebElement workwithMakerbutton = waitTillClickable(driver, By.xpath( ExcelUtility.getValueForKeyword(
				General.KEY_WORK_WITH_MAKER_BTN,
				General.LOCATORS ) ) );
		workwithMakerbutton.click();
	}

	/*
     * Method Name: submitRandomUsernameInPartialRegModel
     * Description: This function will fill-up 
     * the username field in Partial registration form.
     */
	public static void submitRandomUsernameInPartialRegModel(WebDriver driver) throws BiffException, IOException, InterruptedException {
		String partialRegUsername = General.getRandomEmailId( ExcelUtility.getValueForKeyword(
				General.KEY_PARTIAL_REG_USERNAME_WT_P, General.ACCOUNT_CREDENTIALS ) );
		
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                General.KEY_EMAILID_IN_PARTIAL_REG_MODEL_WT_USERNAME,
                General.LOCATORS ), partialRegUsername);

		waitTillClickable(driver, By.id( ExcelUtility.getValueForKeyword(
				General.KEY_SIGNUP_BTN_IN_PARTIAL_REG_MODEL_WT_USERNAME,
				General.LOCATORS ) ) ).click();
	}

	/*
     * Method Name: submitRandomUsernameInPartialRegModel
     * Description: This function will fill-up 
     * the username field in Partial registration form.
     */
	public static void submitRandomUsernameInPartialRegModel(WebDriver driver, String partialRegUsername) throws BiffException, IOException, InterruptedException {
		General.waitToLoad(General.WAIT_MIN);

		inputTextFieldEnter(driver,  ExcelUtility.getValueForKeyword(
	               "emaiIdInPartialRegistrationModalWithUsername",
	               General.LOCATORS), partialRegUsername);

		waitTillClickable(driver, By.id( ExcelUtility.getValueForKeyword(
				General.KEY_SIGNUP_BTN_IN_PARTIAL_REG_MODEL_WT_USERNAME,
				General.LOCATORS ) ) ).click();
		General.waitToLoad(General.WAIT_MIN);
	}

	/*
     * Method Name: submitCompleteRegModel
     * Description: This function will complete the registration form.
     */
	public static void submitCompleteRegModel(WebDriver driver) throws BiffException, IOException, InterruptedException {
		
        String regFirstname = ExcelUtility.getValueForKeyword(
                General.KEY_PARTIAL_REG_FIRSTNAME_WT_P, General.ACCOUNT_CREDENTIALS );
        String regPswd = ExcelUtility.getValueForKeyword(
                General.KEY_PARTIAL_REG_PSWD, General.ACCOUNT_CREDENTIALS );
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                General.KEY_USERNAME_TXT_FLD_IN_CMPLT_REG_MODEL,
                General.LOCATORS ), regFirstname);
        inputTextFieldEnter(driver, ExcelUtility.getValueForKeyword(
                General.KEY_PSWD_TXT_FLD_IN_CMPLT_REG_MODEL,
                General.LOCATORS), regPswd);
        
		waitTillClickable(driver, By.id( ExcelUtility.getValueForKeyword(
				General.KEY_BTN_IN_CMPLT_REG_MODEL,
				General.LOCATORS ) ) ).click();
	}

	/*
     * Method Name: submitPrivatePostForm 
     * 
     * Description: This function will complete the private post form.
     */
	public static void submitPrivatePostForm(WebDriver driver) throws BiffException, IOException, InterruptedException {
		
		General.waitToLoad(General.WAIT_AVG);
		
		WebElement test = waitTillPresence(driver, By.id( ExcelUtility.getValueForKeyword(
				General.KEY_TITLE_FIELD_IN_PRIVATE_POST,
				General.LOCATORS ) ) );
		test.clear();
		test.sendKeys( ExcelUtility.getValueForKeyword(
				General.KEY_TEST_TITLE_IN_PRIVATE_POST,
				General.ACCOUNT_CREDENTIALS ) );

		WebElement id_details = driver
		.findElement( By.id( ExcelUtility.getValueForKeyword(
				General.KEY_DETAIL_FIELD_IN_PRIVATE_POST,
				General.LOCATORS ) ) );
		id_details.clear();
		id_details.sendKeys( ExcelUtility.getValueForKeyword(
				General.KEY_TEST_DETAIL_IN_PRIVATE_POST,
				General.ACCOUNT_CREDENTIALS ) );

		WebElement id_zipcode = driver
		.findElement( By.id( ExcelUtility.getValueForKeyword(
				General.KEY_ZIP_FIELD_IN_PRIVATE_POST,
				General.LOCATORS ) ) );
		id_zipcode.clear();
		id_zipcode.sendKeys( ExcelUtility.getValueForKeyword(
				General.KEY_ZIP_IN_PRIVATE_POST,
				General.ACCOUNT_CREDENTIALS ) );

		WebElement budgetOptionRadioBtn =  waitTillPresence(driver, By.id( ExcelUtility.getValueForKeyword(
				General.KEY_BUDGET_OPTION_IN_PRIVATE_POST,
				General.LOCATORS ) ) );
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", budgetOptionRadioBtn);

		waitTillClickable(driver, By.id( ExcelUtility.getValueForKeyword(
				General.KEY_PROJECT_POST_BTN_IN_PRIVATE_POST,
				General.LOCATORS ) ) ).click();
		General.waitToLoad(General.WAIT_MIN);
	}

	/*
     * Method Name: waitTillClickable 
     * 
     * Description: This function will wait till the element finds the element.
     */
	public static WebElement waitTillClickable(WebDriver driver, By by) {
		return new WebDriverWait(driver, 25).until(ExpectedConditions.elementToBeClickable(by));
	}

	/*
     * Method Name: waitTillPresence 
     * 
     * Description: This function will wait for an element to get loaded.
     */
	public static WebElement waitTillPresence(WebDriver driver, By by) {
		return new WebDriverWait(driver, 25).until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	/*
     * Method Name: inputTextFieldEnter 
     * 
     * Description: This function will enter values to input text field.
     */
    public static void inputTextFieldEnter(WebDriver driver, String elementXpath, String keyword) throws InterruptedException
    {
        waitTillPresence(driver, By.xpath(elementXpath));
        List<WebElement> inputTextField = driver.findElements(By.xpath(elementXpath));
        General.waitToLoad(General.WAIT_MIN);
        inputTextField.get(inputTextField.size() - 1).click();
        General.waitToLoad(General.WAIT_MICRO);
        inputTextField.get(0).clear();
        inputTextField.get(0).sendKeys(keyword);
    }
   
}
