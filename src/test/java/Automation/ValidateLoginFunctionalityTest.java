package Automation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import Pages.LoginPage;
import TestBase.BaseTest;

@Test
public class ValidateLoginFunctionalityTest {
	
	public WebDriver driver;
	
	public ValidateLoginFunctionalityTest() {
		driver = BaseTest.getDriver("Chrome");		
	}
	
	
	public void loginTest() {
		driver.get("https://www.example.com");
		LoginPage loginpage = new LoginPage(driver);		
		loginpage.login("xxxxxx", "xxxxxxx");	
	}
	


}
