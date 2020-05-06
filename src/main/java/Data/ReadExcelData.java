package Data;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import TestBase.BaseTest;


public class ReadExcelData extends BaseTest {

	private static FileInputStream ExcelFile;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFRow Row;
	//Object[][] excelData = null;
	String[][] excelData = null;

	public String[][] getDatafromExcel(String excelFilePath, String sheetName) throws IOException {

		//Object[][] excelData = null;
		ExcelFile = readExcelFile(excelFilePath);
		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		XSSFSheet sheet = ExcelWBook.getSheet(sheetName);
		int rowsCount = sheet.getLastRowNum() + 1;
		Row = sheet.getRow(0);
		int columnsCount = Row.getLastCellNum();
		//excelData = new Object[rowsCount - 1][columnsCount];
		excelData = new String[rowsCount - 1][columnsCount];
		System.out.println("rowCount" + rowsCount + ":::" + "columnsCount" + columnsCount);
		for (int i = 1; i < rowsCount; i++) {
			Row = sheet.getRow(i);
			for (int j = 0; j < columnsCount; j++) {
				// excelData[i-1][j] =
				Cell cell = Row.getCell(j);
				cell.getCellType();
				//System.out.println("Data" + cell.getStringCellValue());
				switch (cell.getCellType()) {
				case NUMERIC:
					excelData[i - 1][j] = (Integer.toString((int) (Math.ceil((double) cell.getNumericCellValue()))));
					//System.out.println("DataNumeric" + excelData[i - 1][j] );
					break;
				case STRING:
					excelData[i - 1][j] = cell.getStringCellValue();
					//System.out.println("Data" + excelData[i - 1][j] );
					break;
				case BOOLEAN:
					excelData[i - 1][j] = cell.getStringCellValue();
					//cell.getBooleanCellValue();
					//System.out.println("Data" + excelData[i - 1][j] );
					break;
				case BLANK:
					excelData[i - 1][j] = null;
					//System.out.println("Data" + excelData[i - 1][j] );
					break;
				case ERROR:
					excelData[i - 1][j] = null;
					//System.out.println("Data" + excelData[i - 1][j] );
					break;
				default:
					excelData = null;

				}
			}
		}

		return excelData;

	}

	@DataProvider(name = "provideDataFromExcel")
	public Object[][] provideData(ITestContext c) throws IOException {
		String excelFilePath="";
		String sheetName = "";
		for(String group:c.getIncludedGroups())
		{
			if(group.equalsIgnoreCase("maintainCustomer"))
			{
				//excelFilePath = "D:\\Git_Projects\\iCargoCRMAutomation\\src\\main\\java\\Data\\CRM_Test_Scenarios_Input_PAL_Data.xlsx";
				excelFilePath = "src/main/java/Data/CRM_Test_Scenarios_Input_PAL_Data.xlsx";
				sheetName = "Test_Scenarios";
			}
			else if(group.equalsIgnoreCase("capacityBooking"))
			{
				System.out.println("Ashok");
				//excelFilePath = "C:\\Users\\972797\\iCargoCRMAutomation\\src\\main\\java\\Data\\CRM_Test_Scenarios_Input_AWB.xlsx";
				excelFilePath = "src/main/java/Data/CRM_Test_Scenarios_Input_AWB.xlsx";
				sheetName = "saveBooking_Scenarios";
			}
			else
			{
				//excelFilePath = "C:\\Users\\972797\\iCargoCRMAutomation\\src\\main\\java\\Data\\ScreenSearch.xlsx";
				excelFilePath = "src/main/java/Data/ScreenSearch.xlsx";
				sheetName = "Sheet1";
			}
		}
		
		//Object[][] testData = getDatafromExcel("C:\\Users\\972797\\iCargoCRMAutomation\\src\\main\\java\\Data\\CRM_Test_Scenarios_Input_AWB.xlsx", "saveBooking_Scenarios");
		Object[][] testData = getDatafromExcel(excelFilePath, sheetName);
		return testData;

	}

}
