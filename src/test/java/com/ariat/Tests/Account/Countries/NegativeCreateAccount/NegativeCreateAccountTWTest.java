package com.ariat.Tests.Account.Countries.NegativeCreateAccount;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.Environments;
import com.ariat.Enums.GlobalCountries;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageTW;
import com.ariat.Pages.Main.CreateAccountPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.GenerateRandomDataUtils;


/**
 * Test negative create account by instantiating the browser, go to Home page,
 * and calls all the methods such as: create account, login, check order status
 * for Taiwan
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class NegativeCreateAccountTWTest extends BaseTest {

	private Environments environment;
	private GlobalCountries country;
	private CreateAccountPage createAccountPage;
	private HomePage homePage;
	private HomePageTW homePageTW;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private String loggingMessage = "The email address is invalid.";
	private String missingLoggingValue = "This field is required.";

	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String BIRTH_MONTH = "March";
	public static final String BIRTH_DAY = "02";

	public static final String EMAIL = GenerateRandomDataUtils.generateRandomNumber(12);
	public static final String PASSWORD = GenerateRandomDataUtils.generateRandomString(10);

	public static final String FIRST_NAME1 = "@#$%^&*()";
	public static final String LAST_NAME1 = "@#$%^&*()";
	public static final String EMAIL1 = "@#$%^&*()";
	public static final String filePath= "\\Users\\Aila\\eclipse-workspace\\ariat-regression\\src\\test\\resources\\chromedriver\\chromedriver.exe";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", filePath);
	}

	@Test(priority = 0)
	public void negativeCreateAccountTest() {
		logger.info("Starting create negative account test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageTW = (HomePageTW) homePage.chooseGlobalLocation(country.TW, country.TW.getCurrencyISO());
		signInPage = homePageTW.returnSignInPage();
		createAccountPage = signInPage.returnCreateAccountPage();
		createAccountPage.firstName(FIRST_NAME);
		createAccountPage.lastNameInfo(LAST_NAME);
		createAccountPage.selectBirthMonth(BIRTH_MONTH);
		createAccountPage.selectBirthDay(BIRTH_DAY);
		createAccountPage.enterEmail(EMAIL);
		createAccountPage.confirmEmail(EMAIL);
		createAccountPage.enterPassword(PASSWORD);
		createAccountPage.confirmPassword(PASSWORD);
		createAccountPage.createAccountClick();
		createAccountPage.assertWrongNameCreateAccount(loggingMessage);
		logger.info("Finishing negative create account test...");
	}

	@Test(priority = 1)
	public void negativeCreateAccountTestWildcards() {
		logger.info("Starting create negative account test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageTW = (HomePageTW) homePage.chooseGlobalLocation(country.TW, country.TW.getCurrencyISO());
		signInPage = homePageTW.returnSignInPage();
		createAccountPage = signInPage.returnCreateAccountPage();
		createAccountPage.firstName(FIRST_NAME1);
		createAccountPage.lastNameInfo(LAST_NAME1);
		createAccountPage.selectBirthMonth(BIRTH_MONTH);
		createAccountPage.selectBirthDay(BIRTH_DAY);
		createAccountPage.enterEmail(EMAIL1);
		createAccountPage.confirmEmail(EMAIL1);
		createAccountPage.enterPassword(PASSWORD);
		createAccountPage.confirmPassword(PASSWORD);
		createAccountPage.createAccountClick();
		createAccountPage.assertWrongNameCreateAccount(loggingMessage);
		logger.info("Finishing negative create account test...");
	}

	@Test(priority = 2)
	public void negativeCreateAccountTestMissingValues() {
		logger.info("Starting create negative account test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageTW = (HomePageTW) homePage.chooseGlobalLocation(country.TW, country.TW.getCurrencyISO());
		signInPage = homePageTW.returnSignInPage();
		createAccountPage = signInPage.returnCreateAccountPage();
		createAccountPage.firstName(FIRST_NAME);
		createAccountPage.lastNameInfo(LAST_NAME);
		myAccountPage = createAccountPage.returnMyAccountPage();
		createAccountPage.asserCreateAccountMissingValues(missingLoggingValue);
		logger.info("Finishing negative create account test...");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageTW.quit();
		signInPage.quit();
		myAccountPage.quit();
		createAccountPage.quit();
	}
}