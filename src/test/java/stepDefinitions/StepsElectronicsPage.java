package stepDefinitions;

import PageObject.ElectronicsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsElectronicsPage {

    @When("I tap on \"View As List\" Button")
    public void i_tap_on_view_as_list_button() {
        new ElectronicsPage().tapOnViewAsListButton();
    }

    @When("^I choose ?\"([^\"]*)?\" of items on page$")
    public void i_choose_count_of_items_on_page(ElectronicsPage.CountOfItemsOnPage count) {
        new ElectronicsPage().selectItemsOnPage(count);
    }

    @Then("I compare or the count of elements on the page equals elements on the page")
    public void i_compare_or_the_count_of_elements_on_the_page_equals_elements_on_the_page() {
        new ElectronicsPage().verifyTheCountOfElementsOnThePage();
    }

    @Then("I verify that only {int} items are shown on each page")
    public void i_verify_that_only_counter_items_are_show_on_each_page(int counter) {
        new ElectronicsPage().verifyTheCountOfElementsOnEachPage(counter);
    }
}
