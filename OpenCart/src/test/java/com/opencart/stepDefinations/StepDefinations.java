package com.opencart.stepDefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.opencart.base.BaseClass;
import com.opencart.pages.RegistrationPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.var;

public class StepDefinations extends BaseClass {

	BaseClass baseClass;
	RegistrationPage registrationPage;

	@Given("user launches the browser and open the url")
	public void user_launches_the_browser_and_open_the_url() {
		launchBrowser();
		openUrl();
		registrationPage = new RegistrationPage(driver);
	}

	@When("user clicks on MyAccount button and selects Register option")
	public void user_clicks_on_my_account_button_and_selects_register_option() {
		registrationPage.clickMyAccount();
		registrationPage.clickRegister();
	}

	@Then("user checks the title of register page")
	public void user_checks_the_title_of_register_page() {
		String title = driver.getTitle();
		System.out.println("Register Page Title: " + title);
	}

	@When("user enters personal deatils of the mandatory fields")
	public void user_enters_personal_deatils_of_the_mandatory_fields(DataTable dataTable) {
		// Convert DataTable to a list of maps
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		String firstName = data.get(0).get("FirstName");
		String lastName = data.get(0).get("LastName");
		String email = data.get(0).get("Email");
		String telephoneNumber = data.get(0).get("TelephoneNumber");

		registrationPage.enterPersonalDetails(firstName, lastName, email, telephoneNumber);

	}

	@When("user enters password details of the mandatory fields")
	public void user_enters_password_details_of_the_mandatory_fields() {
		registrationPage.enterPasswordDetails(properties.getProperty("password"),
				properties.getProperty("confirmPassword")); // Replace with actual password
	}

	@When("user clicks on mandatoryCheckBoxes")
	public void user_clicks_on_mandatory_check_boxes() {
		registrationPage.clickTermsAndConditions();
	}

	@When("user clicks on Continue button")
	public void user_clicks_on_continue_button() {
		registrationPage.clickContinue();
	}

	@Then("user should be navigated to Account Success Page and verify the title of the page")
	public void user_should_be_navigated_to_account_success_page_and_verify_the_title_of_the_page(DataTable dataTable) {
		String expectedTitle = dataTable.asMaps(String.class, String.class).get(0).get("expTitle");
	
		switch(expectedTitle) {
		case "Your Account Has Been Created!":registrationPage.verifyTitle(expectedTitle); break;
		case "Register Account":System.out.println("User already registered with email...");break;
		default: System.out.println("Error while registration... please check all the details that you have provided...");
		}
		
	}
@After
public void tearDown() {
	driver.quit();
}

}
