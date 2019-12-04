package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;

public class TravelocityCruisesResultsPage extends BasePage {

    public TravelocityCruisesResultsPage(WebDriver driver){
        super(driver);
        driver.get("https://www.travelocity.com/");
    }
}
