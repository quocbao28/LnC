package Common;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import page.DashboardPage;
import page.LoginPage;
import page.MailBox;

public class C_Login extends AbstractTest {
	@BeforeClass(alwaysRun = true)
	@Parameters({ "browser" })
	public void setup(String browser) {
		usedBrowser = browser;
		driver = openBrowser(browser, Constant.HOMEPAGE_URL);
		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		mailBox = new MailBox(driver);
		titleNavBar = "カラダかわるNavi Management System";
		resetPwdTitle = "カラダかわるNavi Management System";
		forgotPwdURL = "https://lcphp4.asiantech.vn/password/reset";
		idErrorMessage = "ログインIDは、必ず指定してください。";
		invalidIdErrorMessage = "認証情報と一致するレコードがありません。";
		emptyEmailMessage = "メールは、必ず指定してください。";
		invalidEmailMessage = "このメールアドレスに一致するユーザーを見つけることが出来ませんでした。";
		invalidPwdMessage = "パスワードには、有効な正規表現を指定してください。";
		unRegisterEmailMessage = "このメールアドレスに一致するユーザーを見つけることが出来ませんでした。";
		emptyPwdRestMessage = "パスワードは、必ず指定してください。";
		emptyPwdRestConfirmMessage = "パスワード確認は、必ず指定してください。";
		passwordErrorMessage = "パスワードは、必ず指定してください。";
		repeatResetPwdMessage = "このパスワードリセットトークンは無効です。";
		minResetPwdMessage = "パスワードは、8文字以上にしてください。";
		maxResetPwdMessage = "パスワードは、15文字以下にしてください。";
		notSamePwdMessage = "パスワード確認とパスワードが一致しません。";
		invalidID = "invalid";
		invalidPassword = "invalid";
		shortID = "1234567";
		shortPassword = "1234567";
		longID = "1234567890123456";
		longPassword = "1234567890123456";
		invalidEmail = "abc@xyz";
		validEmail = "abc@xyz.com";
		validPasswordReset = "abcd123456789";
		validPasswordReset2 = "abcd1234567890";
		invalidPasswordReset = "abcd 12345678";
		minPasswordReset = "1234567";
		maxPasswordReset = "1234567890123456";
	}
	@Test(enabled = false, description = "TC 001: Check user doesn't input ID and password")
	public void C_Login_TC_001_No_ID_and_No_Password() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Click Login button without input ID, password");
		login.clickLoginButton();

