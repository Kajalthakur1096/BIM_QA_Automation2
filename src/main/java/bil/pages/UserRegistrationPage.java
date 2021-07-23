package bil.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegistrationPage extends BasePage {
	//private By registrationButton = By.cssSelector("div.login-tabs>button:nth-child(2)");
	 private By registrationButton = By.xpath("//button[contains(text(), 'Register')]"); // newBTS-UI

	private By accessCode = By.cssSelector("#access-code-input");

	//private By nextButton = By.xpath("//button[text()='Next']");
	 private By nextButton = By.xpath("//span[text()='Next']"); // newBTS-UI

	//private By errorMessage = By.cssSelector(".access-code-error");
	 private By errorMessage = By.xpath("//div[text()='That code was not found.']");// newBTS-UI

	private By teacherFirstName = By.cssSelector("#teacher-first-name");
	private By teacherLastName = By.cssSelector("#teacher-last-name");
	private By teacherEmail = By.cssSelector("#teacher-email");
	private By teacherEmailconfirm = By.cssSelector("#teacher-email-confirm");
	private By teacherPassword = By.cssSelector("#teacher-pass");
	private By teacherPasswordConfirm = By.cssSelector("#teacher-pass-confirm");
	private By teacherSubmitButton = By.xpath("//div[@id='teacher-content-one']//button[text()='Next']");
	private By teacherSchoolSubmitButton = By.xpath("//div[@id='teacher-content-two']//button[text()='Next']");
	private By teacherSchoolCheckbox = By.cssSelector("#school-not-listed");
	private By loginButton = By.cssSelector(".done-reg-btn");
	private By studentFirstName = By.cssSelector("#student-first-name");
	private By studentLastName = By.cssSelector("#student-last-name");
	private By studentPassword = By.cssSelector("#student-pass");
	private By studentPasswordConfirm = By.cssSelector("#student-pass-confirm");
	private By studentId = By.cssSelector("#student-id");
	private By studentSubmitButton = By.xpath("//div[@id='student-content-one']//button[text()='Next']");
	private By studentLoginButton = By.xpath("//div[@id='student-content-two']//button[text()='Log in']");
	private By DAFirstName = By.cssSelector("#disadmin-first-name");
	private By DALastName = By.cssSelector("#disadmin-last-name");
	private By DAEmail = By.cssSelector("#disadmin-email");
	private By DAEmailConfirm = By.cssSelector("#disadmin-email-confirm");
	private By DAPassword = By.cssSelector("#disadmin-pass");
	private By DAPasswordConfirm = By.cssSelector("#disadmin-pass-confirm");
	private By DASubmitButton = By.xpath("//div[@id='disadmin-content-one']//button[text()='Next']");
	private By DALoginButton = By.xpath("//div[@id='disadmin-content-two']//button[text()='Next']");

	public UserRegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getTeacherSchoolCheckbox() {
		return driver.findElement(teacherSchoolCheckbox);
	}

	public WebElement getTeacherLoginButton() {
		return driver.findElement(loginButton);
	}

	public WebElement getTeacherSchoolSubmitButton() {
		return driver.findElement(teacherSchoolSubmitButton);

	}

	public WebElement getRegistrationButton() {
		return driver.findElement(registrationButton);

	}

	public WebElement getAccessCodeButton() {
		return driver.findElement(accessCode);

	}

	public WebElement getNextButton() {
		return driver.findElement(nextButton);

	}

	public WebElement getAccessCodeErrorText() {
		return driver.findElement(errorMessage);

	}

	public WebElement getTeacherFirstName() {
		return driver.findElement(teacherFirstName);

	}

	public WebElement getTeacherLastName() {
		return driver.findElement(teacherLastName);

	}

	public WebElement getTeacherEmail() {
		return driver.findElement(teacherEmail);

	}

	public WebElement getTeacherEmailConfirm() {
		return driver.findElement(teacherEmailconfirm);

	}

	public WebElement getTeacherPassword() {
		return driver.findElement(teacherPassword);

	}

	public WebElement getTeacherPasswordConfirm() {
		return driver.findElement(teacherPasswordConfirm);

	}

	public WebElement getTeacherSubmitButton() {
		return driver.findElement(teacherSubmitButton);

	}

	public WebElement getStudentFirstName() {
		return driver.findElement(studentFirstName);
	}

	public WebElement getStudentLastName() {
		return driver.findElement(studentLastName);
	}

	public WebElement getStudentPassword() {
		return driver.findElement(studentPassword);
	}

	public WebElement getStudentPasswordConfirm() {
		return driver.findElement(studentPasswordConfirm);
	}

	public WebElement getStudentId() {
		return driver.findElement(studentId);
	}

	public WebElement getStudentSubmitButton() {
		return driver.findElement(studentSubmitButton);
	}

	public WebElement getStudentLoginButton() {
		return driver.findElement(studentLoginButton);
	}

	public WebElement getDAFirstName() {
		return driver.findElement(DAFirstName);
	}

	public WebElement getDALastName() {
		return driver.findElement(DALastName);
	}

	public WebElement getDAEmail() {
		return driver.findElement(DAEmail);
	}

	public WebElement getDAEmailConfirm() {
		return driver.findElement(DAEmailConfirm);
	}

	public WebElement getDAPasword() {
		return driver.findElement(DAPassword);
	}

	public WebElement getDAPaswordConfirm() {
		return driver.findElement(DAPasswordConfirm);
	}

	public WebElement getDASubmitButton() {
		return driver.findElement(DASubmitButton);
	}

	public WebElement getDALoginButton() {
		return driver.findElement(DALoginButton);
	}

	/*
	 * This method will enter the accesscode inside the accesscode input box.
	 */
	public void setAccessCode(String accesscode) {
		/*
		 * I had no choice but to introduce thread here because explicit wait
		 * was unable to interact with access-code web element.Sad.
		 */
		try {
			Thread.sleep(2000);
			getRegistrationButton().click();
			getAccessCodeButton().sendKeys(accesscode);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getNextButton().click();
	}

	/*
	 * This method will validate the accesscode and will return the boolean flag
	 * if the code entered is either valid or invalid.
	 */
	public boolean validateAccessCode(String accesscode) {
		setAccessCode(accesscode);
		try {
			Thread.sleep(2000);
			if (getAccessCodeErrorText().isDisplayed()) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return true;
	}

}
