import io.cucumber.java.After;

import static driver.manager.Driver.killDriver;

public class Hooks {
    @After
    public  void tearDown(){
        killDriver();
    }
}
