package Common;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.CommonAction;
import common.Constant;
import page.DashboardPage;
import page.LoginPage;
import page.SettingPage;

public class C_Setting extends AbstractTest{
	@BeforeClass (alwaysRun = true)
	@Parameters({ "browser" })
	public void setUp(String browser){
		driver = openBrowser(browser, Constant.HOMEPAGE_URL);
		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		setting = new SettingPage(driver);
		
		adminUserName = Constant.ADMIN_USERNAME;
		adminPassword = Constant.ADMIN_PASSWORD;
		randomEmail = "automation" + CommonAction.getCommon().getRandomNumber() + "@gmail.com";
		lastEmailUsed = "oreilly.rae@gmail.com";
		invalidEmail = "#@%^%#$@#$@#.com";
		duplicateEmail = "vintt@asiantech.vn";
		errorEmailFormatMessage = "メールアドレスは、有効なメールアドレス形式で指定してください。";
		errorIDFormatMessage = "IDには、有効な正規表現を指定してください。";
		errorNullEmailMessage = "メールアドレスは、必ず指定してください。";
		errorDuplicateEmailMessage = "指定のメールアドレスは既に使用されています。";
		errorDuplicateIDMessage = "指定のIDは既に使用されています。";
		randomID = "IDtest" + CommonAction.getCommon().getRandomNumber();
		invalidID = "#@%^%#$@#$@#";
		lastIDUsed = "administrator1";
		duplicateID = "company211";
		s50CharacterText = "12345678901234567890123456789012345678901234567890";
		s51CharacterText = "123456789012345678901234567890123456789012345678901";
		doesNotReachMiniumCharacterErrorMessage = "メンテナンス期間は、必ず指定してください。";
		OutOfBoundaryErrorMessage = "メンテナンス期間は、50文字以下にしてください。";
		messageOnModalDialog = "この情報を登録してもよいですか？\nよろしければ「登　録」ボタンをクリックしてください。\n登録しない場合は「キャンセル」ボタンをクリックしてください。";
		
		log.info("Pre-condition_Login: Login to RN Admin");
		navigateToURL(Constant.HOMEPAGE_URL);
		login.loginAs(adminUserName, adminPassword);
		
	}
	
	@Test (groups = "COMMON", description = "TC 011: Check user inputs different value == TC 014")
	public void C_Setting_TC_011_CheckメールアドレスEmail_CheckInputDifferentValue(){
		log.info("Step 01: Come to Admin Setting Page");
		dashboard.clickDynamicMenuBarButton("アカウント設定");
		
		log.info("Step 02: Enter Different Value into Email Textbox");
		setting.inputEmailAddress(randomEmail);
		
		log.info("Step 03: Click Submit Button");
		setting.clickSubmitButton();
		setting.acceptSubmitModalDialog();
		
		log.info("VP 01. Verified that Email has been saved with changed value");
		verifyEquals(setting.getCurrentEmail(), randomEmail);
	}
	
	@Test (groups = "COMMON", description = "TC 012: Check user inputs duplicate Email")
	public void C_Setting_TC_012_CheckメールアドレスEmail_CheckInputDuplicateValue(){
		log.info("Step 01: Come to Admin Setting Page");
		dashboard.clickDynamicMenuBarButton("アカウント設定");
		
		log.info("Step 02: Enter Duplicate Value into Email Textbox");
		setting.inputEmailAddress(duplicateEmail);
		
		log.info("Step 03: Click Submit Button");
		setting.clickSubmitButton();
		setting.acceptSubmitModalDialog();
		
		log.info("VP 01. Verified that error message '指定のメールアドレスは既に使用されています。' is appeared");
		verifyTrue(setting.isDynamicErrorMessageDisplayed(errorDuplicateEmailMessage));
	}
	
	@Test (groups = "COMMON", description = "TC 013: Check invalid value")
	public void C_Setting_TC_013_CheckメールアドレスEmail_CheckInputInvalidValue(){
		log.info("Step 01: Come to Admin Setting Page");
		dashboard.clickDynamicMenuBarButton("アカウント設定");
		
		log.info("Step 02: Enter invalid into Email Textbox");
		setting.inputEmailAddress(invalidEmail);
		
		log.info("Step 03: Click Submit Button");
		setting.clickSubmitButton();
		
		log.info("VP 01. Verified that error message 'メールアドレスは、有効なメールアドレス形式で指定してください。' is appeared");
		verifyTrue(setting.isDynamicErrorMessageDisplayed(errorEmailFormatMessage));
	}
	
