package Pages;

import org.openqa.selenium.By;

public class LogoutPage extends BasePage {
	
	private By logout = By.id("logout");
	
	public void logOutFromApp() {
		elementWrapper.elementClick(logout);
		
	}

}
