package stepDefinitions;

import PageObject.ElectronicsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsElectronicsPage {

    @When("I tap on \"View As List\" Button")
    public void i_tap_on_view_as_list_button() {
        new ElectronicsPage().tapOnViewAsListButton();
    }

    @When("^I choose ?\"([^\"]*)?\" of items on Electronics page$")
    public void i_choose_count_of_items_on_page(ElectronicsPage.CountOfItemsOnElectronicsPageInListView count) {
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

    @When("^I select type ?\"([^\"]*)?\" of Sort By$")
    public void i_select_type_of_sort_by(ElectronicsPage.SortBy typeOfSort) {
        new ElectronicsPage().selectTypeOfSortBy(typeOfSort);
    }

    @Then("I verify sort by price")
    public void i_verify_sort_by_price() {
        new ElectronicsPage().verifySortByPrice();
    }

    @When("I tap on \"$0.00 - $999.99\" price from \"Shop By\"")
    public void i_tap_on_price_from_shop_by() {
        new ElectronicsPage().tapOnFirstPriceFromShopBy();
    }

    @Then("I verify that the price of all items is less than \"999.99\"")
    public void i_verify_that_the_price_of_all_items_is_less_than_indicated_price() {
        new ElectronicsPage().verifyThatThePriceOfItemsIsLessThenIndicatedPrice();
    }

    @When("I choose any random item and tap on \"Add to Wishlist\" button")
    public void i_choose_any_random_item_and_tap_on_wishlist_button() {
        new ElectronicsPage().chooseAnyRandomItemAndTapOnWishListButton();
    }

    @When("I tap on \"grid view\" button on \"Electronics\" page")
    public void i_tap_on_grid_view_button_on_electronics_page() {
        new ElectronicsPage().tapOnGridViewButtonOnElectronicsPage();
    }

    @When("^I choose ?\"([^\"]*)?\" of items on \"Electronics\" page on Grid view$")
    public void i_choose_count_of_items_on_electronics_page(ElectronicsPage.CountOfItemsOnElectronicsPageInGridView count) {
        new ElectronicsPage().selectItemsOnElectronicsPageInGridView(count);
    }

    @When("I choose any random item and tap on \"ADD TO CART\" button")
    public void i_choose_any_random_item_and_tap_on_add_to_cart_button() {
        new ElectronicsPage().chooseAnyRandomItemAndTapOnAddToCartButton();
    }
}