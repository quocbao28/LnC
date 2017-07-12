package interfaces;

public class RN_Message {
	public static final String REGISTER_DATETIME = "(//td[contains(text(),'2017-06')])[1]";
	public static final String DELIVERY_DATETIME = "(//td[contains(text(),'固定')])[1]";
	public static final String MESSAGE_DETAILS_HEADER = "//h2[@class='sub-header']";
	public static final String BROWSING_BTN = "(//a[@class='btn btn-primary btn-sm'])[1]";
	public static final String SEARCH_DELIVERY_MSG_BTN= "//a[@class='btn btn-default panel-filter']";
	public static final String STARTDATE_FIELD= "//input[@id='schedule-start-date']";
	public static final String ENDDATE_FIELD= "//input[@id='schedule-end-date']";
	public static final String NONE_OPTION= "//label[@class='col-md-4' and contains(text(),'なし')]";
	public static final String SPECIFY_DATE_OPTION= "//label[@class='col-md-4' and contains(text(),'日時指定')]";
	public static final String REPEAT_DAILY_OPTION= "//label[@class='col-md-4' and contains(text(),'繰り返し（毎日）')]";
	public static final String REPEAT_WEEKLY_OPTION= "//label[@class='col-md-4' and contains(text(),'繰り返し（毎週）')]";
	public static final String REPEAT_MONTHLY_OPTION= "//label[@class='col-md-4' and contains(text(),'繰り返し（毎月）')]";
	public static final String SEARCH_BTN= "//button[contains(text(),'検索する')]";
	public static final String LAST_PAGINATE_BTN= "//a[@data-dt-idx='7']";
}
