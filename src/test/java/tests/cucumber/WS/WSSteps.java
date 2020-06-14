package tests.cucumber.WS;

import application_items.Search;
import application_items.WS.Case;
import application_items.WS.UserFromResponse;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import tests.cucumber.RegistrationOnBookingTests;
import utility.GsonParser;
import utility.HttpCalls;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class WSSteps {
    private static final Logger LOGGER = LogManager.getLogger(WSSteps.class);
    GsonParser gsonParser = new GsonParser();
    HttpCalls myHttpClient = new HttpCalls ();
    Case numberOfCase;
    Search search;
    UserFromResponse[] users;
    UserFromResponse expResult;
    String response;

    @Given("I start finding by {int} predicate")
    public void findByPredicate(int i) throws FileNotFoundException {
        LOGGER.debug("I start finding by predicate");
        numberOfCase = gsonParser.parseGSON(i);
        search = new Search(numberOfCase.user, numberOfCase.strict);
    }

    @When("I get a response from a web service")
    public void getResponse() throws IOException, URISyntaxException {
        LOGGER.debug("I get a response from a web service");
        response = myHttpClient.search(search);
    }

    @And("I parse result and exp result by {int} result")
    public void parseResult(int expResultI) throws FileNotFoundException {
        LOGGER.debug("I parse result and exp result by result");
        users = gsonParser.parseGSONResponse(response);
        expResult = gsonParser.parseGSONExpectRes(expResultI);
    }

    @Then("I verify the web service response")
    public void verifyResultFromWS(){
        LOGGER.debug("I verify the web service response");
        Assert.assertTrue(expResult.equals(users[0]), "Test Passed");
    }

    @And("I parse result")
    public void parseResultResponse(){
        LOGGER.debug("I parse result");
        users = gsonParser.parseGSONResponse(response);
    }

    @Then("I verify the web service response by {int}")
    public void verifyResultFromWSByLength(int length){
        LOGGER.debug("I verify the web service response by");
        Assert.assertTrue(users.length==length, "Test Passed");
    }


}
