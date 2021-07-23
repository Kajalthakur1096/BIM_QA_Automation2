package bil.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bil.helper.CalendarUtils;
import bil.model.ClassDetails;

public class ClassManagementPage extends BasePage {
	private By getStartedButton = By.xpath("//p-footer//button");
	private By noActiveClassModal = By
			.xpath("//div[@class='confirmation-modal-container archive']//h2[text()='No active classes']");
	private By okayButton = By.xpath("//button[text()='Okay']");
	private By addClassButton = By.xpath("//button[@class='add-class-button']");
	private By welcomePopup = By.xpath("//div[@class='self-reg-user-welcome-popup-label']");
	// addaclass
	private By className = By.cssSelector("#className");
	private By addButton = By.xpath("//button[text()='Add']");
	private By selectGradeDropdown = By.xpath("//label[text()='Select grade']");
	private By gradeList = By.xpath("//li[contains(@class,'ui-dropdown-item')]");
	private By selectBookDropdown = By.cssSelector("button.dropdown-toggle.multiselect-dropdown");
	private By bookList = By.xpath("//a[@class='ng-star-inserted']");
	private By gotoTeacherDashButton = By.xpath("//span[text()='Go to Teacher Dashboard']");

	public ClassManagementPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getWelcomePopup() {
		return driver.findElement(welcomePopup);
	}

	public WebElement getNoActiveClassModal() {
		return driver.findElement(noActiveClassModal);
	}

	public WebElement GetStartedButton() {
		return driver.findElement(getStartedButton);
	}

	public WebElement getOkayButton() {
		return driver.findElement(okayButton);
	}

	public WebElement getGoToDashboardButton() {
		return driver.findElement(gotoTeacherDashButton);
	}

	public WebElement getAddClassButton() {
		return driver.findElement(addClassButton);
	}

	private WebElement getAddButton() {
		return driver.findElement(addButton);
	}

	public WebElement getClassName() {
		return driver.findElement(className);
	}

	public WebElement selectGradeDropdown() {
		return driver.findElement(selectGradeDropdown);
	}

	public List<WebElement> getGradeDropdownList() {
		return driver.findElements(gradeList);
	}

	private WebElement selectBookDropdown() {
		return driver.findElement(selectBookDropdown);
	}

	private List<WebElement> getBookDropdownList() {
		return driver.findElements(bookList);
	}


	private void selectGrade(String grade) {
		selectGradeDropdown().click();
		List<WebElement> li = getGradeDropdownList();
		selectInputFromList(li, grade);
	}

	public void createNewClass(ClassDetails objectOfClassDetails) {
		getClassName().sendKeys(objectOfClassDetails.getClassName());
		selectGrade(objectOfClassDetails.getGrade());
		CalendarUtils.selectCalendarDate(driver, objectOfClassDetails.getFromDate(), objectOfClassDetails.getToDate());
		selectBook(objectOfClassDetails.getBook());
		getAddButton().click();
	}

	public void selectBook(String book) {
		selectBookDropdown().click();
		List<WebElement> dropdownList = getBookDropdownList();
		selectInputFromList(dropdownList, book);
		selectBookDropdown().click();
	}

	public void selectInputFromList(List<WebElement> li, String input) {
		for (WebElement webelement : li) {
			if (webelement.getText().equalsIgnoreCase(input)) {
				webelement.click();
				break;
			}
		}
	}
}
