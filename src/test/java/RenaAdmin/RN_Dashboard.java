package RenaAdmin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import page.RN_BranchPage;
import page.RN_CompanyGroupListPage;
import page.RN_CounselingPage;
import page.DashboardPage;
import page.RN_EmployeePage;
import page.LoginPage;
import page.RN_RankingPage;
import page.RN_SettingPage;

public class RN_Dashboard extends AbstractTest {

	@BeforeClass(alwaysRun = true)
	@Parameters({ "browser" })
	public void setup(String browser) {
		driver = openBrowser(browser, Constant.HOMEPAGE_URL);
		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		ranking = new RN_RankingPage(driver);
		counseling = new RN_CounselingPage(driver);
		company = new RN_CompanyGroupListPage(driver);
		branch = new RN_BranchPage(driver);
		employee = new RN_EmployeePage(driver);
		setting = new RN_SettingPage(driver);
		
		adminUserName = Constant.ADMIN_USERNAME;
		adminPassword = Constant.ADMIN_PASSWORD;
		textUnder新規作成Link = "メッセージ、お知らせ、キャンペーンをユーザーに配信";
		textUnder配信リストLink = "配信予定と配信済みメッセージの一覧";
		textUnderランキングイベント管理Link = "ランキングイベントの作成とユーザー追加・編集";
		textUnderオンライン栄養指導Link = "オンライン栄養指導のユーザー追加・一覧";
		textUnder事業所管理Link = "事業所の追加・編集"; 
		textUnder企業管理Link = "企業の追加・編集";
		textUnder社員管理Link = "社員の追加・編集";
		
		log.info("Pre-condition_Login: Login to RN Admin");
		navigateToURL(Constant.HOMEPAGE_URL);
		login.loginAs(adminUserName, adminPassword);
		
	}
	
	@Test (groups = "LOW", description = "TC 002: Check the display UI of [新規作成] link ")
	public void RN_Dashboard_TC_002_CreateNew_CheckTheDisplay新規作成Link(){
		log.info("VP_01. Verify that [新規作成] link is displayed");
		verifyTrue(dashboard.isDynamicButtonDisplay("新規作成"));
	}

	@Test (groups = "LOW", description = "TC 003: Check the display texts at [新規作成] link ")
	public void RN_Dashboard_TC_003_CreateNew_CheckTheDisplayTextAt新規作成Link(){
		log.info("VP_01. Verify that The Text Displayed Under Link is 'メッセージ、お知らせ、キャンペーンをユーザーに配信'");
		verifyEquals(dashboard.getTextUnderDynamicButton("新規作成"), textUnder新規作成Link);
	}
	
	@Test (groups = "HIGH", description = "TC 004: Check action of [新規作成] link ")
	public void RN_Dashboard_TC_004_CreateNew_CheckActionOf新規作成Link(){
		log.info("Step 01: Click 新規作成 Link");
		dashboard.clickDynamicButton("新規作成");
		
		log.info("VP_01. Verify that Message Create page is displayed");
		verifyTrue(dashboard.isDynamicDashboardPageTitleDisplayed("メッセージ配信"));
	}
	
	@Test(groups = "LOW", description = "TC 005: Check the display UI of [配信リスト] link")
	public void RN_Dashboard_TC_005_DeliveryList_CheckTheDisplay配信リストLink(){
		log.info("Pre-condition 01: Click Dashboard button");
		dashboard.clickDashboardButton(driver);
		
		log.info("VP_01. Verify that [配信リスト] link is displayed");
		verifyTrue(dashboard.isDynamicButtonDisplay("配信リスト"));
	}
	
	@Test(description = "TC 006: Check the display texts at [配信リスト] link", groups = "LOW")
	public void RN_Dashboard_TC_006_DeliveryList_CheckTheDisplayTextAt配信リストLink(){
		log.info("VP_01. Verify that The Text Displayed Under Link is '配信予定と配信済みメッセージの一覧'");
		verifyEquals(dashboard.getTextUnderDynamicButton("配信リスト"), textUnder配信リストLink);
	}
	
	@Test(groups = "HIGH", description = "TC 007: Check action of [配信リスト] link ")
	public void RN_Dashboard_TC_007_DeliveryList_CheckTheActionOf配信リストLink(){
		log.info("Step 01: Click 配信リスト Link");
		dashboard.clickDynamicButton("配信リスト");
		
		log.info("VP_01. Verify that Delivery List page is displayed");
		verifyTrue(dashboard.isDynamicDashboardPageTitleDisplayed("メッセージ配信"));
	}
	
