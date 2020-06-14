package tests.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import web_driver.Driver;
import web_pages.EmailChecker;
import web_pages.MainBookingPage;
import web_pages.TrashMailRegistration;

public class RegistrationOnBookingTests {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationOnBookingTests.class);
    static WebDriver driver;
    TrashMailRegistration mailboxRegistration;
    EmailChecker emailChecker;
    MainBookingPage mainBookingPage;

    @Given("I go6 to site '(.*)'")
    public void goToSite6(String site) throws InterruptedException {
        LOGGER.debug("I go6 to site");
        driver = Driver.getDriver();
        driver.navigate().to(site);

        Thread.sleep(3000);
    }

    @Then("I create new trash mail")
    public void createAcc() throws InterruptedException {
        LOGGER.debug("I create new trash mail");
        mailboxRegistration = new TrashMailRegistration(driver);
        mailboxRegistration.createTempEmail();
    }

    @Then("I confirm new account")
    public void confirmNewEmail() throws InterruptedException {
        LOGGER.debug("I confirm new account");
        emailChecker = new EmailChecker(driver);
        emailChecker.loginInPost();
        emailChecker.comfirmTrushRegistration();
    }

    @And("I go7 to site '(.*)'")
    public void goToSite7(String site) throws InterruptedException {
        LOGGER.debug("I go7 to site");
        driver.navigate().to(site);
        Thread.sleep(3000);
    }

    @Then("I create booking account")
    public void createBookingAcc() throws InterruptedException {
        LOGGER.debug("I create booking account");
        mainBookingPage = new MainBookingPage(driver);
        mainBookingPage.createAccount();
    }

    @And("I check that user is not active")
    public void checkNotActivatedUser() throws InterruptedException {
        LOGGER.debug("I check that user is not active");
        Assert.assertTrue(mainBookingPage.verifyAccActivation());
    }

}
