package tests;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import web_driver.Driver;
import web_pages.EmailChecker;
import web_pages.MainBookingPage;
import web_pages.TrashMailRegistration;

import java.io.IOException;

public class PreconditionSteps {

    static WebDriver driver;
    TrashMailRegistration mailboxRegistration;
    EmailChecker emailChecker;
    MainBookingPage mainBookingPage;

    @Before
    public void createTempMail() throws InterruptedException, IOException {
        WebDriver driver = Driver.getDriver();
        mailboxRegistration = new TrashMailRegistration(driver);
        mailboxRegistration.createTempEmail();
    }

    @Before
    public void checkRealEmail() throws InterruptedException {
        driver = Driver.getDriver();
        emailChecker = new EmailChecker(driver);
        emailChecker.loginInPost();
        emailChecker.comfirmTrushRegistration();
    }


}
