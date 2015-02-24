package baseCRM;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tools.Manager;
import baseCRM.data.LeadData;
import baseCRM.page.LoginPage;

public class TestLead {

	private LeadData leadData;
	private Logger logger;

	@BeforeClass
	public void setUp() {
		logger = LogManager.getLogger(getClass().getName());
	}

	@BeforeMethod
	public void setUpMethod(Method method) {
		logger.info("Started " + method.getName() + " test");
	}

	@Test
	public void create_and_rename_status_lead() throws Exception {
		leadData = new LeadData();
		leadData.setFirstName("Florence Foster");
		leadData.setLastName("Jenkins");
		
		String newStatus = "Very new";

		new LoginPage().login().leads().createNewLead(leadData)
				.checkStatus("New").settingsProfile().leadSettings()
				.setNewLeadStatus(newStatus).leads().editLead(leadData)
				.checkStatus(newStatus).logout();
	}

	@AfterClass
	public void tearDown() throws Exception {
		logger.info("Started cleaning up");
		Manager.closeBrowser();
		new LoginPage().login().leads().editLead(leadData).deleteLead()
				.settingsProfile().leadSettings().setNewLeadStatus("New")
				.logout();
		Manager.closeBrowser();
	}
}
