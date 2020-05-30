package runners;

import application_items.Search;
import application_items.WS.UserFromResponse;
import application_items.WS.Case;
import utility.GsonParser;
import utility.HttpCalls;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class ParserGSONRunner {

    public static void main(String[] args) throws IOException, URISyntaxException {
        GsonParser gsonParser = new GsonParser();
        Case numberOfCase = gsonParser.parseGSON(0);
        Search search = new Search(numberOfCase.user, numberOfCase.strict);
        HttpCalls myHttpClient = new HttpCalls ();
        String response = myHttpClient.search(search);
        UserFromResponse[] users = gsonParser.parseGSONResponse(response);
        System.out.println(users[0]);

        UserFromResponse expResult0 = gsonParser.parseGSONExpectRes(0);
        UserFromResponse expResult1 = gsonParser.parseGSONExpectRes(0);
        System.out.println("--------------------------");
        System.out.println(expResult1);

        System.out.println(expResult1.equals(users[0]));

    }
}
