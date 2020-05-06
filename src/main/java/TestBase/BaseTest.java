package TestBase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import DriverManager.DriverManagerFactory;
import DriverManager.DriverType;


public class BaseTest {
	
	protected final static int EXPLICIT_WAIT_TIME_LIMIT = 60;
	protected final static int FLUENT_WAIT_TIME_LIMIT = 100;
	
	protected static WebDriver driver;
	protected static Properties prop;
	protected static BufferedReader objReader = null;
	protected static FileInputStream propFile = null;
	protected static XSSFWorkbook workbook = null;
	protected static FileInputStream excelFile = null;
	protected static FileOutputStream excelOutPutStream = null;
	protected static XSSFWorkbook ExcelWBook;
	private static XSSFRow Row;
	protected static WebDriverWait wait;
	protected static int implicitWait=50;
	protected static Wait<WebDriver> fluentWait;
	

	public static Logger log = LogManager.getLogger(BaseTest.class.getName());

	public BaseTest() {
		prop=loadPropertiesFile();
	}

	public static WebDriver getDriver(@Optional("Chrome") String BrowserType) {
		// TODO Auto-generated method stub

		log.info("Launch Application in: " + BrowserType + " Broswer");
		// driver = DriverManagerFactory.getDriver(DriverType.valueOf(BrowserType.toUpperCase()));
		DriverManagerFactory.getInstance();
		driver = DriverManagerFactory.getDriver(DriverType.valueOf(BrowserType.toUpperCase()));
		//implicitWait = Integer.parseInt(prop.getProperty("implicitlyWait"));
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(implicitWait, TimeUnit.SECONDS);		
		log.info("Driver object is created and initiated");
		return driver;

	}

	public static void closeDriver(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		//prop = null;
		//log.info("Properties file object is nullified");
		driver.close();
		driver.quit();
		log.info("Driver object is purged and browser session is closed");

	}

	public static Properties loadPropertiesFile() {
		prop = new Properties();
		try {
			propFile = new FileInputStream("src/main/java/Data/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(propFile);
			log.info("Properties file is read into prop object");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	public static void takeScreenshot() throws IOException {
		File scrshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("src/main/java/Screenshots/screenshot.png");
		FileUtils.copyFileToDirectory(scrshot, destFile);
		Reporter.log("<a href='" + destFile.getAbsolutePath() + "'>screenshot</a>");

	}

	public static FileInputStream readExcelFile(String excelFilePath) {
		// FileInputStream excellFile = null;
		try {
			excelFile = new FileInputStream(excelFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return excelFile;
	}

	public static void WriteExcelData(String excelFilePath, String sheetName, int rowNumber, int columnNumber, String cellValue) {
		// FileInputStream excellFile = null;
		try {
			excelFile = new FileInputStream(excelFilePath);
			ExcelWBook = new XSSFWorkbook(excelFile);
			XSSFSheet sheet = ExcelWBook.getSheet(sheetName);
			Row = sheet.getRow(rowNumber);
			Row.createCell(columnNumber).setCellValue(cellValue);

			excelOutPutStream = new FileOutputStream(excelFilePath);
			ExcelWBook.write(excelOutPutStream);
			excelFile.close();
			excelOutPutStream.close();
			ExcelWBook.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
