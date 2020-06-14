package tests.cucumber;

import application_items.booking.BookingTestData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.GsonParser;
import web_driver.Driver;
import web_pages.HeaderMainBooking;
import web_pages.HotelsPage;
import web_pages.MainBookingPage;

import java.util.ArrayList;
import java.util.List;

public class CheckHeaderElementsSteps {
    private static final Logger LOGGER = LogManager.getLogger(CheckHeaderElementsSteps.class);
    static WebDriver driver;
    MainBookingPage mainBookingPage;
    HeaderMainBooking headerMainBooking;

    @Given("I go5 to site '(.*)'")
    public void goToSite5(String site) throws InterruptedException {
        LOGGER.debug("I go5 to site");
        driver = Driver.getDriver();
        driver.navigate().to(site);
        Thread.sleep(3000);
    }

    @Then("I login3")
    public void login3() throws InterruptedException {
        LOGGER.debug("I login3");
        mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.login();
        Thread.sleep(3000);
    }

    @And("I check displaying all header elements")
    public void check_displaying_all_header_elements(){
        LOGGER.debug("I check displaying all header elements");
        Boolean displayingCondition = false;
        headerMainBooking = new HeaderMainBooking(driver);
        List<WebElement> elements = new ArrayList<>();
        elements.add(headerMainBooking.stays);
        elements.add(headerMainBooking.carRentals);
        elements.add(headerMainBooking.attractions);
        elements.add(headerMainBooking.taxis);
        elements.add(headerMainBooking.currency);
        elements.add(headerMainBooking.language);
        elements.add(headerMainBooking.notifications);
        elements.add(headerMainBooking.helpCenter);
        elements.add(headerMainBooking.property);
        elements.add(headerMainBooking.currentAcc);
        elements.add(headerMainBooking.logo);

        for (int i = 0; i < elements.size(); i++){
            displayingCondition = elements.get(i).isDisplayed();
            if (!displayingCondition){
                break;
            }
        }
        Assert.assertTrue("All elements is display", displayingCondition);
    }

}
