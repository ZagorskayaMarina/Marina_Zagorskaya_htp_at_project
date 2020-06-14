package tests.cucumber;

import application_items.booking.BookingTestData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.GsonParser;
import web_driver.Driver;
import web_pages.HotelsPage;
import web_pages.MainBookingPage;

import java.io.FileNotFoundException;

public class OsloSteps {
    private static final Logger LOGGER = LogManager.getLogger(OsloSteps.class);
    static WebDriver driver;
    String JSONBookingTests = "src/test/resources/booking/bookingTestsData";
    MainBookingPage mainBookingPage;
    HotelsPage hotelsPage;
    GsonParser gsonParser;
    BookingTestData test;
    WebElement text;

    @Given("I go3 to site '(.*)'")
    public void goToSite3(String site) throws InterruptedException {
        LOGGER.debug("I go3 to site");
        driver = Driver.getDriver();
        driver.navigate().to(site);
        Thread.sleep(3000);
    }

    @Then("I get3 data to search from JSON file '(.*)' element in array")
    public void getData3(int i) throws FileNotFoundException, InterruptedException {
        LOGGER.debug("I get3 data to search from JSON");
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

    @And("I select hotels with stars 3 and 4")
    public void select_hotels_with_stars3() throws InterruptedException {
        LOGGER.debug("I select hotels with stars 3 and 4");
        hotelsPage = new HotelsPage(driver);
        hotelsPage.selectStarsOfHotel(3);
        Thread.sleep(3000);
        hotelsPage.selectStarsOfHotel(4);
        Thread.sleep(3000);
    }

    @Then("I scroll to 10 hotel")
    public void scrollToElement() throws InterruptedException {
        LOGGER.debug("I scroll to 10 hotel");
        WebElement hotel = driver.findElement(By.xpath("//*[@data-hotelid][10]"));
        hotelsPage.scrollToElement(hotel);
    }

    @Then("I focus mouse to hotel address")
    public void focusToElement() throws FileNotFoundException {
        LOGGER.debug("I focus mouse to hotel address");
        WebElement element = driver.findElement(By.xpath("//*[@data-hotelid][10]//*[contains(@class,'address_line')]/a"));
        hotelsPage.focusMouse(element);
    }

    @Then("I change the background color to green")
    public void changeBackgroundColor() {
        LOGGER.debug("I change the background color to green");
        WebElement element = driver.findElement(By.xpath("//*[@data-hotelid][10]//*[contains(@class,'address_line')]/a"));
        hotelsPage.changeBackgroundColor(element);
    }

    @Then("I change the text color to red")
    public void changeTextColor() {
        LOGGER.debug("I change the text color to red");
        WebElement text = driver.findElement(By.xpath("//*[@data-hotelid][10]//h3/a"));
        hotelsPage.changeTextColor(text);
    }

    @And("I verify the text color")
    public void verifyTextColor() {
        LOGGER.debug("I verify the text color");
        WebElement text = driver.findElement(By.xpath("//*[@data-hotelid][10]//h3/a"));
        String textColor = text.getAttribute("style");
        Assert.assertEquals("color: red;", textColor);
    }
}
