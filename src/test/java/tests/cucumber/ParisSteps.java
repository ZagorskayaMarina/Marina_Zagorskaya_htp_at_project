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

public class ParisSteps {
    /*private static final Logger LOGGER = LogManager.getLogger(ParisSteps.class);
    private StepData stepData;
    //static WebDriver driver;

    public ParisSteps(){}

    public ParisSteps(StepData stepData) {
        this.stepData = stepData;
    }

    @Given("I go to site '(.*)'")
    public void goToSite(String site) throws InterruptedException {
        stepData.driver = Driver.getDriver();
        stepData.driver.navigate().to(site);
        Thread.sleep(3000);
    }

    @Then("I get data to search from JSON file '(.*)' element in array")
    public void getData(int i) throws FileNotFoundException, InterruptedException {
        stepData.gsonParser = new GsonParser();
        stepData.test = stepData.gsonParser.parseGSONBookingData(stepData.JSONBookingTests, i);
        stepData.mainBookingPage = new MainBookingPage(stepData.driver);
        stepData.mainBookingPage.enterCity(stepData.test.city);
        stepData.mainBookingPage.enterDate(stepData.test.dayBeforeStartDate,stepData.test.dayOfStay);
        stepData.mainBookingPage.enterGuestData(stepData.test.adults,stepData.test.children,stepData.test.rooms);
        stepData.mainBookingPage.search();
        Thread.sleep(3000);

        System.out.println("class name: " + CommonSteps.class.getName() + " city: " + stepData.test.city + " dayBeforeStartDate: " + stepData.test.dayBeforeStartDate
                + " dayOfStay: " + stepData.test.dayOfStay + " adults: " + stepData.test.adults +
                " children: " + stepData.test.children + " rooms: " + stepData.test.rooms);
    }

    @And("I select hotel in  price category '(.*)'")
    public void selectPriceCategory(int i) throws InterruptedException {
        stepData.hotelsPage = new HotelsPage(stepData.driver);
        stepData.hotelsPage.selectPriceCategory(i);
        stepData.budgetCategory = stepData.hotelsPage.retrievePriceFromCategory(i);
        Thread.sleep(3000);
    }

    @And("I sort hotels by price from min to max")
    public void sortHotels() throws InterruptedException {
        stepData.hotelsPage.sortByPrice();
        Thread.sleep(3000);
    }

    @And("I select '(.*)' hotel")
    public void selectHotel(int i) throws FileNotFoundException {
        stepData.test = stepData.gsonParser.parseGSONBookingData(stepData.JSONBookingTests, 1);//need refactoring
        stepData.priceOfHotel = stepData.hotelsPage.getPriceOfHotelPerNight(i, stepData.test.dayOfStay);
    }

    @And("I compare hotel's category price with price of hotel")
    public void comparePrice() {
        System.out.println("priceOfHotel is: " + stepData.priceOfHotel + " budgetCategory is: " + stepData.budgetCategory);
        Assert.assertTrue("Verify that the price per night in hotel more than priseOfCathegory", stepData.priceOfHotel > stepData.budgetCategory);
    }*/

    private static final Logger LOGGER = LogManager.getLogger(ParisSteps.class);
    static WebDriver driver;
    String JSONBookingTests = "src/test/resources/booking/bookingTestsData";
    MainBookingPage mainBookingPage;
    HotelsPage hotelsPage;
    GsonParser gsonParser;
    BookingTestData test;
    int priceOfHotel;
    int budgetCategory;

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
    public void selectHotel(int i) throws FileNotFoundException {
        test = gsonParser.parseGSONBookingData(JSONBookingTests, 1);//need refactoring
        priceOfHotel = hotelsPage.getPriceOfHotelPerNight(i, test.dayOfStay);
    }

    @And("I compare hotel's category price with price of hotel")
    public void comparePrice() {
        System.out.println("priceOfHotel is: " + priceOfHotel + " budgetCategory is: " + budgetCategory);
        Assert.assertTrue("Verify that the price per night in hotel more than priseOfCathegory", priceOfHotel > budgetCategory);
    }
}
