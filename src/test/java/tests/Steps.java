package tests;

import application_items.booking.BookingTestData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.GsonParser;
import web_driver.Driver;
import web_pages.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Steps {

    static WebDriver driver;
    TrashMailRegistration mailboxRegistration;
    EmailChecker emailChecker;
    MainBookingPage mainBookingPage;
    HeaderMainBooking headerMainBooking;
    HotelsPage hotelsPage;


    @Test
    public void createBookingNotActiveAcc() throws InterruptedException {
        driver = Driver.getDriver();
        mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.createAccount();
        Assert.assertTrue(mainBookingPage.verifyAccActivation());
    }

    @Test
    public void verifyNextTrip() throws FileNotFoundException, InterruptedException {
        driver = Driver.getDriver();
        driver.navigate().to("https://www.booking.com/");
        MainBookingPage mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.login();
        Thread.sleep(3000);
        HotelsPage hotelsPage = new HotelsPage(driver);
        GsonParser gsonParser = new GsonParser();
        String JSONBookingTests = "src/test/resources/booking/bookingTestsData";
        BookingTestData test = gsonParser.parseGSONBookingData(JSONBookingTests, 0);
        mainBookingPage.cleanCityData();
        mainBookingPage.enterCity(test.city);
        mainBookingPage.enterDate(test.dayBeforeStartDate,test.dayOfStay);
        mainBookingPage.enterGuestData(test.adults,test.children,test.rooms);
        mainBookingPage.search();
        Thread.sleep(3000);
        hotelsPage.saveHotel("1");
        String color = hotelsPage.getColor();
        Thread.sleep(10000);
        hotelsPage.selectLastPage();
        Thread.sleep(2000);
        hotelsPage.saveHotel("last()");
        mainBookingPage.goToDashboard();
        int items = mainBookingPage.retrieveNumberOfTrips();
        Assert.assertTrue("2 items appeared in the 'My next trip' list", (items == 2) && (color == "color: red"));
    }

    @After
    public void deleteTrips() throws InterruptedException {
        driver = Driver.getDriver();
        MainBookingPage mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.goToDashboard();

    }

    @Test
    public void verifyDisplayingAllHeadeElem() throws InterruptedException {
        driver = Driver.getDriver();
        mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.login();
        Thread.sleep(3000);
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
