package bil.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bil.helper.ConfigFileReader;
import bil.helper.TestDataProvider;
import bil.model.ClassDetails;
import bil.model.UserDetails;
import bil.pages.ClassManagementPage;
import bil.pages.LoginPage;
import bil.pages.TeacherDashboardPage;

public class ClassManagementTest extends BaseTest {
	protected WebDriver driver;
	public static Logger log = LogManager.getLogger(ClassManagementTest.class.getName());

	/*
	 * This method is going to initialize the driver and is going to launch the
	 * website.
	 */
	@BeforeTest
	public void setUp() throws IOException {
		log.info("ClassManagementTest:Initializing driver");
		driver = initializeDriver();
		log.info("ClassManagementTest:driver initialised successfully");
		driver.get(ConfigFileReader.INSTANCE.getApplicationUrl());
		log.info("ClassManagementTest: Url opened successfully");
	}

	/*
	 * This method will Create a new class and verify if the class is created
	 * for New User or not.
	 */
	@Test(enabled = false, dataProvider = "AddClassForNewUserDataProvider", dataProviderClass = TestDataProvider.class)
	public void shouldCreateNewClassForNewUser(String username, String password, String className, String grade,
			String fromDate, String toDate, String book) {
		UserDetails objectOfUserDetails = new UserDetails();
		objectOfUserDetails.setUsername(username);
		objectOfUserDetails.setPassword(password);
		LoginPage objectOfLoginPage = new LoginPage(driver);
		objectOfLoginPage.LoginUser(objectOfUserDetails);
		ClassDetails objectOfClassDetails = new ClassDetails();
		objectOfClassDetails.setClassName(className);
		objectOfClassDetails.setGrade(grade);
		objectOfClassDetails.setFromDate(fromDate);
		objectOfClassDetails.setToDate(toDate);
		objectOfClassDetails.setBook(book);
		log.info("ClassManagementTest:Teacher logged in successfully");
		ClassManagementPage objectOfClassManagement = new ClassManagementPage(driver);
		if (objectOfClassManagement.getWelcomePopup().isDisplayed()) {
			objectOfClassManagement.GetStartedButton().click();
			objectOfClassManagement.createNewClass(objectOfClassDetails);
			objectOfClassManagement.getGoToDashboardButton().click();
		}
		TeacherDashboardPage objectOfTeacherDashboardPage = new TeacherDashboardPage(driver);
		Assert.assertEquals(objectOfTeacherDashboardPage.getDashboardClassText(), className);
		log.info("ClassManagementTest:Class created successfully");
		objectOfLoginPage.MRLUserLogout();
	}

	/*
	 * This method will Create a new class and verify if the class is created or
	 * not.
	 */
	@Test(enabled = true, dataProvider = "AddClassWithExistingClassDataProvider", dataProviderClass = TestDataProvider.class)
	public void shouldCreateNewClassWhenClassExist(String username, String password, String className, String grade,
			String fromDate, String toDate, String book) throws InterruptedException {
		UserDetails objectOfUserDetails = new UserDetails();
		objectOfUserDetails.setUsername(username);
		objectOfUserDetails.setPassword(password);
		LoginPage objectOfLoginPage = new LoginPage(driver);
		objectOfLoginPage.LoginUser(objectOfUserDetails);
		ClassDetails objectOfClassDetails = new ClassDetails();
		objectOfClassDetails.setClassName(className);
		objectOfClassDetails.setGrade(grade);
		objectOfClassDetails.setFromDate(fromDate);
		objectOfClassDetails.setToDate(toDate);
		objectOfClassDetails.setBook(book);
		log.info("ClassManagementTest:Teacher logged in successfully");
		TeacherDashboardPage objectOfTeacherDashboardPage = new TeacherDashboardPage(driver);
		objectOfTeacherDashboardPage.getClassManagementButton().click();
		ClassManagementPage objectOfClassManagement = new ClassManagementPage(driver);
		objectOfClassManagement.getAddClassButton().click();
		objectOfClassManagement.createNewClass(objectOfClassDetails);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", objectOfTeacherDashboardPage.homeButton());
		objectOfTeacherDashboardPage.homeButton().click();
		Assert.assertEquals(objectOfTeacherDashboardPage.getDashboardClassText(), className);
		log.info("ClassManagementTest:Class created successfully");
		objectOfLoginPage.MRLUserLogout();

	}

	/*
	 * This method will Create a new class and verify if the class is created
	 * for the user which has no Active class .
	 */
	@Test(enabled = false, dataProvider = "AddClassWithNoActiveClassDataProvider", dataProviderClass = TestDataProvider.class)
	public void shouldCreateNewClassWhenNoActiveClassPresent(String username, String password, String className,
			String grade, String fromDate, String toDate, String book) throws InterruptedException {
		UserDetails objectOfUserDetails = new UserDetails();
		objectOfUserDetails.setUsername(username);
		objectOfUserDetails.setPassword(password);
		LoginPage objectOfLoginPage = new LoginPage(driver);
		objectOfLoginPage.LoginUser(objectOfUserDetails);
		ClassDetails objectOfClassDetails = new ClassDetails();
		objectOfClassDetails.setClassName(className);
		objectOfClassDetails.setGrade(grade);
		objectOfClassDetails.setFromDate(fromDate);
		objectOfClassDetails.setToDate(toDate);
		objectOfClassDetails.setBook(book);
		log.info("ClassManagementTest:Teacher logged in successfully");
		ClassManagementPage objectOfClassManagement = new ClassManagementPage(driver);
		if (objectOfClassManagement.getNoActiveClassModal().isDisplayed()) {
			objectOfClassManagement.getOkayButton().click();
			objectOfClassManagement.createNewClass(objectOfClassDetails);
			log.info("ClassManagementTest:Class created successfully");
		}
		TeacherDashboardPage objectOfTeacherDashboardPage = new TeacherDashboardPage(driver);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", objectOfTeacherDashboardPage.homeButton());
		objectOfTeacherDashboardPage.homeButton().click();
		Assert.assertEquals(objectOfTeacherDashboardPage.getDashboardClassText(), className);
		objectOfLoginPage.MRLUserLogout();

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
