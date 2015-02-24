package baseCRM.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import tools.Manager;

public abstract class Page extends LoadableComponent<Page> {

	protected Logger logger;
	
	public Page() {
		logger = LogManager.getLogger(getClass().getName());
		
		//Use load method only in LoginPage class
		if(getClass().getName().equals(LoginPage.class.getName())) {
			load();
		}
		
		PageFactory.initElements(Manager.getDriver(), this);
		isLoaded();
	}
	
	@Override
	protected void load() {
		Manager.getDriver().get(Manager.getURL());
	}
	
	protected void urlEndsWith(String regexp) {	
		for (int i = 0; i < 10; i++) {
			try { Thread.sleep(500); } 
			catch (InterruptedException e) { e.printStackTrace(); }
			String pageURL = Manager.getDriver().getCurrentUrl();
			if (pageURL.matches(regexp)) {
				logger.info("Loaded page: " + getClass().getName());
				return;
			}
		}
		
		Assert.fail("Something went wrong I'm not on " + getClass().getName());
	}
}