package page;

import java.util.Date;

import org.openqa.selenium.WebDriver;

import common.CommonAction;
import common.Constant;

public class RN_Message extends AbstractPage {

	public RN_Message(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Is Message Header Displayed
	 * 
	 * @param value
	 * @return
	 */
	public boolean isMessageHeaderDisplayed(String value) {
		waitForElement(driver, interfaces.AbstractPage.DYNAMIC_PAGE_HEADER, value, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.AbstractPage.DYNAMIC_PAGE_HEADER, value);
	}

	public boolean isDateTimeRegisterCorrected (){	
		waitForElement(driver,interfaces.RN_Message.REGISTER_DATETIME,Constant.TimeWait);
		String date = getText(driver,interfaces.RN_Message.REGISTER_DATETIME);
		return CommonAction.getCommon().verifyFormatDate(date);
	}

	public boolean isDateTimeDeliveryCorrected(){
		waitForElement(driver,interfaces.RN_Message.DELIVERY_DATETIME,Constant.TimeWait);
		String date = getAttributeValue(driver, interfaces.RN_Message.DELIVERY_DATETIME, "innerText");
		return CommonAction.getCommon().verifyFormatDate(date.substring(3));
	}
	
	public boolean isMessageDetailsHeaderDisplayed() {
		waitForElement(driver, interfaces.RN_Message.MESSAGE_DETAILS_HEADER, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_Message.MESSAGE_DETAILS_HEADER);
	}
	
	public boolean isStartDateFieldDisplayed() {
		waitForElement(driver, interfaces.RN_Message.STARTDATE_FIELD, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_Message.STARTDATE_FIELD);
	}
	
	public boolean isEndDateFieldDisplayed() {
		waitForElement(driver, interfaces.RN_Message.ENDDATE_FIELD, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_Message.ENDDATE_FIELD);
	}
	
	public boolean isNoneOptionDisplayed() {
		waitForElement(driver, interfaces.RN_Message.NONE_OPTION, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_Message.NONE_OPTION);
	}
	
	public boolean isSpecifyDateOptionDisplayed() {
		waitForElement(driver, interfaces.RN_Message.SPECIFY_DATE_OPTION, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_Message.SPECIFY_DATE_OPTION);
	}
	
	public boolean isDailyOptionDisplayed() {
		waitForElement(driver, interfaces.RN_Message.REPEAT_DAILY_OPTION, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_Message.REPEAT_DAILY_OPTION);
	}
	
	public boolean isWeeklyOptionDisplayed() {
		waitForElement(driver, interfaces.RN_Message.REPEAT_WEEKLY_OPTION, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_Message.REPEAT_WEEKLY_OPTION);
	}
	
	public boolean isMonthlyOptionDisplayed() {
		waitForElement(driver, interfaces.RN_Message.REPEAT_MONTHLY_OPTION, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_Message.REPEAT_MONTHLY_OPTION);
	}
	
	public boolean isLastedPaginateButtonDisplayed() {
		try{
		waitForElement(driver, interfaces.RN_Message.LAST_PAGINATE_BTN, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_Message.LAST_PAGINATE_BTN);
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean compareStartDateEndDate(){
		if(CommonAction.getCommon().startDateBeforeEndDate(getDateStartDate(), getDateEndDate())){
			return true;
		}else if(CommonAction.getCommon().startDateEqualsEndDate(getDateStartDate(), getDateEndDate())){
			return true;
		}
		return false;
	}
	
	public void clickBrowsingButton() {
		waitForElement(driver, interfaces.RN_Message.BROWSING_BTN, Constant.TimeWait);
		click(driver, interfaces.RN_Message.BROWSING_BTN);
	}

	public void clickSearchDeliveryMessageButton() {
		sleep(2);
		waitForElement(driver, interfaces.RN_Message.SEARCH_DELIVERY_MSG_BTN, Constant.TimeWait);
		click(driver, interfaces.RN_Message.SEARCH_DELIVERY_MSG_BTN);
	}
	
	public void inputStratDateField(String value){
		waitForElement(driver, interfaces.RN_Message.STARTDATE_FIELD, Constant.TimeWait);
		type(driver, interfaces.RN_Message.STARTDATE_FIELD, value);
	}
	
	public void inputEndDateField(String value){
		waitForElement(driver, interfaces.RN_Message.ENDDATE_FIELD, Constant.TimeWait);
		type(driver, interfaces.RN_Message.ENDDATE_FIELD, value);
	}
	
	
	public void clearStratDateField(){
		waitForElement(driver, interfaces.RN_Message.STARTDATE_FIELD, Constant.TimeWait);
		clear(driver, interfaces.RN_Message.STARTDATE_FIELD);
	}
	
	public void clearEndDateField(){
		waitForElement(driver, interfaces.RN_Message.ENDDATE_FIELD, Constant.TimeWait);
		clear(driver, interfaces.RN_Message.ENDDATE_FIELD);
	}
	
	public void clickSearchButton() {
		waitForElement(driver, interfaces.RN_Message.SEARCH_BTN, Constant.TimeWait);
		click(driver, interfaces.RN_Message.SEARCH_BTN);
		sleep(2);
	}
	
	public Date getDateStartDate(){
		waitForElement(driver, interfaces.RN_Message.STARTDATE_FIELD, Constant.TimeWait);
		String value =  getAttributeValue(driver, interfaces.RN_Message.STARTDATE_FIELD, "placeholder");
		Date date = CommonAction.getCommon().changeStringToDateFormat(value);
		return  date;
	}
	
	public Date getDateEndDate(){
		waitForElement(driver, interfaces.RN_Message.ENDDATE_FIELD, Constant.TimeWait);
		String value =  getAttributeValue(driver, interfaces.RN_Message.ENDDATE_FIELD, "placeholder");
		Date date = CommonAction.getCommon().changeStringToDateFormat(value);
		return  date;
	}
	
	public String getNumberOfPage(){
		waitForElement(driver, interfaces.RN_Message.LAST_PAGINATE_BTN, Constant.TimeWait);
		String date = getText(driver, interfaces.RN_Message.LAST_PAGINATE_BTN);
		return date;
	}
	
	
	WebDriver driver;
}
