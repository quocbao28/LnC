package Common;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import page.AbstractPage;
import page.LoginPage;
import page.RN_EmployeePage;


public class C_Employeelist extends AbstractTest{
	@BeforeClass (alwaysRun = true)
	@Parameters({ "browser" })
	public void setUp(String browser){
		browser_= browser;
		employeePageUrl="https://lcphp4.asiantech.vn/admin/employee";
		driver = openBrowser(browser, Constant.HOMEPAGE_URL);
		login = new LoginPage(driver);
		employeePage = new RN_EmployeePage (driver);
		
		adminUserName = Constant.ADMIN_USERNAME;
		adminPassword = Constant.ADMIN_PASSWORD;
		
		log.info("Pre-condition_Login: Login to RN Admin");
		navigateToURL(Constant.HOMEPAGE_URL);
		login.loginAs(adminUserName, adminPassword);
		
		log.info("Go to Employee List Page");
		((AbstractPage) employeePage).clickEmployeeLink();
		
		log.info("Verify go to Employee List Page Successfull ");
		verifyTrue(employeePage.isEmployeeHeaderDisplayed("社員管理"));
	}
	
	@Test (groups = "COMMON", description = "TC 008: Check incase choose date in date picker at [From date] textbox ")
	public void C_Employeelist_008_Check_Search_Employee(){
		
		log.info("Step 01:  Click on [社員の検索] button ");
		employeePage.clickEmployeeSearchButton();
		
		log.info("Step 02:  Input Start Date");
		employeePage.inputStartDate("2017-06-15");
		
		log.info("Step 03: Input End Date");
		employeePage.inputEndDate("2017-06-20");
		
		log.info("Step 04: Click Search button");
		employeePage.clickSearchButton();
		
		log.info("VP 01. Verify Search Result");
		verifyTrue(employeePage.isSearchResultDisplayed());		
	}
	
//	@Test (groups = "COMMON", description = "TC 021: Check the display value at [歳以上] and [歳未満] dropdown lists ")
//	public void C_Employeelist_021_Check_Age(){
//		
//		
//	}
	
	@Test (groups = "COMMON", description = "TC 030: Check the action [ランキング結果CSV] link ")
	public void C_Employeelist_030_Check_DownloadCSV_button(){
		
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
	
	@Test (groups = "COMMON", description = "TC 038: Check action of [閲覧] button ")
	public void C_Employeelist_038_Check_Reading_Function_button(){
		log.info("Step 01: Click Reading Employee Button");
		employeePage.clickReadingEmployeeButton();
		
		log.info("VP 01. Verify Employee Details Page appears");
		verifyTrue(employeePage.isDynamicPageHeaderDisplayed(driver, "社員管理"));
		
		log.info("Step 02: Back to Employee Page");
		navigateToURL(employeePageUrl);
	}
	
	@Test (groups = "COMMON", description = "TC 040: Check action [分析]/ Analytics button ")
	public void C_Employeelist_040_Check_Analytics_Function_button(){
		log.info("Step 01: Click Analytics Button");
		employeePage.clickAnalyticsButton();
		
		log.info("VP 01. Verify Analyticss Page appears");
		verifyTrue(employeePage.isDynamicPageHeaderDisplayed(driver, "個人分析"));
		
		log.info("Step 02: Back to Employee Page");
		navigateToURL(employeePageUrl);
	}
	
	@AfterClass (alwaysRun = true)
	public void tearsDown(){		
		closeBrowser();
	}
	
	public LoginPage login;
	public AbstractPage abstractPage;
	public RN_EmployeePage employeePage;
	public String adminUserName, adminPassword, browser_;
	public String employeePageUrl;
}
