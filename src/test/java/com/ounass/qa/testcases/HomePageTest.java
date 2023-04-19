package com.ounass.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ounass.qa.base.TestBase;
import com.ounass.qa.pages.BagPage;
import com.ounass.qa.pages.HomePage;
import com.ounass.qa.pages.LoginPage;
import com.ounass.qa.pages.WishlistPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	WishlistPage wishlistPage;
	BagPage bagPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization(); // Calling initialization method from TestBase class
		loginPage = new LoginPage(); // creating constructor of loginpage class
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password")); // returning object of
																								// homepage class
	}

	@Test (priority = 1)
	public void verifyAccountTitleTest() {
		boolean flag = homePage.verifyAccountlogin();
		assertTrue(flag, "User is not logged In");
	}

	@Test(priority = 2)
	public void verifyEmailaddressTest() {
		boolean eflag = homePage.verifyEmailaddress();
		assertTrue(eflag);
	}
	
	@Test (priority = 3)
	public void verifyWishlistLinkTest() {

		wishlistPage = homePage.clickOnWishlistLink();

	}
	
	@Test (priority = 4)
	public void verifyBaglistLinkTest() {

		bagPage = homePage.clickOnBagLink();

	}
	
	@Test (priority = 5)
	public void verifyHomepagebtnTest() {
		
		Assert.assertTrue(homePage.veifyHpWomenBtn(),"Women btn not displayed");
		Assert.assertTrue(homePage.veifyHpMenBtn(),"Men btn not displayed");
		Assert.assertTrue(homePage.veifyHpKidsBtn(),"Kids btn not displayed");
		
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
