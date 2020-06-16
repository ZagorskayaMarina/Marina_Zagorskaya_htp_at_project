package tests.cucumber.silver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import web_driver.Driver;
import web_pages.Silver;

import java.util.List;

public class SilverTests {
    private static final Logger LOGGER = LogManager.getLogger(SilverTests.class);
    static WebDriver driver;
    Silver silver;

    @Given("I open an app")
    public void openApp() throws InterruptedException {
        LOGGER.debug("I open an app silver");
        driver = Driver.getDriver();
        driver.navigate().to("https://silverscreen.by/");
        Thread.sleep(3000);
    }

    @When("I search for '(.*)' word")
    public void searchWord(String word) throws InterruptedException {
        LOGGER.debug("I search word");
        silver = new Silver(driver);
        silver.searchWord(word);
        Thread.sleep(3000);
    }

    @And("Each item name or description contains '(.*)' word")
    public void containWord(String word){
        LOGGER.debug("each item name or description contains " + word);
        List<Boolean> labels = silver.containWord(word);
        for (int i = 0; i < labels.size(); i++){
            Assert.assertTrue(labels.get(i));
        }

    }

    @When("I login with '(.*)' and '(.*)'")
    public void loginWithEmailAndPsw(String email, String psw) throws InterruptedException {
        LOGGER.debug("I login to silver");
        silver = new Silver(driver);
        silver.moveCursorToElement();
        silver.login(email, psw);
        Thread.sleep(2000);
    }

    @Then("I can see Red Carpet Club '(.*)' in upper right corner")
    public void verifyDisplayingElement(String xpathStr){
        LOGGER.debug("I can see Red Carpet Club label in upper right corner");
        Assert.assertTrue(silver.verifyDisplayingElement(xpathStr));
    }

    @When("I left blank {string} field")
    public void fillBlank(String field) throws InterruptedException {
        LOGGER.debug("I left blank " + field + " field");
        silver = new Silver(driver);
        silver.moveCursorToElement();
        if (field=="ee1vp@yandex.by"){
            silver.enterEmail(field);
        } else{
            silver.enterPSW(field);
        }
    }

    @Then("I see {string} message")
    public void seeMessage(String message){
        LOGGER.debug("I see " + message + " message");
        Boolean label = silver.verifyDisplayingElement((String.format("//*[contains(text(),'%s')]", message)));
        Assert.assertTrue(label);
    }


}
