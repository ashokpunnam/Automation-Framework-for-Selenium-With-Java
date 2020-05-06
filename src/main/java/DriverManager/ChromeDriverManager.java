package DriverManager;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

	@Override
	protected WebDriver createWebDriver() {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-extensions");	
		//options.setPageLoadStrategy(PageLoadStrategy.NONE);
		//options.addArguments("headless");
		
		options.addArguments("start-maximized"); 
	    options.addArguments("enable-automation"); 
	    options.addArguments("--no-sandbox"); 
	    options.addArguments("--disable-infobars"); 
	    options.addArguments("--disable-dev-shm-usage"); 
	    options.addArguments("--disable-browser-side-navigation"); 
	    options.addArguments("--disable-gpu");
	    options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	    
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\selenium-java-3.141.59\\chromedriver.exe");
		driver = new ChromeDriver(options);	
		return driver;
		
	}
	

}
