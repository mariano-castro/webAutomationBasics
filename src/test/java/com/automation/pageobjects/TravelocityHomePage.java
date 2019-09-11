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

    @FindBy(css = "#section-flight-tab-hp")
    public WebElement flyButton;

    @FindBy(css = "#tab-flight-tab-hp")
    public WebElement flyButton2;

    @FindBy(css = "#flight-origin-hp-flight")
    public WebElement flyFrom;

    @FindBy(css = "#flight-destination-hp-flight")
    public WebElement flyTo;

    @FindBy(css = "#flight-departing-hp-flight")
    public WebElement flyDepartureDate;

    @FindBy(css = "#flight-returning-hp-flight")
    public WebElement flyReturnDate;

    @FindBy(css = "#flight-adults-hp-flight")
    public WebElement flyAdults;

    @FindBy(css = "#flight-children-hp-flight")
    public WebElement flyChildren;

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
