package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static driver.manager.Driver.getDriver;

public class RegistrationPage extends AbstractPage {

    public RegistrationPage() {
        //((JavascriptExecutor) getDriver()).executeScript("document.getElementById('close-fixedban').click()");
    }

    private static final By FIRST_NAME_FIELD = By.xpath("//input[@id='firstname']");

    public void checkFirstNameField() {
        WebElement firstNameField = getDriver().findElement(FIRST_NAME_FIELD);
        firstNameField.isDisplayed();
    }
}
