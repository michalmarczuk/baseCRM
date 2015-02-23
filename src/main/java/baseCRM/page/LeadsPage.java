package baseCRM.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import tools.Manager;
import baseCRM.data.LeadData;

public class LeadsPage extends DashboardPage {

	//TODO Fix ugly sleep
	public LeadDetailsPage createNewLead(LeadData leadData) throws Exception {
		logger.info("Click new lead");
		Thread.sleep(1000);
		newLeadButton.click();
		
		//Set data from leadData
		logger.info("Set first name: " + leadData.getFirstName());
		Manager.getDriver().findElement(By.id("lead-first-name")).sendKeys(leadData.getFirstName());
		logger.info("Set last name: " + leadData.getLastName());
		Manager.getDriver().findElement(By.id("lead-last-name")).sendKeys(leadData.getLastName());
		
		logger.info("Click save");
		Manager.getDriver().findElement(By.className("save")).click();
		
		return PageFactory.initElements(Manager.getDriver(), LeadDetailsPage.class);
	}
	
	public LeadDetailsPage editLead(LeadData leadData) throws Exception {
		String leadName = leadData.getFirstName() + " " + leadData.getLastName();
		
		for (WebElement leadLink : leadsList) {
			if (leadLink.getText().equals(leadName)) {
				leadLink.click();
				
				return PageFactory.initElements(Manager.getDriver(), LeadDetailsPage.class);
			}
		}
		
		throw new Exception("Lead \"" + leadName + "\" wasn't available on leads list");
	}
	
	@Override
	protected void isLoaded() throws Error {
		urlEndsWith("(.*)/leads");
	}
	
	@FindBy(xpath = "//*[@id='selection']//a[@class='btn btn-info unselected']")
	private WebElement newLeadButton;
	
	@FindBys(@FindBy(className = "lead-name"))
	private List<WebElement> leadsList;
}
