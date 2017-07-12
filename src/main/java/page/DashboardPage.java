package page;

import org.openqa.selenium.WebDriver;

import common.Constant;

/**
 * @author AsianTech
 *
 */
public class DashboardPage extends AbstractPage {
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * Click Dynamic Button
	 * @param value
	 */
	public void clickDynamicButton(String value){
		waitForElement(driver, interfaces.DashboardPage.DYNAMIC_DASHBOARD_BUTTON, value, Constant.TimeWait);
		click(driver, interfaces.DashboardPage.DYNAMIC_DASHBOARD_BUTTON, value);
		sleep(2);
	}
	
	/**
	 * Click Dynamic Menu Bar button
	 * @param value
	 */
	public void clickDynamicMenuBarButton(String value){
		waitForElement(driver, interfaces.DashboardPage.DYNAMIC_MENU_BAR_BUTTON, value, Constant.TimeWait);
		click(driver, interfaces.DashboardPage.DYNAMIC_MENU_BAR_BUTTON, value);
		sleep(2);
	}

	/**Is Header displayed
	 * @return
	 */
	public boolean isHeaderDisplayed() {
		waitForElement(driver, interfaces.DashboardPage.DASHBOARD_HEADER, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.DashboardPage.DASHBOARD_HEADER);
	}
	
	/**
	 * is Dynamic Button Display
	 * @param value
	 * @return
	 */
	public boolean isDynamicButtonDisplay(String value){
		waitForElement(driver, interfaces.DashboardPage.DYNAMIC_DASHBOARD_BUTTON, value, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.DashboardPage.DYNAMIC_DASHBOARD_BUTTON, value);
	}
	
	/**is Nav Bar Acc Displayed
	 * @return
	 */
	public boolean isNavBarAccDisplayed(String value) {
		waitForElement(driver, interfaces.DashboardPage.NAVBAR_ACCOUNT,value, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.DashboardPage.NAVBAR_ACCOUNT,value);
	}
	
	public boolean isDynamicDashboardPageTitleDisplayed(String value){
		waitForElement(driver, interfaces.DashboardPage.DYNAMIC_DASHBOARD_PAGE_TITLE, value, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.DashboardPage.DYNAMIC_DASHBOARD_PAGE_TITLE, value);
	}
	
	/**
	 * Get Text Under Dynamic Button
	 * @param value
	 * @return
	 */
	public String getTextUnderDynamicButton(String value){
		waitForElement(driver, interfaces.DashboardPage.DYNAMIC_DASHBOARD_MESSAGE_UNDER_BUTTON,value, Constant.TimeWait);
		return getText(driver, interfaces.DashboardPage.DYNAMIC_DASHBOARD_MESSAGE_UNDER_BUTTON, value);
	}


	WebDriver driver;
}
