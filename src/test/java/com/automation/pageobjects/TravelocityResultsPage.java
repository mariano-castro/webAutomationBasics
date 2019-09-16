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

public class TravelocityResultsPage extends BasePage {
    public TravelocityResultsPage(WebDriver driver){
        super(driver);
        driver.get("https://www.travelocity.com/");
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

    public By modalBy = new By.ByCssSelector("");

    public TravelocityResultsPage searchByProperty(String hotelName){
        hotelNameSearch.click();
        hotelNameSearch.sendKeys(hotelName);
        hotelNameButton.click();

        return new TravelocityResultsPage(getDriver());
    }
    /*public OrbitzResultsPage performSearchWait() {
        getWait().until(ExpectedConditions.elementToBeClickable(hotelNameSearch));

        return OrbitzResultsPage(getDriver());
    }*/
}
