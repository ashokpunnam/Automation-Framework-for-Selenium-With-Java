package DriverManager;

import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriver extends DriverManager  {


	@Override
	protected WebDriver createWebDriver() {
		// TODO Auto-generated method stub
		 //driver = new HtmlUnitDriver();
		return driver;
	}
	
}
