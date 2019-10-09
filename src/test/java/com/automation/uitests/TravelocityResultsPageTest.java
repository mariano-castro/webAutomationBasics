package com.automation.uitests;

import com.automation.pageobjects.*;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Calendar;

public class TravelocityResultsPageTest extends BaseTest{

    String goingFromName = "LAS";
    String goingToName = "LAX";
    String checkInDate = "11/20/2019";
    String checkOutDate = "11/27/2019";
    int adultsNumber = 1;
    int childrenNumber = 0;

    TravelocityHomePage home1;
    TravelocityResultsPage result1;



    @Test(alwaysRun = true)
    public void loadPage() throws ParseException, InterruptedException {
        home1 = new TravelocityHomePage(myDriver.getDriver());
        result1 = home1.performFlySearch(goingFromName, goingToName,checkInDate, checkOutDate, adultsNumber);
        result1.ensureTravelocityResultsPage();
        result1.sortByDurationShorter();
        result1.selectFirstResult();
        result1.selectThirdResult();
        result1.popUpClose();
        //result1 = home1.performFlyHotelSearch(goingFromName, goingToName,checkInDate, checkOutDate, adultsNumber);
    }

    @Test
    public void floghtAndHotelSearch() throws ParseException, InterruptedException {
        home1 = new TravelocityHomePage(myDriver.getDriver());
        //Calendar checkInDay = Calendar.getInstance()
        result1 = home1.performFlyHotelSearch(goingFromName, goingToName,checkInDate, checkOutDate, adultsNumber);
        result1.sortByPrice();


    }

}
