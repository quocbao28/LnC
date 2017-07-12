package RenaAdmin;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.CommonAction;
import common.Constant;
import page.AbstractPage;
import page.RN_EmployeePage;
import page.LoginPage;

public class RN_Employeelist extends AbstractTest {

	@BeforeClass(alwaysRun = true)
	@Parameters({ "browser" })
	public void setup(String browser) {
		browser_= browser;
		employeePageUrl="https://lcphp4.asiantech.vn/admin/employee";
		driver = openBrowser(browser, Constant.HOMEPAGE_URL);
		loginPage = new LoginPage(driver);
		employeePage = new RN_EmployeePage(driver);
		
		adminUserName = Constant.ADMIN_USERNAME;
		adminPassword = Constant.ADMIN_PASSWORD;
		
		log.info("Pre-condition_Login: Login to RN Admin");
		navigateToURL(Constant.HOMEPAGE_URL);
		loginPage.loginAs(adminUserName, adminPassword);
		
		log.info("Pre-condition: Go to Employee Page");
		((AbstractPage) employeePage).clickEmployeeLink();
		
		log.info("Verify go to Employee List Page Successfull ");
		verifyTrue(employeePage.isEmployeeHeaderDisplayed("社員管理"));
		
	}
	
	@Test (groups = "HIGH", description = "TC 006: Check action of [search] button  ")
	public void RN_Employeelist_006_Check_action_search_button(){
		log.info("Step 01: Click Search button");
		employeePage.clickEmployeeSearchButton();
		
		log.info("VP 01. Verify List Search is displayed");
		verifyTrue(employeePage.isEmployeeIdFieldrDisplayed());
		verifyTrue(employeePage.isCompanyDropDownrDisplayed());
		verifyTrue(employeePage.isOfficeDropDownDisplayed());
		verifyTrue(employeePage.isNameFieldDisplayed());
		verifyTrue(employeePage.isNameFieldDisplayed());
		verifyTrue(employeePage.isStartDateDisplayed());
		verifyTrue(employeePage.isEndDateDisplayed());
	}
	
	@Test (groups = "HIGH", description = "TC 006: Check action of Send Code button  ")
	public void RN_Employeelist_009_Check_action_SendCode_button(){
		log.info("Step 01: Click Send Code button");
		employeePage.clickSendCodeButton();
		
		log.info("VP 01. Verify Send Code Pop Up is displayed");
		verifyTrue(employeePage.isSendCodePopUpDisplayed());
		
		log.info("Step 02: Close Send Code Pop up");
		employeePage.clickClosePopUpSendCodeButton();
	}

	@Test (groups = "HIGH", description = "TC 026: Check the action [ランキング結果CSV] link ")
	public void RN_Employeelist_026_Check_DownloadCSV_button(){
		
		log.info("Step 01: Click Download button");
		employeePage.clickDownloadButton();
		
		log.info("Step 02: Click Confirm Download button");
		employeePage.clickConfirmDownloadButton(browser_);
	
		log.info("Step 03: Open Download folder");
		openFolder(browser_,"Downloads");
		
		log.info("VP 01. Verify file is downloaded");
		verifyTrue(employeePage.isCSVFileDownloaded());
		
		log.info("Step 04: Back to Employee Page");
		navigateToURL(employeePageUrl);
	}
	
//	@Test (groups = "HIGH", description = "TC 027: Check action of [ランキング結果CSV] follow information that user filter ")
//	public void RN_Employeelist_027_Check_(){
//		
//		log.info("Step 01: Click Search Employee Button");
//		employeePage.clickEmployeeSearchButton();
//		
//		log.info("Step 02: Input Search Condition");
//		
//		log.info("Step 03:Download CSV file");
//		employeePage.clickDownloadButton();
//		employeePage.clickConfirmDownloadButton(browser_);
//	}
	
//	@Test (groups = "HIGH", description = "TC 032: Check display csv file ")
//	public void RN_Employeelist_032_Check_Display_CSVFile(){
//		
//		log.info("Step 01:Download CSV file");
//		employeePage.clickDownloadButton();
//		employeePage.clickConfirmDownloadButton(browser_);
//		
//		log.info("Step 02: Open CSV file");
//		
//		log.info("VP01: Open CSV file to check display");
//		
//	}
	
	@Test (groups = "HIGH", description = "TC 055: Check the display information ")
	public void RN_Employeelist_055_Check_Display_Information(){
		
	
	}
	
	
	@Test (groups = "HIGH", description = "TC 059: Check action [閲覧]/ View button  ")
	public void RN_Employeelist_059_Check_View_Button(){
		
		log.info("Step 01: Click Reading Employee Button");
		employeePage.clickReadingEmployeeButton();
		
		log.info("VP 01. Verify Employee Details Page appears");
		verifyTrue(employeePage.isDynamicPageHeaderDisplayed(driver, "社員管理"));
		
		log.info("Step 02: Back to Employee Page");
		navigateToURL(employeePageUrl);
		
	}
	
	@Test (groups = "HIGH", description = "TC 060: Incase: User already registered Check action [分析]/ Analytics button  ")
	public void RN_Employeelist_060_Check_Analytics_Function_button(){
		log.info("Step 01: Click Analytics Button");
		employeePage.clickAnalyticsButton();
		
		log.info("VP 01. Verify Analyticss Page appears");
		verifyTrue(employeePage.isDynamicPageHeaderDisplayed(driver, "個人分析"));
		
		log.info("Step 02: Back to Employee Page");
		navigateToURL(employeePageUrl);
	}
	
	@Test (groups = "HIGH", description = "TC 076: Check action of [submit] button when user choose CSV file correctly")
	public void RN_Employeelist_076_Check_Action_of_Submit_Button() throws IOException, AWTException{
		log.info("Step 01: Retirement bulk addition");
		employeePage.clickRetirementBulkAdditionButton();
		
		log.info("Step 02: Click Browse File button");
		employeePage.clickBrowseFileButton();
		
		log.info("Step 03: Upload file");
		CommonAction.getCommon().uploadFile(driver, "/LnCAdmin/src/test/resources/import_employee.csv");
		employeePage.clickRecordButton();
		
		
	}
	
	@AfterClass (alwaysRun = true)
	public void tearsDown() {
		closeBrowser();
	}

	public LoginPage loginPage;
	public RN_EmployeePage employeePage;
	
	String adminUserName, adminPassword, browser_;
	String employeePageUrl;
}
