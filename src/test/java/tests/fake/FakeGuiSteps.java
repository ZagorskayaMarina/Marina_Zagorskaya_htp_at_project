package tests.fake;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import web_driver.Driver;

public class FakeGuiSteps {

    @Given(value = "I go to tut.by")
    public void checkHeaderTest(){
        Driver.getDriver().get("https://tut.by");
    }

    @When("I start waiting")
    public void checkFooterTest() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Then("I just passed")
    public void verify(){
        Assert.assertTrue(true);
    }
}
