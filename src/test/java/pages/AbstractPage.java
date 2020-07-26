package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractPage {

    protected static WebDriver driver;

    private static final By OPEN_SELECT_LANGUAGE_LIST = By.xpath("//select[@id='select-language']");
    private static final By CHOOSE_ENGLISH_LANGUAGE = By.xpath(".//*[@id='select-language']/option[@value='http://magento.mainacad.com/index" +
                                                                       ".php/lesson_12/?%2Findex_php%2Flesson_12%2F=&___from_store=lesson_12']");


    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://magento.mainacad.com/");
        driver.manage().window().maximize();
    }

    public void finish() {
        driver.quit();
    }

    //откраем выпадающий список SelectLanguage
    public void openSelectLanguageList() {
        WebElement openSelectLanguageList = driver.findElement(OPEN_SELECT_LANGUAGE_LIST);
        openSelectLanguageList.click();
    }

    public void chooseEnglishLanguage() {
        WebElement chooseEnglishLanguage = driver.findElement(CHOOSE_ENGLISH_LANGUAGE);
        chooseEnglishLanguage.click();
    }
}
