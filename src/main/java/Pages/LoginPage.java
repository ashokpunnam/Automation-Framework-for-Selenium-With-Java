package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	private By userName = By.id("userID");
	private By password = By.id("password");
	private By login = By.id("login");
	//private By remindButton = By.id("remindBtn");
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}

	public String getUserName() {

		return elementWrapper.getText(driver.findElement(userName));
	}

	public void setUserName(String strUserName) {

		elementWrapper.sendKeys(driver.findElement(userName), strUserName);

	}

	public void setPassword(String strUserPassword) {

		elementWrapper.sendKeys(driver.findElement(password), strUserPassword);

	}

	public void clickLogin() {
		// driver.findElement(login).click();
		elementWrapper.elementClick(driver.findElement(login));
	}

	public void login(String strUserName, String strUserPassword) {
		this.setUserName(strUserName);
		this.setPassword(strUserPassword);
		this.clickLogin();		

	}

}
