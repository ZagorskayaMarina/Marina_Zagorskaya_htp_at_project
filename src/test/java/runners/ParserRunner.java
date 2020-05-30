package runners;

import application_items.Recipe;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.xml.sax.SAXException;
import utility.JsonParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParserRunner {
    static JsonParser jsonParser = new JsonParser();
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
         {
            jsonParser.paseJSON();
            jsonParser.parseGSON();
            jsonParser.parseJackson();
            jsonParser.fromGSON();
            jsonParser.parseGSONArr();
        }
    }


}
