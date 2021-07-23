package bil.constants;

public class ConfigConstants {
	private static final String BROWSER = "browser";
	private static final String CHROME_BROWSER = "chrome";
	private static final String FIREFOX_BROWSER = "firefox";
	private static final String IMPLICITLY_WAIT = "implicitly.wait";
	private static final String EXPLICITLY_WAIT = "explicitly.wait";
	private static final String URL = "url";
	//private static final String CHROME_DRIVER_PATH = "chrome.driver.path";
	//private static final String FIREFOX_DRIVER_PATH = "gecko.driver.path";
	private static final String EXCEL_PATH_READER = "excel.test.data.path";
	private static final String IMAGE_EXTENSION = "image.extension";
	private static final String REPORT_PATH = "report.path";
	private static final String REPORT_FOLDER_NAME = "report.folder.name";
	private static final String REPORT_NAME = "report.name";

	public static String getBrowser() {
		return BROWSER;
	}

	public static String getChromeBrowser() {
		return CHROME_BROWSER;
	}

	public static String getFirefoxBrowser() {
		return FIREFOX_BROWSER;
	}

	public static String getImplicitlyWait() {
		return IMPLICITLY_WAIT;
	}

	public static String getExplicitlyWait() {
		return EXPLICITLY_WAIT;
	}

	public static String getUrl() {
		return URL;
	}

	/*public static String getChromeDriverPath() {
		return CHROME_DRIVER_PATH;
	}

	public static String getFirefoxDriverPath() {
		return FIREFOX_DRIVER_PATH;
	}
*/
	public static String getExcelPathReader() {
		return EXCEL_PATH_READER;
	}

	public static String getImageExtension() {
		return IMAGE_EXTENSION;
	}

	public static String getReportPath() {
		return REPORT_PATH;
	}

	public static String getReportFolderName() {
		return REPORT_FOLDER_NAME;
	}

	public static String getReportName() {
		return REPORT_NAME;
	}

	

}
