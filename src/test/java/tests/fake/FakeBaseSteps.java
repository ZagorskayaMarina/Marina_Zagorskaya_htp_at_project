package tests.fake;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import web_driver.Config;
import web_driver.Driver;

public class FakeBaseSteps {

    private static final Logger LOGGER = LogManager.getLogger(FakeBaseSteps.class);

    @Before
    public static void beforeTest(){
        LOGGER.info("Initializing WebDriver..");
        Driver.initDriver(Config.CHROME);
        //Driver.initDriver(Config.REMOTE);
    }

    @After
    public static void afterTest(){
        LOGGER.info("Killing WebDriver ..");
        Driver.destroy();
    }
}
