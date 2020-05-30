package utility;

import application_items.Search;
import application_items.WS.Case;
import application_items.WS.ResponseObject;
import application_items.WS.UserFromResponse;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.Properties;

public class GsonParser {
    public final static  String JSON = "src/test/resources/testData.json";
    public final static  String JSONExpRes = "src\\test\\resources\\expectedResults.json";

    /*private static Properties getTestProperties() {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("Marina_Zagorskaya_project/src/test/resources/path.properties")) {
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }

    public final static  String JSON = getTestProperties().getProperty("JSON");
    public final static String JSONExpRes = getTestProperties().getProperty("JSONExpRes");*/

    public Case parseGSON(int i) throws FileNotFoundException {
        Gson gson = new Gson();
        Case[] arrCase = gson.fromJson(new JsonReader(new FileReader(JSON)), Case[].class);
        return arrCase[i];
    }

    public UserFromResponse[] parseGSONResponse(String responsAsString) {
        Gson gson = new Gson();
        ResponseObject resp = gson.fromJson(responsAsString, ResponseObject.class);
        return resp.data;
    }

    public static String fromGSON(Search search) {
        Gson gson = new Gson();
        return gson.toJson(search);
    }

    public UserFromResponse parseGSONExpectRes(int i) throws FileNotFoundException {
        Gson gson = new Gson();
        UserFromResponse[] users = gson.fromJson(new JsonReader(new FileReader(JSONExpRes)), UserFromResponse[].class);
        return users[i];
    }

}
