package com.pranavbale.resources.properties;

import java.io.FileInputStream;
import java.util.Properties;
// get the data from the properties file
public class GlobalData  {

    // the function is used to load data from the properties file
    public static String loadProperties(String key) {

        // create an object of properties
        Properties properties = new Properties();

        // load properties file
        try (FileInputStream fis = new FileInputStream("src/main/java/com/pranavbale/resources/properties/GlobalData.properties")) {
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // get the data from the properties file and return it.
        return properties.getProperty(key);
    }

}
