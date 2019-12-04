package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TravelocityHotelRoomsPage extends BasePage {

    public TravelocityHotelRoomsPage(WebDriver driver){
        super(driver);
        driver.get("https://www.travelocity.com/");
    }

    @FindBy(css="btn-sub-action book-button")
    public List<WebElement> selectRooms;

    public TravelocityFlightResultsPage selectFirstRoom(){
        selectRooms.get(0).click();
        return new TravelocityFlightResultsPage(getDriver());
    }
}
