package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import web_driver.Driver;
import web_pages.TrashMailRegistration;

public class CreateMailBoxUserTests {
    static WebDriver driver;
    TrashMailRegistration mailboxRegistration;

    //@BeforeClass
    @Test
    public void createTempMail() throws InterruptedException {
        driver = Driver.getDriver();
        mailboxRegistration = new TrashMailRegistration(driver);
        mailboxRegistration.createMail(driver);
    }
}
