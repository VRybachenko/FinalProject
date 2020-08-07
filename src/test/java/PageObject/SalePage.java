package PageObject;

import java.util.ArrayList;
import java.util.List;

import dto.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static driver.manager.Driver.getDriver;
import static utils.StringUtils.extractDoubleFromString;

public class SalePage {

    private static final By GRID_VIEW_BUTTON = By.cssSelector(".category-products > .toolbar > .sorter > .view-mode > strong[title='Grid']");
    private static final By OPEN_SELECT_ITEMS_ON_PAGE = By.cssSelector(".category-products > .toolbar > .pager > .count-container > .limiter > " +
                                                                               "select[title='Results per page']");
    private static final By ITEM = By.cssSelector(".item");
    private static final By TITLE = By.cssSelector(".product-name");
    private static final By PRICES_WITHOUT_SALE = By.cssSelector(".old-price > .price");
    private static final By PRICES_WITH_SALE = By.cssSelector(".special-price");

    public void tapOnGridViewButton() {
        WebElement gridViewButton = getDriver().findElement(GRID_VIEW_BUTTON);
        gridViewButton.click();
    }

    public enum CountOfItemsOnSalePage {
        Twelve("12"),
        TwentyFour("24"),
        ThirtySix("36");

        private final String count;

        CountOfItemsOnSalePage(String count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return count;
        }
    }

    public void selectItemsOnSalePage(CountOfItemsOnSalePage count) {
        Select selectItemsOnPage = new Select(getDriver().findElement(OPEN_SELECT_ITEMS_ON_PAGE));
        selectItemsOnPage.selectByVisibleText(count.toString());
    }

    public void verifyThatTheOlePriceIsHigherThanASalePrice() {
        List<WebElement> listOfItems = new WebDriverWait(getDriver(), 10).until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(ITEM));

        List<Item> items = new ArrayList<>();

        for (WebElement webItem : listOfItems) {
            Item item = Item.builder()
                            .title(webItem.findElement(TITLE).getText())
                            .price(extractDoubleFromString(webItem.findElement(PRICES_WITHOUT_SALE).getText()))
                            .salePrice(extractDoubleFromString(webItem.findElement(PRICES_WITH_SALE).getText()))
                            .build();
            items.add(item);
        }


        for (Item item : items) {
            Assert.assertTrue(item.getPrice() > item.getSalePrice(), "Old price is higher than a sale " +
                    "price!");

        }
    }
}