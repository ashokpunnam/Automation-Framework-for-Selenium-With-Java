package DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IEDriverManager extends DriverManager{

	@Override
	protected WebDriver createWebDriver() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C:\\Softwares\\selenium-java-3.141.59\\msedgedriver.exe");		
	    driver =new FirefoxDriver();
	    return driver;
		
	}

}
