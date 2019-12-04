package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TravelocityWhosTravelingPage extends BasePage {

    public TravelocityWhosTravelingPage(WebDriver driver){
        super(driver);
        driver.get("https://www.travelocity.com/");
    }

    @FindBy(className = "faceoff-module-title")
    public WebElement whosTravelingTitle;

    @FindBy(id="firstname[0]")
    public WebElement firstName;

    @FindBy(id="lastname[0]")
    public WebElement lastName;

    @FindBy(className = "cko-field always-include gb-whitelist alpha3CountryCode")
    public WebElement countryForm;

    @FindBy(id="gender_male[0]")
    public WebElement genderMaleButton;

    public void ensureWhosTravelingPage (){
        Assert.assertTrue(whosTravelingTitle.isDisplayed(), "Page title is not displayed");
        Assert.assertTrue(firstName.isDisplayed(), "First name is not displayed");
        Assert.assertTrue(lastName.isDisplayed(), "Last name is not displayed");
        Assert.assertTrue(countryForm.isDisplayed(), "Country form is not displayed");
        Assert.assertTrue(genderMaleButton.isDisplayed(), "Gender male button is not displayed");
        //Assert.assertEquals(whosTravelingTitle.getText(), "Title", "");
        //return (whosTravelingTitle.isDisplayed() && firstName.isDisplayed() && lastName.isDisplayed() && countryForm.isDisplayed() && genderMaleButton.isDisplayed() );
    }
}
