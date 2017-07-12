package RenaAdmin;

import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;

import page.LoginPage;
import page.RN_CompanyGroupListPage;
import page.DashboardPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;

public class RN_Company extends AbstractTest {

	@BeforeClass(alwaysRun = true)
	@Parameters({ "browser" })
	public void setup(String browser) {
		driver = openBrowser(browser, Constant.HOMEPAGE_URL);
		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		company = new RN_CompanyGroupListPage(driver);
		
	}

	@Test(description = "TC 001: Check Action of 一括追加 Button")
	public void RN_Company_TC001_Check_Action_一括追加_Button(){
		log.info("Step 01: Click Company on side menu");
		dashboard.clickDynamicMenuBarButton("社員管理");
		
		log.info("Step 02: Click Import CSV button");
		company.clickImportCSVButton();
		
		log.info("VP 01. Verify that Import CSV Pop-up Displayed");
		verifyTrue(company.isImportCSVPopUpDisplayed());
	}
	
	

	@AfterClass (alwaysRun = true)
	public void tearsDown() {
		closeBrowser();
	}

	public LoginPage login;
	public DashboardPage dashboard;
	public RN_CompanyGroupListPage company;

}
