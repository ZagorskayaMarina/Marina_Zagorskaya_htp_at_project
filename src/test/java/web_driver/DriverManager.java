package web_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    public static WebDriver getDriver(Config config) throws MalformedURLException {
        switch (config){
            case CHROME:
                return getChromeDriver();
            case FF:
                return getFirefoxDriver();
            case REMOTE:
                return getRemoteDriver();
            default:
                throw null;
        }
    }

    private static WebDriver getChromeDriver() {
        System.out.println("Print from getChromeDriver");
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        //options.addArguments("--headless"); //head chrom window
        //options.addArguments("--disable-gpu");
        //options.addArguments("--window-size=1920,1200");
        //options.addArguments("--ignore-certificate--errors");
        //System.setProperty("webdriver.chrome.driver", "c:\\Users\\user\\Java\\webdrivers\\chrome\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.silentOutput", "true");
        return new ChromeDriver(options);
    }

    private static WebDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "c:\\Users\\user\\Java\\webdrivers\\firefox\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", "true");
        return new FirefoxDriver();
    }

    private static WebDriver getRemoteDriver() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        return webDriver;
    }
}
