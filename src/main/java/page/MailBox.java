package page;

import java.util.Properties;

import org.eclipse.jetty.websocket.api.Session;
import org.openqa.selenium.WebDriver;

import common.Constant;


public class MailBox extends AbstractPage{
	public MailBox(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	public WebDriver openGmailPage() {
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		return driver;
	}
	
	/**
	 * Log In Email
	 * @param account
	 * @param password
	 */
	public void logInEmail(String account, String password){
		sleep(5);
		inputMailAccount(account);
		clickNextButton();
		inputMailPassword(password);
		clickNextButton();
		sleep(2);
	}
	
//	public void loginGmailviaAIP(String account, String password){
//		Properties props = System.getProperties();
//		props.setProperty("mail.store.protocol", "imaps");
//		Session sesion = Session.
////		Session session = Session.getDefaultInstance(props, null);
//		Object store = session.getStore("imaps");
//		store.connect("imap.gmail.com", account, password);
//	}
	/**
	 * Log Out Email
	 */
	public void logOutEmail(){
		waitForElement(driver, interfaces.MailBox.ACCOUNT_BUTTON, Constant.TimeWait);
		click(driver, interfaces.MailBox.ACCOUNT_BUTTON);
		waitForElement(driver, interfaces.MailBox.LOG_OUT_BUTTON, Constant.TimeWait);
		click(driver, interfaces.MailBox.LOG_OUT_BUTTON);
		sleep(2);
		handleUnexpectedAlert(driver);
	}

	
	/**
	 * Open Latest Mail
	 * @param value
	 */
	public void openLatestMail(String value){
		waitForElement(driver, interfaces.MailBox.LATEST_EMAIL_TITLE, value, Constant.TimeWait);
		click(driver, interfaces.MailBox.LATEST_EMAIL_TITLE, value);
	}
	
	/**
	 * Open Mail Box
	 */
	public void openMailbox(){
		waitForElement(driver, interfaces.MailBox.MAIN_MENU_BUTTON, Constant.TimeWait);
		click(driver, interfaces.MailBox.MAIN_MENU_BUTTON);
		waitForElement(driver, interfaces.MailBox.GMAIL_BUTTON, Constant.TimeWait);
		click(driver, interfaces.MailBox.GMAIL_BUTTON);
		sleep(2);
	}
	
	/**
	 * DeleteCurrentOnpeningMail
	 */
	public void deleteCurrentOpeningMail(){
		waitForElement(driver, interfaces.MailBox.MAIL_MENU_BUTTON, Constant.TimeWait);
		click(driver, interfaces.MailBox.MAIL_MENU_BUTTON);
		waitForElement(driver, interfaces.MailBox.DELETE_THIS_MESSAGE_BUTTON, Constant.TimeWait);
		sleep(2);
		click(driver, interfaces.MailBox.DELETE_THIS_MESSAGE_BUTTON);
	}
	
	/**
	 * Click Next Button
	 */
	public void clickNextButton(){
		waitForElement(driver, interfaces.MailBox.NEXT_BUTTON, Constant.TimeWait);
		click(driver, interfaces.MailBox.NEXT_BUTTON);
	}
	
	/**
	 * Click Back Button
	 */
	public void clickBackButton(){
		waitForElement(driver, interfaces.MailBox.BACK_BUTTON, Constant.TimeWait);
		click(driver, interfaces.MailBox.BACK_BUTTON);
	}
	
	/**
	 * Input Mail Account
	 * @param value
	 */
	public void inputMailAccount(String value){
		try{
		waitForElement(driver, interfaces.MailBox.MAIL_ACCOUNT_TEXTBOX, Constant.TimeWait);
		type(driver, interfaces.MailBox.MAIL_ACCOUNT_TEXTBOX, value);
		}catch(Exception e){
			inputMailAccount(value);
		}
	}
	
	/**
	 * Input Mail Password
	 * @param value
	 */
	public void inputMailPassword(String value){
		try{
		waitForElement(driver, interfaces.MailBox.MAIL_PASSWORD_TEXTBOX, Constant.TimeWait);
		type(driver, interfaces.MailBox.MAIL_PASSWORD_TEXTBOX, value);
		}catch(Exception e){
			inputMailPassword(value);
		}
	}
	
	/**
	 *Delete mail after verify mail appears
	 */
	public void deleteMailAfterVerifing() {
		waitForElement(driver, interfaces.MailBox.CHECKBOX_BUTTON, Constant.TimeWait);	
		click(driver, interfaces.MailBox.CHECKBOX_BUTTON);
		waitForElement(driver, interfaces.MailBox.DELETE_MESSAGE_BUTTON, Constant.TimeWait);	
		click(driver, interfaces.MailBox.DELETE_MESSAGE_BUTTON);
	}
	
	public void openResetPwdPage_keepMail() {
		waitForElement(driver, interfaces.MailBox.RESET_PWD_LINK, Constant.TimeWait);
		String link  = getAttributeValue(driver, interfaces.MailBox.RESET_PWD_LINK, "href");
		logOutEmail();
		sleep(2);
		driver.get(link);
		sleep(2);
	}
	
	public void openResetPwdPage_deleteMail() {
		waitForElement(driver, interfaces.MailBox.RESET_PWD_LINK, Constant.TimeWait);
		String link  = getAttributeValue(driver, interfaces.MailBox.RESET_PWD_LINK, "href");
		deleteCurrentOpeningMail();
		logOutEmail();
		sleep(2);
		driver.get(link);
		sleep(2);
	}
	
	
	public boolean isResetEmaildisplayed(String value) {
		waitForElement(driver, interfaces.MailBox.LATEST_EMAIL_TITLE, value, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.MailBox.LATEST_EMAIL_TITLE, value);
	}
protected WebDriver driver;
}
