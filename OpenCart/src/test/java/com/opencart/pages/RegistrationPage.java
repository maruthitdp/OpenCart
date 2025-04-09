package com.opencart.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.base.BaseClass;

public class RegistrationPage extends BasePage{
	private WebDriver driver;
	
	 public RegistrationPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountButton;

    @FindBy(xpath = "(//a[text()='Register'])[1]")
    private WebElement registerButton;
    
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='telephone']")
    private WebElement telephoneField;
    
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='confirm']")
    private WebElement confirmPasswordField;

    @FindBy(name = "agree")
    private WebElement termsCheckbox;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;
    
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement privacyCheckBox;
    
  
    @FindBy(xpath = "//form[@id='form-currency']")
    private WebElement detailsForm;


   

    public void clickMyAccount() {
    	
        click(myAccountButton);
        getScreenshot(myAccountButton);
    }

    public void clickRegister() {
    	
        mouseHover(registerButton);
        getScreenshot(registerButton);
    }

   
    
    public void enterPersonalDetails(String firstName, String lastName, String email, String telephone) {
        type(firstNameField, firstName);
        getScreenshot(firstNameField);
        type(lastNameField, lastName);
        getScreenshot(lastNameField);
        type(emailField, email);
        getScreenshot(emailField);
        type(telephoneField, telephone);
        getScreenshot(telephoneField);
    }
    
    public void enterPasswordDetails(String password, String confirmPassword) {
        type(passwordField, password);
		getScreenshot(passwordField);
        type(confirmPasswordField, confirmPassword);
		getScreenshot(confirmPasswordField);

        
    }

	public void clickTermsAndConditions() {
		
		click(privacyCheckBox);
		getScreenshot(privacyCheckBox);
	}

	public void clickContinue() {
		
		click(continueButton);
		getScreenshot(continueButton);
	}


	
}
