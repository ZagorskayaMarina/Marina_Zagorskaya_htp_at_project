package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import web_driver.Driver;
import web_pages.EmailChecker;
import web_pages.HotelsPage;
import web_pages.MainBookingPage;
import web_pages.TrashMailRegistration;

public class Steps {

    static WebDriver driver;
    TrashMailRegistration mailboxRegistration;
    EmailChecker emailChecker;
    MainBookingPage mainBookingPage;


    @Test
    public void createBookingNotActiveAcc() throws InterruptedException {
        driver = Driver.getDriver();
        mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.createAccount();
        Assert.assertTrue(mainBookingPage.verifyAccActivation());
    }


}
