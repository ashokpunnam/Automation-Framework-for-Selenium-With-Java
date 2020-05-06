package Wrappers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestBase.BaseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.function.Function;


public class Synchronization extends BaseTest {
	
	public static final int DEFAULTWAITFORELEMENT=10;
	public static final int DEFAULTWAITFORPAGE=20;	
	
	protected JavascriptExecutor js;
	
	protected static Logger log = LogManager.getLogger(Synchronization.class.getName());
	
	public Synchronization() {
		wait = new WebDriverWait(driver, 60);
		fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
	}
	

	public WebElement WaitForVisibilityOfElement(final By element) {
		WebElement localElement;
		
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			localElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
			return localElement;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static WebElement WaitForVisibilityOfElement(WebDriver driver, final WebElement element) {
		WebElement localElement;
		
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			localElement = wait.until(ExpectedConditions.visibilityOf(element));
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
			return localElement;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static WebElement WaitForPresenceOfElement(WebDriver driver, final By element) {
		WebElement localElement;
		
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			  localElement = fluentWait.until(new ExpectedCondition<WebElement>() {
	                @Override
	                public WebElement apply(WebDriver driver) {
	                    return driver.findElement(element);
	                }
	            });
			//localElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
			return localElement;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static WebElement WaitForPresenceOfElement(WebDriver driver, final WebElement element) {
		WebElement localElement;
		
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			  localElement = fluentWait.until(new ExpectedCondition<WebElement>() {
	                @Override
	                public WebElement apply(WebDriver driver) {
	                    return element;
	                }
	            });
			//localElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
			return localElement;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void NullifyImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
	}
	
	public static void SetImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);  
	}
	
	public static void DefaultImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait() 
		driver.manage().timeouts().implicitlyWait(DEFAULTWAITFORPAGE, TimeUnit.SECONDS); //reset implicitlyWait
	} 
	
	public static void ResetImplicitWait(WebDriver driver, int waitTime) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait() 
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS); //reset implicitlyWait
	} 
	
	public void MinWaitTime() {
		try {
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void MaxWaitTime() {
		try {
			Thread.sleep(10000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return (js.executeScript("return document.readyState").toString().equals("complete"));
                    }
                };
        try {
            Thread.sleep(1000);           
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
	
	public WebElement WaitForElementFluentWait(final WebElement element) {		
		WebElement elment = fluentWait.until(new Function<WebDriver, WebElement>(){			
			public WebElement apply(WebDriver driver ) {
				return element;
			}
		});
		return elment;
	}
	
	public WebElement WaitForElementFluentWait(final By element) {
		
		WebElement elment = fluentWait.until(new Function<WebDriver, WebElement>(){			
			public WebElement apply(WebDriver driver ) {
				return driver.findElement(element);
			}
		});
		return elment;
	}
	
	public void WebElementWaitUntilClickable(WebElement element) {	
		//while(true) {
			try {
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				//driver.manage().timeouts().implicitlyWait(implicitWait,TimeUnit.SECONDS);
				wait.until(ExpectedConditions.elementToBeClickable(element));				
				driver.manage().timeouts().implicitlyWait(implicitWait,TimeUnit.SECONDS);	
				System.out.println("Ashok Click");
				//break;
			}
			catch(UnhandledAlertException ex) {
				driver.switchTo().alert().accept();			
			}
			catch(Exception e) {
				e.printStackTrace();		
			}
			
		//}

		
	}
	
	public void WebElementWaitUntilClickable(By element) {
		//while(true) {
			try {
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				//driver.manage().timeouts().implicitlyWait(implicitWait,TimeUnit.SECONDS);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				driver.manage().timeouts().implicitlyWait(implicitWait,TimeUnit.SECONDS);
				//break;
			}
			catch(UnhandledAlertException ex) {
				driver.switchTo().alert().accept();			
			}
			catch(Exception e) {
				e.printStackTrace();		
			}
			
		//}
		
		
	}
	
	public void WaitUntilWindowsAvailable(int numberOfWindows) {
		//while(true) {
			try {
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				//driver.manage().timeouts().implicitlyWait(implicitWait,TimeUnit.SECONDS);
				wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
				driver.manage().timeouts().implicitlyWait(implicitWait,TimeUnit.SECONDS);
				//break;
			}
			catch(UnhandledAlertException ex) {
				driver.switchTo().alert().accept();			
			}
			catch(Exception e) {
				e.printStackTrace();		
			}
			
		//}		
		
	}
	
	public boolean ElementVisibility(WebElement element) {
		//Boolean bool = false;
		//while(true) {
			try {
				//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				//MinWaitTime();
				//driver.manage().timeouts().implicitlyWait(implicitWait,TimeUnit.SECONDS);
				//wait.until(ExpectedConditions.visibilityOf(element));				
				//driver.manage().timeouts().implicitlyWait(implicitWait,TimeUnit.SECONDS);
				WaitForElementFluentWait(element);
				return element.isDisplayed();
				//break;
			}
			catch(UnhandledAlertException ex) {
				driver.switchTo().alert().accept();	
				return false;						
			}
			catch(Exception e) {
				//e.printStackTrace();				
				MinWaitTime();
				return false;						
			}
			
		//}	
		
		
		
	}		

	public boolean ElementInvisibility(WebElement element) {
		Boolean bool = false;
		
			try {
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);				
				wait.until(ExpectedConditions.invisibilityOf(element));
				bool=true;
				driver.manage().timeouts().implicitlyWait(implicitWait,TimeUnit.SECONDS);				
			}
			catch(NoSuchElementException e){
				bool = false;
				
			}
			catch(UnhandledAlertException ex) {
				driver.switchTo().alert().accept();				
			}
			//
			catch(Exception e) {
				bool = false;
				e.printStackTrace();		
			}			
		
		return bool;
		
	}
	
	public WebElement WaitForElementRefresh(By element) {
        WebElement localElement = null;
       // while (true) {
            try {
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);                
                localElement = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
                driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
                //break;
            } catch (UnhandledAlertException e) {
                driver.switchTo().alert().accept();
                
            }
        //}
        return localElement;
    }
	
	public WebElement WaitForElementRefresh(WebElement element) {
        WebElement localElement = null;
       // while (true) {
            try {
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);                
                localElement = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
                driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
                //break;
            } catch (UnhandledAlertException e) {
                driver.switchTo().alert().accept();
                
            }
        //}
        return localElement;
    }
	
	public Boolean WaitForElementEnabled(final WebElement element) {
		Boolean bool;
       // while (true) {
            try {
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                bool = fluentWait.until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver webDriver) {
                        return element.isEnabled();
                    }
                });
                driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
                return bool;                
               // break;
            } catch (UnhandledAlertException e) {
                driver.switchTo().alert().accept();                
            }            
        //}
            return false;

    }
	
	public Boolean WaitForElementEnabled(final By element) {
		Boolean bool;
       // while (true) {
            try {
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                bool = fluentWait.until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver webDriver) {
                        return driver.findElement(element).isEnabled();
                    }
                });
                driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
                return bool;                
               // break;
            } catch (UnhandledAlertException e) {
                driver.switchTo().alert().accept();                
            }            
        //}
            return false;

    }
}