	@Test(groups = "LOW", description = "TC 008: Check the display UI of [ランキングイベント管理] link ")
	public void RN_Dashboard_TC_008_TeamFunction_CheckTheDisplayランキングイベント管理Link(){
		log.info("Pre-condition 01: Click Dashboard button");
		dashboard.clickDashboardButton(driver);
		
		log.info("VP_01. Verify that [チーム機能] link is displayed");
		verifyTrue(dashboard.isDynamicButtonDisplay("ランキングイベント管理"));
	}
	
	@Test(groups = "LOW", description = "TC 009: Check the display texts at [ランキングイベント管理] link")
	public void RN_Dashboard_TC_009_TeamFunction_CheckTheDisplayTextAtランキングイベント管理Link(){
		log.info("VP_01. Verify that The Text Displayed Under Link is 'ランキングイベントの作成とユーザー追加・編集'");
		verifyEquals(dashboard.getTextUnderDynamicButton("ランキングイベント管理"), textUnderランキングイベント管理Link);
	}
	
	@Test(groups = "HIGH", description = "TC 010: Check action of [ランキングイベント管理] link ")
	public void RN_Dashboard_TC_010_TeamFunction_CheckTheActionOfランキングイベント管理Link(){
		log.info("Step 01: Click ランキングイベント管理 Link");
		dashboard.clickDynamicButton("ランキングイベント管理");
		
		log.info("VP_01. Verify that  page is displayed");
		verifyTrue(ranking.isRankingHeaderDisplayed("ランキングイベント管理"));
	}
	
	@Test(groups = "LOW", description = "TC 011: Check the display UI of [オンライン栄養指導] link ")
	public void RN_Dashboard_TC_011_OnlineNutritionGuidance_CheckTheDisplayオンライン栄養指導Link(){
		log.info("Pre-condition 01: Click Dashboard button");
		dashboard.clickDashboardButton(driver);
		
		log.info("VP_01. Verify that [オンライン栄養指導] link is displayed");
		verifyTrue(dashboard.isDynamicButtonDisplay("オンライン栄養指導"));
	}
	
	@Test(groups = "LOW", description = "TC 012: Check the display texts at [オンライン栄養指導] link")
	public void RN_Dashboard_TC_012_OnlineNutritionGuidance_CheckTheDisplayTextAtオンライン栄養指導Link(){
		log.info("VP_01. Verify that The Text Displayed Under Link is 'オンライン栄養指導のユーザー追加・一覧'");
		verifyEquals(dashboard.getTextUnderDynamicButton("オンライン栄養指導"), textUnderオンライン栄養指導Link);
	}
	
	@Test(groups = "HIGH", description = "TC 013: Check action of [オンライン栄養指導] link ")
	public void RN_Dashboard_TC_013_OnlineNutritionGuidance_CheckTheActionOfオンライン栄養指導Link(){
		log.info("Step 01: Click オンライン栄養指導 Link");
		dashboard.clickDynamicButton("オンライン栄養指導");
		
		log.info("VP_01. Verify that  page is displayed");
		verifyTrue(counseling.isCounselingHeaderDisplayed("オンライン栄養指導"));
	}
	
	@Test(groups = "LOW", description = "TC 014: Check the display UI of [企業管理] link ")
	public void RN_Dashboard_TC_014_Company_CheckTheDisplay企業管理Link(){
		log.info("Pre-condition 01: Click Dashboard button");
		dashboard.clickDashboardButton(driver);
		
		log.info("VP_01. Verify that [企業管理] link is displayed");
		verifyTrue(dashboard.isDynamicButtonDisplay("企業管理"));
	}
	
	@Test(groups = "LOW", description = "TC 015: Check the display texts at [企業管理] link")
	public void RN_Dashboard_TC_015_Company_CheckTheDisplayTextAt企業管理Link(){
		log.info("VP_01. Verify that The Text Displayed Under Link is '企業の追加・編集'");
		verifyEquals(dashboard.getTextUnderDynamicButton("企業管理"), textUnder企業管理Link);
	}
	
	@Test(groups = "HIGH", description = "TC 016: Check action of [企業管理] link ")
	public void RN_Dashboard_TC_016_Company_CheckTheActionOf企業管理Link(){
		log.info("Step 01: Click 企業管理Link");
		dashboard.clickDynamicButton("企業管理");
		
		log.info("VP_01. Verify that  page is displayed");
		verifyTrue(company.isCompanyHeaderDisplayed("企業管理"));
	}
	
