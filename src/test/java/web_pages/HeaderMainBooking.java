package web_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.MyProperty;
import web_driver.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import static web_driver.Driver.getDriver;

public class HeaderMainBooking {
    public static WebDriver driver = Driver.getDriver();
    private String propPath = "src/test/resources/booking/mail.properties";
    private Properties properties = MyProperty.getProperties(propPath);

    @FindBy(xpath = "//div[@id='cross-product-bar']/div/span")
    public WebElement stays;

    @FindBy(xpath = "//a[@data-decider-header='flights']")
    public WebElement flights;

    @FindBy(xpath = "//a[contains(@data-ga-track,'rentalcars ')]")
    public WebElement carRentals;

    @FindBy(xpath = "//a[@data-decider-header='attractions']")
    public WebElement attractions;

    @FindBy(xpath = "//a[@data-decider-header='rideways']")
    public WebElement taxis;

    @FindBy(xpath = "//a[@data-title='Choose your currency']")
    public WebElement currency;

    @FindBy(xpath = "//a[@data-title='Select your language']")
    public WebElement language;

    @FindBy(xpath = "//a[@data-title='View your notifications']")
    public WebElement notifications;

    @FindBy(xpath = "//a[contains(@data-title, 'Help')]")
    public WebElement helpCenter;

    @FindBy(xpath = "//li[@id='add_property_topbar']")
    public WebElement property;

    @FindBy(xpath = "//li[@id='current_account']")
    public WebElement currentAcc;

    @FindBy(xpath = "//*[@id='logo_no_globe_new_logo']")
    public WebElement logo;

    public HeaderMainBooking(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public Boolean isElementPresented(WebElement element){
        Boolean elementCondition = false;
        try{
            elementCondition = element.isDisplayed();
        }
        catch (NoSuchElementException e){
            return  elementCondition;
        }

        if(!elementCondition){
            System.out.println(element);
        }

        return elementCondition;
    }


}
