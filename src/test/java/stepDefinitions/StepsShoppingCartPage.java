package stepDefinitions;

import PageObject.ShoppingCartPage;
import io.cucumber.java.en.Then;

public class StepsShoppingCartPage {

    @Then("I verify that \"SHOPPING CART\" page is open")
    public void i_verify_that_shopping_page_is_open() {
        new ShoppingCartPage().checkIfPageWasOpen();
    }

    @Then("I verify that name and price are of the chosen item")
    public void i_verify_that_name_and_price_are_of_the_chosen_item() {
        new ShoppingCartPage().verifyNameAndPrices();
    }

    @Then("I verify that \"SUBTOTAL\" amount is equal to the sum of \"GRAND TOTAL\"")
    public void i_verify_that_subtotal_amount_is_equal_to_the_sum_of_grand_total() {
        new ShoppingCartPage().verifySubtotalAndGrandTotal();
    }
}