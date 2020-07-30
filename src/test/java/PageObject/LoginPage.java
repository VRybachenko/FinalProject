package PageObject;

import java.util.concurrent.TimeUnit;

import driver.manager.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static driver.manager.Driver.getDriver;

public class LoginPage extends AbstractPage {
    private static final By CLOSE_BUTTON = By.id("close-fixedban");
    private static final By CREATE_AN_ACCOUNT = By.cssSelector("a[title='Create an Account']");

    public void tapOnCreateAnAccountButton() {
        WebElement tapOnCreateAnAccountButton = getDriver().findElement(CREATE_AN_ACCOUNT);
        //((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", tapOnCreateAnAccountButton);
        tapOnCreateAnAccountButton.click();
    }

    public void tapOnCloseButton() {
        WebElement closeButton = getDriver().findElement(CLOSE_BUTTON);
        closeButton.isDisplayed();
        closeButton.click();
    }
}
