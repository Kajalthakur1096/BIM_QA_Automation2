package bil.helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import bil.constants.TestReportConstants;

public class ExtentReporter {

	public static ExtentReports getReportObject() {
		ExtentReports objectOfExtentReports;
		String pathOfReport = ConfigFileReader.INSTANCE.getReportPath()
				+ ConfigFileReader.INSTANCE.getReportFolderName() + ConfigFileReader.INSTANCE.getReportName();
		ExtentSparkReporter objectOfExtentSparkReporter = new ExtentSparkReporter(pathOfReport);

		objectOfExtentSparkReporter.config().setReportName(TestReportConstants.getExtentReportName());
		objectOfExtentSparkReporter.config().setDocumentTitle(TestReportConstants.getDocumentTitle());
		objectOfExtentReports = new ExtentReports();
		objectOfExtentReports.attachReporter(objectOfExtentSparkReporter);
		objectOfExtentReports.setSystemInfo(TestReportConstants.getTesterInfo(), TestReportConstants.getTesterName());
		return objectOfExtentReports;
	}
}
