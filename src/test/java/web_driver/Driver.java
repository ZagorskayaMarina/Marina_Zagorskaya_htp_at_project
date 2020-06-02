package web_driver;

import org.openqa.selenium.WebDriver;

public class Driver {
    private static  ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(Config config) {
        if (null == driver.get()) {
            try {
                driver.set(DriverManager.getDriver(config));
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static WebDriver getDriver() {
        if (null == driver.get()) {
            try {
                driver.set(DriverManager.getDriver(Config.CHROME)); //Config.REMOTE
                System.out.println("Print from Driver");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return driver.get();
    }

    public static void destroy() {
        driver.get().close();
        driver.get().quit();
    }

    /*private Driver() throws IllegalAccessException{
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
    }*/
}
