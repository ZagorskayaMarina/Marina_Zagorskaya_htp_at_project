package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_driver.Driver;
import web_pages.*;

import java.util.ArrayList;
import java.util.List;

public class Steps {

    static WebDriver driver;
    TrashMailRegistration mailboxRegistration;
    EmailChecker emailChecker;
    MainBookingPage mainBookingPage;
    HeaderMainBooking headerMainBooking;


    @Test
    public void createBookingNotActiveAcc() throws InterruptedException {
        driver = Driver.getDriver();
        mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.createAccount();
        Assert.assertTrue(mainBookingPage.verifyAccActivation());
    }

    @Test
    public void verifyNextTrip(){

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
