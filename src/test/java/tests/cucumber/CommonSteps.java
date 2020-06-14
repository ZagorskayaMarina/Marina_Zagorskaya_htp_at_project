package tests.cucumber;

import application_items.booking.BookingTestData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import utility.GsonParser;
import web_driver.Driver;
import web_pages.HotelsPage;
import web_pages.MainBookingPage;

import java.io.FileNotFoundException;

public class CommonSteps {
/*
    static WebDriver driver;
    String JSONBookingTests = "src/test/resources/booking/bookingTestsData";
    MainBookingPage mainBookingPage;
    HotelsPage hotelsPage;
    GsonParser gsonParser;
    BookingTestData test;

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

        System.out.println("class name: " + CommonSteps.class.getName() + " city: " + test.city + " dayBeforeStartDate: " + test.dayBeforeStartDate
                + " dayOfStay: " + test.dayOfStay + " adults: " + test.adults +
                " children: " + test.children + " rooms: " + test.rooms);

    }
*/
}
