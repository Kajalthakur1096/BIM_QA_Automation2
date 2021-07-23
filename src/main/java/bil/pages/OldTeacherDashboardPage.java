package bil.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OldTeacherDashboardPage extends BasePage {

	private By dashboardText = By.xpath("//div[@class='resource-library']//h1");

	public OldTeacherDashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getDashboardText() {
		return driver.findElement(dashboardText);
	}
}
