package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import PageClass.homePage;

public class stepDefinitions {
	
	
	homePage homePage;
	@Given("^User is on home Page$")
	public void user_is_on_home_page() {
		homePage.launchApplication();
	}
	
	@When("^User clicks on Account icon$")
	public void clickOnAccountIcon() {
		homePage.clickOnAccountIcon();
	}
	@When("^User clicks on Login/Register link$")
	public void click_on_register_link() {
		homePage.clickOnRegisterLink();
	}
	
	@Then("^User enters \\\"([^\\\"]*)\\\" mandatory fields and click on Register button$")
	public void enterMandatoryFields(String data) throws IOException {
		homePage.enterMandatoryFields(data);
	}
	
	@And("^User verifies the success message$")
	public void successMessage() {
		homePage.verifySuccessMessage();
	}
	
	@Then("^User enters \\\"([^\\\"]*)\\\" and \\\"([^\\\"]*)\\\" details$")
	public void enterLoginDetails(String email, String password) {
		homePage.enterUserDetails(email, password);
	}
	
	@And("^User clicks on login button$")
	public void click_on_login_button() {
		homePage.clickOnLoginLink();
	}
	}


