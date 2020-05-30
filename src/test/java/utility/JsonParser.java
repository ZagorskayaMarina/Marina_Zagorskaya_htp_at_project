package utility;

import application_items.Ingredient;
import application_items.Recipe;
import application_items.Search;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.json.JSONObject;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {
    public final static  String JSON = "Marina_Zagorskaya_project\\src\\main\\resources\\recipe.json";
    File file = new File(JSON);

    public void paseJSON() throws IOException {
        String input = new String(Files.readAllBytes(Paths.get(JSON)));
        JSONObject obj = new JSONObject(input);
        System.out.println(obj.getString("recipename"));
    }

    public void parseGSON() throws FileNotFoundException {
        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);
        System.out.println(recipe.recipename);
    }

    public void parseGSONArr() throws FileNotFoundException {
        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);
        System.out.println(recipe.ingredlist[0]);
    }
//delete it:
    /*public void paseJSON1() throws IOException {
        String input = new String(Files.readAllBytes(Paths.get(JSON)));
        JSONObject obj = new JSONObject(input);
        System.out.println(obj.getString("recipename"));
    }*/

    public void parseJackson() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Recipe recipe = mapper.readValue(file, Recipe.class);
        System.out.println(recipe.recipename);
    }

    public void fromGSON() {
        Gson gson = new Gson();
        Recipe recipe = new Recipe("Borsh", new Ingredient[]{},"120");
        /*FileWriter writer = new FileWriter(JSON_1), gson.toJson(recipe).getBytes();*/
        System.out.println(gson.toJson(recipe));
    }

    public static String fromGSON(Search search) {
        Gson gson = new Gson();
        return gson.toJson(search);
    }
}
