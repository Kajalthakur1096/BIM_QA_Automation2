package bil.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TeacherDashboardPage extends BasePage {
	private By featuredComponentsText = By.cssSelector("#dashboard-header-text");
	private By classManagementFeaturedComponents = By.xpath("//span[text()='Class Management']");
	private By dashboardClassName = By.xpath("//div[contains(@class,'k8-dashboard-class-name')]");
	private By homeButton = By.xpath("//div[contains(@class,'k8-home-button')]");

	public TeacherDashboardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getFeaturedComponentsText() {
		return driver.findElement(featuredComponentsText);
	}

	public WebElement getClassManagementButton() {
		return driver.findElement(classManagementFeaturedComponents);
	}

	public WebElement getClassName() {
		return driver.findElement(dashboardClassName);
	}

	public WebElement homeButton() {
		return driver.findElement(homeButton);
	}

	/*
	 * This method will locate the ClassName present in Dashboard and then split
	 * operation is operation is performed to fetch the exact name of class for
	 * assertion.
	 */
	public String getDashboardClassText() {
		String[] splitTextByColon = getClassName().getText().split("[:][\\s]");
		String className = splitTextByColon[1];
		return className;

	}
}
