package tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Manager {

	private static WebDriver driver = null;
	private static InputStream inputStream;
	private static Properties properties = null;
	
	public static WebDriver getDriver() {
		if (driver == null) {
			FirefoxProfile ff = new FirefoxProfile();
			ff.setPreference("network.proxy.type", 4);
			driver = new FirefoxDriver(ff);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver = new FirefoxDriver();
		}
		
		return driver;
	}
	
	public static void closeBrowser() {
		driver.close();
		driver.quit();
		driver = null;
	}
	
	public static String getURL() {
		return getProperty("url");
	}
	
	public static String getUser() {
		return getProperty("user");
	}
	
	public static String getPassword() {
		return getProperty("password");
	}
	
	private static String getProperty(String property) {
		if (properties == null) {
			inputStream = Manager.class.getResourceAsStream("/test.properties");
			properties = new Properties();
			
			try {
				properties.load(inputStream);
				inputStream.close();			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return properties.getProperty(property);
	}
}
