/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package app.properties;


import app.constants.Constants;
import app.report.ExtentFactory;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoadeer {
    private Logger logger = LogManager.getLogger(ConfigLoadeer.class);

    @Getter
    private static ConfigLoadeer instance;

    static {
        try {
            instance = new ConfigLoadeer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Properties prop;

    private ConfigLoadeer() throws IOException {
        FileReader reader =null;

        try{
            reader = new FileReader(Constants.CONFIG_FILE_PATH);

        } catch (FileNotFoundException e) {
           logger.error("Execption occured while reading file from config");
          ExtentFactory.getInstance().failTest("Execption occured while reading file from config");
        }

       prop = new Properties();

        try{
            prop.load(reader);
        } catch (IOException e) {
           e.printStackTrace();
        }

        Constants.EXECUTION_ENV = getPropertyValue("environment");
    }

    public String getPropertyValue(String key){
        return prop.getProperty(key);
    }

}
