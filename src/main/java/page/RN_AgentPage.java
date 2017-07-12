package page;

import org.openqa.selenium.WebDriver;

import page.AbstractPage;
import common.Constant;

public class RN_AgentPage extends AbstractPage{
	
	public RN_AgentPage(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	public boolean isAgentHeaderDisplayed(){
		waitForElement(driver, interfaces.RN_AgentPage.AGENT_HEADER,Constant.TimeWait);
		return isControlDisplayed(driver, interfaces.RN_AgentPage.AGENT_HEADER);
	}
	WebDriver driver;

}
