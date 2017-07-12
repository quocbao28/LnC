package RenaAdmin;

import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;

import page.LoginPage;
import page.MailBox;
import page.DashboardPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;

public class RN_LoginTest extends AbstractTest {

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
		invalidEmail = "abc@xyz";
		validEmail = "abc@xyz.com";
		validPasswordReset = "abcd123456789";
		validPasswordReset2 = "abcd1234567890";
		invalidPasswordReset = "abcd 12345678";
		minPasswordReset = "1234567";
		maxPasswordReset = "1234567890123456";
	}

	@Test(description = "TC 002: Check the display title of [login screen] page ")
	public void TC_002_Title_Login_Screen() {
		log.info("Step 01: Come to login screen");

		log.info("VP. Verify that the title is 'カラダかわるNavi Management System'");
		verifyEquals(login.getTitleNavBarText(), titleNavBar);
	}

	@Test(description = "TC 003: Check user doesn't input ID and password")
	public void TC_003_No_ID_and_No_Password() {
		log.info("Step 01: Come to login screen");
		navigateToURL( Constant.HOMEPAGE_URL);

		log.info("Step 02: Click Login button without input ID, password");
		login.clickLoginButton();

		log.info("VP 01. 'ログインIDは、必ず指定してください。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(idErrorMessage));

		log.info("VP 02. 'パスワードは、必ず指定してください。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(passwordErrorMessage));
	}

	@Test(description = "TC 004: Check user inputs valid ID and doesn't input password")
	public void TC_004_Vaid_ID_and_No_Password() {
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

	@Test(description = "TC 005: Check user doesn't input ID and inputs valid password")
	public void TC_005_No_ID_and_Valid_Password() {
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

	@Test(description = "TC 006: Check user inputs invalid ID and doesn't input password")
	public void TC_006_Invaid_ID_and_No_Password() {
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

	@Test(description = "TC 007: Check user doesn't input ID and inputs invalid password")
	public void TC_007_No_ID_and_Invalid_Password() {
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

	@Test(description = "TC 008: Check user inputs valid ID and invalid password")
	public void TC_008_Valid_ID_and_Invalid_Password() {
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

	@Test(description = "TC 009: Check user inputs invalid ID and valid password")
	public void TC_009_Invalid_ID_and_Valid_Password() {
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

	@Test(description = "TC 010: Check user inputs invalid ID and invalid password")
	public void TC_010_Invalid_ID_and_Invalid_Password() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Input valid ID");
		login.inputID(invalidID);

		log.info("Step 03: Input invalid Pwd");
		login.inputPwd(invalidPassword);

		log.info("Step 04: Click Login button with invalid ID and valid password");
		login.clickLoginButton();

		log.info("VP 01. '認証情報と一致するレコードがありません。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(invalidIdErrorMessage));
	}

	@Test(description = "TC 011: Check user input valid ID and valid password")
	public void TC_011_Valid_ID_and_Valid_Password() {
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
	
	@Test(enabled = false, description = "TC 015: Check ログイン状態を保存する button")
	public void TC_015_Check_Remember_button_function() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Input valid ID");
		login.inputID(Constant.ADMIN_USERNAME);

		log.info("Step 03: Input valid Pwd");
		login.inputPwd(Constant.ADMIN_PASSWORD);

		log.info("Step 04: Click Remember button");
		login.clickRememberButton();

		log.info("Step 05: Click Login button with invalid ID and valid password");
		login.clickLoginButton();

		log.info("Step 06: Close browser");
		closeBrowserTmp();

		log.info("Step 07: Open browser again");
		driver = openBrowserWithOldCookies(usedBrowser, Constant.HOMEPAGE_URL);

		log.info("VP 01. Come to Dashboard screen");
		verifyTrue(dashboard.isHeaderDisplayed());

		log.info("Step 08: Close browser");
		closeBrowser();
	}

	@Test(description = "TC 017: Check ログインID/パスワードを忘れた場合は？ button")
	public void TC_017_Check_Forgot_Pwd_function() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Click Forgot Password button");
		login.clickForgotPwdButton();

		log.info("VP 01. Verify Forgot Password Page appears");
		verifyTrue(login.isForgotPwdPageDisplayed());
	}

	@Test(description = "TC 018: Check incase login by admin account")
	public void TC_018_LogIn_AdminAccount() {
		log.info("Step 01: Come to login screen");
		navigateToURL( Constant.HOMEPAGE_URL);

		log.info("Step 02: Input Admin ID");
		login.inputID(Constant.ADMIN_USERNAME);

		log.info("Step 03: Input Admin Pwd");
		login.inputPwd(Constant.ADMIN_PASSWORD);

		log.info("Step 04: Click login button");
		login.clickLoginButton();

		log.info("VP 01.Login with admin account");
		verifyTrue(dashboard.isNavBarAccDisplayed("運営"));

		log.info("Step 05: LogOut");
		dashboard.logOut();
	}

	@Test(description = "TC 019: Check incase login by company account ")
	public void TC_019_LogIn_CompnayAccount() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Input Admin ID");
		login.inputID(Constant.COMPANY_USERNAME);

		log.info("Step 03: Input Admin Pwd");
		login.inputPwd(Constant.COMPANY_PASSWORD);

		log.info("Step 04: Click login button");
		login.clickLoginButton();

		log.info("VP 01.Login with Company account");
		verifyTrue(dashboard.isNavBarAccDisplayed("company 211"));

		log.info("Step 05: LogOut");
		dashboard.logOut();
	}

	@Test(description = "TC 020: Check incase login branch account ")
	public void TC_020_LogIn_BranchAccount() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Input Admin ID");
		login.inputID(Constant.BRANCH_USERNAME);

		log.info("Step 03: Input Admin Pwd");
		login.inputPwd(Constant.BRANCH_PASSWORD);

		// pwd and id are incorrect
		log.info("Step 04: Click login button");
		login.clickLoginButton();

		log.info("VP 01.Login with Company account");
		verifyTrue(dashboard.isNavBarAccDisplayed("branchco211"));

		log.info("Step 05: LogOut");
		dashboard.logOut();
	}

	@Test(description = "TC 021: Check incase login by agent account ")
	public void TC_021_LogIn_AgentAccount() {
		log.info("Step 01: Come to login screen");
		navigateToURL(Constant.HOMEPAGE_URL);

		log.info("Step 02: Input Admin ID");
		login.inputID(Constant.AGENT_USERNAME);

		log.info("Step 03: Input Admin Pwd");
		login.inputPwd(Constant.AGENT_PASSWORD);

		log.info("Step 04: Click login button");
		login.clickLoginButton();

		log.info("VP 01.Login with Agent account");
		verifyTrue(dashboard.isNavBarAccDisplayed("agent 001"));

		log.info("Step 05: LogOut");
		dashboard.logOut();
	}

	@Test(description = "TC 026: Check user doesn't input email")
	public void TC_026_ForgotPwd_Without_Email() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Click Reset button");
		login.clickSendMailButton();

		log.info("VP 01. 'メールは、必ず指定してください。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(emptyEmailMessage));

	}

	@Test(description = "TC 027: Check user inputs invalid email")
	public void TC_027_ForgotPwd_Invalid_Email() {
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

	@Test(description = "TC 028: Check user inputs valid email")
	public void TC_028_ForgotPwd_Valid_Email() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Input Valid Email");
		login.inputEmail(validEmail);

		log.info("Step 03: Click Reset button");
		login.clickSendMailButton();

		log.info("VP 01. Come to 送信完了 screen ");
		verifyTrue(login.isResetPageDisplayed());
	}

	@Test(description = "TC 029: Check resest email with register email")
	public void TC_029_ForgotPwd_Reset_Register_Email() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL( forgotPwdURL);

		log.info("Step 02: Input Registered Email");
		login.inputEmail(Constant.MAIL_ACCOUNT);

		log.info("Step 03: Click Reset button");
		login.clickSendMailButton();

		log.info("Step 04: Open Gmail Page");
		mailBox.openGmailPage();

		log.info("Step 05: SignIn emaiil");
		mailBox.logInEmail(Constant.MAIL_ACCOUNT, Constant.MAIL_PASSWORD);

		log.info("VP 01. Verify 'カラダかわるNavi パスワード変更手続きのお願い' Email is displayed");
		verifyTrue(mailBox.isResetEmaildisplayed("カラダかわるNavi パスワード変更手続きのお願い"));
		mailBox.deleteMailAfterVerifing();
		mailBox.logOutEmail();
	}

	@Test(description = "TC 030: Check match email")
	public void TC_030_ForgotPwd_Unregister_Email() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Input Valid Email");
		login.inputEmail(validEmail);

		log.info("Step 03: Click Reset button");
		login.clickSendMailButton();

		log.info("VP 01. 'このメールアドレスに一致するユーザーを見つけることが出来ませんでした。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(unRegisterEmailMessage));
	}

	@Test(description = "TC 033: Check Cancel button")
	public void TC_033_Check_Cancel_Button() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Click Cancel button");
		login.clickCancelButton();

		log.info("VP 01. Verify that come to LogIn page");
		verifyEquals(login.getTitleNavBarText(), titleNavBar);
	}

	@Test(description = "TC 034: Check valid value of password and password confirmation")
	public void TC_034_RestPwd_with_validPwd() {
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

		log.info("Step 08: Change password with valid value");
		login.inputPasswordReset(validPasswordReset);
		login.inputPasswordConfirmReset(validPasswordReset);

		log.info("Step 09: Reset Password");
		login.clickResetPwdButton();

		log.info("VP 01. Verify Password is changed");
		verifyTrue(dashboard.isHeaderDisplayed());
		dashboard.logOut();
	}

	@Test(description = "TC 035: Check invalid value of password and password confirmation")
	public void TC_035_RestPwd_with_InvalidPwd() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Input Registered Email");
		login.inputEmail(Constant.MAIL_ACCOUNT);

		log.info("Step 03: Click Reset button");
		login.clickSendMailButton();

		log.info("Step 04: Open Gmail Page");
		mailBox.openGmailPage();

		log.info("Step 05: SignIn email");
		mailBox.logInEmail(Constant.MAIL_ACCOUNT, Constant.MAIL_PASSWORD);
		
		log.info("Step 06: Open Reset Password mail");
		mailBox.openLatestMail("カラダかわるNavi パスワード変更手続きのお願い");

		log.info("Step 07: Go to Reset Password page");
		mailBox.openResetPwdPage_deleteMail();

		log.info("Step 08: Change password with invalid value");
		login.inputPasswordReset(invalidPasswordReset);
		login.inputPasswordConfirmReset(invalidPasswordReset);

		log.info("Step 09: Reset Password");
		login.clickResetPwdButton();

		log.info("VP 01. Verify Error message is displayed");
		verifyTrue(login.isErrorMessageDisplay(invalidPwdMessage));

	}

	@Test(description = "TC 036: Check user doesn't input password and and password confirmation")
	public void TC_036_Reset_Pwd_without_Input() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Input Registered Email");
		login.inputEmail(Constant.MAIL_ACCOUNT);

		log.info("Step 03: Click Reset button");
		login.clickSendMailButton();

		log.info("Step 04: Open Gmail Page");
		mailBox.openGmailPage();

		log.info("Step 05: SignIn email");
		mailBox.logInEmail(Constant.MAIL_ACCOUNT, Constant.MAIL_PASSWORD);

		log.info("Step 06: Open Reset Password mail");
		mailBox.openLatestMail("カラダかわるNavi パスワード変更手続きのお願い");

		log.info("Step 07: Go to Reset Password page");
		mailBox.openResetPwdPage_deleteMail();
		
		log.info("Step 08: Reset Password");
		login.clickResetPwdButton();

		log.info("VP 01. 'このメールアドレスに一致するユーザーを見つけることが出来ませんでした。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(emptyPwdRestMessage));
	}

	@Test(description = "TC 038: Check user inputs valid password and password confirmation")
	public void TC_038_Reset_Pwd_with_ValidPwd() {
		log.info("Step 01: Check user inputs valid password and password confirmation");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Input Registered Email");
		login.inputEmail(Constant.MAIL_ACCOUNT);

		log.info("Step 03: Click Reset button");
		login.clickSendMailButton();

		log.info("Step 04: Open Gmail Page");
		mailBox.openGmailPage();

		log.info("Step 05: SignIn email");
		mailBox.logInEmail(Constant.MAIL_ACCOUNT, Constant.MAIL_PASSWORD);
		
		log.info("Step 06: Open Reset Password mail");
		mailBox.openLatestMail("カラダかわるNavi パスワード変更手続きのお願い");

		log.info("Step 07: Go to Reset Password page");
		mailBox.openResetPwdPage_deleteMail();

		log.info("Step 08: Change password with invalid value");
		login.inputPasswordReset(validPasswordReset);
		login.inputPasswordConfirmReset(validPasswordReset);

		log.info("Step 09: Reset Password");
		login.clickResetPwdButton();

		log.info("VP 01. Password is changed");
		verifyTrue(dashboard.isHeaderDisplayed());
		dashboard.logOut();
	}

	@Test(description = "TC 039: Check user inputs valid password and password confirmation 2 times")
	public void TC_039_Reset_Pwd_with_ValidValue_2times() {
		log.info("Step 01: Come to Reset screen");
		navigateToURL(forgotPwdURL);

		log.info("Step 02: Input Registered Email");
		login.inputEmail(Constant.MAIL_ACCOUNT);

		log.info("Step 03: Click Reset button");
		login.clickSendMailButton();

		log.info("Step 04: Open Gmail Page");
		mailBox.openGmailPage();

		log.info("Step 05: SignIn email");
		mailBox.logInEmail(Constant.MAIL_ACCOUNT, Constant.MAIL_PASSWORD);

		log.info("Step 06: Open Reset Password mail");
		mailBox.openLatestMail("カラダかわるNavi パスワード変更手続きのお願い");

		log.info("Step 07: Go to Reset Password page");
		mailBox.openResetPwdPage_keepMail();

		log.info("Step 08: Input new password with valid value");
		login.inputPasswordReset(validPasswordReset);
		login.inputPasswordConfirmReset(validPasswordReset);

		log.info("Step 09: Reset Password");
		login.clickResetPwdButton();

		log.info("Step 10: LogOut");
		dashboard.logOut();

		log.info("Step 011: Open Gmail Page -2");
		mailBox.openGmailPage();

		log.info("Step 12: SignIn emaiil - 2");
		mailBox.logInEmail(Constant.MAIL_ACCOUNT, Constant.MAIL_PASSWORD);

		log.info("Step 13: Open Reset Password mail -2");
		mailBox.openLatestMail("カラダかわるNavi パスワード変更手続きのお願い");

		log.info("Step 14: Go to Reset Password page -2");
		mailBox.openResetPwdPage_deleteMail();

		log.info("Step 15: Input new password with valid value -2");
		login.inputPasswordReset(validPasswordReset);
		login.inputPasswordConfirmReset(validPasswordReset);

		log.info("Step 16: Reset Password -2");
		login.clickResetPwdButton();

		log.info("VP 01. 'このパスワードリセットトークンは無効です。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(repeatResetPwdMessage));
	}

	@Test(description = "TC 040: Check user inputs less than 8 characters")
	public void TC_040_Reset_Pwd_with_Pwdlessthan8cha() {
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
		login.inputPasswordReset(minPasswordReset);
		login.inputPasswordConfirmReset(minPasswordReset);

		log.info("Step 09: Reset Password");
		login.clickResetPwdButton();

		log.info("VP 01. 'パスワードは、8文字以上にしてください。。' message is displayed");
		verifyTrue(login.isErrorMessageDisplay(minResetPwdMessage));
	}

	@Test(description = "TC 042: Check user inputs more than 15 characters")
	public void TC_042_Reset_Pwd_with_Pwdmorethan15cha() {
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

	@Test(description = "TC 043: Check password and password confirmation are not the same")
	public void TC_043_Reset_Pwd_with_PwdisNotSame() {
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
}
