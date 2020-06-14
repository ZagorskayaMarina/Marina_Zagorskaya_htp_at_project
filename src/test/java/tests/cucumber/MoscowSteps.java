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
import web_pages.HotelsPage;
import web_pages.MainBookingPage;

import java.io.FileNotFoundException;


public class MoscowSteps {
    private static final Logger LOGGER = LogManager.getLogger(MoscowSteps.class);
    static WebDriver driver;
    String JSONBookingTests = "src/test/resources/booking/bookingTestsData";
    MainBookingPage mainBookingPage;
    HotelsPage hotelsPage;
    GsonParser gsonParser;
    BookingTestData test;
    int priceOfHotel;
    int budgetCategory;

    @Given("I go2 to site '(.*)'")
    public void goToSite2(String site) throws InterruptedException {
        driver = Driver.getDriver();
        driver.navigate().to(site);
        Thread.sleep(3000);
    }

    @Then("I get2 data to search from JSON file '(.*)' element in array")
    public void getData2(int i) throws FileNotFoundException, InterruptedException {
        gsonParser  = new GsonParser();
        test = gsonParser.parseGSONBookingData(JSONBookingTests, i);
        mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.enterCity(test.city);
        mainBookingPage.enterDate(test.dayBeforeStartDate,test.dayOfStay);
        mainBookingPage.enterGuestData(test.adults,test.children,test.rooms);
        mainBookingPage.search();
        Thread.sleep(3000);

        System.out.println("class name: " + CommonSteps.class.getName() + " city: " + test.city + " dayBeforeStartDate: " + test.dayBeforeStartDate
                + " dayOfStay: " + test.dayOfStay + " adults: " + test.adults +
                " children: " + test.children + " rooms: " + test.rooms);
    }

    @And("I select2 hotel in  price category '(.*)'")
    public void selectPriceCategory2(int i) throws InterruptedException {
        hotelsPage = new HotelsPage(driver);
        hotelsPage.selectPriceCategory(i);
        budgetCategory = hotelsPage.retrievePriceFromCategory(i);
        Thread.sleep(3000);
    }

    @And("I select2 '(.*)' hotel")
    public void selectHotel2(int i) throws FileNotFoundException {
        test = gsonParser.parseGSONBookingData(JSONBookingTests, 1);//need refactoring
        priceOfHotel = hotelsPage.getPriceOfHotelPerNight(i, test.dayOfStay);
    }

    @And("I compare2 price Moscow")
    public void comparePrice2() {
        System.out.println("priceOfHotel is: " + priceOfHotel + " budgetCategory is: " + budgetCategory);
        Assert.assertTrue("Verify that the price per night in hotel more than priseOfCathegory", priceOfHotel < budgetCategory);
    }

}
