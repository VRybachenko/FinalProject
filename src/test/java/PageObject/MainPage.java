package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static driver.manager.Driver.getDriver;

public class MainPage extends AbstractPage {
    private static final By ACCOUNT_BUTTON = By.linkText("ACCOUNT");
    private static final By MY_ACCOUNT_BUTTON = By.cssSelector("#header-account [title='My Account']");

    public void tapOnAccountButton() {
        WebElement tapOnAccountButton = getDriver().findElement(ACCOUNT_BUTTON);
        tapOnAccountButton.isDisplayed();
        tapOnAccountButton.click();
    }

    public void tapOnMyAccountButton() {
        WebElement tapOnMyAccountButton = getDriver().findElement(MY_ACCOUNT_BUTTON);
        tapOnMyAccountButton.isDisplayed();
        tapOnMyAccountButton.click();
    }
}
