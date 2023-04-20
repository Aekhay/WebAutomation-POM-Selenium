package com.ounass.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ounass.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver; //public -> can be used in child classes
	public static Properties prop;
	public static WebDriverWait wait;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/wrp/git/Selenium-WebAutomation-POM/Selenium-WebAutomation-POM/src/main/java/com/ounass/"
							+ "qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
					"/Users/wrp/git/Selenium-WebAutomation-POM/Selenium-WebAutomation-POM/src/main/resources/Drivers/chromedriver");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			
			driver = new ChromeDriver();
			
		} else if (browserName.equals("FireFox")) {
			
			System.setProperty("webdriver.gecko.driver","");
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		//Getting url from the properties file
		driver.get(prop.getProperty("url"));
	}

}
