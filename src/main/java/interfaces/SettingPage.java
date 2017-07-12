package interfaces;

public class SettingPage {
	public static final String EMAIL_TEXTBOX = "//input[@name='email']";
	public static final String ID_TEXTBOX = "//input[@name='username']";
	public static final String SUBMIT_BUTTON = "//button[@type='submit']";
	public static final String OK_MODAL_DIALOG_BUTTON = "//button[contains(.,'登録')]";
	public static final String DYNAMIC_ERROR_MESSAGE = "//span[contains(.,'%s')]";
	public static final String MAINTENANCE_OFF_OPTION = "//input[@class='more-option']";
	public static final String MAINTENANCE_ON_OPTION = "//input[@id='maintenance2']";
	public static final String MAINTENANCE_MESSAGE_TEXTBOX = "//input[@class='form-control maintenance-message' or @class = 'form-control maintenance-message valid']";
	public static final String SAVED_SUCCESSFULLY_MESSAGE = "//div[contains(.,'設定情報が変更されました。')]";
	public static final String MESSAGE_IN_MODAL_DIALOG = "//div[@class='bootbox-body']";
	

}
