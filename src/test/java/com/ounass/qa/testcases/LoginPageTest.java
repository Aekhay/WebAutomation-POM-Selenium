package com.ounass.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ounass.qa.base.TestBase;
import com.ounass.qa.pages.HomePage;
import com.ounass.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage; //Defining at class level so it can be used overall in program
	HomePage homePage;
	
	public LoginPageTest() {
		super(); //calling super class constructor to call properties file
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		initialization(); //Calling initialization method from TestBase class
		
		loginPage = new LoginPage(); //creating constructor of loginpage class
	}
	
	
	//Creating Testcases
	@Test (priority = 2)
	public void loginPageTitleTest() {
		
		String title = loginPage.validateLoginPageTitle(); //Coming from login page class
		Assert.assertEquals(title, "OUNASS UAE | The Definitive Home of Luxury"); //Validating title
	}
	
	@Test (priority = 2)
	public void loginbtnTest() {
		
		boolean flag  = loginPage.validateLoginbtn();
		Assert.assertTrue(flag);
	}
	
	@Test (priority = 1)
	public void loginTest() throws InterruptedException {
		
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password")); //returning object of homepage class
		
		
	}
	

	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	

}
