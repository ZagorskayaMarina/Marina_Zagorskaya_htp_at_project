package tests.booking;

import application_items.booking.BookingTestData;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utility.GsonParser;
import web_driver.Config;
import web_driver.Driver;
import web_pages.HotelsPage;
import web_pages.MainBookingPage;

import java.io.FileNotFoundException;

public class MoscowSteps {
    private static final Logger LOGGER = LogManager.getLogger(ParisSteps.class);
    static WebDriver driver;
    String JSONBookingTests = "src/test/resources/booking/bookingTestsData";
    MainBookingPage mainBookingPage;
    HotelsPage hotelsPage;
    GsonParser gsonParser;
    BookingTestData test;
    int priceOfHotel;
    int budgetCategory;

    @And("I compare price Moscow")
    public void comparePriceMoscow(){
        System.out.println("priceOfHotel is: " + priceOfHotel + " budgetCategory is: " + budgetCategory);
        Assert.assertTrue("Verify that the price per night in hotel more than priseOfCathegory", priceOfHotel>budgetCategory);
    }
}
