package Wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementWrapperGeneric extends AbstractWebElementWrapper {

	@Override
	public String getText(WebElement element) {
		// TODO Auto-generated method stub
		String data = "";
		try {
			WebElementWaitUntilClickable(element);
			data= element.getText();			
		}
		catch(Exception ex) {
			log.info("Unable to get data from element"+element);
			ex.printStackTrace();
		}
		return data;
	}

	@Override
	public String getText(By element) {
		// TODO Auto-generated method stub
		String data = "";
		try {
			WebElementWaitUntilClickable(element);
			data= driver.findElement(element).getText();			
		}
		catch(Exception ex) {
			log.info("Unable to get data from element"+element);
			ex.printStackTrace();
		}
		return data;
	}

	@Override
	public String getAttribute(By element, String attributeType) {
		// TODO Auto-generated method stub
		String data = "";
		try {
			WebElementWaitUntilClickable(element);
			data= driver.findElement(element).getAttribute(attributeType);			
		}
		catch(Exception ex) {
			log.info("Unable to get data from element"+element);
			ex.printStackTrace();
		}
		return data;
	}

	@Override
	public String getAttribute(WebElement element, String attributeType) {
		// TODO Auto-generated method stub
		String data = "";
		try {
			WebElementWaitUntilClickable(element);
			data= element.getAttribute(attributeType);			
		}
		catch(Exception ex) {
			log.info("Unable to get data from element"+element);
			ex.printStackTrace();
		}
		return data;
	}

	@Override
	public void sendKeys(WebElement element, String value) {
		// TODO Auto-generated method stub
		try {
			WebElementWaitUntilClickable(element);			
			element.clear();
			for (int i = 0; i < value.length(); i++) {
				char c = value.charAt(i);
				String s = new StringBuilder().append(c).toString();				
				element.sendKeys(s);
			}	
			
			
		} catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			try {
				AlertAccept();
			}
			catch(Exception ex) {
				e.printStackTrace();
			}			
		}
	}

	@Override
	public void sendKeys(WebElement element, int value) {
		// TODO Auto-generated method stub
		try{
			WebElementWaitUntilClickable(element);				
		element.clear();
		String tmpValue = Integer.toString(value);
		for (int i = 0; i < tmpValue.length(); i++) {
			char c = tmpValue.charAt(i);
			String s = new StringBuilder().append(c).toString();
			element.sendKeys(s);
		}
		}
		catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			try {
				AlertAccept();
			}
			catch(Exception ex) {
				e.printStackTrace();
			}			
		}
	}

	@Override
	public void sendKeys(WebElement element, double value) {
		// TODO Auto-generated method stub
		try{
			WebElementWaitUntilClickable(element);				
		element.clear();
		String tmpValue = Double.toString(value);
		for (int i = 0; i < tmpValue.length(); i++) {
			char c = tmpValue.charAt(i);
			String s = new StringBuilder().append(c).toString();
			element.sendKeys(s);
		}
		}
		catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			try {
				AlertAccept();
			}
			catch(Exception ex) {
				e.printStackTrace();
			}			
		}
	}

	@Override
	public void elementClick(WebElement element) {
		// TODO Auto-generated method stub
		try {
			//WebElementWaitUntilClickable(element);
			WaitForElementFluentWait(element);
			element.click();
			
			//return false;
		} catch (Exception ex) {
			// logger
			log.info("Element click was unsuccessful"+element);			
			//ex.printStackTrace();
		}
	}

	@Override
	public void elementClick(By element) {
		// TODO Auto-generated method stub
		try {
			//WebElementWaitUntilClickable(element);
			WaitForElementFluentWait(element);
			driver.findElement(element).click();
			
			//return false;
		} catch (Exception ex) {
			// logger
			log.info("Element click was unsuccessful"+element);			
			//ex.printStackTrace();
		}
	}

	@Override
	public void selectByValue(WebElement element, String listValue) {
		// TODO Auto-generated method stub
		try {
			ElementVisibility(element);
			Select items = new Select(element);
			items.selectByValue(listValue);			
		}
		catch(Exception ex) {
			//logger
			ex.printStackTrace();
		}
	}

	@Override
	public void selectByIndex(WebElement element, int listValueByIndex) {
		// TODO Auto-generated method stub
		try {
			ElementVisibility(element);
			Select items = new Select(element);
			items.selectByIndex(listValueByIndex);			
		}
		catch(Exception ex) {
			//logger
			ex.printStackTrace();
		}
	}

	@Override
	public void selectByText(WebElement element, String listValue) {
		// TODO Auto-generated method stub
		try {
			if(ElementVisibility(element)) {
				Select items = new Select(element);
				items.selectByVisibleText(listValue);
			}
			else {
				
			}
						
		}
		catch(Exception ex) {
			//logger
			ex.printStackTrace();
		}
	}

	

}
