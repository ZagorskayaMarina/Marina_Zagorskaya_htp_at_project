package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import web_driver.Config;
import web_driver.Driver;

public class BaseSteps {
    @BeforeClass
    public void initDriver() {
        Driver.initDriver(Config.CHROME);
    }

    @AfterClass
    public void closeDriver() {
        Driver.destroy();
    }
}
