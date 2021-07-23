package bil.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GreaterThanFiveStudentDashboardPage extends BasePage {
	private By dashboardHeader = By.cssSelector("h1");

	public GreaterThanFiveStudentDashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getDashboardHeader() {
		return driver.findElement(dashboardHeader);
	}
}
