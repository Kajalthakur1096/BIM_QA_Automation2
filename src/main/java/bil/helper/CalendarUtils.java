package bil.helper;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DateUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarUtils {
	private static final String DATE_FORMAT = "dd MMMM yyyy";

	public static List<String> splitDate(String anyDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		Date date = DateUtil.getJavaDate(Double.parseDouble(anyDate));
		String strDate = formatter.format(date);
		String[] x = strDate.split("\\s+");
		List<String> li = Arrays.asList(x[0], x[1], x[2]);
		return li;
	}

	public static String getDate(String anyDate) {
		return splitDate(anyDate).get(0);
	}

	public static String getMonth(String anyDate) {
		return splitDate(anyDate).get(1);
	}

	public static String getYear(String anyDate) {
		return splitDate(anyDate).get(2);
	}

	public static void clickPrevButton(WebDriver driver, int noOfClicks) {
		WebElement prevBtn = driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-prev')]"));
		for (int i = 0; i < noOfClicks; i++) {
			prevBtn.click();
		}
	}

	public static void clickNextButton(WebDriver driver, int noOfClicks) {
		WebElement nextBtn = driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-next')]"));
		for (int i = 0; i < noOfClicks; i++) {
			nextBtn.click();
		}
	}

	public static void getcalendar(int currYear, int currMonth, String anyDate, Map<String, Integer> map,
			WebDriver driver) {

		if (Integer.parseInt(getYear(anyDate)) > currYear) {
			int noOfClicks = (((Integer.parseInt(getYear(anyDate)) - currYear)) - 1) * 12 + map.get(getMonth(anyDate))
					+ (12 - currMonth);
			clickNextButton(driver, noOfClicks);
			selectDate(driver, anyDate);

		} else if (Integer.parseInt(getYear(anyDate)) < currYear) {
			int noOfClicks = ((currYear - Integer.parseInt(getYear(anyDate))) - 1) * 12
					+ (12 - map.get(getMonth(anyDate))) + currMonth;
			clickPrevButton(driver, noOfClicks);
			selectDate(driver, anyDate);

		} else {
			if (map.get(getMonth(anyDate)) > currMonth) {
				int noOfClicks = (map.get(getMonth(anyDate)) - currMonth);
				clickNextButton(driver, noOfClicks);
				selectDate(driver, anyDate);
			} else if (map.get(getMonth(anyDate)) < currMonth) {
				int noOfClicks = (currMonth - map.get(getMonth(anyDate)));
				clickPrevButton(driver, noOfClicks);
				selectDate(driver, anyDate);
			} else {
				selectDate(driver, anyDate);
			}
		}

	}

	public static void selectDate(WebDriver driver, String anyDate) {
		List<WebElement> dateList = driver
				.findElements(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//td"));
		for (int i = 0; i < dateList.size(); i++) {
			if (!dateList.get(i).getAttribute("class").contains("ui-datepicker-other-month")
					&& (Integer.parseInt(dateList.get(i).getText()) == (Integer.parseInt(getDate(anyDate))))) {
				dateList.get(i).click();
				break;
			}
		}

	}

	public static void selectCalendarDate(WebDriver driver, String fromDate, String toDate) {
		WebElement From = driver.findElement(By.xpath("//p-calendar[@placeholder='From']//input[@type='text']"));
		WebElement To = driver.findElement(By.xpath("//p-calendar[@placeholder='To']//input[@type='text']"));
		From.click();
		WebElement currentMonth = driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-month')]"));
		WebElement currentYear = driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-year')]"));

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("January", 1);
		map.put("February", 2);
		map.put("March", 3);
		map.put("April", 4);
		map.put("May", 5);
		map.put("June", 6);
		map.put("July", 7);
		map.put("August", 8);
		map.put("September", 9);
		map.put("October", 10);
		map.put("November", 11);
		map.put("December", 12);
		int currMonth = map.get(currentMonth.getText());
		int currYear = Integer.parseInt(currentYear.getText());
		getcalendar(currYear, currMonth, fromDate, map, driver);
		To.click();
		getcalendar(currYear, currMonth, toDate, map, driver);

	}
}
