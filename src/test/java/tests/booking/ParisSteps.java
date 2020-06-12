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

public class ParisSteps {

    private static final Logger LOGGER = LogManager.getLogger(ParisSteps.class);
    static WebDriver driver;
    String JSONBookingTests = "src/test/resources/booking/bookingTestsData";
    MainBookingPage mainBookingPage;
    HotelsPage hotelsPage;
    GsonParser gsonParser;
    BookingTestData test;
    int priceOfHotel;
    int budgetCategory;


    /*@Before
    public static void beforeTest(){
        LOGGER.info("Initializing WebDriver");
        Driver.initDriver(Config.CHROME);
    }*/

    @Given("I go to site '(.*)'")
    public void goToSite(String site) throws InterruptedException {
        driver = Driver.getDriver();
        driver.navigate().to(site);
        Thread.sleep(3000);
    }

    @Then("I get data to search from JSON file '(.*)' element in array")
    public void getData(int i) throws FileNotFoundException, InterruptedException {
        gsonParser  = new GsonParser();
        test = gsonParser.parseGSONBookingData(JSONBookingTests, i);
        mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.enterCity(test.city);
        mainBookingPage.enterDate(test.dayBeforeStartDate,test.dayOfStay);
        mainBookingPage.enterGuestData(test.adults,test.children,test.rooms);
        mainBookingPage.search();
        Thread.sleep(3000);
    }

    @And("I select hotel in  price category '(.*)'")
    public void selectPriceCategory(int i) throws InterruptedException {
        hotelsPage = new HotelsPage(driver);
        hotelsPage.selectPriceCategory(i);
        budgetCategory = hotelsPage.retrievePriceFromCategory(i);
        Thread.sleep(3000);
    }

    @And("I sort hotels by price from min to max")
    public void sortHotels() throws InterruptedException {
        hotelsPage.sortByPrice();
        Thread.sleep(3000);
    }

    @And("I select '(.*)' hotel")
    public void selectHotel(int i) throws FileNotFoundException{
        test = gsonParser.parseGSONBookingData(JSONBookingTests, 1);//need refactoring
        priceOfHotel = hotelsPage.getPriceOfHotelPerNight(i, test.dayOfStay);
    }

    @And("I compare hotel's category price with price of hotel")
    public void comparePrice(){
        System.out.println("priceOfHotel is: " + priceOfHotel + " budgetCategory is: " + budgetCategory);
        Assert.assertTrue("Verify that the price per night in hotel more than priseOfCathegory", priceOfHotel>budgetCategory);
    }

}
