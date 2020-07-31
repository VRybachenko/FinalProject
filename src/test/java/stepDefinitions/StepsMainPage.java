package stepDefinitions;

import PageObject.AbstractPage;
import PageObject.MainPage;
import io.cucumber.java.en.When;

import static driver.manager.Driver.getDriver;

public class StepsMainPage {

    @When("I am navigate to {string} url")
    public void i_am_navigate_to_url(String url) {
        getDriver().navigate().to(url);
    }

    //https://stackoverflow.com/questions/34718083/is-it-possible-to-pass-java-enum-as-argument-from-cucumber-feature-file
    //@When("^I choose \"([^\"]*)\" language$")
    @When("^I choose ?\"([^\"]*)?\" language$")
    public void i_choose_automation_language(AbstractPage.Language lang) {
        new MainPage().chooseAutomationLanguage(lang);
    }

    @When("I tap on \"Account\" button")
    public void i_tap_on_account_button() {
        new MainPage().tapOnAccountButton();
    }

    @When("I tap on \"My Account\" button")
    public void i_tap_on_my_account_button() {
        new MainPage().tapOnMyAccountButton();
    }

    @When("I move the cursor to \"HOME & DECOR\" button")
    public void i_move_the_cursor_to_home_and_decor_button() {
        new MainPage().moveTheCursorToHomeAndDecor();
    }

    @When("I chose \"Electronics\" page from list")
    public void i_chose_electronics_page_from_list() {
        new MainPage().choseElectronicsPageFromList();
    }
}