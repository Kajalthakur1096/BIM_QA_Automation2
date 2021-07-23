package bil.helper;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import bil.tests.BaseTest;

public class Listeners extends BaseTest implements ITestListener {
	ExtentReports objectOfExtentReports = ExtentReporter.getReportObject();
	ThreadLocal<ExtentTest> objectOfThreadLocal = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest objectOfExtentTest = objectOfExtentReports.createTest(result.getMethod().getMethodName());
		objectOfThreadLocal.set(objectOfExtentTest);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		objectOfThreadLocal.get().log(Status.PASS, result.getMethod().getMethodName() + " TestCase is passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		objectOfThreadLocal.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			Field f = result.getTestClass().getRealClass().getDeclaredField("driver");
			f.setAccessible(true);
			driver = (WebDriver) f.get(result.getInstance());
			objectOfThreadLocal.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver),
					result.getMethod().getMethodName());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * This is the method of ITestListener interface which needs to be
	 * implemented
	 */
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		objectOfExtentReports.flush();
	}

	/*
	 * This is the method of ITestListener interface which needs to be
	 * implemented
	 */
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	/*
	 * This is the method of ITestListener interface which needs to be
	 * implemented
	 */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	/*
	 * This is the method of ITestListener interface which needs to be
	 * implemented
	 */
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
