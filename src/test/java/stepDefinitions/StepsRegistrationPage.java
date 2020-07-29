package stepDefinitions;

import PageObject.RegistrationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsRegistrationPage extends RegistrationPage {

    @Then("I check if \"First Name Field\" present")
    public void i_check_if_first_name_field_present() {
        new RegistrationPage().checkFirstNameField();
    }
}