	@Test (groups = "COMMON", description = "TC 015: Check the require ")
	public void C_Setting_TC_015_CheckメールアドレスEmail_CheckRequire(){
		log.info("Step 01: Come to Admin Setting Page");
		dashboard.clickDynamicMenuBarButton("アカウント設定");
		
		log.info("Step 02: Enter Null Value into Email Textbox");
		setting.inputEmailAddress("");
		
		log.info("Step 03: Click Submit Button");
		setting.clickSubmitButton();
		setting.acceptSubmitModalDialog();
		
		log.info("VP 01. Verified that error message 'メールアドレスは、必ず指定してください。' is appeared");
		verifyTrue(setting.isDynamicErrorMessageDisplayed(errorNullEmailMessage));
	}
	
	@Test (groups = "COMMON", description = "TC 020: Check user inputs different value == TC 023")
	public void C_Setting_TC_020_CheckIDTextbox_CheckInputDifferentValue(){
		log.info("Step 01: Come to Admin Setting Page");
		dashboard.clickDynamicMenuBarButton("アカウント設定");
		
		log.info("Step 02: Enter Different Value into ID Textbox. ID value: " + randomID);
		setting.inputID(randomID);
		
		log.info("Step 03: Click Submit Button");
		setting.clickSubmitButton();
		setting.acceptSubmitModalDialog();
		
		log.info("VP 01. Verified that ID has been saved with changed value");
		verifyEquals(setting.getCurrentID(), randomID);
	}
	
	@Test (groups = "COMMON", description = "TC 021: Check invalid value")
	public void C_Setting_TC_021_CheckIDTextbox_CheckInputInvalidValue(){
		log.info("Step 01: Come to Admin Setting Page");
		dashboard.clickDynamicMenuBarButton("アカウント設定");
		
		log.info("Step 02: Enter Invalid into ID Textbox");
		setting.inputID(invalidID);
		
		log.info("Step 03: Click Submit Button");
		setting.clickSubmitButton();
		
		log.info("VP 01. Verified that error message 'IDには、有効な正規表現を指定してください。' is appeared");
		verifyTrue(setting.isDynamicErrorMessageDisplayed(errorIDFormatMessage));
	}
	
	@Test (groups = "COMMON", description = "TC 022: Check user inputs duplicate ID")
	public void C_Setting_TC_022_CheckID_CheckInputDuplicateValue(){
		log.info("Step 01: Come to Admin Setting Page");
		dashboard.clickDynamicMenuBarButton("アカウント設定");
		
		log.info("Step 02: Enter Duplicate Value into ID Textbox");
		setting.inputID(duplicateID);
		
		log.info("Step 03: Click Submit Button");
		setting.clickSubmitButton();
		setting.acceptSubmitModalDialog();
		
		log.info("VP 01. Verified that error message '指定のIDは既に使用されています。' is appeared");
		verifyTrue(setting.isDynamicErrorMessageDisplayed(errorDuplicateIDMessage));
	}
	
	@Test (groups = "COMMON", description = "TC 029: Check user chooses off")
	public void C_Setting_TC_029_Checkメンテナンス設定_CheckChooseOFFMaintenance(){
		log.info("Step 01: Come to Admin Setting Page");
		dashboard.clickDynamicMenuBarButton("アカウント設定");
		
		log.info("Step 02: Click Maintenace Off Radio Button");
		setting.clickMaintenanceOffRadioButton();
		
		log.info("Step 03: Click Submit Button");
		setting.clickSubmitButton();
		setting.acceptSubmitModalDialog();
		
		log.info("VP 01. Verify that Maintenace is OFF");
		verifyTrue(setting.isMaintenanceOffSelected());
	}
	
	@Test (groups = "COMMON", description = "TC 030: Check user chooses on")
	public void C_Setting_TC_030_Checkメンテナンス設定_CheckChooseOnMaintenance(){
		log.info("Step 01: Come to Admin Setting Page");
		dashboard.clickDynamicMenuBarButton("アカウント設定");
		
		log.info("Step 02: Click Maintenace On Radio Button");
		setting.clickMaintenanceOnRadioButton();
		
		log.info("Step 03: Click Submit Button");
		setting.clickSubmitButton();
		setting.acceptSubmitModalDialog();
		
		log.info("VP 01. Verify that Maintenace is On and Maintenace Message textbox displayed");
		verifyTrue(setting.isMaintenanceOnSelected());
		verifyTrue(setting.isMaintenanceMessageTextboxDisplayed());
	}
	
