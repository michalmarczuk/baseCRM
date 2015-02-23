package baseCRM.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tools.Manager;

public abstract class SettingsPage extends DashboardPage {

	public SettingsLeadsPage leadSettings() {
		logger.info("Settings leads");
		leadsLink.click();
		
		return PageFactory.initElements(Manager.getDriver(), SettingsLeadsPage.class);
	}
	
	@FindBy(xpath = "//*[@id='sidebar']//li[@class='leads']//a")
	private WebElement leadsLink;
}
