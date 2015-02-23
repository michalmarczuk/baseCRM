package baseCRM.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import tools.Manager;

public class LoginPage extends Page {

	public SalesPage login() {
		logger.info("Logging with user: " + Manager.getUser());
		userEmailField.sendKeys(Manager.getUser());
		userPasswordField.sendKeys(Manager.getPassword());
		loginButton.click();
		
		return PageFactory.initElements(Manager.getDriver(), SalesPage.class);
	}
	
	@Override
	protected void isLoaded() throws Error {
		String pageTitle = Manager.getDriver().getTitle();
		Assert.assertTrue("Login to Base".equals(pageTitle), "Something went wrong I'm not on " + getClass().getName());
		logger.info("Loaded page: " + getClass().getName());
	}
	
	@FindBy(id = "user_email")
	private WebElement userEmailField;
	
	@FindBy(id = "user_password")
	private WebElement userPasswordField;
	
	@FindBy(className = "btn")
	private WebElement loginButton;
}
