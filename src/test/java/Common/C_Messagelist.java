package Common;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import common.Constant;
import page.AbstractPage;
import page.LoginPage;
import page.RN_Message;


public class C_Messagelist extends AbstractTest{
	@BeforeClass (alwaysRun = true)
	@Parameters({ "browser" })
	public void setUp(String browser){
		messagePageUrl="https://lcphp4.asiantech.vn/message";
		driver = openBrowser(browser, Constant.HOMEPAGE_URL);
		login = new LoginPage(driver);
		messagePage = new RN_Message(driver);
		
		adminUserName = Constant.ADMIN_USERNAME;
		adminPassword = Constant.ADMIN_PASSWORD;
		
		log.info("Pre-condition_Login: Login to RN Admin");
		navigateToURL(Constant.HOMEPAGE_URL);
		login.loginAs(adminUserName, adminPassword);
		
		log.info("Go to Employee List Page");
		((AbstractPage) messagePage).clickMessageLink();
		
		log.info("Verify go to Employee List Page Successfull ");
		verifyTrue(messagePage.isMessageHeaderDisplayed("メッセージ配信"));
	}
	
	@Test (groups = "COMMON", description = "TC 004: Check the value display at [登録日時] column")
	public void C_Employeelist_004_RegisterTime(){
		log.info("VP 01. Verify Register Time");
		verifyTrue(messagePage.isDateTimeRegisterCorrected());
	}
	
	@Test (groups = "COMMON", description = "TC 005: Check the value display at [配信日時] column")
	public void C_Employeelist_005_DeliveryTime(){
		log.info("VP 01. Verify Delivery Time");
		verifyTrue(messagePage.isDateTimeDeliveryCorrected());
	}
	
	@Test (groups = "COMMON", description = "TC 011: Check action of [閲覧]/view button")
	public void C_Employeelist_011_Check_Browsing_Button() throws InterruptedException{
		log.info("Step 01. Click Browsing button");
		messagePage.clickBrowsingButton();
		
		log.info("VP 01. Verify Message Details Page appears");
		verifyTrue(messagePage.isMessageDetailsHeaderDisplayed());
		
		log.info("Step 02: Back to Messsage Page");
		navigateToURL(messagePageUrl);
	}
	
	@Test (groups = "COMMON", description = "TC 020: Check display of 配信スケジュール ")
	public void C_Employeelist_020_Check_Delivery_Schedule(){
		log.info("Step 01. Click Search delivery messages button");
		messagePage.clickSearchDeliveryMessageButton();
		
		log.info("VP 01. Verify elements is displayed");
		messagePage.isNoneOptionDisplayed();
		messagePage.isSpecifyDateOptionDisplayed();
		messagePage.isDailyOptionDisplayed();
		messagePage.isWeeklyOptionDisplayed();
		messagePage.isMonthlyOptionDisplayed();
	}
	
	@Test (groups = "COMMON", description = "TC 021: Check validation of start day and end day ")
	public void C_Employeelist_021_Check_Vaildate_StartAndEnd_Date(){
		log.info("VP 01. Verify End day is greater than or equal to start day.");
		verifyTrue(messagePage.compareStartDateEndDate());
	}
	
	@Test (groups = "COMMON", description = "TC 022: Check no choose date pickers (start day and end day)")
	public void C_Employeelist_022_Check_NoChooseDatePicker(){
		String before;
		String after;
		log.info("Pre - Condifion: Get Number Of Page");
		before = messagePage.getNumberOfPage();
		
		log.info("Step 01: Input Date to Change Number Of Page");
		messagePage.inputStratDateField("2016-05-01");
		messagePage.inputEndDateField("2016-05-02");
		messagePage.clickSearchButton();
		
		log.info("VP 01. Verify Number Of Page is Changed");
		verifyFalse(messagePage.isLastedPaginateButtonDisplayed());
		
		log.info("Step 02: Clear input date");
		messagePage.clearStratDateField();
		messagePage.clearEndDateField();
		messagePage.clickSearchButton();
		after = messagePage.getNumberOfPage();
		
		log.info("VP 02. Verify Nothing happens (Still display all result)");
		verifyEquals(before, after);
	}
	
	@Test (groups = "COMMON", description = "TC 023: Check no choose date pickers (start day and end day)")
	public void C_Employeelist_022_Check_ChooseDatePicker(){
		log.info("Step 01: Input Date to Change Number Of Page");
		messagePage.inputStratDateField("2016-05-01");
		messagePage.inputEndDateField("2016-05-02");
		messagePage.clickSearchButton();
		
		log.info("VP 01. Verify Number Of Page is Changed");
		verifyFalse(messagePage.isLastedPaginateButtonDisplayed());
	}
	
	@AfterClass (alwaysRun = true)
	public void tearsDown(){		
		closeBrowser();
	}
	
	public LoginPage login;
	public AbstractPage abstractPage;
	public RN_Message messagePage;
	public String adminUserName, adminPassword, browser_;
	public String messagePageUrl;
}
