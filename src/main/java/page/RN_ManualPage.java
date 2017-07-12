package page;

import org.openqa.selenium.WebDriver;

public class RN_ManualPage extends AbstractPage{
	public RN_ManualPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	WebDriver driver;
}
