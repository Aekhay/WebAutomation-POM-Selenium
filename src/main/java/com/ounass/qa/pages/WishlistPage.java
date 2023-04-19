package com.ounass.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ounass.qa.base.TestBase;

public class WishlistPage extends TestBase {

	@FindBy(xpath = "//h1[contains(text(),'My Wishlist')]")
	WebElement WishlistTitle;

	@FindBy(xpath = "(//div[@class=\"WishListItemDesktop\"])[1]")
	WebElement Wishlistitem;

	@FindBy(xpath = "(//button[@class='AddToBag'])[1]")
	WebElement Wishlistitembagbtn;

	// Initializition Page Objects with Page Factory Class
	public WishlistPage() {
	PageFactory.initElements(driver, this);

	}

	public boolean verifyWishlistPageTitle() {
		return WishlistTitle.isDisplayed();
	}

	public boolean verifyWishlistitem() {

		return Wishlistitem.isDisplayed();
	}

	public boolean verifyWishListitembtn() {

		return Wishlistitembagbtn.isDisplayed();
	}
}
