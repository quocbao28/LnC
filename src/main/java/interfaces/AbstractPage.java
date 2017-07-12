package interfaces;

public class AbstractPage {
	public static final String DYNAMIC_PAGE_HEADER = "//h1[contains(.,'%s')]";
	public static final String DASHBOARD_BUTTON = "//a[contains(.,' ダッシュボード')]";
	public static final String LOGOUT_BUTTON = "//a[@href='/logout']";
	
	//Menu bar
	public static final String MENU_BAR = "//div[@class='col-sm-3 col-md-2 sidebar']";
	public static final String STATISTICS_DASHBOARD_LINK="//a[contains(text(),'ユーザー分析')]";
	public static final String RANKING_LINK="//a[contains(text(),'ランキングイベント管理')]";
	public static final String COUNSELING_LINK="//a[contains(text(),'オンライン栄養指導')]";
	public static final String EMPLOYEE_LINK="//a[contains(text(),'社員管理')]";
	public static final String MESSAGE_LINK="//a[contains(text(),'配信リスト')]";

}
