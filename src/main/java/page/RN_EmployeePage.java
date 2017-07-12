package page;

import org.openqa.selenium.WebDriver;

import common.CommonAction;
import common.Constant;

public class RN_EmployeePage extends AbstractPage{

	public RN_EmployeePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * Is Start Date Displayed
	 * @param value
	 * @return
	 */
	public boolean isStartDateDisplayed(){
		waitForElement(driver, interfaces.RN_EmployeePage.STARTDATE_FIELD, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_EmployeePage.STARTDATE_FIELD);
	}
	
	/**
	 * Is End Date Displayed
	 * @param value
	 * @return
	 */
	public boolean isEndDateDisplayed(){
		waitForElement(driver, interfaces.RN_EmployeePage.ENDDATE_FIELD, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_EmployeePage.ENDDATE_FIELD);
	}
	
	
	/**
	 * Is Employee Header Displayed
	 * @param value
	 * @return
	 */
	public boolean isEmployeeHeaderDisplayed(String value){
		waitForElement(driver, interfaces.AbstractPage.DYNAMIC_PAGE_HEADER, value, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.AbstractPage.DYNAMIC_PAGE_HEADER, value);
	}
	
	/**
	 * Is Employee Id Field Displayed
	 * @return
	 */
	public boolean isEmployeeIdFieldrDisplayed(){
		waitForElement(driver, interfaces.RN_EmployeePage.EMPLOYEE_ID_FIELD, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_EmployeePage.EMPLOYEE_ID_FIELD);
	}
	
	/**
	 * Is Company DropDown Displayed
	 * @return
	 */
	public boolean isCompanyDropDownrDisplayed(){
		waitForElement(driver, interfaces.RN_EmployeePage.COMPANY_DROPDOWN, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_EmployeePage.COMPANY_DROPDOWN);
	}
	
	/**
	 * Is Office DropDown Displayed
	 * @return
	 */
	public boolean isOfficeDropDownDisplayed(){
		waitForElement(driver, interfaces.RN_EmployeePage.OFFICE_DROPDOWN, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_EmployeePage.OFFICE_DROPDOWN);
	}
	
	/**
	 * Is Name Field Displayed
	 * @return
	 */
	public boolean isNameFieldDisplayed(){
		waitForElement(driver, interfaces.RN_EmployeePage.YOURNAME_FIELD, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_EmployeePage.YOURNAME_FIELD);
	}
	
	/**
	 * Is Send Code PopUp Displayed
	 * @return
	 */
	public boolean isSendCodePopUpDisplayed(){
		waitForElement(driver, interfaces.RN_EmployeePage.SEND_CODE_POPUP_TITLE, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_EmployeePage.SEND_CODE_POPUP_TITLE);
	}
	
	
	/**
	 * Click Employee Search Button
	 */
	public void clickEmployeeSearchButton(){
		sleep(2);
		waitForElement(driver, interfaces.RN_EmployeePage.EMPLOYEE_SEARCH_BTN, Constant.TimeWait);
		click(driver, interfaces.RN_EmployeePage.EMPLOYEE_SEARCH_BTN);
	}
	
	/**
	 * Click Close PopUp Send Code
	 */
	public void clickClosePopUpSendCodeButton(){
		waitForElement(driver, interfaces.RN_EmployeePage.CLOSE_POPUP_BUTTON, Constant.TimeWait);
		click(driver, interfaces.RN_EmployeePage.CLOSE_POPUP_BUTTON);
	}
	
	
	/**
	 * Click Send Code Button
	 */
	public void clickSendCodeButton(){
		waitForElement(driver, interfaces.RN_EmployeePage.SEND_CODE_BUTTON, Constant.TimeWait);
		click(driver, interfaces.RN_EmployeePage.SEND_CODE_BUTTON);
	}
	
	/**
	 * Click Retirement bulk addition Button
	 */
	public void clickRetirementBulkAdditionButton(){
		waitForElement(driver, interfaces.RN_EmployeePage.RETIREMENT_BULK_ADDITION_BUTTON, Constant.TimeWait);
		click(driver, interfaces.RN_EmployeePage.RETIREMENT_BULK_ADDITION_BUTTON);
	}
	
