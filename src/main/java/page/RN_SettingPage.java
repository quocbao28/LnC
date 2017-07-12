package page;

import org.openqa.selenium.WebDriver;

import common.Constant;

public class RN_SettingPage extends AbstractPage {

	public RN_SettingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isSettingHeaderDisplayed(String value) {
		waitForElement(driver, interfaces.AbstractPage.DYNAMIC_PAGE_HEADER, value, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.AbstractPage.DYNAMIC_PAGE_HEADER, value);
	}

	WebDriver driver;
}
