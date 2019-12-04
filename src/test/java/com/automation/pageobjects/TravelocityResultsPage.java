package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import javax.swing.text.html.parser.Element;
import java.util.List;

public abstract class TravelocityResultsPage extends BasePage {
    public TravelocityResultsPage(WebDriver driver){
        super(driver);
    }

    // selecciona el boton select del primer resultado
    @FindBy(css = ".bColumn ul li:first-child .t-select-btn")
    public WebElement botonSelectDeparture;

    @FindBy(css = "#inpHotelNameMirror")
    public WebElement hotelNameSearch;

    @FindBy(css = "#forcedChoiceNoThanks")
    public WebElement linkNoThanks;

    @FindBy(css = "#hotelNameGoBtn")
    public WebElement hotelNameButton;

    @FindBy(css = "#modalCloseButton")
    public WebElement modalCloseButton;

    @FindBy(css = "#resultsContainer article")
    public List<WebElement> flexList;

    @FindBy(className = "starRating secondary")
    public WebElement starRating;

    @FindBy(id="sortDropdown")
    public WebElement sortBy;

    @FindBy(className="btn-secondary btn-action t-select-btn")
    public WebElement selectButton;

    @FindBy(css = "[value='duration:asc']")
    public WebElement durationShorterButton;

    @FindBy(className= "btn-secondary btn-action t-select-btn")
    public List<WebElement> selectButtons;

    @FindBy(id="forcedChoiceNoThanks")
    public WebElement noThanks;

    @FindBy(className = "packagePriceTotal")
    public WebElement tripTotalPrice;

    @FindBy(className = "flex-card flex-tile details OD0")
    public WebElement departureInformation;

    @FindBy(className = "flex-card flex-tile details OD1")
    public WebElement returnInformation;

    @FindBy(className = "btn-primary btn-action bookButton")
    public WebElement bookingButton;

    @FindBy(css = "[data-opt-group='Price']")
    public WebElement  buttonSortByPrice;





    //HotelsResultsPage
    @FindBy(className = "uitk-cell all-cell-3-4 all-x-gutter-six")
    public List <WebElement> hotelsResults;

    @FindBy(className="uitk-badge-text")
    public WebElement sponsored;
//.listing-photo-gallery .uitk-badge-text

    public By modalBy = new By.ByCssSelector("");

    public void searchByProperty(String hotelName){
        hotelNameSearch.click();
        hotelNameSearch.sendKeys(hotelName);
        hotelNameButton.click();

        //return new TravelocityResultsPage(getDriver());
        hotelsResults.get(0).findElement(By.cssSelector("uitk-badge-text"));
    }

    public boolean ensureTravelocityResultsPage(){
        return (sortBy.isDisplayed() && selectButtons.get(0).isDisplayed()); // && flightDuration.isDisplayed() && flightDetail.isDisplayed());
    }

    public void sortByDurationShorter(){
        sortBy.click();
        durationShorterButton.click();
    }

    public void selectFirstResult(){
        botonSelectDeparture.click();
    }

    public void selectThirdResult(){
        botonSelectDeparture.click();
    }

    public void popUpClose(){
        if(/*driver.elementEXISTSindom89(By)&& */noThanks.isDisplayed()){
            noThanks.click();
        }
    }

    public void sortByPrice(){
        buttonSortByPrice.click();
    }

    //        getWait().until(ExpectedConditions.elementToBeClickable(hotelNameSearch));

}
