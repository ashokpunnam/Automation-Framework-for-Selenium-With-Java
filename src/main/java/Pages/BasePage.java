package Pages;

import org.openqa.selenium.support.PageFactory;

import Data.ReadExcelData;
import TestBase.BaseTest;
import Wrappers.WebElementWrapperGeneric;

public class BasePage extends BaseTest {
	
	WebElementWrapperGeneric elementWrapper;
	ReadExcelData readexcelData;
	
	public BasePage() {
		elementWrapper = new WebElementWrapperGeneric();
		PageFactory.initElements(driver, this);
		
	}

}
