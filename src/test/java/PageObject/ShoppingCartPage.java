package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.testng.Assert;

import static PageObject.ElectronicsPage.getNameOfTitleOfElementOnElectronicsPageInGridView;
import static PageObject.ElectronicsPage.getPriceOfElementOnElectronicsPageInGridView;
import static driver.manager.Driver.getDriver;

public class ShoppingCartPage {

    private static final By NAME_OF_PRODUCTS = By.cssSelector(".product-cart-info .product-name");
    private static final By CART_PRICE = By.cssSelector(".product-cart-price  .price");
    private static final By SUBTOTAL_PRICE = By.cssSelector(".product-cart-total  .price");
    private static final By GRAND_TOTAL_PRICE = By.cssSelector(".product-cart-total  .price");

    private static ThreadLocal<String> nameOfTitleOfElementOnShoppingCartPage = new ThreadLocal<>();
    public static synchronized String getNameOfTitleOfElementOnShoppingCartPage() {
        return nameOfTitleOfElementOnShoppingCartPage.get();
    }
    public synchronized void setNameOfTitleOfElementOnShoppingCartPage(String nameOfTitleOfElementOnShoppingCartPage) {
        ShoppingCartPage.nameOfTitleOfElementOnShoppingCartPage.set(nameOfTitleOfElementOnShoppingCartPage);
    }

    private static ThreadLocal<String> priceOfElementOnShoppingCartPage = new ThreadLocal<>();
    public static synchronized String getPriceOfElementOnShoppingCartPage() {
        return priceOfElementOnShoppingCartPage.get();
    }
    public synchronized void setPriceOfElementOnShoppingCartPage(String priceOfElementOnShoppingCartPage) {
        ShoppingCartPage.priceOfElementOnShoppingCartPage.set(priceOfElementOnShoppingCartPage);
    }

    public static ThreadLocal<String> subtotalPriceOfElementOnShoppingCartPage = new ThreadLocal<>();
    public static synchronized String getSubtotalPriceOfElementOnShoppingCartPage() {
        return subtotalPriceOfElementOnShoppingCartPage.get();
    }
    public synchronized void setSubtotalPriceOfElementOnShoppingCartPage(String subtotalPriceOfElementOnShoppingCartPage) {
        ShoppingCartPage.subtotalPriceOfElementOnShoppingCartPage.set(subtotalPriceOfElementOnShoppingCartPage);
    }

    public static ThreadLocal<String> GrandTotalPriceOfElementOnShoppingCartPage = new ThreadLocal<>();
    public static synchronized String getGrandTotalPriceOfElementOnShoppingCartPage() {
        return GrandTotalPriceOfElementOnShoppingCartPage.get();
    }
    public synchronized void setGrandTotalPriceOfElementOnShoppingCartPage(String grandTotalPriceOfElementOnShoppingCartPage) {
        GrandTotalPriceOfElementOnShoppingCartPage.set(grandTotalPriceOfElementOnShoppingCartPage);
    }

    public void checkIfPageWasOpen() {
        String expectedTitle = "Shopping Cart";
        if (getDriver().getTitle().equals(expectedTitle)) {
            setNameOfTitleOfElementOnShoppingCartPage(getDriver().findElement(NAME_OF_PRODUCTS).getText());
            setPriceOfElementOnShoppingCartPage(getDriver().findElement(CART_PRICE).getText());
            setSubtotalPriceOfElementOnShoppingCartPage(getDriver().findElement(SUBTOTAL_PRICE).getText());
            setGrandTotalPriceOfElementOnShoppingCartPage(getDriver().findElement(GRAND_TOTAL_PRICE).getText());
        } else {
            throw new NotFoundException("The current page does not match the expected" + expectedTitle);
        }
    }

    public void verifyNameAndPrices() {
        Assert.assertEquals(getNameOfTitleOfElementOnShoppingCartPage(), getNameOfTitleOfElementOnElectronicsPageInGridView(), "Invalid Name Of Title!");
        Assert.assertEquals(getPriceOfElementOnShoppingCartPage(), getPriceOfElementOnElectronicsPageInGridView(), "Invalid value for Price!");
    }

    public void verifySubtotalAndGrandTotal() {
        Assert.assertEquals(getSubtotalPriceOfElementOnShoppingCartPage(), getGrandTotalPriceOfElementOnShoppingCartPage(), "Invalid value!");
    }
}