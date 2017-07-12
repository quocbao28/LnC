package interfaces;

public class MailBox {
	public static final String MAIL_ACCOUNT_TEXTBOX = "//input[@id = 'identifierId']";
	public static final String MAIL_PASSWORD_TEXTBOX = "//input[@type = 'password']";
	public static final String NEXT_BUTTON = "//span[contains(.,'Next')]";
	public static final String BACK_BUTTON ="//div[@title = 'Back to Inbox']/div/div";
//	public static final String ACCOUNT_BUTTON = "//a[@role = 'button' and @href = contains(.,'SignOutOptions')]";
	public static final String ACCOUNT_BUTTON = "//a[@href = 'https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']";
	public static final String LOG_OUT_BUTTON = "//a[contains(.,'Sign out')]";
	public static final String LATEST_EMAIL_TITLE = "//span[contains(.,'%s')]";
	public static final String MAIN_MENU_BUTTON = "//a[@title='Google Apps' or @title='Google apps']";
	public static final String GMAIL_BUTTON = "//div[@aria-label = 'Google apps']//span[contains(.,'Gmail')]";
	public static final String MAIL_MENU_BUTTON = "//div[@data-tooltip ='More']/img";
	public static final String DELETE_THIS_MESSAGE_BUTTON = "//div[contains(text(),'Delete this message')]";
	public static final String CHECKBOX_BUTTON="//span[contains(.,'カラダかわるNavi パスワード変更手続きのお願い')]/../../../../../td/div[@role = 'checkbox']";
	public static final String DELETE_MESSAGE_BUTTON ="//div[@title = 'Delete']/div/div";
	public static final String RESET_PWD_LINK="//a[contains(text(),'https://lcphp4.asiantech.vn/')]";
	
}