	/**
	 * Click Browse File Button
	 */
	public void clickBrowseFileButton(){
		waitForElement(driver, interfaces.RN_EmployeePage.BROWSE_FILE_BUTTON, Constant.TimeWait);
		click(driver, interfaces.RN_EmployeePage.BROWSE_FILE_BUTTON);
	}
	
	/**
	 * Click Search Button
	 */
	public void clickSearchButton(){
		waitForElement(driver, interfaces.RN_EmployeePage.SEARCH_BTN, Constant.TimeWait);
		click(driver, interfaces.RN_EmployeePage.SEARCH_BTN);
	}
	
	/**
	 * Click Record Button
	 */
	public void clickRecordButton(){
		waitForElement(driver, interfaces.RN_EmployeePage.RECORD_BUTTON, Constant.TimeWait);
		click(driver, interfaces.RN_EmployeePage.RECORD_BUTTON);
	}
	
	
	/**
	 * Get Start Date Placeholder
	 * @return
	 */
	public String getStartDatePlaceholder(){
		String date = getAttributeValue(driver, interfaces.RN_EmployeePage.STARTDATE_FIELD, "placeholder");
		return date;
	}
	
	/**
	 * Get End Date Placeholder
	 * @return
	 */
	public String getEndDatePlaceholder(){
		String date= getAttributeValue(driver, interfaces.RN_EmployeePage.ENDDATE_FIELD, "placeholder");
		return date;
	}
	
	/**
	 * Input Start Date
	 * @param date
	 */
	public void inputStartDate(String date){
		waitForElement(driver, interfaces.RN_EmployeePage.STARTDATE_FIELD, Constant.TimeWait);
		type(driver, interfaces.RN_EmployeePage.STARTDATE_FIELD, date);
	}
	
	/**
	 * Input End Date
	 * @param date
	 */
	public void inputEndDate(String date){
		waitForElement(driver, interfaces.RN_EmployeePage.ENDDATE_FIELD, Constant.TimeWait);
		type(driver, interfaces.RN_EmployeePage.ENDDATE_FIELD, date);
	}
	
	/**
	 * Is Search Result Displayed
	 * @return
	 */
	public boolean isSearchResultDisplayed(){
		waitForElement(driver, interfaces.RN_EmployeePage.SEARCH_RESULT, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_EmployeePage.SEARCH_RESULT);
	}
	
	/**
	 * Click Download Button
	 */
	public void clickDownloadButton(){
		waitForElement(driver, interfaces.RN_EmployeePage.DOWNLOAD_CSV_BTN, Constant.TimeWait);
		click(driver, interfaces.RN_EmployeePage.DOWNLOAD_CSV_BTN);
	}
	
	/**
	 * Click Confirm Download Button
	 * @param browser
	 */
	public void clickConfirmDownloadButton(String browser){
		if (browser.toString().toLowerCase().contains("firefox")) {
			waitForElement(driver, interfaces.RN_EmployeePage.CONFIRM_DOWNLOAD_CSV_BTN, Constant.TimeWait);
			click(driver, interfaces.RN_EmployeePage.CONFIRM_DOWNLOAD_CSV_BTN);
			sleep(5);
			CommonAction.getCommon().pressEnterKey();
		}else{
			waitForElement(driver, interfaces.RN_EmployeePage.CONFIRM_DOWNLOAD_CSV_BTN, Constant.TimeWait);
			click(driver, interfaces.RN_EmployeePage.CONFIRM_DOWNLOAD_CSV_BTN);
		}
		sleep(60);
	}
	
	/**
	 * Is CSV File Downloaded
	 * @return
	 */
	public boolean isCSVFileDownloaded(){
		waitForElement(driver, interfaces.RN_EmployeePage.CSV_FILE, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_EmployeePage.CSV_FILE);
	}
	
	/**
	 * Click Employee Button
	 */
	public void clickReadingEmployeeButton(){
		waitForElement(driver, interfaces.RN_EmployeePage.READING_EMPLOYEE_BTN, Constant.TimeWait);
		click(driver, interfaces.RN_EmployeePage.READING_EMPLOYEE_BTN);
	}
	
	/**
	 * Click Anlytics button
	 */
	public void clickAnalyticsButton(){
		waitForElement(driver, interfaces.RN_EmployeePage.ANALYTICS_BTN, Constant.TimeWait);
		click(driver, interfaces.RN_EmployeePage.ANALYTICS_BTN);
	}
	
WebDriver driver;
}
