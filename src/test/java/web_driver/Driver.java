package web_driver;

import org.openqa.selenium.WebDriver;

public class Driver {

    private Driver() throws IllegalAccessException{
        throw new IllegalAccessException("Utility class");
    }

    private static WebDriver driver;

    public static WebDriver initDriver(Config config) {
        if (null == driver) {
            driver = DriverManager.getDriver(config);
        }
        return null;
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            driver = DriverManager.getDriver(Config.CHROME);
        }
        return driver;
    }

    public static void destroy() {
        driver.close();
        driver.quit();
    }
}
