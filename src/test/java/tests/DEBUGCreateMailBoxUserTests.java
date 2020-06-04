package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import web_driver.Driver;
import web_pages.TrashMailRegistration;

import java.io.IOException;

public class DEBUGCreateMailBoxUserTests {
    static WebDriver driver;
    TrashMailRegistration mailboxRegistration;

    //@BeforeClass
    @Test
    public void createTempMail() throws InterruptedException, IOException {
        driver = Driver.getDriver();
        mailboxRegistration = new TrashMailRegistration(driver);
        mailboxRegistration.createTempEmail();
        mailboxRegistration.createUser();
    }
}
