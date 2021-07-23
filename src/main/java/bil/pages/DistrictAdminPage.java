package bil.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DistrictAdminPage extends BasePage {
	private By reportsLink = By.cssSelector("[href*='district-report']");

	public DistrictAdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getReportsLink() {
		return driver.findElement(reportsLink);
	}
}
