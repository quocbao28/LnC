package page;

import org.openqa.selenium.WebDriver;

import page.AbstractPage;
import common.Constant;

public class RN_RankingPage extends AbstractPage{
	public RN_RankingPage (WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * Is Ranking Header Displayed
	 * @param value
	 * @return
	 */
	public boolean isRankingHeaderDisplayed(String value){
		waitForElement(driver, interfaces.AbstractPage.DYNAMIC_PAGE_HEADER, value, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.AbstractPage.DYNAMIC_PAGE_HEADER, value);
	}
	WebDriver driver;

}
