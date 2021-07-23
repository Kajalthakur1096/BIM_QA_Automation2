package bil.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bil.model.UserDetails;

public class LoginPage extends BasePage {
	private By username = By.cssSelector("input[name='username']");
	private By password = By.cssSelector("input[name='password']");
	private By login = By.cssSelector("#loginSubmit");
	private By usernameButton = By.xpath("//div[@class='k8-header-nav']/div[4]");
	private By mrlLogout = By.xpath("//*[@id='Logout']/div");
	private By oldMenu = By.cssSelector("#fullName");
	private By oldLogout = By.cssSelector("[href*='logout']");
	private By checkInvalidUserText = By.cssSelector("div.error");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getInvalidUserText() {
		return driver.findElement(checkInvalidUserText);
	}

	public WebElement getUsername() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getOldMenuOption() {
		return driver.findElement(oldMenu);
	}

	public WebElement getLogin() {
		return driver.findElement(login);

	}

	public WebElement getUserNameButton() {
		return driver.findElement(usernameButton);
	}

	public WebElement getMRLLogoutButton() {
		return driver.findElement(mrlLogout);
	}

	public WebElement getOLDLogoutButton() {
		return driver.findElement(oldLogout);
	}

	public TeacherDashboardPage teacherDashboardPage() {
		return new TeacherDashboardPage(driver);

	}

	public OldTeacherDashboardPage oldTeacherDashboardPage() {
		return new OldTeacherDashboardPage(driver);

	}

	public OldStudentDashboardPage oldStudentDashboardPage() {
		return new OldStudentDashboardPage(driver);

	}

	public Kto5StudentDashboardPage kto5StudentDashboardPage() {
		return new Kto5StudentDashboardPage(driver);
	}

	public GreaterThanFiveStudentDashboardPage greaterThanFiveStudentDashboardPage() {
		return new GreaterThanFiveStudentDashboardPage(driver);
	}

	public DistrictAdminPage districtAdminPage() {
		return new DistrictAdminPage(driver);
	}

	public SystemAdminPage systemAdminPage() {
		return new SystemAdminPage(driver);
	}

	public void LoginUser(UserDetails objectOfUserDetails) {
		getUsername().sendKeys(objectOfUserDetails.getUsername());
		getPassword().sendKeys(objectOfUserDetails.getPassword());
		getLogin().click();
	}

	public void MRLUserLogout() {
		getUserNameButton().click();
		getMRLLogoutButton().click();
	}

	public void OldPlatformUserLogout() {
		getOldMenuOption().click();
		getOLDLogoutButton().click();
	}

}
