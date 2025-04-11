package com.opencart.pages;



import org.junit.Assert;
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

    @FindBy(xpath="//div[text()=' Warning: E-Mail Address is already registered!']")
    private WebElement resultText;
   

    public void clickMyAccount() {
		higlightingElements(myAccountButton);

        click(myAccountButton);
    }

    public void clickRegister() {
		higlightingElements(registerButton);

        mouseHover(registerButton);
    }

   
    
    public void enterPersonalDetails(String firstName, String lastName, String email, String telephone) {
    	
        type(firstNameField, firstName);
        higlightingElements(firstNameField);
        
        type(lastNameField, lastName);
        higlightingElements(lastNameField);
        
        type(emailField, email);
        higlightingElements(emailField);
      
        type(telephoneField, telephone);
        higlightingElements(telephoneField);
       
    }
    
    public void enterPasswordDetails(String password, String confirmPassword) {
        
        type(passwordField, password);
        higlightingElements(passwordField);
        
        type(confirmPasswordField, confirmPassword);
        higlightingElements(confirmPasswordField);
		getScreenshot(driver.getTitle(),"src\\test\\resources\\screenshots\\registration\\");


        
    }

	public void clickTermsAndConditions() {
        higlightingElements(privacyCheckBox);
		click(privacyCheckBox);
		
	}

	public void clickContinue() {
        higlightingElements(continueButton);
		click(continueButton);
		higlightingElements(resultText);

		getScreenshot(driver.getTitle(),"src\\test\\resources\\screenshots\\registration\\");
	}

	
	

	
}
