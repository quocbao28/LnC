package interfaces;

public class RN_LoginPage {
	public static final String USERNAME_TEXTBOX = "//input[@id='username']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='password']";
	public static final String LOGIN_BTN = "//input[@type='submit']";
	public static final String HEADER_NAVBAR = "//a[@class='navbar-brand']";
	public static final String DYNAMIC_ERROR_MESSAGE = "//strong[contains(.,'%s')]";
	public static final String REMEMBER_BTN = "//input[@name='remember']";
	public static final String FORGOT_PASSWORD_BUTTON = "//a[@href='https://lcphp4.asiantech.vn/password/reset']";
	public static final String FORGOT_PASSWORD_HEADER = "//h2[contains(text(),'パスワード再設定')]";
	public static final String SENDMAIL_BTN = "//input[@value='メール送信']";
	public static final String CANCEL_BTN = "//a[contains(text(),'キャンセル')]";
	public static final String EMAIL_TEXTBOX = "//input[@name='email']";
	public static final String RESET_PASSWORD_TEXTBOX="//input[@name='password']";	
	public static final String RESET_PASSWORD_CONFIRM_TEXTBOX="//input[@name='password_confirmation']";
	public static final String RESET_PASSWORD_BUTTON="//input[@value='確定']";
}
