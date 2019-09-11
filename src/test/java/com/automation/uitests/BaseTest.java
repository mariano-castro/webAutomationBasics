package com.automation.uitests;

import com.automation.MyDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    MyDriver myDriver;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser) {
        myDriver = new MyDriver(browser);
        myDriver.getDriver().manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void afterSuite() {
        myDriver.disposeDriver();
    }

}
