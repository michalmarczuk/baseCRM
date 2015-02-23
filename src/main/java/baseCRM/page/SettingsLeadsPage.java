package baseCRM.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SettingsLeadsPage extends SettingsPage {

	public SettingsLeadsPage setLeadStatus(String status) {
		getSettingTabByText("Lead Statuses").click();
		
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
	
	@FindBys({ @FindBy(id = "leads-settings-tabs"), @FindBy(tagName = "a") })
	private List<WebElement> leadsSettingsTabs;	
}
