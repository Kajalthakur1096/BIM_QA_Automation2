package bil.helper;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import bil.constants.ConfigConstants;

public enum ConfigFileReader {
	INSTANCE;
	Properties prop;

	ConfigFileReader() {
		prop = new Properties();
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public String getBrowserName() {
		String browserName = prop.getProperty(ConfigConstants.getBrowser());
		if (browserName != null)
			return browserName;
		else
			throw new RuntimeException("BrowserName not specified in the config.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = prop.getProperty(ConfigConstants.getImplicitlyWait());
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the config.properties file.");
	}

	public String getApplicationUrl() {
		String url = prop.getProperty(ConfigConstants.getUrl());
		if (url != null)
			return url;
		else
			throw new RuntimeException("Url not specified in the config.properties file.");
	}

	/*public String getChromeDriverPath() {
		String chromeDriverPath = prop.getProperty(ConfigConstants.getChromeDriverPath());
		if (chromeDriverPath != null)
			return chromeDriverPath;
		else
			throw new RuntimeException("chromeDriverPath not specified in the config.properties file.");
	}

	public String getFireFoxDriverPath() {
		String firefoxDriverPath = prop.getProperty(ConfigConstants.getFirefoxDriverPath());
		if (firefoxDriverPath != null)
			return firefoxDriverPath;
		else
			throw new RuntimeException("firefoxDriverPath not specified in the config.properties file.");
	}*/

	public String getExcelTestDataPath() {
		String ExcelTestDataPath = prop.getProperty(ConfigConstants.getExcelPathReader());
		if (ExcelTestDataPath != null)
			return ExcelTestDataPath;
		else
			throw new RuntimeException("ExcelTestDataPath not specified in the config.properties file.");
	}

	public long getExplicitlyWait() {
		String explicitlyWait = prop.getProperty(ConfigConstants.getImplicitlyWait());
		if (explicitlyWait != null)
			return Long.parseLong(explicitlyWait);
		else
			throw new RuntimeException("explicitlyWait not specified in the config.properties file.");
	}

	public String getImageExtension() {
		String imageExtension = prop.getProperty(ConfigConstants.getImageExtension());
		if (imageExtension != null)
			return imageExtension;
		else
			throw new RuntimeException("ImageExtensionType not specified in the config.properties file.");
	}

	public String getReportPath() {
		String reportPath = prop.getProperty(ConfigConstants.getReportPath());
		if (reportPath != null)
			return reportPath;
		else
			throw new RuntimeException("Report folder path not specified in the config.properties file.");

	}

	public String getReportFolderName() {
		String reportFolderName = prop.getProperty(ConfigConstants.getReportFolderName());
		if (reportFolderName != null)
			return reportFolderName;
		else
			throw new RuntimeException("Report folder name not specified in the config.properties file.");

	}

	public String getReportName() {
		String reportName = prop.getProperty(ConfigConstants.getReportName());
		if (reportName != null)
			return reportName;
		else
			throw new RuntimeException("Report name not specified in the config.properties file.");

	}

}
