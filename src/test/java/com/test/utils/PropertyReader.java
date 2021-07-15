package com.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class PropertyReader {

    private static final String CONFIGFILEPATH= "./config.properties";

    public static String getValue(String key) throws Exception {
        File file = new File(CONFIGFILEPATH);
        FileInputStream fis = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fis);
        return prop.getProperty(key);
    }

    public Long getTimeout() throws Exception {
        String timeout = PropertyReader.getValue("timeout");
        return Long.parseLong(timeout);
    }

}