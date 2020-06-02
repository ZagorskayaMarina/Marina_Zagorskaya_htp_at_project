package utility;

import java.io.*;
import java.util.Properties;

public class MyProperty {
    private static Properties prop = new Properties();

    public static Properties getProperties(String path){
        if(null != prop){
            return prop;
        }
        try (InputStream input = new FileInputStream(path)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

}