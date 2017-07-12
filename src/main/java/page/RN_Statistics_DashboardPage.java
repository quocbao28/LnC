package page;

import org.openqa.selenium.WebDriver;

import page.AbstractPage;
import common.Constant;

public class RN_Statistics_DashboardPage extends AbstractPage{
	public RN_Statistics_DashboardPage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	public boolean isStatisticsHeaderDisplayed(){
		waitForElement(driver, interfaces.RN_Statistics_DashboardPage.STATISTICS_HEADER, Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_Statistics_DashboardPage.STATISTICS_HEADER);
	}
	
	WebDriver driver;

}
