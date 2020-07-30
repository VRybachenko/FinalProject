package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static driver.manager.Driver.getDriver;

public class RegistrationPage extends AbstractPage {

    private static final By FIRST_NAME_FIELD = By.xpath("//input[@id='firstname']");
    private static final By LAST_NAME_FIELD = By.xpath("//input[@id='lastname']");
    private static final By EMAIL_ADDRESS_FIELD = By.xpath("//input[@id='email_address']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@id='password']");
    private static final By CONFIRM_PASSWORD_FIELD = By.xpath("//input[@id='confirmation']");

    public void checkFirstNameFieldIsPresent() {
        WebElement firstNameField = getDriver().findElement(FIRST_NAME_FIELD);
        firstNameField.isDisplayed();
    }

    public void checkLastNameFieldIsPresent() {
        WebElement lastNameField = getDriver().findElement(LAST_NAME_FIELD);
        lastNameField.isDisplayed();
    }

    public void checkEmailAddressFieldIsPresent() {
        WebElement emailAddressField = getDriver().findElement(EMAIL_ADDRESS_FIELD);
        emailAddressField.isDisplayed();
    }

    public void checkPasswordFieldIsPresent() {
        WebElement passwordField = getDriver().findElement(PASSWORD_FIELD);
        passwordField.isDisplayed();
    }

    public void checkConfirmPassIsPresent() {
        WebElement confirmPasswordField = getDriver().findElement(CONFIRM_PASSWORD_FIELD);
        confirmPasswordField.isDisplayed();
    }
}