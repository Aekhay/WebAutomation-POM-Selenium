package com.ounass.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ounass.qa.base.TestBase;
import com.ounass.qa.pages.HomePage;
import com.ounass.qa.pages.LoginPage;
import com.ounass.qa.pages.WishlistPage;

public class WishlistPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	WishlistPage wishlistPage;

	public WishlistPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization(); // Calling initialization method from TestBase class
		loginPage = new LoginPage(); // creating constructor of loginpage class
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password")); // returning object of
		wishlistPage = homePage.clickOnWishlistLink(); // homepage class
	}

	@Test (priority = 1)
	public void verifyWishlistTitleTest() {

		Assert.assertTrue(wishlistPage.verifyWishlistPageTitle());

	}

	@Test (priority = 2)
	public void verifyWishlistitemTest() {

		Assert.assertTrue(wishlistPage.verifyWishlistitem());
		Assert.assertTrue(wishlistPage.verifyWishListitembtn());

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
