package bil.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataReader {
	private XSSFSheet getExcelSheetAccess(String sheetName) throws IOException {
		FileInputStream objectOfFileInputStream = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;

		try {
			objectOfFileInputStream = new FileInputStream(ConfigFileReader.INSTANCE.getExcelTestDataPath());
			workbook = new XSSFWorkbook(objectOfFileInputStream);
			int sheetCount = workbook.getNumberOfSheets();
			for (int i = 0; i < sheetCount; i++) {
				if (workbook.getSheetAt(i).getSheetName().equalsIgnoreCase(sheetName)) {
					sheet = workbook.getSheetAt(i);
					break;
				}
			}
		} finally {
			workbook.close();
			objectOfFileInputStream.close();
		}
		return sheet;

	}

	public Object[][] getSheetData(String sheetName) throws IOException {
		XSSFSheet sheet = getExcelSheetAccess(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows() - 1;
		Object[][] cred = null;
		if (rowCount > 0) {
			Row row1 = sheet.getRow(0);
			int columnCount = row1.getLastCellNum();
			cred = new Object[rowCount][columnCount];
			for (int i = 0; i < rowCount; i++) {
				Row row = sheet.getRow(i + 1);
				for (int j = 0; j < columnCount; j++) {
					Cell cell = row.getCell(j);
					cred[i][j] = getCellValue(cell);
				}
			}
		}

		return cred;
	}

	public Object getCellValue(Cell cell) {
		if (cell == null) {
			return null;
		}
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();

		case BOOLEAN:
			return cell.getBooleanCellValue();

		case NUMERIC:

			if (DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
				return dateFormat.format(cell.getDateCellValue());
			} else {
				return cell.getNumericCellValue();
			}

		default:
			return null;

		}

	}

}