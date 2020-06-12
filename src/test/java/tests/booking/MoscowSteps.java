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
    /*private static final Logger LOGGER = LogManager.getLogger(ParisSteps.class);
    static WebDriver driver;
    String JSONBookingTests = "src/test/resources/booking/bookingTestsData";
    MainBookingPage mainBookingPage;
    HotelsPage hotelsPage;
    GsonParser gsonParser;
    BookingTestData test;
    int priceOfHotel;
    int budgetCategory;


    @Before
    public static void beforeTest(){
        LOGGER.info("Initializing WebDriver");
        Driver.initDriver(Config.CHROME);
    }

    @Given("I go to booking.com")
    public void goToSite() throws InterruptedException {
        driver = Driver.getDriver();
        driver.navigate().to("https://booking.com/");
        Thread.sleep(3000);
    }

    @Then("I get data to search from JSON file")
    public void enterData() throws FileNotFoundException, InterruptedException {
        gsonParser  = new GsonParser();
        test = gsonParser.parseGSONBookingData(JSONBookingTests, 2);
        mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.enterCity(test.city);
        mainBookingPage.enterDate(test.dayBeforeStartDate,test.dayOfStay);
        mainBookingPage.enterGuestData(test.adults,test.children,test.rooms);
        mainBookingPage.search();
        Thread.sleep(3000);
    }

    @And("I select hotel in max price category")
    public void selectPriceCategory1() throws InterruptedException {
        hotelsPage = new HotelsPage(driver);
        hotelsPage.selectPriceCategory(1);
        budgetCategory = hotelsPage.retrievePriceFromCategory(1);
        Thread.sleep(3000);
    }

    @And("I find hotel with min price")
    public void filterPrice() throws FileNotFoundException, InterruptedException {
        hotelsPage.sortByPrice();
        Thread.sleep(3000);
        test = gsonParser.parseGSONBookingData(JSONBookingTests, 1);//need refactoring
        priceOfHotel = hotelsPage.getPriceOfHotelPerNight(1, test.dayOfStay);
    }

    @And("I compare hotel's category price with price of hotel")
    public void comparePrice(){
        System.out.println("priceOfHotel is: " + priceOfHotel + " budgetCategory is: " + budgetCategory);
        Assert.assertTrue("Verify that the price per night in hotel more than priseOfCathegory", priceOfHotel>budgetCategory);
    }*/
}
