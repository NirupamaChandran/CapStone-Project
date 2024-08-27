package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.ReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void setUp(Scenario scenario) {
        ConfigReader.initConfig();
        DriverManager.createDriver();
        ReportManager.initReport(scenario);
    }

    @After
    public void tearDown(Scenario scenario) {
        ReportManager.attachScreenshot(scenario);
        DriverManager.getDriver().quit();
    }
}
