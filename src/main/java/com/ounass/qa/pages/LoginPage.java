package com.ounass.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ounass.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//PageFactory / OR (Object Repository)
	
	@FindBy (xpath = "//button[@class=\"No thanks\"]")
	WebElement pushnotifibtn;
	
	@FindBy (xpath = "//span[text()='Account']")
	WebElement Accountopen;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy (xpath = "//button[@type='submit'][normalize-space()='LOG IN']")
	WebElement loginbtn;
	
	@FindBy (xpath = "//a[@class=' Button SignInForm-createAccountLink secondary']")
	WebElement CreateAccountbtn;
	
	@FindBy (xpath = "//button[@class=' Button  SignInForm-continueWithAppleButton tertiary']")
	WebElement Applebtn;
	
	
	//Initializition Page Objects with Page Factory Class
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Actions
	public String validateLoginPageTitle() {
		
		return driver.getTitle(); //Returning Title in String
	}
	
	public Boolean validateLoginbtn() {
		pushnotifibtn.click();
		Accountopen.click();
		return Applebtn.isDisplayed();
	}
	
	public HomePage Login(String mail, String pass) throws InterruptedException {
		
		pushnotifibtn.click();
		Accountopen.click();
		email.sendKeys(mail); 
		password.sendKeys(pass);
		loginbtn.click();
		Thread.sleep(3000);
		return new HomePage();
		
	}

}
