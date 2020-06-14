package tests;
import application_items.Search;
import application_items.WS.Case;
import application_items.WS.UserFromResponse;
import org.junit.Test;
import org.testng.Assert;
import utility.GsonParser;
import utility.HttpCalls;
import java.io.IOException;
import java.net.URISyntaxException;

public class TestsWS {
    GsonParser gsonParser = new GsonParser();
    HttpCalls myHttpClient = new HttpCalls ();

    @Test
    public void fullShort() throws IOException, URISyntaxException {

        Case numberOfCase = gsonParser.parseGSON(0);
        Search search = new Search(numberOfCase.user, numberOfCase.strict);
        String response = myHttpClient.search(search);
        UserFromResponse[] users = gsonParser.parseGSONResponse(response);
        UserFromResponse expResult0 = gsonParser.parseGSONExpectRes(0);

        Assert.assertTrue(expResult0.equals(users[0]), "fullShort test Passed");
    }

    @Test
    public void fullLong() throws IOException, URISyntaxException {

        Case numberOfCase = gsonParser.parseGSON(1);
        Search search = new Search(numberOfCase.user, numberOfCase.strict);
        String response = myHttpClient.search(search);
        UserFromResponse[] users = gsonParser.parseGSONResponse(response);
        UserFromResponse expResult1 = gsonParser.parseGSONExpectRes(1);

        Assert.assertTrue(expResult1.equals(users[0]), "fullLong test Passed");
    }

    @Test
    public void partialShort() throws IOException, URISyntaxException {

        Case numberOfCase = gsonParser.parseGSON(2);
        Search search = new Search(numberOfCase.user, numberOfCase.strict);
        String response = myHttpClient.search(search);
        UserFromResponse[] users = gsonParser.parseGSONResponse(response);

        Assert.assertTrue(users.length==4, "partialShort test Passed");
    }

    @Test
    public void partialLong() throws IOException, URISyntaxException {

        Case numberOfCase = gsonParser.parseGSON(3);
        Search search = new Search(numberOfCase.user, numberOfCase.strict);
        String response = myHttpClient.search(search);
        UserFromResponse[] users = gsonParser.parseGSONResponse(response);
        UserFromResponse expResult4 = gsonParser.parseGSONExpectRes(4);

        Assert.assertTrue(expResult4.equals(users[0]), "fullLong test Passed");
    }

    @Test
    public void allUsers() throws IOException, URISyntaxException {

        Case numberOfCase = gsonParser.parseGSON(4);
        Search search = new Search(numberOfCase.user, numberOfCase.strict);
        String response = myHttpClient.search(search);
        UserFromResponse[] users = gsonParser.parseGSONResponse(response);

        Assert.assertTrue(users.length==6, "allUsers test passed");

        //Assert.assertEquals(users.length, 6, "allUsers test Passed");
    }

}
