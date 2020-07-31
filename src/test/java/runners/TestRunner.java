package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/"},
        glue = "stepDefinitions",
        tags = {"not @Muted "},
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm", "pretty", "json:target/cucumber-report/report.json"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
