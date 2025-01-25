package hooks;

import io.cucumber.java.*;

import static hooks.DriverManager.getDriver;
import static hooks.DriverManager.quitDriver;


public class Hooks {

    @Before
    public static void setUp() {
        getDriver();
    }

    @After
    public static void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            ScreenshotUtil.captureScreenshot(getDriver(),scenario.getName().replaceAll(" ","_"));
        }
        DriverManager.getDriver().manage().deleteAllCookies();
        quitDriver();


    }
}