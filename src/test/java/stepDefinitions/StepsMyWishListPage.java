package stepDefinitions;

import PageObject.MyWishListPage;
import io.cucumber.java.en.Then;

public class StepsMyWishListPage {

    @Then("I check if name of the chosen item is present")
    public void i_check_if_name_of_the_chosen_item_is_present() {
        new MyWishListPage().checkProductNameField();
    }
}