		log.info("VP 01. 'ログインIDは、必ず指定してください。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(idErrorMessage));

		log.info("VP 02. 'パスワードは、必ず指定してください。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(passwordErrorMessage));
	}
	
	@Test(enabled = false, description = "TC 002: Check user inputs valid ID and doesn't input password")
	public void C_Login_TC_002_Vaid_ID_and_No_Password() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Input valid ID");
		login.inputID(Constant.ADMIN_USERNAME);
		login.clearPwdField();

		log.info("Step 03: Click Login button with valid ID and doesn't input password");
		login.clickLoginButton();

		log.info("VP 01. 'パスワードは、必ず指定してください。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(passwordErrorMessage));
	}
	

	@Test(enabled = false, description = "TC 003: Check user doesn't input ID and inputs valid password")
	public void C_Login_TC_003_No_ID_and_Valid_Password() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Input valid Pwd");
		login.inputPwd(Constant.ADMIN_PASSWORD);
		login.clearIdField();

		log.info("Step 03: Click Login button with doesn't input ID and valid password");
		login.clickLoginButton();

		log.info("VP 01. 'ログインIDは、必ず指定してください。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(idErrorMessage));
	}

	@Test(enabled = false, description = "TC 004: Check user inputs invalid ID and doesn't input password")
	public void C_Login_TC_004_Invaid_ID_and_No_Password() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Input invalid ID");
		login.inputID(invalidID);
		login.clearPwdField();

		log.info("Step 03: Click Login button with valid ID and doesn't input password");
		login.clickLoginButton();

		log.info("VP 01. 'パスワードは、必ず指定してください。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(passwordErrorMessage));
	}
	
	@Test(enabled = false, description = "TC 005: Check user doesn't input ID and inputs invalid password")
	public void C_Login_TC_005_No_ID_and_Invalid_Password() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Input valid Pwd");
		login.inputPwd(invalidPassword);
		login.clearIdField();

		log.info("Step 03: Click Login button with doesn't input ID and valid password");
		login.clickLoginButton();

		log.info("VP 01. 'ログインIDは、必ず指定してください。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(idErrorMessage));
	}
	
	@Test(enabled = false, description = "TC 006: Check user inputs valid ID and invalid password")
	public void C_Login_TC_006_Valid_ID_and_Invalid_Password() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Input valid ID");
		login.inputID(Constant.ADMIN_USERNAME);

		log.info("Step 03: Input invalid Pwd");
		login.inputPwd(invalidPassword);

		log.info("Step 04: Click Login button with valid ID and invalid password");
		login.clickLoginButton();

		log.info("VP 01. '認証情報と一致するレコードがありません。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(invalidIdErrorMessage));
	}

	@Test(enabled = false, description = "TC 007: Check user inputs invalid ID and valid password")
	public void TC_007_Invalid_ID_and_Valid_Password() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Input valid ID");
		login.inputID(invalidID);

		log.info("Step 03: Input invalid Pwd");
		login.inputPwd(Constant.ADMIN_PASSWORD);

		log.info("Step 04: Click Login button with invalid ID and valid password");
		login.clickLoginButton();

		log.info("VP 01. '認証情報と一致するレコードがありません。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(invalidIdErrorMessage));
	}

	@Test(enabled = false, description = "TC 008: Check user inputs invalid ID and invalid password")
	public void C_Login_TC_008_Invalid_ID_and_Invalid_Password() {
		log.info("Step 01: Come to login screen");
		navigateToURL( Constant.HOMEPAGE_URL);

		log.info("Step 02: Input valid ID");
		login.inputID(invalidID);

		log.info("Step 03: Input invalid Pwd");
		login.inputPwd(invalidPassword);

		log.info("Step 04: Click Login button with invalid ID and valid password");
		login.clickLoginButton();

		log.info("VP 01. '認証情報と一致するレコードがありません。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(invalidIdErrorMessage));
	}

	@Test(enabled = false, description = "TC 009: Check user input valid ID and valid password")
	public void C_Login_TC_009_Valid_ID_and_Valid_Password() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Input valid ID");
		login.inputID(Constant.ADMIN_USERNAME);

		log.info("Step 03: Input valid Pwd");
		login.inputPwd(Constant.ADMIN_PASSWORD);

		log.info("Step 04: Click Login button with valid ID and valid password");
		login.clickLoginButton();

		log.info("VP 01. Come to Dashboard screen");
		verifyTrue(dashboard.isHeaderDisplayed());

		log.info("Log Out");
		dashboard.logOut();
	}
	
	@Test(enabled = false, description = "TC 010: Check valid value of ID and password")
	public void C_Login_TC_010_Valid_Value_ID_and_Valid_Value_Password() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);
		
		log.info("Step 02: Input valid ID");
		login.inputID("12345678");
		
		log.info("Step 03: Input valid Pwd");
		login.inputPwd("12345678");
		
		log.info("Step 04: Click Login button with valid ID and valid password");
		login.clickLoginButton();
		
		log.info("VP 01. No Invalid ID/Password content message displayed ");
		verifyFalse(login.isErrorMessageDisplay("Invalid ID/Password content"));

		log.info("Step 05: Input valid ID");
		login.inputID("12345678");

		log.info("Step 06: Input valid Pwd");
		login.inputPwd("12345678");
		
		log.info("Step 07: Click Login button with valid ID and valid password");
		login.clickLoginButton();
		
