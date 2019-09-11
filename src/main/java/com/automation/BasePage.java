package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        wait = new WebDriverWait(pDriver, 10);
        driver = pDriver;
    }

    public WebDriverWait getWait(){
        return wait;
    }


    public WebDriver getDriver() {
        return driver;
    }

    @AfterSuite(alwaysRun = true)
    public void dispose(){
        if (driver != null){
            driver.quit();
        }
    }
}
