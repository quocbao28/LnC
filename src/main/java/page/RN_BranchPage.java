package page;

import org.openqa.selenium.WebDriver;

import common.Constant;

public class RN_BranchPage extends AbstractPage{

	public RN_BranchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * Is Branch Header Displayed
	 * @param value
	 * @return
	 */
	public boolean isBranchHeaderDisplayed(String value){
		waitForElement(driver, interfaces.AbstractPage.DYNAMIC_PAGE_HEADER, value, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.AbstractPage.DYNAMIC_PAGE_HEADER, value);
	}

	WebDriver driver;
}
