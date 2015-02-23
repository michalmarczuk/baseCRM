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
		logger.info("Opening page: " + Manager.getURL());
		Manager.getDriver().get(Manager.getURL());
	}
	
	//TODO sleep!
	protected void urlEndsWith(String regexp) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String pageURL = Manager.getDriver().getCurrentUrl();
		Assert.assertTrue(pageURL.matches(regexp), "Something went wrong I'm not on " + getClass().getName());
		logger.info("Loaded page: " + getClass().getName());
	}
}