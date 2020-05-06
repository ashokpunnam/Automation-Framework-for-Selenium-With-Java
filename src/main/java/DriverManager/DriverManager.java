package DriverManager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	
	protected static WebDriver driver;
	
	abstract WebDriver createWebDriver();
	
	public void setDriver(WebDriver driver) {
		DriverManager.driver = driver;
	}	
	
	public WebDriver getWebDriver() {
		if(driver==null) {
			driver = createWebDriver();
		}
		return driver;
	}

}
