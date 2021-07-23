package bil.helper;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import bil.constants.ExcelConstants;

public class TestDataProvider {

	@DataProvider(name = "MRLTeacherLoginDataProvider")
	public static Object[][] getMRLTeacherLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getMRLTeacherLoginSheetName());

	}

	@DataProvider(name = "OLDTeacherLoginDataProvider")
	public static Object[][] getOLDTeacherLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getOLDTeacherLoginSheetName());

	}

	@DataProvider(name = "Kto5StudentLoginDataProvider")
	public static Object[][] getKto5StudentLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getKto5StudentLoginSheetName());

	}

	@DataProvider(name = "GreaterThan5StudentLoginDataProvider")
	public static Object[][] getGreaterThan5StudentLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getGreaterthanfiveStudentLoginSheetName());

	}

	@DataProvider(name = "OLDStudentLoginDataProvider")
	public static Object[][] getOLDStudentLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getOLDStudentLoginSheetName());

	}

	@DataProvider(name = "InvalidUserDataProvider")
	public static Object[][] getInvalidUserLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getInvalidUserLoginSheetName());

	}

	@DataProvider(name = "DistrictAdminLoginDataProvider")
	public static Object[][] getDistrictAdminLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getDistrictadminloginSheetName());

	}

	@DataProvider(name = "SystemAdminLoginDataProvider")
	public static Object[][] getSystemAdminLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getSystemadminloginSheetName());

	}

	@DataProvider(name = "TeacherRegistrationDataProvider")
	public static Object[][] getTeacherRegistrationData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getTeacherRegistrationSheetName());

	}

	@DataProvider(name = "MultipleTeacherRegistrationDataProvider")
	public static Object[][] getMultipleTeacherRegistrationData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getMultipleTeacherRegistrationSheetName());

	}

	@DataProvider(name = "StudentRegistrationDataProvider")
	public static Object[][] getStudentRegistrationData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getStudentRegistrationSheetName());

	}

	@DataProvider(name = "DARegistrationDataProvider")
	public static Object[][] getDARegistrationData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getDARegistrationSheetName());

	}

	@DataProvider(name = "MultipleStudentRegistrationDataProvider")
	public static Object[][] getMultipleStudentRegistrationData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getMultipleStudentRegistrationSheetName());

	}

	@DataProvider(name = "MultipleDARegistrationDataProvider")
	public static Object[][] getMultipleDARegistrationData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getMultipleDARegistrationSheetName());

	}

	@DataProvider(name = "AddClassForNewUserDataProvider")
	public static Object[][] AddClassForNewUserData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getAddClassNewUserSheetName());

	}

	@DataProvider(name = "AddClassWithExistingClassDataProvider")
	public static Object[][] AddClassWithExistingClassData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getAddClassWithExistingClassSheetName());

	}

	@DataProvider(name = "AddClassWithNoActiveClassDataProvider")
	public static Object[][] AddClassWithNoActiveClassData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getSheetData(ExcelConstants.getAddClassWhenNoActiveClassSheetName());

	}

}
