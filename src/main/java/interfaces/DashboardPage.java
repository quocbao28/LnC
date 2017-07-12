package interfaces;

public class DashboardPage {
	public static final String DASHBOARD_HEADER = "//h1[@class='page-header message']";
	public static final String NAVBAR_ACCOUNT = "//span[contains(text(),'%s')]";
	public static final String DYNAMIC_DASHBOARD_BUTTON = "//p[contains(.,'%s')]";
	public static final String DYNAMIC_MENU_BAR_BUTTON = "//a[contains(.,'%s')]";
	public static final String DYNAMIC_DASHBOARD_MESSAGE_UNDER_BUTTON = "//div[@class = 'text']/p[contains(.,'%s')]/following-sibling::p";
	public static final String DYNAMIC_DASHBOARD_PAGE_TITLE = "//h1[contains(.,'%s')]";
}
