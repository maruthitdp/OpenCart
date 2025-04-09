package com.opencart.pages;

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

	@FindBy(css= "input[value='Login']")
	private WebElement logInButton;

	public void clickMyAccount() {
		
		click(myAccount);
		getScreenshot(myAccount);
	}

	public void clickLogin() {
		mouseHover(logIn);
		getScreenshot(logIn);

	}
	
	public void clickLogInButton() {
		click(logInButton);
	}

	public void send_Data_To_Login(String email, String password) {
		
		type(emailTextField, email);
		getScreenshot(emailTextField);
		type(passwordField, password);
		getScreenshot(passwordField);
	}
	
	
}
