package tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UserApiTests {
    
    private static final Logger LOGGER = LogManager.getLogger(UserApiTests.class);

    @Given("I start execution")
    public void iStartExecution() {
        // Write code here that turns the phrase above into concrete actions
        //System.out.println("Given");
        LOGGER.error("Given");
    }

    @When("I search user by \"(.*)\" name")
    public void iSearchUserByName(String string) {
        // Write code here that turns the phrase above into concrete actions
        //System.out.println("When");
        LOGGER.error("When");
    }

    @Then("I verify that I got \"(.*)\"")
    public void iVerifyThatIGot(String string) {
        // Write code here that turns the phrase above into concrete actions
        //System.out.println("Then");
        LOGGER.error("Then");
    }
}
