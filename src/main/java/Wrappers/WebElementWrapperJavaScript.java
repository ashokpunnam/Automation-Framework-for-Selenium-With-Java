package Wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class WebElementWrapperJavaScript extends AbstractWebElementWrapper {
	
	JavascriptExecutor js;

	public WebElementWrapperJavaScript() {		
		js = ((JavascriptExecutor) driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getText(WebElement element) {
		// TODO Auto-generated method stub
		String data = "";
		try {
			WebElementWaitUntilClickable(element);
			data =  (String) js.executeScript("return arguments[0].value", element);
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
			data =  (String) js.executeScript("return arguments[0].value", driver.findElement(element));
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
		return null;
	}

	@Override
	public String getAttribute(WebElement element, String attributeType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendKeys(WebElement element, String value) {
		// TODO Auto-generated method stub
		try {
			WebElementWaitUntilClickable(element);			
			element.clear();
			js.executeScript("arguments[0].setAttribute('value', arguments[1])", element, value);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void sendKeys(WebElement element, int value) {
		// TODO Auto-generated method stub
		try {
			WebElementWaitUntilClickable(element);		
			element.clear();
			js.executeScript("arguments[0].setAttribute('value', arguments[1])", element, value);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void sendKeys(WebElement element, double value) {
		// TODO Auto-generated method stub
		try {
			WebElementWaitUntilClickable(element);			
			element.clear();
			js.executeScript("arguments[0].setAttribute('value', arguments[1])", element, value);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void elementClick(WebElement element) {
		// TODO Auto-generated method stub
		try {
			WebElementWaitUntilClickable(element);		
			js.executeScript("arguments[0].click()", element);
		} catch (Exception ex) {
			// logger
			ex.printStackTrace();
		}
	}

	@Override
	public void elementClick(By element) {
		// TODO Auto-generated method stub
		try {
			WebElementWaitUntilClickable(element);		
			js.executeScript("arguments[0].click()", driver.findElement(element));
		} catch (Exception ex) {
			// logger
			ex.printStackTrace();
		}
	}

	@Override
	public void selectByValue(WebElement element, String listValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectByIndex(WebElement element, int listValueByIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectByText(WebElement element, String listValue) {
		// TODO Auto-generated method stub
		
	}

	

}
