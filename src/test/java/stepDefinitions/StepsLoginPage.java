package stepDefinitions;

import PageObject.LoginPage;
import io.cucumber.java.en.When;

public class StepsLoginPage {

    @When("I tap on \"Create An Account\" button")
    public void i_tap_on_create_an_account_button() {
        new LoginPage().tapOnCreateAnAccountButton();
    }

    @When("I input Email Address: {string} Login Page")
    public void i_input_email_address(String email) {
        new LoginPage().InputEmailAddress(email);
    }

    @When("I input password: {string} on Login page")
    public void i_input_password(String password) {
        new LoginPage().InputPassword(password);
    }

    @When("I tap on \"Login\" button")
    public void i_tap_on_login_button() {
        new LoginPage().tapOnLoginButton();
    }
}