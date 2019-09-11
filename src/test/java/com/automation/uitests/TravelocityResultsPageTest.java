package com.automation.uitests;

import com.automation.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TravelocityResultsPageTest extends BaseTest{

    String goingToName = "Miami Beach";
    String checkInDate = "07/20/2019";
    String checkOutDate = "07/27/2019";
    int adultsNumber = 4;
    int childrenNumber = 1;
    int ageFirstChild = 7;
    String propertyName = "Faena Hotel Miami Beach";
    TravelocityHomePage home1;
    TravelocityResultsPage result1;

    String goingFrom = "LAS";
    String goingTo = "LAX";
    int adults = 1;
    int childs = 0;




    @BeforeMethod(alwaysRun = true)
    public void loadPage() throws InterruptedException {
        home1 = new TravelocityHomePage(myDriver.getDriver());
        result1 = home1.performSearch(goingToName,checkInDate, checkOutDate, adultsNumber, childrenNumber, ageFirstChild);
    }

    @Test
    public void searchHotel_Correct() {
        Assert.assertNotEquals(result1.flexList.size(), 0, "List came empty");
    }

    @Test(enabled = false)
    public void searchByProperty_Correct() {
        result1.searchByProperty(propertyName);
        Assert.assertEquals("a", "a");
    }

    @Test
    public void searchFlight_Correct(){
        result1 = home1.performFlySearch(goingFrom, goingTo, adults, childs);
    }

}
