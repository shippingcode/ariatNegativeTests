package com.ariat.Tests.Addresses.Countries.NegativeAddAddress;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageBE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.AddAddressesPage;
import com.ariat.Pages.Main.AddressesPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;


/**
 * Adds negative address and checks the address was created for Belgium
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class NegativeAddAddressBETest extends BaseTest {

	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageBE homePageBE;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private AddAddressesPage addAddressPage;
	private AddressesPage addressesPage;
	private EUCountries euCountry;
	private Environments environment;

	public static final String ADDRESS = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String CITY = GenerateRandomDataUtils.generateRandomNumber(5);
	
	public static final String POST_CODE = GenerateRandomDataUtils.generateRandomString(5);
	public static final String PHONE = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS_ID = GenerateRandomDataUtils.generateRandomNumber(5);
	private static final String EMAIL = "aila.bogasieru@ariat.com";
	private static final String PASSWORD = "Parola12345!";
	
	public static final String ADDRESSWILD = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String CITYWILD = GenerateRandomDataUtils.generateRandomNumber(5);
	
	public static final String POST_CODEWILD = GenerateRandomDataUtils.generateRandomString(5);
	public static final String PHONEWILD = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS_IDWILD = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority=0)
	public void negativeAddAddressNOTest() {
		logger.info("Starting add negative address NO test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		signInPage = homePageBE.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "EnglishUK");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addAddressPage = myAccountPage.returnAddAddressesPageMiddleNav();
		addAddressPage.enterFName("444");
		addAddressPage.enterLName("4444");
		addAddressPage.enterAddress1(ADDRESS);
		addAddressPage.enterCity(CITY);
		addAddressPage.selectCountry("Norway");
		addAddressPage.enterPostCode(POST_CODE);
		addAddressPage.enterPhone(PHONE);
		addAddressPage.enterAddressId(ADDRESS_ID);
		addressesPage = addAddressPage.returnAddressesPage();
		logger.info("Finishing add negative address NO test");
	}
	
	@Test(priority=1)
	public void negativeAddAddressNOTestWildcards() {
		logger.info("Starting add negative address NO test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		signInPage = homePageBE.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "EnglishUK");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addAddressPage = myAccountPage.returnAddAddressesPageMiddleNav();
		addAddressPage.enterFName("444");
		addAddressPage.enterLName("4444");
		addAddressPage.enterAddress1(ADDRESSWILD);
		addAddressPage.enterCity(CITYWILD);
		addAddressPage.selectCountry("Norway");
		addAddressPage.enterPostCode(POST_CODEWILD);
		addAddressPage.enterPhone(PHONEWILD);
		addAddressPage.enterAddressId(ADDRESS_IDWILD);
		addressesPage = addAddressPage.returnAddressesPage();
		logger.info("Finishing add negative address NO test");
	}
	
	@Test(priority=2)
	public void negativeAddAddressNOTestMissingValues() {
		logger.info("Starting add negative address NO test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		signInPage = homePageBE.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "EnglishUK");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addAddressPage = myAccountPage.returnAddAddressesPageMiddleNav();
		addAddressPage.enterAddress1(ADDRESS);
		addAddressPage.enterCity(CITY);
		addAddressPage.selectCountry("Norway");
		addAddressPage.saveAddress();
		logger.info("Finishing add negative address NO test");
	}
	
	@AfterTest
	public void clearBrowserSession() {
		KillChrome kill = new KillChrome();
    }
	
	@AfterSuite
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageBE.quit();
		signInPage.quit();
		addAddressPage.quit();
		addressesPage.quit();
	}
}