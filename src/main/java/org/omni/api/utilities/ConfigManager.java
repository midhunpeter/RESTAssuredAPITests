package org.omni.api.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager manager;
    private final static Properties properties = new Properties();


    /*private ConfigManager(){
        try(InputStream stream = ConfigManager.class.getResourceAsStream("/resources/config.properties")) {
            properties.load(stream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

   private ConfigManager() throws IOException {
       InputStream inputStream = ConfigManager.class.getResourceAsStream("../resources/config.properties");
       properties.load(inputStream);
   }

    public static ConfigManager getInstance() throws IOException {
        if (manager == null) {
            synchronized (ConfigManager.class) {
                manager = new ConfigManager();
            }
        }
        return manager;
    }

    public String getString(String key) {
        return System.getProperty(key, properties.getProperty(key));
    }

}