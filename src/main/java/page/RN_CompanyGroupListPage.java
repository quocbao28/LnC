package page;

import org.openqa.selenium.WebDriver;

import page.AbstractPage;
import common.Constant;

public class RN_CompanyGroupListPage extends AbstractPage {
	public RN_CompanyGroupListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * Click Import CSV Button
	 */
	public void clickImportCSVButton(){
		waitForElement(driver, interfaces.RN_CompanyGroupListPage.IMPORT_CSV_BUTTON, Constant.TimeWait);
		click(driver, interfaces.RN_CompanyGroupListPage.IMPORT_CSV_BUTTON);
	}

	/**
	 * Is Company Header Displayed
	 * @param value
	 * @return
	 */
	public boolean isCompanyHeaderDisplayed(String value){
		waitForElement(driver, interfaces.AbstractPage.DYNAMIC_PAGE_HEADER, value, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.AbstractPage.DYNAMIC_PAGE_HEADER, value);
	}
	
	/**
	 * Is Import CSV Pop-up Displayed
	 * @return
	 */
	public boolean isImportCSVPopUpDisplayed(){
		waitForElement(driver, interfaces.RN_CompanyGroupListPage.IMPORT_CSV_MODAL_TITLE, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_CompanyGroupListPage.IMPORT_CSV_MODAL_TITLE);
	}
	
	WebDriver driver;
}
