package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyProperty {
    private static Properties prop = new Properties();

    public static Properties getProperties(String path){
        try (InputStream input = new FileInputStream(path)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}