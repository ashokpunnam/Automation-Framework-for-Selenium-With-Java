package DriverManager;

import org.openqa.selenium.WebDriver;

public class DriverManagerFactory {
	private static DriverManager driverManager=null;
	private static WebDriver driver=null;
	private static DriverManagerFactory obj;

	
public static WebDriver getDriver(DriverType type) {
	switch (type) {
	case CHROME:
		driverManager = new ChromeDriverManager();
		break;
	case FIREFOX:
		driverManager = new FirefoxDriverManager();
		break;
	case IE:
		driverManager = new IEDriverManager();
		break;
		case HTMLUNIT:
			driverManager = new HTMLUnitDriver();
			break;
	default:
		driverManager = new ChromeDriverManager();
	}
	driver = driverManager.getWebDriver();
	return driver;		
		
	}

public static DriverManagerFactory getInstance() {
	if(obj==null) 
		obj = new DriverManagerFactory();
	return obj;
}

}