	@Test(groups = "LOW", description = "TC 017: Check the display UI of [事業所管理] link ")
	public void RN_Dashboard_TC_017_Branch_CheckTheDisplay事業所管理Link(){
		log.info("Pre-condition 01: Click Dashboard button");
		dashboard.clickDashboardButton(driver);
		
		log.info("VP_01. Verify that [事業所管理] link is displayed");
		verifyTrue(dashboard.isDynamicButtonDisplay("事業所管理"));
	}
	
	@Test(groups = "LOW", description = "TC 018: Check the display texts at [事業所管理] link")
	public void RN_Dashboard_TC_018_Branch_CheckTheDisplayTextAt事業所管理Link(){
		log.info("VP_01. Verify that The Text Displayed Under Link is '事業所の追加・編集'");
		verifyEquals(dashboard.getTextUnderDynamicButton("事業所管理"), textUnder事業所管理Link);
	}
	
	@Test(groups = "HIGH", description = "TC 019: Check action of [事業所管理] link ")
	public void RN_Dashboard_TC_019_Branch_CheckTheActionOf事業所管理Link(){
		log.info("Step 01: Click 事業所管理 Link");
		dashboard.clickDynamicButton("事業所管理");
		
		log.info("VP_01. Verify that  page is displayed");
		verifyTrue(branch.isBranchHeaderDisplayed("事業所管理"));
	}
	
	@Test(groups = "LOW", description = "TC 020: Check the display UI of [社員管理] link ")
	public void RN_Dashboard_TC_020_Employee_CheckTheDisplay社員管理Link(){
		log.info("Pre-condition 01: Click Dashboard button");
		dashboard.clickDashboardButton(driver);
		
		log.info("VP_01. Verify that [社員管理] link is displayed");
		verifyTrue(dashboard.isDynamicButtonDisplay("社員管理"));
	}
	
	@Test(groups = "LOW", description = "TC 021: Check the display texts at [社員管理] link")
	public void RN_Dashboard_TC_021_Employee_CheckTheDisplayTextAt事業所管理Link(){
		log.info("VP_01. Verify that The Text Displayed Under Link is '社員の追加・編集'");
		verifyEquals(dashboard.getTextUnderDynamicButton("社員管理"), textUnder社員管理Link);
	}
	
	@Test(groups = "HIGH", description = "TC 022: Check action of [社員管理] link ")
	public void RN_Dashboard_TC_022_Employee_CheckTheActionOf社員管理Link(){
		log.info("Step 01: Click 社員管理 Link");
		dashboard.clickDynamicButton("社員管理");
		
		log.info("VP_01. Verify that  page is displayed");
		verifyTrue(employee.isEmployeeHeaderDisplayed("社員管理"));
	}
	
	@Test(groups = "LOW", description = "TC 023: Check the display UI of [アカウント設定] link ")
	public void RN_Dashboard_TC_023_ManagerMenu_CheckTheDisplayアカウント設定Link(){
		log.info("Pre-condition 01: Click Dashboard button");
		dashboard.clickDashboardButton(driver);
		
		log.info("VP_01. Verify that [アカウント設定] link is displayed");
		verifyTrue(dashboard.isDynamicButtonDisplay("アカウント設定"));
	}
	
	@Test(groups = "HIGH", description = "TC 024: Check action of [アカウント設定] link ")
	public void RN_Dashboard_TC_024_ManagerMenu_CheckTheActionOfアカウント設定Link(){
		log.info("Step 01: Click アカウント設定 Link");
		dashboard.clickDynamicButton("アカウント設定");
		
		log.info("VP_01. Verify that  page is displayed");
		verifyTrue(setting.isSettingHeaderDisplayed("設定"));
	}
	
	@AfterClass (alwaysRun = true)
	public void tearsDown() {
		closeBrowser();
	}

	protected WebDriver driver;
	public LoginPage login;
	public DashboardPage dashboard;
	public RN_RankingPage ranking;
	public RN_CounselingPage counseling;
	public RN_CompanyGroupListPage company;
	public RN_BranchPage branch;
	public RN_EmployeePage employee;
	public RN_SettingPage setting;
	
	String adminUserName, adminPassword;
	String textUnder新規作成Link, textUnder配信リストLink, textUnderランキングイベント管理Link, textUnderオンライン栄養指導Link, textUnder事業所管理Link, 
	textUnder企業管理Link, textUnder社員管理Link;

}
