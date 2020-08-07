package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static driver.manager.Driver.getDriver;
import static driver.manager.Driver.killDriver;

public class Hooks {

    /* @AfterStep
    public void tearDown1(Scenario scenario) {
            byte[] picture = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(picture, "image/png");
    } */

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] picture = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(picture, "image/png");
        }
        killDriver();
    }
}