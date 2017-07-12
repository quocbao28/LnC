package page;

import org.openqa.selenium.WebDriver;

import page.AbstractPage;
import common.Constant;

public class RN_CounselingPage extends AbstractPage {
	public RN_CounselingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * Is Counseling header Displayed
	 * @param value
	 * @return
	 */
	public boolean isCounselingHeaderDisplayed(String value){
		waitForElement(driver, interfaces.AbstractPage.DYNAMIC_PAGE_HEADER, value, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.AbstractPage.DYNAMIC_PAGE_HEADER, value);
	}
	
	WebDriver driver;
}
