/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package app.constants;

public class Constants {

    public static final String CURRENT_DIR = System.getProperty("user.dir");

    public static final String EXECUTION_REPORT_PATH=CURRENT_DIR+"/reports/execution.html";
    public static final int EXPLICIT_WAIT_TIME=20;
    public static final int IMPLICIT_WAIT_TIME=30;

    public static final String CONFIG_FILE_PATH=CURRENT_DIR+"/src/test/resources/execution/config.properties";

    public static String EXECUTION_ENV;

    public static final String TEST_ENV_DATA_FILE=CURRENT_DIR+"/src/test/resources/testData/test_data.properties";
}
