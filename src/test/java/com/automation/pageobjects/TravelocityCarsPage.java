package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TravelocityCarsPage extends BasePage {

    public TravelocityCarsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className="btn-action ember-view")
    public List<WebElement> carsSelectButtons;

    public TravelocityWhosTravelingPage selectFirstCar(){
        carsSelectButtons.get(0).click();
        return new TravelocityWhosTravelingPage(getDriver());
    }
}
