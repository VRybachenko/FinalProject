package stepDefinitions;

import PageObject.RegistrationPage;
import io.cucumber.java.en.Then;

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
}