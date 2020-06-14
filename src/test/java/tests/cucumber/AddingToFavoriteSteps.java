package tests.cucumber;

import application_items.booking.BookingTestData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utility.GsonParser;
import web_driver.Driver;
import web_pages.*;

import java.io.FileNotFoundException;

public class AddingToFavoriteSteps {
    public static final Logger LOGGER = LogManager.getLogger(AddingToFavoriteSteps.class);
    static WebDriver driver;
    MainBookingPage mainBookingPage;
    HotelsPage hotelsPage;
    GsonParser gsonParser;
    BookingTestData test;
    String JSONBookingTests = "src/test/resources/booking/bookingTestsData";
    String color;

    @Given("I go4 to site '(.*)'")
    public void goToSite4(String site) throws InterruptedException {
        LOGGER.debug("I go4 to site");
        driver = Driver.getDriver();
        driver.navigate().to(site);
        Thread.sleep(3000);
    }

    @Then("I login")
    public void login() throws InterruptedException {
        LOGGER.debug("I login");
        MainBookingPage mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.login();
        Thread.sleep(3000);
    }

    @Then("I get4 data to search from JSON file '(.*)' element in array")
    public void getData4(int i) throws FileNotFoundException, InterruptedException {
        LOGGER.debug("I get4 data to search from JSON file");
        gsonParser = new GsonParser();
        test = gsonParser.parseGSONBookingData(JSONBookingTests, i);
        mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.cleanCityData();
        mainBookingPage.enterCity(test.city);
        mainBookingPage.enterDate(test.dayBeforeStartDate, test.dayOfStay);
        mainBookingPage.enterGuestData(test.adults, test.children, test.rooms);
        mainBookingPage.search();
        Thread.sleep(3000);
    }

    @Then("I save first hotel and get color of heart")
    public void saveFirstHotel() throws InterruptedException {
        LOGGER.debug("Save first hotel and get color of heart");
        HotelsPage hotelsPage = new HotelsPage(driver);
        hotelsPage.saveHotel("1");
        color = hotelsPage.getColor();
        Thread.sleep(3000);
    }

    @Then("I go to last page")
    public void goToLastPage() throws InterruptedException {
        LOGGER.debug("I go to last page");
        hotelsPage.selectLastPage();
        Thread.sleep(2000);
    }

    @Then("I save last hotel")
    public void saveLastHotel() throws InterruptedException {
        LOGGER.debug("I save last hotel");
        hotelsPage.saveHotel("last()");
        Thread.sleep(2000);
    }

    @Then("I go to user page")
    public void goToDashboard() throws InterruptedException {
        LOGGER.debug("I go to user page");
        mainBookingPage.goToDashboard();
    }

    @And("I check quantity of hotels and color of heart")
    public void check_quantity_of_hotels_and_color_of_heart(){
        LOGGER.debug("I check quantity of hotels and color of heart");
        int items = mainBookingPage.retrieveNumberOfTrips();
        Assert.assertTrue("2 items appeared in the 'My next trip' list", (items == 2) && (color == "color: red"));
    }
}