		log.info("VP 02. No Invalid ID/Password content message displayed");
		verifyFalse(login.isErrorMessageDisplay("Invalid ID/Password content"));
		
	}
	
	//Fail because no message related to Invalid form of ID and Password
	@Test(enabled = false, description = "TC 011: Check invalid value of ID and password")
	public void C_Login_TC_011_Invalid_Value_ID_and_Valid_Invalue_Password() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);
		
		log.info("Step 02: Input long ID");
		login.inputID(longID);
		
		log.info("Step 03: Input long Pwd");
		login.inputPwd(longPassword);
		
		log.info("Step 04: Click Login button with long ID and long password");
		login.clickLoginButton();
		
		log.info("VP 01. Invalid ID/Password content message displayed ");
		verifyTrue(login.isErrorMessageDisplay("Invalid ID/Password content"));
		
		log.info("Step 05: Input short ID");
		login.inputID(shortID);
		
		log.info("Step 06: Input short Pwd");
		login.inputPwd(shortPassword);
		
		log.info("Step 07: Click Login button with short ID and short password");
		login.clickLoginButton();
		
		log.info("VP 02. Invalid ID/Password content message displayed");
		verifyTrue(login.isErrorMessageDisplay("Invalid ID/Password content"));
		
		log.info("Step 08: Input short ID");
		login.inputID(shortID);
		
		log.info("Step 09: Input valid Pwd");
		login.inputPwd("12345678");
		
		log.info("Step 10: Click Login button with short ID and valid password");
		login.clickLoginButton();
		
		log.info("VP 03. Invalid ID/Password content message displayed");
		verifyTrue(login.isErrorMessageDisplay("Invalid ID/Password content"));
		
		log.info("Step 11: Input valid ID");
		login.inputID("12345678");

		log.info("Step 12: Input short Pwd");
		login.inputPwd(shortPassword);
		
		log.info("Step 13: Click Login button with valid ID and short password");
		login.clickLoginButton();
		
		log.info("VP 02. Invalid ID/Password content message displayed");
		verifyTrue(login.isErrorMessageDisplay("Invalid ID/Password content"));
	}
	
	@Test(enabled = false, description = "TC 015: Check ログインID/パスワードを忘れた場合は？ button")
	public void C_Login_TC_015_Check_Forgot_Pwd_function() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Click Forgot Password button");
		login.clickForgotPwdButton();

		log.info("VP 01. Verify Forgot Password Page appears");
		verifyTrue(login.isForgotPwdPageDisplayed());
	}
	
	@Test(description = "TC 016: Check user inputs valid email")
	public void C_Login_TC_016_ForgotPwd_Valid_Email() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Input Valid Email");
		login.inputEmail(validEmail);

		log.info("Step 03: Click Reset button");
		login.clickSendMailButton();

		log.info("VP 01. Come to 送信完了 screen ");
		verifyTrue(login.isResetPageDisplayed());
	}
	
	@Test(description = "TC 017: Check user inputs invalid email")
	public void C_Login_TC_017_ForgotPwd_Invalid_Email() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL( forgotPwdURL);

		log.info("Step 02: Input Invalid Email");
		login.inputEmail(invalidEmail);

		log.info("Step 03: Click Reset button");
		login.clickSendMailButton();

		// expected message must be"メールは、有効なメールアドレス形式で指定してください。" instead of
		// "このメールアドレスに一致するユーザーを見つけることが出来ませんでした。
		// キャンセル
		log.info("VP 01. 'このメールアドレスに一致するユーザーを見つけることが出来ませんでした。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(invalidEmailMessage));
	}
	
	@Test(description = "TC 018: Check user doesn't input email")
	public void C_Login_TC_018_ForgotPwd_Without_Email() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Click Reset button");
		login.clickSendMailButton();

		log.info("VP 01. 'メールは、必ず指定してください。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(emptyEmailMessage));

	}
	
	@Test(description = "TC 019: Check user inputs invalid email")
	public void C_Login_TC_019_ForgotPwd_Invalid_Email() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL( forgotPwdURL);

		log.info("Step 02: Input Invalid Email");
		login.inputEmail(invalidEmail);

		log.info("Step 03: Click Reset button");
		login.clickSendMailButton();

		// expected message must be"メールは、有効なメールアドレス形式で指定してください。" instead of
		// "このメールアドレスに一致するユーザーを見つけることが出来ませんでした。
		// キャンセル
		log.info("VP 01. 'このメールアドレスに一致するユーザーを見つけることが出来ませんでした。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(invalidEmailMessage));
	}
	
	@Test(description = "TC 020: Check user inputs valid email")
	public void C_Login_TC_020_ForgotPwd_Valid_Email() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Input Valid Email");
		login.inputEmail(validEmail);

		log.info("Step 03: Click Reset button");
		login.clickSendMailButton();

		log.info("VP 01. Come to 送信完了 screen ");
		verifyTrue(login.isResetPageDisplayed());
	}
	
	@Test(description = "TC 022: Check match email")
	public void C_Login_TC_022_ForgotPwd_Unregister_Email() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Input Valid Email");
		login.inputEmail(validEmail);

		log.info("Step 03: Click Reset button");
		login.clickSendMailButton();

		log.info("VP 01. 'このメールアドレスに一致するユーザーを見つけることが出来ませんでした。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(unRegisterEmailMessage));
	}
	
	@Test(description = "TC 025: Check Cancel button")
	public void C_Login_TC_025_Check_Cancel_Button() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Click Cancel button");
		login.clickCancelButton();

		log.info("VP 01. Verify that come to LogIn page");
		verifyEquals(login.getTitleNavBarText(), titleNavBar);
	}
	
	@Test(description = "TC 034: Check user inputs more than 15 characters")
	public void C_Login_TC_034_Reset_Pwd_with_Pwd_More_Than_15_Char() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Input Registered Email");
		login.inputEmail(Constant.MAIL_ACCOUNT);

		log.info("Step 03: Click Reset button");
		login.clickSendMailButton();

		log.info("Step 04: Open Gmail Page");
		mailBox.openGmailPage();

		log.info("Step 05: SignIn emaiil");
		mailBox.logInEmail(Constant.MAIL_ACCOUNT, Constant.MAIL_PASSWORD);

		log.info("Step 06: Open Reset Password mail");
		mailBox.openLatestMail("カラダかわるNavi パスワード変更手続きのお願い");

		log.info("Step 07: Go to Reset Password page");
		mailBox.openResetPwdPage_deleteMail();

		log.info("Step 08: Input new password with valid value");
		login.inputPasswordReset(maxPasswordReset);
		login.inputPasswordConfirmReset(maxPasswordReset);

		log.info("Step 09: Reset Password");
		login.clickResetPwdButton();

		log.info("VP 01. 'パスワードは、15文字以下にしてください。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(maxResetPwdMessage));
	}
	
	@Test(description = "TC 035: Check password and password confirmation are not the same")
	public void C_Login_TC_035_Reset_Pwd_With_Pwd_Is_Not_Same() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Input Registered Email");
		login.inputEmail(Constant.MAIL_ACCOUNT);

		log.info("Step 03: Click Reset button");
		login.clickSendMailButton();

		log.info("Step 04: Open Gmail Page");
		mailBox.openGmailPage();

		log.info("Step 05: SignIn emaiil");
		mailBox.logInEmail(Constant.MAIL_ACCOUNT, Constant.MAIL_PASSWORD);

		log.info("Step 06: Open Reset Password mail");
		mailBox.openLatestMail("カラダかわるNavi パスワード変更手続きのお願い");

		log.info("Step 07: Go to Reset Password page");
		mailBox.openResetPwdPage_deleteMail();

		log.info("Step 08: Input new password with valid value");
		login.inputPasswordReset(validPasswordReset);
		login.inputPasswordConfirmReset(validPasswordReset2);

		log.info("Step 09: Reset Password");
		login.clickResetPwdButton();

		log.info("VP 01. 'パスワード確認とパスワードが一致しません。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(notSamePwdMessage));
	}
	
	

	@AfterClass (alwaysRun = true)
	public void tearsDown() {
		closeBrowser();
	}

	public LoginPage login;
	public DashboardPage dashboard;
	public MailBox mailBox;

	String titleNavBar, idErrorMessage, passwordErrorMessage, invalidIdErrorMessage, emptyEmailMessage,
			invalidEmailMessage, invalidPwdMessage, unRegisterEmailMessage, emptyPwdRestMessage,
			emptyPwdRestConfirmMessage, repeatResetPwdMessage, minResetPwdMessage, maxResetPwdMessage,
			notSamePwdMessage;

	String invalidID, invalidPassword, invalidEmail, validEmail, validPasswordReset,
			validPasswordReset2, invalidPasswordReset, minPasswordReset, maxPasswordReset;

	String usedBrowser, resetPwdTitle;
	
	String forgotPwdURL;
	
	String shortID, shortPassword, longID, longPassword;
}
