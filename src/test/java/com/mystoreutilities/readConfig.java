package com.mystoreutilities;

import java.io.FileInputStream;

import java.util.Properties;

public class readConfig {
    Properties properties;
    String path = "/Users/rupaliramji/IdeaProjects/rupali/MyFirstProject/Configuration/config.properties";

    //constructor
    public readConfig() {

        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public String getBaseUrl()
    {
        String value = properties.getProperty("baseUrl");
        if (value != null) {
            return value;
        } else {
            throw new RuntimeException("url not found");
        }

    }

    public String getBrowser()
    {
        String value = properties.getProperty("browser");
        if (value != null) {
            return value;
        } else {
            throw new RuntimeException("browser not found");
        }

    }
    public String getEmail()
    {
        String value = properties.getProperty("Email");
        if (value != null) {
            return value;
        } else {
            throw new RuntimeException("Email not found");
        }

    }





    

}







