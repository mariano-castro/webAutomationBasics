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

    //  Vuelos

    @FindBy(id = "flight-origin-hp-flight")
    public WebElement flyFrom;

    @FindBy(id = "flight-destination-hp-flight")
    public WebElement flyTo;

    @FindBy(css = "#flight-departing-hp-flight")
    public WebElement flyDeparture;

    @FindBy(css = "#flight-returning-hp-flight")
    public WebElement flyReturn;

    @FindBy(css = "#flight-adults-hp-flight")
    public WebElement flyAdults;

    @FindBy(css = "#flight-children-hp-flight")
    public WebElement flyChildren;

    // Hotels

    @FindBy(css = "#hotel-destination-hp-hotel")
    public WebElement goingToInputField;

    @FindBy(css = "#hotel-checkin-hp-hotel")
    public WebElement checkInField;

    @FindBy(css = "#hotel-checkout-hp-hotel")
    public WebElement checkOutField;

    @FindBy(css = "#hotel-1-adults-hp-hotel")
    public WebElement adultsField;

    @FindBy(css = "#hotel-1-children-hp-hotel")
    public WebElement childrenField;

    @FindBy(css = "#hotel-1-age-select-1-hp-hotel")
    public WebElement ageFirstChildField;

    @FindBy(css = ".on .btn-primary.btn-action.gcw-submit")
    public WebElement searchButton;

    // chanchada

    @FindBy(css = "#inpHotelNameMirror")
    public WebElement hotelNameSearch;

    @FindBy(css = "#hotelNameGoBtn")
    public WebElement hotelNameButton;

    @FindBy(css = "#modalCloseButton")
    public WebElement modalCloseButton;

    @FindBy(css = "#resultsContainer article")
    public List<WebElement> flexList;

    // selecciona el boton select del primer resultado
    @FindBy(css = ".bColumn ul li:first-child .t-select-btn")
    public WebElement botonSelectDeparture;

    @FindBy(css = "#forcedChoiceNoThanks")
    public WebElement linkNoThanks;



    public travelocityResultsPage performSearch(String goingToName, String checkInDate, String checkOutDate, int adultsNumber, int childrenNumber, int ageFirstChild ) throws InterruptedException {

        hotelButton.click();
        goingToInputField.click();
        goingToInputField.sendKeys(goingToName);
        checkInField.click();
        checkInField.sendKeys(checkInDate);
        checkOutField.click();
        checkOutField.sendKeys(checkOutDate);
        new Select(adultsField).selectByValue(String.valueOf(adultsNumber));
        new Select(childrenField).selectByValue(String.valueOf(childrenNumber));
        getWait().until(ExpectedConditions.elementToBeClickable(ageFirstChildField));
        new Select(ageFirstChildField).selectByValue(String.valueOf(ageFirstChild));
        searchButton.click();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e) {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }

        hotelNameSearch.click();
        hotelNameSearch.sendKeys("Faena Hotel Miami Beach");
        hotelNameButton.click();

        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e) {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }


        return new travelocityResultsPage(getDriver());
    }

    public travelocityResultsPage performFlySearch(String from, String to, int flyingAdults, int flyingChildren ){

        flyButton.click();
        flyFrom.click();
        flyFrom.sendKeys(from);
        flyTo.click();
        flyTo.sendKeys(to);
        /*flyDeparture.click();
        flyDeparture.sendKeys(departureDate);
        flyReturn.click();
        flyReturn.sendKeys(returnDate);*/
        new Select(flyAdults).selectByValue(String.valueOf(flyingAdults));
        new Select(flyChildren).selectByValue(String.valueOf(flyingChildren));
        searchButton.click();

        try
        {
            Thread.sleep(4000);
        }
        catch(InterruptedException e) {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }

        botonSelectDeparture.click();

        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e) {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }

        botonSelectDeparture.click();

        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e) {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }

        linkNoThanks.click();

        return new travelocityResultsPage(getDriver());

    }

}
