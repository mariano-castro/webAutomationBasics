package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public boolean ensureWhosTravelingPage (){
        return (whosTravelingTitle.isDisplayed() && firstName.isDisplayed() && lastName.isDisplayed() && countryForm.isDisplayed() && genderMaleButton.isDisplayed());
    }
}
