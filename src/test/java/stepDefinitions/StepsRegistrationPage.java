package stepDefinitions;

import PageObject.RegistrationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsRegistrationPage {

    @Then("I check if \"First Name Field\" present")
    public void i_check_if_first_name_field_present() {
        new RegistrationPage().checkFirstNameFieldIsPresent();
    }

    @Then("I check if \"Last Name Field\" present")
    public void i_check_if_last_name_field_present() {
        new RegistrationPage().checkLastNameFieldIsPresent();
    }

    @Then("I check if \"Email Address Field\" present")
    public void i_check_if_email_address_field_present() {
        new RegistrationPage().checkEmailAddressFieldIsPresent();
    }

    @Then("I check if \"Password Field Field\" present")
    public void i_check_if_password_field_present() {
        new RegistrationPage().checkPasswordFieldIsPresent();
    }

    @Then("I check if \"Confirm Pass Field\" present")
    public void i_check_if_confirm_pass_field_present() {
        new RegistrationPage().checkConfirmPassIsPresent();
    }

    @When("I input {string} in User Name")
    public void i_input_user_name(String firstName) {
        new RegistrationPage().inputFirstName(firstName);
    }

    @When("I input {string} in Last Name")
    public void i_input_last_name(String lastName) {
        new RegistrationPage().inputLastName(lastName);
    }

    @When("I input Email Address on Registration Page")
    public void i_input_email_address() {
        new RegistrationPage().inputEmailAddress();
    }

    @When("I input password: {string} on Registration Page")
    public void i_input_password(String password) {
        new RegistrationPage().inputPassword(password);
    }

    @When("I confirm password: {string}")
    public void i_confirm_password(String password) {
        new RegistrationPage().confirmPassword(password);
    }

    @When("I tap on \"Register\" button")
    public void i_tap_on_register_button() {
        new RegistrationPage().tapOnRegisterButton();
    }
}