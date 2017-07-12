package page;

import org.openqa.selenium.WebDriver;

import common.Constant;

public class SettingPage extends AbstractPage{

	public SettingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * Enter Email Address
	 * @param value
	 */
	public void inputEmailAddress(String value){
		waitForElement(driver, interfaces.SettingPage.EMAIL_TEXTBOX, Constant.TimeWait);
		type(driver, interfaces.SettingPage.EMAIL_TEXTBOX, value);
		sleep(2);
	}
	
	/**
	 * Enter Mainternace Message
	 * @param value
	 */
	public void inputMaintenanceMessage(String value){
		waitForElement(driver, interfaces.SettingPage.MAINTENANCE_MESSAGE_TEXTBOX, Constant.TimeWait);
		type(driver, interfaces.SettingPage.MAINTENANCE_MESSAGE_TEXTBOX, value);
		sleep(1);
	}
	
	/**
	 * Enter ID textbox
	 * @param value
	 */
	public void inputID(String value){
		waitForElement(driver, interfaces.SettingPage.ID_TEXTBOX, Constant.TimeWait);
		click(driver, interfaces.SettingPage.ID_TEXTBOX);
		type(driver, interfaces.SettingPage.ID_TEXTBOX, value);
		sleep(2);
	}

	
	/**
	 * Click Submit Button
	 */
	public void clickSubmitButton(){
		waitForElement(driver, interfaces.SettingPage.SUBMIT_BUTTON, Constant.TimeWait);
		click(driver, interfaces.SettingPage.SUBMIT_BUTTON);
		sleep(2);
	}
	
	/**
	 * Click OFF of Maintenance Option
	 */
	public void clickMaintenanceOffRadioButton(){
		waitForElement(driver, interfaces.SettingPage.MAINTENANCE_OFF_OPTION, Constant.TimeWait);
		click(driver, interfaces.SettingPage.MAINTENANCE_OFF_OPTION);
		sleep(1);
	}
	
	/**
	 * Click ON of Maintenance Option
	 */
	public void clickMaintenanceOnRadioButton(){
		waitForElement(driver, interfaces.SettingPage.MAINTENANCE_ON_OPTION, Constant.TimeWait);
		click(driver, interfaces.SettingPage.MAINTENANCE_ON_OPTION);
		sleep(1);
	}
	
	/**
	 * Accept Submit Alert
	 */
	public void acceptSubmitModalDialog(){
		waitForElement(driver, interfaces.SettingPage.OK_MODAL_DIALOG_BUTTON, Constant.TimeWait);
		click(driver, interfaces.SettingPage.OK_MODAL_DIALOG_BUTTON);
		sleep(2);
	}
	
	
	/**
	 * Get Current Email
	 * @return
	 */
	public String getCurrentEmail(){
		waitForElement(driver, interfaces.SettingPage.EMAIL_TEXTBOX, Constant.TimeWait);
		return getAttributeValue(driver, interfaces.SettingPage.EMAIL_TEXTBOX, "value");
	}
	
	/**
	 * Get Current ID
	 * @return
	 */
	public String getCurrentID(){
		waitForElement(driver, interfaces.SettingPage.ID_TEXTBOX, Constant.TimeWait);
		return getAttributeValue(driver, interfaces.SettingPage.ID_TEXTBOX, "value");
	}
	
	/**
	 * Get Message on Modal Dialog
	 * @return
	 */
	public String getMessageOnModalDialog(){
		waitForElement(driver, interfaces.SettingPage.MESSAGE_IN_MODAL_DIALOG, Constant.TimeWait);
		return getAttributeValue(driver, interfaces.SettingPage.MESSAGE_IN_MODAL_DIALOG, "innerText");
	}
	
	/**
	 * Is Dynamic Error Displayed
	 * @param value
	 * @return
	 */
	public boolean isDynamicErrorMessageDisplayed(String value){
		waitForElement(driver, interfaces.SettingPage.DYNAMIC_ERROR_MESSAGE, value, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.SettingPage.DYNAMIC_ERROR_MESSAGE, value);
	}
	
	/**
	 * is OFF Maintenance Selected
	 * @return
	 */
	public boolean isMaintenanceOffSelected(){
		waitForElement(driver, interfaces.SettingPage.MAINTENANCE_OFF_OPTION, Constant.TimeWait);
		return isControlSelected(driver, interfaces.SettingPage.MAINTENANCE_OFF_OPTION);
	}
	
	/**
	 * is ON Maintenance Selected
	 * @return
	 */
	public boolean isMaintenanceOnSelected(){
		waitForElement(driver, interfaces.SettingPage.MAINTENANCE_ON_OPTION, Constant.TimeWait);
		return isControlSelected(driver, interfaces.SettingPage.MAINTENANCE_ON_OPTION);
	}
	
	/**
	 * is Maintenace message textbox Displayed
	 * @return
	 */
	public boolean isMaintenanceMessageTextboxDisplayed(){
		waitForElement(driver, interfaces.SettingPage.MAINTENANCE_MESSAGE_TEXTBOX, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.SettingPage.MAINTENANCE_MESSAGE_TEXTBOX);
	}
	
	/**
	 * Is Saved Successfully Message Displayed
	 * @return
	 */
	public boolean isSavedSuccessfullyMessageDisplayed(){
		waitForElement(driver, interfaces.SettingPage.SAVED_SUCCESSFULLY_MESSAGE, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.SettingPage.SAVED_SUCCESSFULLY_MESSAGE);
	}

	public WebDriver driver;
}
