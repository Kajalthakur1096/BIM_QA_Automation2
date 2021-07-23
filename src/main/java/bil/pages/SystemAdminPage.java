package bil.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SystemAdminPage extends BasePage {
	private By addNewDistrictButton = By.cssSelector("[href*='school-district']");

	public SystemAdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAddNewDistrictButton() {
		return driver.findElement(addNewDistrictButton);
	}
}
