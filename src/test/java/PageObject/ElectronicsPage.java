package PageObject;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    private static final By LIST_OF_ITEMS_ON_PAGE_IN_LIST_VIEW = By.cssSelector("ol#products-list > li");
    private static final By LIST_OF_PAGES = By.cssSelector(".category-products > .toolbar > .pager > .pages > ol > li");
    private static final By NEXT_PAGE_BUTTON = By.cssSelector(".category-products > .toolbar > .pager > .pages > ol  a[title='Next']");
    private static final By SORT_BY_LIST = By.cssSelector(".category-products > .toolbar > .sorter > .sort-by > select[title='Sort By']");
    private static final By PRICE_OF_PRODUCTS_IN_LIST_VIEW = By.cssSelector(
            "li .regular-price > .price, li > .product-shop .price-from > .price, li .product-shop .price-to > .price");
    private static final By FIRST_PRICE_FROM_SHOP_BY = By.linkText("$0.00 - $999.99 (11)");
    private static final By ADD_WISHLIST_BUTTON = By.linkText("Add to Wishlist");
    private static final By TITLE_OF_ELEMENT = By.cssSelector("ol#products-list > li .product-name");
    private static final By GRID_VIEW_BUTTON = By.cssSelector(".category-products > .toolbar > .sorter > .view-mode > strong[title='Grid']");
    private static final By LIST_OF_ITEMS_ON_PAGE_IN_GRID_VIEW = By.cssSelector(".first.last.odd.products-grid.products-grid--max-4-col > li");
    private static final By LIST_OF_BUTTON_ON_PAGE_IN_GRID_VIEW = By.cssSelector("li > .product-info  a[title='View Details'] , li > .product-info  button");
    private static final By LIST_OF_NAME_OF_ITEMS_ON_PAGE_IN_GRID_VIEW = By.cssSelector("li > .product-info > .product-name");
    private static final By PRICE_OF_PRODUCTS_IN_GRID_VIEW = By.cssSelector("li .regular-price > .price, li > .product-shop .price-from > .price");

    public static volatile WebElement element;

    private static ThreadLocal<String> nameOfTitleOfElementOnElectronicsPageInListView = new ThreadLocal<>();
    public static synchronized String getNameOfTitleOfElementOnElectronicsPageInListView() {
        return nameOfTitleOfElementOnElectronicsPageInListView.get();
    }
    public synchronized void setNameOfTitleOfElementOnElectronicsPageInListView(String nameOfTitleOfElementOnElectronicsPage) {
        ElectronicsPage.nameOfTitleOfElementOnElectronicsPageInListView.set(nameOfTitleOfElementOnElectronicsPage);
    }

    private static ThreadLocal<String> nameOfTitleOfElementOnElectronicsPageInGridView = new ThreadLocal<>();
    public static synchronized String getNameOfTitleOfElementOnElectronicsPageInGridView() {
        return nameOfTitleOfElementOnElectronicsPageInGridView.get();
    }
    public synchronized void setNameOfTitleOfElementOnElectronicsPageInGridView(String nameOfTitleOfElementOnElectronicsPageInGridView) {
        ElectronicsPage.nameOfTitleOfElementOnElectronicsPageInGridView.set(nameOfTitleOfElementOnElectronicsPageInGridView);
    }

    private static ThreadLocal<String> priceOfElementOnElectronicsPageInGridView = new ThreadLocal<>();
    public static synchronized String getPriceOfElementOnElectronicsPageInGridView() {
        return priceOfElementOnElectronicsPageInGridView.get();
    }
    public synchronized void setPriceOfElementOnElectronicsPageInGridView(String priceOfElementOnElectronicsPageInGridView) {
        ElectronicsPage.priceOfElementOnElectronicsPageInGridView.set(priceOfElementOnElectronicsPageInGridView);
    }

    public void tapOnViewAsListButton() {
        WebElement viewAsListButton = getDriver().findElement(VIEW_AS_LIST_BUTTON);
        viewAsListButton.click();
    }

    public enum CountOfItemsOnElectronicsPageInListView {
        Five("5"),
        Ten("10"),
        Fifteen("15"),
        Twenty("20"),
        Twentyfive("25");

        private final String count;

        CountOfItemsOnElectronicsPageInListView(String count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return count;
        }
    }

    public void selectItemsOnPage(CountOfItemsOnElectronicsPageInListView count) {
        Select selectItemsOnPage = new Select(getDriver().findElement(OPEN_SELECT_ITEMS_ON_PAGE));
        selectItemsOnPage.selectByVisibleText(count.toString());
    }

    public void verifyTheCountOfElementsOnThePage() {
        List<WebElement> listOfElements = new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                LIST_OF_ITEMS_ON_PAGE_IN_LIST_VIEW));
        int amountProductOnPage = listOfElements.size();

        String items = getDriver().findElement(AMOUNT_ITEMS_ON_PAGE).getText();
        int counterAmount = extractIntFromString(items);

        Assert.assertEquals(amountProductOnPage, counterAmount, "Invalid count");
    }

    public void verifyTheCountOfElementsOnEachPage(int counter) {
        int countOfPages = getDriver().findElements(LIST_OF_PAGES).size();

        for (int i = 1; i < countOfPages; i++) {
            List<WebElement> listOfElements = new WebDriverWait(getDriver(), 10).until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(LIST_OF_ITEMS_ON_PAGE_IN_LIST_VIEW));
            int amountProductOnPage = listOfElements.size();
            if (i < countOfPages - 1) {
                Assert.assertEquals(amountProductOnPage, counter, "");
                getDriver().findElement(NEXT_PAGE_BUTTON).click();
            } else {
                Assert.assertTrue(amountProductOnPage <= counter, "Invalid count");
            }
        }
    }

    public enum SortBy {
        Position("Position"),
        Name("Name"),
        Price("Price");

        private final String typeOfSort;

        SortBy(String count) {
            this.typeOfSort = count;
        }

        @Override
        public String toString() {
            return typeOfSort;
        }
    }

    public void selectTypeOfSortBy(SortBy typeOfSort) {
        Select selectTypeOfSortBy = new Select(getDriver().findElement(SORT_BY_LIST));
        selectTypeOfSortBy.selectByVisibleText(typeOfSort.toString());
    }

    public void verifySortByPrice() {
        List<WebElement> listOfPriceWebElement = new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                PRICE_OF_PRODUCTS_IN_LIST_VIEW));

        List<Double> listOfPriceDouble;
        listOfPriceDouble = listOfPriceWebElement.stream()
                                                 .map(WebElement::getText)
                                                 .map(s -> s.replaceAll("[^a-zA-Z0-9.]", ""))
                                                 .map(Double::parseDouble)
                                                 .collect(Collectors.toList());


        for (int i = 0; i < listOfPriceDouble.size() - 2; i++) {
            double before = listOfPriceDouble.get(i);
            double after = listOfPriceDouble.get(i + 1);
            Assert.assertTrue(before < after,
                              String.format("Expected that previous value '%s' should be less that nex one '%s'", before, after));
        }
    }

    public void tapOnFirstPriceFromShopBy() {
        WebElement firstPriceFromShopBy = getDriver().findElement(FIRST_PRICE_FROM_SHOP_BY);
        firstPriceFromShopBy.click();
    }

    public void verifyThatThePriceOfItemsIsLessThenIndicatedPrice() {
        List<WebElement> listOfPriceWebElement = new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                PRICE_OF_PRODUCTS_IN_LIST_VIEW));

        List<Double> listOfPriceDouble;
        listOfPriceDouble = listOfPriceWebElement.stream()
                                                 .map(WebElement::getText)
                                                 .map(s -> s.replaceAll("[^a-zA-Z0-9.]", ""))
                                                 .map(Double::parseDouble)
                                                 .collect(Collectors.toList());


        for (Double aDouble : listOfPriceDouble) {
            Assert.assertTrue(aDouble < 999.99, "Invalid price");
        }
    }

    public void chooseAnyRandomItemAndTapOnWishListButton() {
        List<WebElement> listOfElements = new WebDriverWait(getDriver(), 10).until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(LIST_OF_ITEMS_ON_PAGE_IN_LIST_VIEW));
        int amountOfElements = listOfElements.size();

        Random random = new Random();
        int randomElements = random.nextInt(amountOfElements);

        element = listOfElements.get(randomElements);
        setNameOfTitleOfElementOnElectronicsPageInListView(element.findElement(TITLE_OF_ELEMENT).getText());
        element.findElement(ADD_WISHLIST_BUTTON).click();
    }

    public void tapOnGridViewButtonOnElectronicsPage() {
        WebElement gridViewButton = getDriver().findElement(GRID_VIEW_BUTTON);
        gridViewButton.click();
    }

    public enum CountOfItemsOnElectronicsPageInGridView {
        Twelve("12"),
        TwentyFour("24"),
        ThirtySix("36");

        private final String count;

        CountOfItemsOnElectronicsPageInGridView(String count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return count;
        }
    }

    public void selectItemsOnElectronicsPageInGridView(CountOfItemsOnElectronicsPageInGridView count) {
        Select selectItemsOnPage = new Select(getDriver().findElement(OPEN_SELECT_ITEMS_ON_PAGE));
        selectItemsOnPage.selectByVisibleText(count.toString());
    }

    public void chooseAnyRandomItemAndTapOnAddToCartButton() {
        List<WebElement> listOfElements = new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                LIST_OF_ITEMS_ON_PAGE_IN_GRID_VIEW));

        int amountOfElements = listOfElements.size();
        Random random = new Random();

        while (true) {
            int randomElements = random.nextInt(amountOfElements);
            element = listOfElements.get(randomElements);
            if (!element.findElement(LIST_OF_BUTTON_ON_PAGE_IN_GRID_VIEW).getText().equals("VIEW DETAILS") && element.findElement(
                    PRICE_OF_PRODUCTS_IN_GRID_VIEW).isDisplayed()) {

                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                                                                 element.findElement(LIST_OF_NAME_OF_ITEMS_ON_PAGE_IN_GRID_VIEW));
                setNameOfTitleOfElementOnElectronicsPageInGridView(element.findElement(LIST_OF_NAME_OF_ITEMS_ON_PAGE_IN_GRID_VIEW).getText());

                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element.findElement(PRICE_OF_PRODUCTS_IN_GRID_VIEW));
                setPriceOfElementOnElectronicsPageInGridView(element.findElement(PRICE_OF_PRODUCTS_IN_GRID_VIEW).getText());

                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                                                                 element.findElement(LIST_OF_BUTTON_ON_PAGE_IN_GRID_VIEW));
                element.findElement(LIST_OF_BUTTON_ON_PAGE_IN_GRID_VIEW).click();

                break;
            }
        }
    }
}