package stepDefinitions;

import PageObject.LoginPage;
import io.cucumber.java.en.When;

public class StepsLoginPage extends LoginPage {

    @When("I tap on \"Create An Account\" Button")
    public void i_tap_on_create_an_account_button()
    {
        new LoginPage().tapOnCreateAnAccountButton();
    }

}
