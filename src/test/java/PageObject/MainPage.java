package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static driver.manager.Driver.getDriver;

public class MainPage extends AbstractPage {

    Actions actions = new Actions(getDriver());

    private static final By ACCOUNT_BUTTON = By.linkText("ACCOUNT");
    private static final By MY_ACCOUNT_BUTTON = By.cssSelector("#header-account [title='My Account']");
    private static final By HOME_AND_DECOR = By.linkText("HOME & DECOR");
    private static final By ELECTRONICS = By.linkText("Electronics");

    public void tapOnAccountButton() {
        WebElement accountButton = getDriver().findElement(ACCOUNT_BUTTON);
        accountButton.isDisplayed();
        accountButton.click();
    }

    public void tapOnMyAccountButton() {
        WebElement myAccountButton = getDriver().findElement(MY_ACCOUNT_BUTTON);
        myAccountButton.isDisplayed();
        myAccountButton.click();
    }

    public void moveTheCursorToHomeAndDecor() {
        WebElement homeAndDecorButton = getDriver().findElement(HOME_AND_DECOR);
        actions.moveToElement(homeAndDecorButton).build().perform();
    }

    public void choseElectronicsPageFromList() {
        WebElement electronicsPage = getDriver().findElement(ELECTRONICS);
        electronicsPage.click();
    }
}
