package stepDefinitions;

import PageObject.SalePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsSalePage {
    @When("I tap on \"grid view\" button on \"Sale\" page")
    public void i_tap_on_grid_view_button_on_sale_page() {
        new SalePage().tapOnGridViewButtonOnSalePage();
    }

    @When("^I choose ?\"([^\"]*)?\" of items on Sale page$")
    public void i_choose_count_of_items_on_sale_page(SalePage.CountOfItemsOnSalePageInGridView count) {
        new SalePage().selectItemsOnSalePageInGridView(count);
    }

    @Then("I verify that the old price is higher than a sale price for each item")
    public void i_verify_that_the_old_price_is_higher_than_a_sale_price_for_each_item() {
        new SalePage().verifyThatTheOlePriceIsHigherThanASalePrice();
    }
}