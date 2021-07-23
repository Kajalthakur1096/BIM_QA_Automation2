package bil.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OldStudentDashboardPage extends BasePage {
	private By stateSpecificText = By.xpath("//li//span[text()='State Specific Resources']");

	public OldStudentDashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getStateSpecificText() {
		return driver.findElement(stateSpecificText);
	}
}
