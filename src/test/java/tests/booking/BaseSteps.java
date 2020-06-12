package tests.booking;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import web_driver.Config;
import web_driver.Driver;


public class BaseSteps {
    private static final Logger LOGGER = LogManager.getLogger(BaseSteps.class);

    @Before
    public static void beforeTest(){
        LOGGER.info("Initializing WebDriver");
        Driver.initDriver(Config.CHROME);
    }

    @After
    public static void afterTest(){
        LOGGER.info("Kill WebDriver");
        Driver.destroy();
    }
}
