package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TravelocityHomePage extends BasePage {

    public TravelocityHomePage(WebDriver driver){
        super(driver);
        driver.get("https://www.travelocity.com/");
    }

    @FindBy(id = "tab-hotel-tab-hp")
    public WebElement hotelsButton;

    @FindBy(id = "tab-flight-tab-hp")
    public WebElement flightsButton;

    @FindBy(id = "flight-origin-hp-flight")
    public WebElement flyFrom;

    @FindBy(id = "flight-destination-hp-flight")
    public WebElement flyTo;

    @FindBy(id = "flight-departing-hp-flight")
    public WebElement flyDepartureDate;

    @FindBy(id = "flight-returning-hp-flight")
    public WebElement flyReturnDate;

    @FindBy(id = "flight-adults-hp-flight")
    public WebElement flyAdults;

    @FindBy(id = "flight-children-hp-flight")
    public WebElement flyChildren;

    // Hotels

    @FindBy(id = "hotel-destination-hp-hotel")
    public WebElement goingToInputField;

    @FindBy(id = "hotel-checkin-hp-hotel")
    public WebElement checkInField;

    @FindBy(id = "hotel-checkout-hp-hotel")
    public WebElement checkOutField;

    @FindBy(id = "hotel-1-adults-hp-hotel")
    public WebElement adultsField;

    @FindBy(id = "hotel-1-children-hp-hotel")
    public WebElement childrenField;

    @FindBy(id = "hotel-1-age-select-1-hp-hotel")
    public WebElement ageFirstChildField;

    @FindBy(css = ".on .btn-primary.btn-action.gcw-submit")
    public WebElement searchButton;


    public TravelocityResultsPage performFlySearch(String goingFromName, String goingToName, String checkInDate, String checkOutDate, int adultsNumber) throws InterruptedException {

        flyButton.click();
        flyFrom.click();
        flyFrom.sendKeys(goingFromName);
        flyTo.click();
        flyTo.sendKeys(goingToName);
        flyDepartureDate.click();
        flyDepartureDate.sendKeys(checkInDate);
        flyReturnDate.click();
        flyReturnDate.sendKeys(checkOutDate);
        searchButton.click();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e) {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }

        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e) {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }

        return new TravelocityResultsPage(getDriver());
    }

}
