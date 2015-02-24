package baseCRM.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import tools.Manager;

public class SettingsLeadsPage extends SettingsPage {

	public SettingsLeadsPage setNewLeadStatus(String status) {
		logger.info("Click lead statuses tab");
		getSettingTabByText("Lead Statuses").click();
		
		logger.info("Click edit new status button");
		leadStatuesEditButtons.get(NEW).click();
		
		logger.info("Set new status to: " + status);
		WebElement statusNameInput = getVisibleElement(Manager.getDriver().findElements(By.id("name")));
		statusNameInput.clear();
		statusNameInput.sendKeys(status);
		
		logger.info("Click save button");
		WebElement saveButton = getVisibleElement(Manager.getDriver().findElements(By.className("save")));
		saveButton.click();
		
		return this;
	}
	
	@Override
	protected void isLoaded() throws Error {
		urlEndsWith("(.*)/settings/leads");
	}
	
	private WebElement getSettingTabByText(String text) {
		for (WebElement tab : leadsSettingsTabs) {
			if (tab.getText().equals(text)) {
				return tab;
			}
		}
		
		return null;
	}
	
	private WebElement getVisibleElement(List<WebElement> list) {
		for (WebElement webElement : list) {
			if (webElement.isDisplayed()) {
				return webElement;
			}
		}
		
		return null;
	}
	
	@FindBys({ @FindBy(id = "leads-settings-tabs"), @FindBy(tagName = "a") })
	private List<WebElement> leadsSettingsTabs;
	
	@FindBys( { @FindBy(id = "lead-status"), @FindBy(tagName = "button") } )
	private List<WebElement> leadStatuesEditButtons;
	
	private final int NEW = 0;
}
