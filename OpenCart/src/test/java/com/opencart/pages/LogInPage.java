package com.opencart.pages;

import org.junit.Assert;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {
	private WebDriver driver;

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccount;

	@FindBy(xpath = "(//a[text()='Login'])[1]")
	private WebElement logIn;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailTextField;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordField;

	@FindBy(css= "input[type='submit']")
	private WebElement logInButton;

	public void clickMyAccount() {
		higlightingElements(myAccount);
		click(myAccount);
		
	}

	public void clickLogin() {
		higlightingElements(logIn);
		
		mouseHover(logIn);

	}
	
	public void clickLogInButton() {
		higlightingElements(logInButton);

		click(logInButton);
	}

	public void send_Data_To_Login(String email, String password) {
		
		type(emailTextField, email);
		higlightingElements(emailTextField);

		type(passwordField, password);
		higlightingElements(passwordField);

		getScreenshot(driver.getTitle(),"src\\test\\resources\\screenshots\\logIn\\");

	}
	public void verifyFinalPageTitle(String expTitle) {

		Assert.assertEquals(driver.getTitle(),expTitle);
		getScreenshot(driver.getTitle(),"src\\test\\resources\\screenshots\\logIn\\");

	}
	

	
}
