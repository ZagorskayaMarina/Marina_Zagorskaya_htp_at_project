package tests;

import application_items.WS.UserFromResponse;
import application_items.booking.BookingTestData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.GsonParser;
import utility.MyProperty;
import web_driver.Driver;
import web_pages.EmailChecker;
import web_pages.MainBookingPage;
import web_pages.Silver;
import web_pages.TrashMailRegistration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Debbuger {
    static WebDriver driver;
    TrashMailRegistration mailboxRegistration;
    EmailChecker emailChecker;
    MainBookingPage mainBookingPage;


    //@BeforeClass
    @Test
    public void createTempMail() throws InterruptedException, IOException {
        driver = Driver.getDriver();
        mailboxRegistration = new TrashMailRegistration(driver);
        driver.navigate().to("https://trashmail.com/");
        mailboxRegistration.createTempEmail();
    }

    @Test
    public void checkRealEmail() throws InterruptedException {
        driver = Driver.getDriver();
        emailChecker = new EmailChecker(driver);
        emailChecker.loginInPost();
        emailChecker.comfirmTrushRegistration();
    }

    @Test
    public void createBookingAcc() throws InterruptedException {
        driver = Driver.getDriver();
        mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.createAccount();
    }

    @Test
    public void test(){
        String propPath = "src/test/resources/booking/mail.properties";
        Properties properties = MyProperty.getProperties(propPath);
        System.out.println(MyProperty.getProperties(propPath).getProperty("REAL_MAIL"));
    }


    @Test
    public void testBooking() throws InterruptedException, FileNotFoundException {

    }

    @Test
    public void testDebug() throws InterruptedException, FileNotFoundException {
        GsonParser gsonParser = new GsonParser();
        String JSONBookingTests = "src/test/resources/booking/bookingTestsData";
        BookingTestData test = gsonParser.parseGSONBookingData(JSONBookingTests, 0);
        System.out.println(test.getAdults());
    }

    @Test
    public void silverSearchWordTest() throws InterruptedException {
        driver = Driver.getDriver();
        driver.navigate().to("https://silverscreen.by/");
        Silver silver = new Silver(driver);
        silver.searchWord("автокинотеатр");
        silver.containWord("автокинотеатр");

    }
}
