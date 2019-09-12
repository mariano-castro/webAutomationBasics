package com.automation.uitests;

import com.automation.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;

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
    public void loadPage() throws ParseException {
        home1 = new TravelocityHomePage(myDriver.getDriver());
        result1 = home1.performFlySearch(goingFromName, goingToName,checkInDate, checkOutDate, adultsNumber);
    }

    /*
    @Test
    public void searchHotel_Correct() {
        Assert.assertNotEquals(result1.flexList.size(), 0, "List came empty");
    }

    @Test(enabled = false)
    public void searchByProperty_Correct() {
        result1.searchByProperty(propertyName);
        Assert.assertEquals("a", "a");
    }
    */


}
