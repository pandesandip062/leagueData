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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataLoader {

    private static Properties prop;

    private TestDataLoader() throws IOException {
        String env = Constants.EXECUTION_ENV;

        switch (env){
            case "test":
                loadFile(Constants.TEST_ENV_DATA_FILE);
                break;
            case "prod":
                loadFile(Constants.TEST_ENV_DATA_FILE);
            default:
                break;

        }
    }

    @Getter
    private static TestDataLoader instance;

    static {
        try {
            instance = new TestDataLoader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void loadFile(String filePath)  {
        FileReader reader =null;
        try{
            reader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
           ExtentFactory.getInstance().failTest("Exceptiom occured while reading test data file");
        }

        prop = new Properties();

        try{
            prop.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String getPropertyValue(String key){
        return prop.getProperty(key);
    }

    public String getAppUrl(){
        return this.getPropertyValue("app_url");
    }
    public String getUsername(){
        return this.getPropertyValue("username");
    }
    public String getPassword(){
        return this.getPropertyValue("password");
    }
}
