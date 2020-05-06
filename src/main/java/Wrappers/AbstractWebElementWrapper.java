package Wrappers;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public abstract class AbstractWebElementWrapper extends Synchronization {

	public abstract String getText(WebElement element);

	public abstract String getText(By element);

	public abstract String getAttribute(By element, String attributeType);

	public abstract String getAttribute(WebElement element, String attributeType);

	// Send Data
	public abstract void sendKeys(WebElement element, String value);

	public abstract void sendKeys(WebElement element, int value);

	public abstract void sendKeys(WebElement element, double value);

	// Element Click
	public abstract void elementClick(WebElement element);

	public abstract void elementClick(By element);

	// Select
	public abstract void selectByValue(WebElement element, String listValue);

	public abstract void selectByIndex(WebElement element, int listValueByIndex);

	public abstract void selectByText(WebElement element, String listValue);

	// Switch Frame
	public void SwitchToFrame(String frameId) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

		} catch (UnhandledAlertException ex) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			AlertAccept();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.info("Unable to Switch to Frame" + frameId + " " + e);
			Assert.fail("Unable to Switch to Frame" + frameId + " " + e);
		}

	}

	public void SwitchToFrame(int frameIndex) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		} catch (UnhandledAlertException ex) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			AlertAccept();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

		} catch (Exception e) {
			log.info("Unable to Switch to Frame" + frameIndex + " " + e);
			Assert.fail("Unable to Switch to Frame" + frameIndex + " " + e);
		}

	}

	public void SwitchToParentFrame() {
		try {
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
			driver.switchTo().parentFrame();
		} catch (UnhandledAlertException ex) {
			AlertAccept();
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
			driver.switchTo().parentFrame();

		} catch (Exception e) {
			log.info("Unable to Switch to Frame" + e);
			Assert.fail("Unable to Switch to Frame" + e);
		}
	}

	public void SwitchToDefaultContent() {
		try {
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
			driver.switchTo().defaultContent();
		} catch (UnhandledAlertException ex) {
			AlertAccept();
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
			driver.switchTo().defaultContent();

		} catch (Exception e) {
			log.info("Unable to Switch to Frame" + e);
			Assert.fail("Unable to Switch to Frame" + e);
		}
	}

	public boolean AlertIsPresentAndSwitchToIt() {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			log.info("Alert is not present");
			Assert.fail("Unable to Switch to Alert" + ex);
		} catch (Exception e) {
			log.info("Alert is not present");
			Assert.fail("Unable to Switch to Alert" + e);
		}
		return false;

	}

	public void AlertAccept() {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException Ex) {
			log.info("Alert is not present");

		}
	}

	public String AlertGetText() {
		String alertText = "";
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			alertText = driver.switchTo().alert().getText();

		} catch (NoAlertPresentException Ex) {
			log.info("Alert is not present");

		}
		return alertText;

	}

	public void AlertDismiss() {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().dismiss();

		} catch (NoAlertPresentException Ex) {
			log.info("Alert is not present");
		}
	}

	public String ParseDataElement(CharSequence dataElement, String stringpattern) {
		String dataElmnt = "";
		Pattern pattern = Pattern.compile(stringpattern);
		Matcher matcher = pattern.matcher(dataElement);
		while (matcher.find()) {
			dataElmnt = matcher.group(1);
		}
		return dataElmnt;
	}

	public void WaitUntilWindowsAvailable(int numberOfWindows) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

		} catch (UnhandledAlertException ex) {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void SwitchToWindow(int numberOfWindow) {
		try {
			WaitUntilWindowsAvailable(numberOfWindow + 1);
			ArrayList<String> windowsSize = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(windowsSize.get(numberOfWindow));
		} catch (UnhandledAlertException ex) {
			try {
				AlertAccept();
				WaitUntilWindowsAvailable(numberOfWindow + 1);
				ArrayList<String> windowsSize = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(windowsSize.get(numberOfWindow));
			} catch (Exception e) {

				log.info("Window Not present or closed: " + e);
				Assert.fail("Window Not present or closed" + ex);
			}

		} catch (Exception e) {
			log.info("Window Not present or closed: " + e);
			Assert.fail("Window Not present or closed" + e);
		}

	}

}