	@Test (groups = "COMMON", description = "TC 031 - 35: Check validation of maintain message")
	public void C_Setting_TC_031_to_TC_35_Checkメンテナンス設定_CheckValidationMaintainMessage(){
		log.info("Step 01: Come to Admin Setting Page");
		dashboard.clickDynamicMenuBarButton("アカウント設定");
		
		log.info("Step 02: Click Maintenace On Radio Button");
		setting.clickMaintenanceOnRadioButton();
		
		log.info("Step 03: Click Submit Button");
		setting.clickSubmitButton();
		setting.acceptSubmitModalDialog();
		
		log.info("VP 01. Verify that Error The Minium of Character isn't reached");
		verifyTrue(setting.isDynamicErrorMessageDisplayed(doesNotReachMiniumCharacterErrorMessage));
		
		log.info("Step 04: Input String with 51 characters into Maintenance Message text box");
		setting.inputMaintenanceMessage(s51CharacterText);
		
		log.info("VP 02. Verify that Error The Maximum of Character is reached");
		verifyTrue(setting.isDynamicErrorMessageDisplayed(OutOfBoundaryErrorMessage));

		log.info("Step 05: Input String with 1 characters into Maintenance Message text box");
		setting.inputMaintenanceMessage("1");
		
		log.info("Step 06: Click Submit Button");
		setting.clickSubmitButton();
		setting.acceptSubmitModalDialog();
		
		log.info("VP 03. Verify that Saved Successfully");
		verifyTrue(setting.isSavedSuccessfullyMessageDisplayed());
		
		log.info("Step 07: Input String with 50 characters into Maintenance Message text box");
		setting.inputMaintenanceMessage(s50CharacterText);
		
		log.info("Step 08: Click Submit Button");
		setting.clickSubmitButton();
		setting.acceptSubmitModalDialog();
		
		log.info("VP 04. Verify that Saved Successfully");
		verifyTrue(setting.isSavedSuccessfullyMessageDisplayed());

	}
	
	@Test (groups = "COMMON", description = "TC 037 - 38: Check Change button and register pop-up")
	public void C_Setting_TC_037_to_TC_38_Checkメンテナンス設定_ChangeButtonandRegisterPopUp(){
		log.info("Step 01: Come to Admin Setting Page");
		dashboard.clickDynamicMenuBarButton("アカウント設定");
		
		log.info("Step 02: Click Submit Button");
		setting.clickSubmitButton();
		
		log.info("VP 01. Verify that Message Content displayed on the modal dialog is the same as expected");
		verifyEquals(setting.getMessageOnModalDialog(), messageOnModalDialog);
		setting.acceptSubmitModalDialog();
	}

	
	@AfterClass (alwaysRun = true)
	public void tearsDown(){
		log.info("Reset-Condition 00: Come to Admin Setting Page");
		dashboard.clickDynamicMenuBarButton("アカウント設定");
		
		log.info("Reset-Condition 01: Enter last used values");
		setting.inputEmailAddress(lastEmailUsed);
		setting.inputID(lastIDUsed);
		setting.clickMaintenanceOffRadioButton();
		
		log.info("Reset-Condition 02: Click Submit button");
		setting.clickSubmitButton();
		setting.acceptSubmitModalDialog();
		
		log.info("Reset-Condition 03: is Values has been returned correctly");
		verifyEquals(setting.getCurrentEmail(), lastEmailUsed);
		verifyEquals(setting.getCurrentID(), lastIDUsed);
		verifyTrue(setting.isMaintenanceOffSelected());
		
		closeBrowser();
	}
	public LoginPage login;
	public DashboardPage dashboard;
	public SettingPage setting;
	
	public String adminUserName, adminPassword;
	public String randomEmail, lastEmailUsed, invalidEmail, duplicateEmail, randomID, lastIDUsed, invalidID, duplicateID;
	public String errorEmailFormatMessage, errorNullEmailMessage, errorDuplicateEmailMessage, errorIDFormatMessage, errorDuplicateIDMessage;
	public String s50CharacterText, s51CharacterText, doesNotReachMiniumCharacterErrorMessage, OutOfBoundaryErrorMessage, messageOnModalDialog;
}
