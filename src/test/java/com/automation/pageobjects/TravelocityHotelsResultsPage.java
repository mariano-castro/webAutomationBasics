package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TravelocityHotelsResultsPage extends BasePage {

    @FindBy(className = "uitk-cell all-cell-3-4 all-x-gutter-six")
    public List<WebElement> hotelsResults;

    @FindBy(className="uitk-badge-text")
    public WebElement sponsored;

    @FindBy(css = "#inpHotelNameMirror")
    public WebElement hotelNameSearch;

    @FindBy(css = "#hotelNameGoBtn")
    public WebElement hotelNameButton;

    @FindBy(css = ".book-button")
    public List<WebElement> roomOptionList;

    @FindBy(css = "[data-opt-group='Price']")
    public WebElement  buttonSortByPrice;

    @FindBy(className = "icon icon-stars3-0 stars-grey")
    public List<WebElement> threeStarsHotels;


    public TravelocityHotelsResultsPage(WebDriver driver){
        super(driver);
        driver.get("https://www.travelocity.com/");
    }

    public TravelocityHotelsResultsPage searchByProperty(String hotelName){
        hotelNameSearch.click();
        hotelNameSearch.sendKeys(hotelName);
        hotelNameButton.click();
        hotelsResults.get(0).findElement(By.cssSelector("uitk-badge-text"));

        return new TravelocityHotelsResultsPage(getDriver());

    }

    public TravelocityHotelRoomsPage selectThreeStarsHotel(){
        threeStarsHotels.get(0).click();
        return new TravelocityHotelRoomsPage(getDriver());
    }

    public void sortByPrice(){
        buttonSortByPrice.click();
    }

    public void selectFirstRoomOption(){
        roomOptionList.get(0).click();
    }

}
