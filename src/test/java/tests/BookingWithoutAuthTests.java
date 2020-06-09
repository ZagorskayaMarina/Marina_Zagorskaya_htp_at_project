package tests;

import application_items.booking.BookingTestData;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.GsonParser;
import web_driver.Driver;
import web_pages.*;

import java.io.FileNotFoundException;

public class BookingWithoutAuthTests {
    static WebDriver driver;
    String JSONBookingTests = "src/test/resources/booking/bookingTestsData";
    MainBookingPage mainBookingPage;
    HotelsPage hotelsPage;
    GsonParser gsonParser;

    @Test
    public void parisTest() throws FileNotFoundException, InterruptedException {
        driver = Driver.getDriver();
        gsonParser  = new GsonParser();
        BookingTestData test = gsonParser.parseGSONBookingData(JSONBookingTests, 1);
        driver.navigate().to("https://booking.com/");
        Thread.sleep(3000);
        mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.enterCity(test.city);
        mainBookingPage.enterDate(test.dayBeforeStartDate,test.dayOfStay);
        mainBookingPage.enterGuestData(test.adults,test.children,test.rooms);
        mainBookingPage.search();
        Thread.sleep(3000);
        hotelsPage = new HotelsPage(driver);
        hotelsPage.selectPriceCategory(5);
        int budgetCategory = hotelsPage.retrievePriceFromCategory(5);
        Thread.sleep(3000);
        hotelsPage.sortByPrice();
        Thread.sleep(3000);
        int priceOfHotel = hotelsPage.getPriceOfHotelPerNight(1, test.dayOfStay);
        System.out.println("priceOfHotel is: " + priceOfHotel + " budgetCategory is: " + budgetCategory);
        Assert.assertTrue("Verify that the price per night in hotel more than priseOfCathegory", priceOfHotel>budgetCategory);
    }

    @Test
    public void moskowTest() throws FileNotFoundException, InterruptedException {
        driver = Driver.getDriver();
        gsonParser  = new GsonParser();
        BookingTestData test = gsonParser.parseGSONBookingData(JSONBookingTests, 2);
        driver.navigate().to("https://booking.com/");
        Thread.sleep(3000);
        mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.enterCity(test.city);
        mainBookingPage.enterDate(test.dayBeforeStartDate,test.dayOfStay);
        mainBookingPage.enterGuestData(test.adults,test.children,test.rooms);
        mainBookingPage.search();
        Thread.sleep(3000);
        hotelsPage = new HotelsPage(driver);
        hotelsPage.selectPriceCategory(1);
        int budgetCategory = hotelsPage.retrievePriceFromCategory(1);
        Thread.sleep(3000);
        int priceOfHotel = hotelsPage.getPriceOfHotelPerNight(1, test.dayOfStay);
        System.out.println("priceOfHotel is: " + priceOfHotel + " budgetCategory is: " + budgetCategory);
        Assert.assertTrue("Verify that the price per night in hotel more than priseOfCathegory", priceOfHotel<budgetCategory);
    }

    @Test
    public void osloTest() throws FileNotFoundException, InterruptedException {
        driver = Driver.getDriver();
        gsonParser  = new GsonParser();
        BookingTestData test = gsonParser.parseGSONBookingData(JSONBookingTests, 3);
        driver.navigate().to("https://booking.com/");
        Thread.sleep(3000);
        mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.enterCity(test.city);
        mainBookingPage.enterDate(test.dayBeforeStartDate,test.dayOfStay);
        mainBookingPage.enterGuestData(test.adults,test.children,test.rooms);
        mainBookingPage.search();
        Thread.sleep(3000);
        hotelsPage = new HotelsPage(driver);
        hotelsPage.selectStarsOfHotel(3);
        Thread.sleep(3000);
        hotelsPage.selectStarsOfHotel(4);
        Thread.sleep(3000);
        WebElement hotel = driver.findElement(By.xpath("//*[@data-hotelid][10]"));
        hotelsPage.scrollToElement(hotel);
        WebElement element = driver.findElement(By.xpath("//*[@data-hotelid][10]//*[contains(@class,'address_line')]/a"));
        hotelsPage.focusMouse(element);
        WebElement text = driver.findElement(By.xpath("//*[@data-hotelid][10]//h3/a"));
        hotelsPage.changeTextColor(text);
        hotelsPage.changeBackgroundColor(element);
        String textColor = text.getAttribute("style");
        Assert.assertEquals("color: red;", textColor);
    }
}
