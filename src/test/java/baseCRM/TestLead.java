package baseCRM;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import baseCRM.data.LeadData;
import baseCRM.page.LoginPage;

public class TestLead {

	private LeadData leadData;
	
	@Test
	public void create_and_rename_lead() throws Exception {
		leadData = new LeadData();
		leadData.setFirstName("Florence Foster");
		leadData.setLastName("Jenkins");
		
		new LoginPage().login().leads().createNewLead(leadData).checkStatus("New").settingsProfile().leadSettings().setLeadStatus("Very new").logout();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		new LoginPage().login().leads().editLead(leadData).deleteLead();
	}
}
