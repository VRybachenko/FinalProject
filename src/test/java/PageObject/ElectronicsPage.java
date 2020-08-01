package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static driver.manager.Driver.getDriver;
import static utils.StringUtils.extractIntFromString;

public class ElectronicsPage extends AbstractPage {

    private static final By VIEW_AS_LIST_BUTTON = By.cssSelector(".category-products > .toolbar:nth-of-type(1) .list");
    private static final By OPEN_SELECT_ITEMS_ON_PAGE = By.cssSelector(".category-products > .toolbar > .pager > .count-container > .limiter > " +
                                                                               "select[title='Results per page']");
    private static final By AMOUNT_ITEMS_ON_PAGE = By.cssSelector(".category-products > .toolbar:nth-of-type(1) .pager strong");
    private static final By LIST_OF_ITEMS_ON_PAGE = By.cssSelector("ol#products-list > li");
    private static final By LIST_OF_PAGES = By.cssSelector(".category-products > .toolbar > .pager > .pages > ol > li");
    private static final By NEXT_PAGE_BUTTON = By.cssSelector(".category-products > .toolbar > .pager > .pages > ol  a[title='Next']");


    public void tapOnViewAsListButton() {
        WebElement viewAsListButton = getDriver().findElement(VIEW_AS_LIST_BUTTON);
        viewAsListButton.click();
    }

    public enum CountOfItemsOnPage {
        Five("5"),
        Ten("10"),
        Fifteen("15"),
        Twenty("20"),
        Twentyfive("25");

        private final String count;

        CountOfItemsOnPage(String count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return count;
        }
    }

    public void selectItemsOnPage(CountOfItemsOnPage count) {
        Select selectItemsOnPage = new Select(getDriver().findElement(OPEN_SELECT_ITEMS_ON_PAGE));
        selectItemsOnPage.selectByVisibleText(count.toString());
    }

    public void verifyTheCountOfElementsOnThePage() {
        List<WebElement> listOfElements = new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(LIST_OF_ITEMS_ON_PAGE));
        int amountProductOnPage = listOfElements.size();

        String items = getDriver().findElement(AMOUNT_ITEMS_ON_PAGE).getText();
        int counterAmount = extractIntFromString(items);

        Assert.assertEquals(amountProductOnPage, counterAmount, "Invalid count");
    }

    public void verifyTheCountOfElementsOnEachPage(int counter) {
        int countOfPages = getDriver().findElements(LIST_OF_PAGES).size();

        for (int i = 1; i < countOfPages; i++) {
            List<WebElement> listOfElements = new WebDriverWait(getDriver(), 10).until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(LIST_OF_ITEMS_ON_PAGE));
            int amountProductOnPage = listOfElements.size();
            if (i < countOfPages - 1) {
                Assert.assertEquals(amountProductOnPage, counter, "");
                getDriver().findElement(NEXT_PAGE_BUTTON).click();
            } else {
                Assert.assertTrue(amountProductOnPage <= counter, "Invalid count");
            }
        }
    }
}