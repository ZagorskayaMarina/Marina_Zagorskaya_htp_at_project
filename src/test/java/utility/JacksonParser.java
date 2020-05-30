package utility;

import application_items.Recipe;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonParser {
    public final static  String JSON = "Marina_Zagorskaya_project\\src\\main\\resources\\recipe.json";
    File file = new File(JSON);

    public void parseJackson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Recipe recipe = mapper.readValue(file, Recipe.class);
        System.out.println(recipe.ingredlist);
    }
}
