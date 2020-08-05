package PageObject;

import java.util.Random;

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
    private static final By REGISTER_BUTTON = By.cssSelector("button[title='Register']");

    Random randomGenerator = new Random();

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

    public void inputFirstName(String firstName) {
        WebElement firstNameField = getDriver().findElement(FIRST_NAME_FIELD);
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        WebElement lastNameField = getDriver().findElement(LAST_NAME_FIELD);
        lastNameField.sendKeys(lastName);
    }

    public void inputEmailAddress() {
        WebElement emailAddressField = getDriver().findElement(EMAIL_ADDRESS_FIELD);
        int randomInt = randomGenerator.nextInt(10000);
        emailAddressField.sendKeys("TestTestovich" + randomInt + "@gmail.com");
    }

    public void inputPassword(String password) {
        WebElement passwordField = getDriver().findElement(PASSWORD_FIELD);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", passwordField);
        passwordField.sendKeys(password);
    }

    public void confirmPassword(String password) {
        WebElement confirmPasswordField = getDriver().findElement(CONFIRM_PASSWORD_FIELD);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", confirmPasswordField);
        confirmPasswordField.sendKeys(password);
    }

    public void tapOnRegisterButton() {
        WebElement registerButton = getDriver().findElement(REGISTER_BUTTON);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", registerButton);
        registerButton.click();
    }
}