package web_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.MyProperty;
import web_driver.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HeaderMainBooking {
    WebDriver driver = Driver.getDriver();
    private String propPath = "src/test/resources/booking/mail.properties";
    private Properties properties = MyProperty.getProperties(propPath);

    @FindBy(xpath = "//div[@id='cross-product-bar']/div/span")
    private WebElement stays;

    @FindBy(xpath = "//a[@data-decider-header='flights']")
    private WebElement flights;

    @FindBy(xpath = "//a[contains(@rentalcars,'rentalcars ')]")
    private WebElement carRentals;

    @FindBy(xpath = "//a[@data-decider-header='attractions']")
    private WebElement attractions;

    @FindBy(xpath = "//a[@data-decider-header='rideways']")
    private WebElement taxis;

    @FindBy(xpath = "//a[@data-title='Choose your currency']")
    private WebElement currency;

    @FindBy(xpath = "//a[@data-title='Select your language']")
    private WebElement language;

    @FindBy(xpath = "//a[@data-title='View your notifications']")
    private WebElement notifications;

    @FindBy(xpath = "//a[@data-title='Customer Service Help Centre']")
    private WebElement helpCenter;

    @FindBy(xpath = "//li[@id='add_property_topbar']")
    private WebElement property;

    @FindBy(xpath = "//li[@id='current_account']")
    private WebElement currentAcc;

    @FindBy(xpath = "//*[@id='logo_no_globe_new_logo']")
    private WebElement logo;

    public HeaderMainBooking(WebDriver driver){
        this.driver = driver;
    }

    public boolean verifyDisplayingElements(){
        List<WebElement> elements = new ArrayList<>();

    }

}
