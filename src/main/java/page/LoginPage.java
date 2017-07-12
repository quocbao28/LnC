package page;

import org.openqa.selenium.WebDriver;

import common.Constant;

/**
 * @author AsianTech
 *
 */
public class LoginPage extends AbstractPage {
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * Login As User
	 * @param username
	 * @param password
	 */
	public void loginAs(String username, String password){
		inputID(username);
		inputPwd(password);
		clickLoginButton();
	}

	/**
	 * Click Login Button
	 */
	public void clickLoginButton() {
		waitForElement(driver, interfaces.RN_LoginPage.LOGIN_BTN, Constant.TimeWait);
		click(driver, interfaces.RN_LoginPage.LOGIN_BTN);
		sleep(2);
	}

	/**
	 * Click Remember Button
	 */
	public void clickRememberButton() {
		waitForElement(driver, interfaces.RN_LoginPage.REMEMBER_BTN, Constant.TimeWait);
		click(driver, interfaces.RN_LoginPage.REMEMBER_BTN);
	}

	/**
	 * Click Forgot pwd Button
	 */
	public void clickForgotPwdButton() {
		waitForElement(driver, interfaces.RN_LoginPage.FORGOT_PASSWORD_BUTTON, Constant.TimeWait);
		click(driver, interfaces.RN_LoginPage.FORGOT_PASSWORD_BUTTON);
		sleep(2);
	}

	/**
	 * Input ID
	 */
	public void inputID(String user) {
		waitForElement(driver, interfaces.RN_LoginPage.USERNAME_TEXTBOX, Constant.TimeWait);
		type(driver, interfaces.RN_LoginPage.USERNAME_TEXTBOX, user);
	}

	/**
	 * Clear Id field
	 */
	public void clearIdField() {
		waitForElement(driver, interfaces.RN_LoginPage.USERNAME_TEXTBOX, Constant.TimeWait);
		clear(driver, interfaces.RN_LoginPage.USERNAME_TEXTBOX);
	}

	/**
	 * Input Pwd
	 */
	public void inputPwd(String pwd) {
		waitForElement(driver, interfaces.RN_LoginPage.PASSWORD_TEXTBOX, Constant.TimeWait);
		type(driver, interfaces.RN_LoginPage.PASSWORD_TEXTBOX, pwd);
	}

	/**
	 * Clear Pwd field
	 */
	public void clearPwdField() {
		waitForElement(driver, interfaces.RN_LoginPage.PASSWORD_TEXTBOX, Constant.TimeWait);
		clear(driver, interfaces.RN_LoginPage.PASSWORD_TEXTBOX);
	}

	/**
	 * Click Send mail Button
	 */
	public void clickSendMailButton() {
		waitForElement(driver, interfaces.RN_LoginPage.SENDMAIL_BTN, Constant.TimeWait);
		click(driver, interfaces.RN_LoginPage.SENDMAIL_BTN);
		sleep(2);
	}
	
	
	/**
	 * Click Reset Password Button
	 */
	public void clickResetPwdButton() {
		waitForElement(driver, interfaces.RN_LoginPage.RESET_PASSWORD_BUTTON, Constant.TimeWait);
		click(driver, interfaces.RN_LoginPage.RESET_PASSWORD_BUTTON);
		sleep(5);
	}
	
	/**
	 * Input password reset
	 */
	public void inputPasswordReset(String password) {
		waitForElement(driver, interfaces.RN_LoginPage.RESET_PASSWORD_TEXTBOX, Constant.TimeWait);
		type(driver, interfaces.RN_LoginPage.RESET_PASSWORD_TEXTBOX, password);
	}

	/**
	 * Input password reset confirm
	 */
	public void inputPasswordConfirmReset(String password) {
		waitForElement(driver, interfaces.RN_LoginPage.RESET_PASSWORD_CONFIRM_TEXTBOX, Constant.TimeWait);
		type(driver, interfaces.RN_LoginPage.RESET_PASSWORD_CONFIRM_TEXTBOX, password);
	}
	
	/**
	 * Click Cancel Button
	 */
	public void clickCancelButton() {
		waitForElement(driver, interfaces.RN_LoginPage.CANCEL_BTN, Constant.TimeWait);
		click(driver, interfaces.RN_LoginPage.CANCEL_BTN);
	}

	/**
	 * Input Email
	 */
	public void inputEmail(String email) {
		waitForElement(driver, interfaces.RN_LoginPage.EMAIL_TEXTBOX, Constant.TimeWait);
		type(driver, interfaces.RN_LoginPage.EMAIL_TEXTBOX, email);
	}

	/**
	 * Get Title Nav Bar text
	 * 
	 * @param value
	 * @return
	 */
	public String getTitleNavBarText() {
		waitForElement(driver, interfaces.RN_LoginPage.HEADER_NAVBAR, Constant.TimeWait);
		String realTitle = getAttributeValue(driver, interfaces.RN_LoginPage.HEADER_NAVBAR, "innerText");
		return realTitle;
	}

	/**
	 * Get Error message
	 * 
	 * @param message
	 * @return
	 */
	public boolean isErrorMessageDisplay(String message) {
		try{
		waitForElement(driver, interfaces.RN_LoginPage.DYNAMIC_ERROR_MESSAGE, message, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_LoginPage.DYNAMIC_ERROR_MESSAGE, message);
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * @return
	 */
	public boolean isForgotPwdPageDisplayed() {
		waitForElement(driver, interfaces.RN_LoginPage.FORGOT_PASSWORD_HEADER, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_LoginPage.FORGOT_PASSWORD_HEADER);
	}
	
	/**
	 * Is Reset Page Displayed
	 * @return
	 */
	public boolean isResetPageDisplayed() {
		waitForElement(driver, interfaces.RN_LoginPage.FORGOT_PASSWORD_HEADER, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_LoginPage.FORGOT_PASSWORD_HEADER);
	}

	WebDriver driver;
}
