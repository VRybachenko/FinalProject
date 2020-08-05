package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static PageObject.ElectronicsPage.nameOfTitleOfElementOnElectronicsPage;
import static driver.manager.Driver.getDriver;

public class MyWishListPage extends AbstractPage {

    public static final By PRODUCT_NAME_FIELD = By.cssSelector(".product-name [title]");

    public static volatile String nameOfTitleOfElementOnMyWishListPage;

    public void checkProductNameField() {
        WebElement productNameField = getDriver().findElement(PRODUCT_NAME_FIELD);
        nameOfTitleOfElementOnMyWishListPage = productNameField.getText();

        Assert.assertEquals(nameOfTitleOfElementOnMyWishListPage, nameOfTitleOfElementOnElectronicsPage, "Invalid value");
    }
}