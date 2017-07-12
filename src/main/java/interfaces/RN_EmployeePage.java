package interfaces;

public class RN_EmployeePage {
	public static final String EMPLOYEE_SEARCH_BTN  = "//a[@class='btn btn-default panel-filter']";
	public static final String STARTDATE_FIELD = "//input[@id='register-start-date']";
	public static final String ENDDATE_FIELD = "//input[@id='register-end-date']";
	public static final String SEARCH_BTN = "//button[@class='btn btn-warning']";
	public static final String SEARCH_RESULT= "//td[contains(text(),'234418')]";
	public static final String DOWNLOAD_CSV_BTN= "//a[@class='btn btn-default pull-right']";
	public static final String CONFIRM_DOWNLOAD_CSV_BTN= "//button[@id='download-csv-employee']";
	public static final String CSV_FILE= "//a[contains(@href,'employee')]";
	public static final String READING_EMPLOYEE_BTN= "//a[@class='btn btn-primary btn-sm']";
	public static final String ANALYTICS_BTN= "(//a[@class='btn btn-success btn-sm'])[2]";
	public static final String EMPLOYEE_ID_FIELD = "//input[@class='form-control']";
	public static final String COMPANY_DROPDOWN= "//select[@class='form-control list-company']";
	public static final String OFFICE_DROPDOWN = "//select[@class='form-control branch_group']";
	public static final String YOURNAME_FIELD = "//input[@name='name']";
	public static final String SEND_CODE_BUTTON = "//a[contains(text(),'パスコードの送信')]";
	public static final String SEND_CODE_POPUP_TITLE = "//h4[contains(text(),'パスコードのメール送信')]";
	public static final String CLOSE_POPUP_BUTTON = "(//button[@class='close'])[3]";
	public static final String RETIREMENT_BULK_ADDITION_BUTTON = "//a[@class='btn btn-retired pull-right']";
	public static final String BROWSE_FILE_BUTTON = "//input[@name='import_file']";
	public static final String RECORD_BUTTON = "//button[@class='btn btn-warning btn-post-form']";
}
