package com.automation.uitests;

import com.automation.pageobjects.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Calendar;

public class TravelocityResultsPageTest extends BaseTest{

    String goingFromName = "LAS";
    String goingToName = "LAX";
    String checkInDate = "11/20/2019";
    String checkOutDate = "11/27/2019";
    String goingToHotel = "Montevideo, Uruguay";
    int adultsNumber = 1;
    int childrenNumber = 0;


    TravelocityHomePage home1;
    TravelocityFlightResultsPage flightResult;
    TravelocityHotelsResultsPage hotelsResult;
    TravelocityHotelRoomsPage hotelRooms;
    TravelocityCarsPage carsPage;
    TravelocityWhosTravelingPage whosTravelingPage;



    @Test(alwaysRun = true)
    public void flightSearch() throws ParseException, InterruptedException {
        home1 = new TravelocityHomePage(myDriver.getDriver());
        flightResult = home1.performFlySearch(goingFromName, goingToName,checkInDate, checkOutDate, adultsNumber);
        WebDriverWait wait = new WebDriverWait(myDriver.getDriver(), 20);
        flightResult.ensureTravelocityResultsPage();
        flightResult.sortByDurationShorter();
        flightResult.selectFirstResult();
        flightResult.selectThirdResult();
        flightResult.popUpClose();

        //result1 = home1.performFlyHotelSearch(goingFromName, goingToName,checkInDate, checkOutDate, adultsNumber);
    }

    @Test
    public void flightAndHotelSearch() throws ParseException, InterruptedException {
        home1 = new TravelocityHomePage(myDriver.getDriver());
        //Calendar checkInDay = Calendar.getInstance()
        hotelsResult = home1.performFlyHotelSearch(goingFromName, goingToName,checkInDate, checkOutDate, adultsNumber);
        hotelsResult.sortByPrice();
        hotelRooms = hotelsResult.selectThreeStarsHotel();
        flightResult = hotelRooms.selectFirstRoom();
        flightResult.selectFirstResult();
        carsPage = flightResult.selectThirdResultCar();
        whosTravelingPage = carsPage.selectFirstCar();
    }
/*

    @Test
    public void HotelSearch(){
        home1 = new TravelocityHomePage(myDriver.getDriver());
        result1 = home1.performHotelSearch(goingToHotel);
    }*/

}
