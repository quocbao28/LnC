package common;

import org.openqa.selenium.WebDriver;

import common.CommonAction;

public class Constant extends CommonAction{
	//--------------------------------LOGIN ADMIN--------------------------------------//
	public static final String HOMEPAGE_URL = "https://lcphp4.asiantech.vn/admin/employee";
	public static final String ADMIN_USERNAME = "administrator1";
	public static final String ADMIN_PASSWORD = "12345678";
	
	public static final String COMPANY_USERNAME = "company211";
	public static final String COMPANY_PASSWORD = "12345678";
	
	public static final String BRANCH_USERNAME = "branchco211";
	public static final String BRANCH_PASSWORD = "12345678";
	
	public static final String AGENT_USERNAME = "agent001";
	public static final String AGENT_PASSWORD = "12345678";
	
	public static final String MAIL_ACCOUNT = "lnc.testing001@gmail.com";
	public static final String MAIL_PASSWORD = "Abc123!@#";
	
	
	//---------------------------------Driver pack------------------------------------//
	public static WebDriver driver = null;
	public static int TimeWait = 10;
	public static final String email = "Automation";
	public static final String DRIVER_PATH = "..\\LnCAdmin\\src\\test\\resources\\";
	public static final String CHROME_DRIVER_SERVER = "chromedriver228";
	public static final String CHROME_WEB_DRIVER = "webdriver.chrome.driver";
	public static final String GECKO_DRIVER_SERVER = "geckodriver";
	public static final String IE_WEBDRIVER = "webdriver.ie.driver";
	public static final String IE_SERVER_DRIVER = "IEDriverServer";


	

	
}
