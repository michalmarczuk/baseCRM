package baseCRM.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import tools.Manager;

public class LeadDetailsPage extends DashboardPage {
	
	@Override
	protected void isLoaded() throws Error {
		urlEndsWith(".*/leads/\\d+");
	}
	
	public LeadsPage deleteLead() throws Exception {
		logger.info("Delete lead");
		deleteButton.click();
		Manager.getDriver().findElement(By.className("confirm")).click();
		
		return PageFactory.initElements(Manager.getDriver(), LeadsPage.class);
	}
	
	public LeadDetailsPage checkStatus(String status) throws Exception {
		logger.info("Check status. Expecting: " + status);
		Assert.assertEquals(leadStatus.getText(), status);
		
		return PageFactory.initElements(Manager.getDriver(), LeadDetailsPage.class);
	}
	
	@FindBy(className = "delete")
	WebElement deleteButton;
	
	@FindBy(className = "lead-status")
	WebElement leadStatus;
}
