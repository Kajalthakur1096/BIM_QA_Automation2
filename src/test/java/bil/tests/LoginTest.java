package bil.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bil.constants.AssertConstants;
import bil.helper.ConfigFileReader;
import bil.helper.TestDataProvider;
import bil.model.UserDetails;
import bil.pages.DistrictAdminPage;
import bil.pages.GreaterThanFiveStudentDashboardPage;
import bil.pages.Kto5StudentDashboardPage;
import bil.pages.LoginPage;
import bil.pages.OldStudentDashboardPage;
import bil.pages.OldTeacherDashboardPage;
import bil.pages.SystemAdminPage;
import bil.pages.TeacherDashboardPage;

public class LoginTest extends BaseTest {
	protected WebDriver driver;
	public static Logger log = LogManager.getLogger(LoginTest.class.getName());

	/*
	 * This method is going to initialize the driver and is going to launch the
	 * website.
	 */
	@BeforeTest
	public void setUp() throws IOException {
		log.info("Login Test:Initializing driver");
		driver = initializeDriver();
		log.info("Login Test:driver initialised successfully");
		driver.get(ConfigFileReader.INSTANCE.getApplicationUrl());
		log.info("Login Test: Url opened successfully");
	}

	/*
	 * This method will verify whether the launched url is the correct url or
	 * not.
	 */
	@Test(enabled = false)
	public void verifyApplicationUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), AssertConstants.getUrlPath());
		log.info("verifyApplicationUrl: Successfully validated the Application Url");
	}

	/*
	 * This method will verify that the MRL teacher is successfully logged into
	 * the website.
	 */
	@Test(enabled = true, dataProvider = "MRLTeacherLoginDataProvider", dataProviderClass = TestDataProvider.class)
	public void verifyMRLTeacherLogin(String username, String password) throws InterruptedException {
		UserDetails objectOfUserDetails= new UserDetails();
		objectOfUserDetails.setUsername(username);
		objectOfUserDetails.setPassword(password);
		LoginPage objectOfLoginPage = new LoginPage(driver);
		objectOfLoginPage.LoginUser(objectOfUserDetails);
		log.info("verifyMRLTeacherLogin: Successfully clicked on Login button");
		TeacherDashboardPage objectOfTeacherDashboardPage = objectOfLoginPage.teacherDashboardPage();
		WebDriverWait wait = new WebDriverWait(driver, ConfigFileReader.INSTANCE.getExplicitlyWait());
		wait.until(ExpectedConditions.visibilityOf(objectOfTeacherDashboardPage.getFeaturedComponentsText()));
		Assert.assertEquals(objectOfTeacherDashboardPage.getFeaturedComponentsText().getText(),
				AssertConstants.getFeaturedComponentsText());
		log.info("verifyMRLTeacherLogin: Successfully validated Teacher user");
		objectOfLoginPage.MRLUserLogout();

	}

	/*
	 * This method will verify that the 2014 teacher is successfully logged into
	 * the website.
	 */
	@Test(enabled = false, dataProvider = "OLDTeacherLoginDataProvider", dataProviderClass = TestDataProvider.class)
	public void verifyOLDTeacherLogin(String username, String password) {
		UserDetails objectOfUserDetails= new UserDetails();
		objectOfUserDetails.setUsername(username);
		objectOfUserDetails.setPassword(password);
		LoginPage objectOfLoginPage = new LoginPage(driver);
		objectOfLoginPage.LoginUser(objectOfUserDetails);
		log.info("verifyOLDTeacherLogin: Successfully clicked on Login button");
		OldTeacherDashboardPage objectOfOldTeacherDashboardPage = objectOfLoginPage.oldTeacherDashboardPage();
		WebDriverWait wait = new WebDriverWait(driver, ConfigFileReader.INSTANCE.getExplicitlyWait());
		wait.until(ExpectedConditions.visibilityOf(objectOfOldTeacherDashboardPage.getDashboardText()));
	/*	Assert.assertEquals(objectOfOldTeacherDashboardPage.getDashboardText().getText(),
				AssertConstants.getResourceLibraryText());*/
		Assert.assertEquals(objectOfOldTeacherDashboardPage.getDashboardText().getText(),
				"xyc");
		log.info("verifyOLDTeacherLogin: Successfully validated Teacher user");
		objectOfLoginPage.OldPlatformUserLogout();

	}

	/*
	 * This method will verify that the error message should appear if the
	 * invalid user logs in.
	 */
	@Test(enabled = false, dataProvider = "InvalidUserDataProvider", dataProviderClass = TestDataProvider.class)
	public void verifyInvalidUserLoginError(String username, String password) throws InterruptedException {
		UserDetails objectOfUserDetails= new UserDetails();
		objectOfUserDetails.setUsername(username);
		objectOfUserDetails.setPassword(password);
		LoginPage objectOfLoginPage = new LoginPage(driver);
		objectOfLoginPage.LoginUser(objectOfUserDetails);
		Assert.assertEquals(objectOfLoginPage.getInvalidUserText().getText(), AssertConstants.getInvalidUserText());
		log.info("verifyInvalidUserLoginError: Successfully validated Inavlid user");

	}

	/*
	 * This method will verify that the K-5Student is successfully logged into
	 * the website.
	 */
	
	@Test(enabled = false, dataProvider = "Kto5StudentLoginDataProvider", dataProviderClass = TestDataProvider.class)
	public void verifyKto5StudentLogin(String username, String password) {
		UserDetails objectOfUserDetails= new UserDetails();
		objectOfUserDetails.setUsername(username);
		objectOfUserDetails.setPassword(password);
		LoginPage objectOfLoginPage = new LoginPage(driver);
		objectOfLoginPage.LoginUser(objectOfUserDetails);
		log.info("verifyKto5StudentLogin: Successfully clicked on Login button");
		Kto5StudentDashboardPage objectOfKto5StudentDashboardPage = objectOfLoginPage.kto5StudentDashboardPage();
		Assert.assertTrue(objectOfKto5StudentDashboardPage.getStateSpecificResourcesButton().isDisplayed());
		log.info("verifyKto5StudentLogin: Student logged in successfully");
		objectOfLoginPage.MRLUserLogout();

	}

	/*
	 * This method will verify that the Greater>5Student is successfully logged
	 * into the website.
	 */
	@Test(enabled = false, dataProvider = "GreaterThan5StudentLoginDataProvider", dataProviderClass = TestDataProvider.class)
	public void verifyGreaterThan5StudentLogin(String username, String password) {
		UserDetails objectOfUserDetails= new UserDetails();
		objectOfUserDetails.setUsername(username);
		objectOfUserDetails.setPassword(password);
		LoginPage objectOfLoginPage = new LoginPage(driver);
		objectOfLoginPage.LoginUser(objectOfUserDetails);
		log.info("verifyGreaterThan5StudentLogin: Successfully clicked on Login button");
		GreaterThanFiveStudentDashboardPage objectOfGreaterThanFiveStudentDashboardPage = objectOfLoginPage
				.greaterThanFiveStudentDashboardPage();
		Assert.assertTrue(objectOfGreaterThanFiveStudentDashboardPage.getDashboardHeader().isDisplayed());
		log.info("verifyGreaterThan5StudentLogin: Student logged in successfully");
		objectOfLoginPage.MRLUserLogout();
	}

	/*
	 * This method will verify that the OldStudent is successfully logged into
	 * the website.
	 */
	@Test(enabled = false, dataProvider = "OLDStudentLoginDataProvider", dataProviderClass = TestDataProvider.class)
	public void verifyOLDStudentLogin(String username, String password) {
		UserDetails objectOfUserDetails= new UserDetails();
		objectOfUserDetails.setUsername(username);
		objectOfUserDetails.setPassword(password);
		LoginPage objectOfLoginPage = new LoginPage(driver);
		objectOfLoginPage.LoginUser(objectOfUserDetails);
		log.info("verifyOLDStudentLogin: Successfully clicked on Login button");
		OldStudentDashboardPage objectOfOldStudentDashboardPage = objectOfLoginPage.oldStudentDashboardPage();
		WebDriverWait wait = new WebDriverWait(driver, ConfigFileReader.INSTANCE.getExplicitlyWait());
		wait.until(ExpectedConditions.visibilityOf(objectOfOldStudentDashboardPage.getStateSpecificText()));
		Assert.assertTrue(objectOfOldStudentDashboardPage.getStateSpecificText().isDisplayed());
		log.info("verifyOLDStudentLogin: Successfully validated Teacher user");
		objectOfLoginPage.OldPlatformUserLogout();

	}

	/*
	 * This method will verify that the District admin is successfully logged
	 * into the website.
	 */
	@Test(enabled = false, dataProvider = "DistrictAdminLoginDataProvider", dataProviderClass = TestDataProvider.class)
	public void verifyDistrictAdminLogin(String username, String password) {
		UserDetails objectOfUserDetails= new UserDetails();
		objectOfUserDetails.setUsername(username);
		objectOfUserDetails.setPassword(password);
		LoginPage objectOfLoginPage = new LoginPage(driver);
		objectOfLoginPage.LoginUser(objectOfUserDetails);
		log.info("verifyDistrictAdminLogin: Successfully clicked on Login button");
		DistrictAdminPage objectOfDistrictAdminPage = objectOfLoginPage.districtAdminPage();
		Assert.assertTrue(objectOfDistrictAdminPage.getReportsLink().isDisplayed());
		log.info("verifyDistrictAdminLogin: Student logged in successfully");
		objectOfLoginPage.OldPlatformUserLogout();
	}

	/*
	 * This method will verify that the System Admin is successfully logged into
	 * the website.
	 */
	@Test(enabled = false, dataProvider = "SystemAdminLoginDataProvider", dataProviderClass = TestDataProvider.class)
	public void verifySystemAdminLogin(String username, String password) {
		UserDetails objectOfUserDetails= new UserDetails();
		objectOfUserDetails.setUsername(username);
		objectOfUserDetails.setPassword(password);
		LoginPage objectOfLoginPage = new LoginPage(driver);
		objectOfLoginPage.LoginUser(objectOfUserDetails);
		log.info("verifySystemAdminLogin: Successfully clicked on Login button");
		SystemAdminPage objectOfSystemAdminPage = objectOfLoginPage.systemAdminPage();
		Assert.assertTrue(objectOfSystemAdminPage.getAddNewDistrictButton().isDisplayed());
		log.info("verifySystemAdminLogin: Student logged in successfully");
		objectOfLoginPage.OldPlatformUserLogout();

	}

	/*
	 * this method will close the driver when all the tests are executed
	 * successfully.
	 */
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
