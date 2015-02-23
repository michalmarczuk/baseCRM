package baseCRM.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tools.Manager;

public abstract class DashboardPage extends Page {
	
	public LeadsPage leads() {
		logger.info("Click leads");
		leadsButton.click();
		
		return PageFactory.initElements(Manager.getDriver(), LeadsPage.class);
	}
	
	public LoginPage logout() {
		logger.info("Logout");
		settingsDropDownList.click();
		logoutButton.click();
		
		return PageFactory.initElements(Manager.getDriver(), LoginPage.class);
	}
	
	public SettingsProfilePage settingsProfile() {
		logger.info("Settings profile");
		settingsDropDownList.click();
		settingsButton.click();
		
		return PageFactory.initElements(Manager.getDriver(), SettingsProfilePage.class);
	}
	
	@FindBy(id = "nav-leads")
	private WebElement leadsButton;
	
	@FindBy(xpath = "//*[@id='user-dd']//a[@class='dropdown-toggle']")
	private WebElement settingsDropDownList;
	
	@FindBy(xpath = "//*[@class='icon-cog']/..")
	private WebElement settingsButton;
	
	@FindBy(xpath = "//*[@id='user-dd']//a[@class='agility-ignore']")
	private WebElement logoutButton;
}
