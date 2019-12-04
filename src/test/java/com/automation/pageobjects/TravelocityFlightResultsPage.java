package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TravelocityFlightResultsPage extends TravelocityResultsPage{

    @FindBy(css = ".bColumn ul li:first-child .t-select-btn")
    public WebElement botonSelectDeparture;

    @FindBy(className="duration-emphasis")
    public WebElement flightDuration;

    @FindBy(className="show-flight-details")
    public WebElement flightDetail;

    @FindBy(css = ".t-select-btn")
    public List<WebElement> departuresList;

    public TravelocityFlightResultsPage(WebDriver driver){
        super(driver);
        driver.get("https://www.travelocity.com/");
    }

    public void selectFirstResult(){
        botonSelectDeparture.click();
    }

    public void selectThirdResult(){
        botonSelectDeparture.click();
    }

    public void selectFirstDeparture(){
        departuresList.get(0).click();
        departuresList.get(1).click();
    }

    public TravelocityCarsPage selectThirdResultCar(){
        botonSelectDeparture.click();
        return new TravelocityCarsPage(getDriver());
    }

}
