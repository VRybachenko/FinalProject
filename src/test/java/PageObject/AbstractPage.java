package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.manager.Driver.getDriver;

public abstract class AbstractPage {

    private static final By OPEN_SELECT_LANGUAGE_LIST = By.id("select-language");

    public AbstractPage()  {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 3);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("close-fixedban")));
            ((JavascriptExecutor) getDriver()).executeScript("document.getElementById('close-fixedban').click()");
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public enum Language {
        ENG("English"),
        Less1("Lesson 1"),
        Less2("Lesson 2"),
        Less3("Lesson 3"),
        Less4("Lesson 4"),
        Less5("Lesson 5"),
        Less6("Lesson 6"),
        Less7("Lesson 7"),
        Less8("Lesson 8"),
        Less9("Lesson 9"),
        Less10("Lesson 10"),
        Less11("Lesson 11"),
        AUTO("Automation");

        private final String name;

        Language(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public void chooseAutomationLanguage(Language lang) {
        Select dropdown = new Select(getDriver().findElement(OPEN_SELECT_LANGUAGE_LIST));
        dropdown.selectByVisibleText(lang.toString());
    }
}