package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static PageObject.ElectronicsPage.getNameOfTitleOfElementOnElectronicsPage;
import static driver.manager.Driver.getDriver;

public class MyWishListPage extends AbstractPage {

    public static final By PRODUCT_NAME_FIELD = By.cssSelector(".product-name [title]");

    private static ThreadLocal<String> nameOfTitleOfElementOnMyWishListPage = new ThreadLocal<>();

    public static synchronized String getNameOfTitleOfElementOnMyWishListPage() {
        return nameOfTitleOfElementOnMyWishListPage.get();
    }

    public synchronized void setNameOfTitleOfElementOnMyWishListPage(String nameOfTitleOfElementOnMyWishListPage) {
        MyWishListPage.nameOfTitleOfElementOnMyWishListPage.set(nameOfTitleOfElementOnMyWishListPage);
    }

    public void checkProductNameField() {
        WebElement productNameField = getDriver().findElement(PRODUCT_NAME_FIELD);
        setNameOfTitleOfElementOnMyWishListPage(productNameField.getText());

        Assert.assertEquals(getNameOfTitleOfElementOnMyWishListPage(), getNameOfTitleOfElementOnElectronicsPage(), "Invalid value");
    }
}