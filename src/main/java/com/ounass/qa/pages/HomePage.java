package com.ounass.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ounass.qa.base.TestBase;
import com.ounass.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	@FindBy (xpath = "//span[text()='Account']")
	WebElement Accountopen;

	@FindBy(xpath = "//h1[@class='MyAccountPage-title']")
	WebElement AccountTitle;

	@FindBy(xpath = "//span[text()='aaqib@werplay.com']")
	WebElement emailaddress;

	@FindBy(xpath = "//span[contains(text(),'Wishlist')]")
	WebElement wishlistlink;

	@FindBy(xpath = "(//span[contains(text(),'Bag')])[1]")
	WebElement Baglink;
	
	@FindBy(xpath="//div[normalize-space()='SHOP WOMEN']")
	WebElement Womenbtn;
	
	@FindBy(xpath="//div[normalize-space()='SHOP MEN']")
	WebElement Menbtn;
	
	@FindBy(xpath="//div[normalize-space()='SHOP KIDS']")
	WebElement Kidsbtn;

	// Initializition Page Objects with Page Factory Class
	public HomePage() {
		PageFactory.initElements(driver, this);

	}
	
	public boolean veifyHpWomenBtn() {
		return Womenbtn.isDisplayed();
	}
	
	public boolean veifyHpMenBtn() {
		return Menbtn.isDisplayed();
	}
	
	public boolean veifyHpKidsBtn() {
		return Kidsbtn.isDisplayed();
	}

	public boolean verifyAccountlogin() {
		Accountopen.click();
		return AccountTitle.isDisplayed();

	}

	public boolean verifyEmailaddress() {
		Accountopen.click();
		return emailaddress.isDisplayed();
	}

	public WishlistPage clickOnWishlistLink() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));   
		wait.until(ExpectedConditions.elementToBeClickable(wishlistlink));
		wishlistlink.click();
		return new WishlistPage();
	}

	public BagPage clickOnBagLink() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));   
		wait.until(ExpectedConditions.elementToBeClickable(Baglink));
		Baglink.click();
		return new BagPage();
	}

}
