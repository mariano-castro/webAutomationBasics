package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TravelocityHomePage extends BasePage {

    public TravelocityHomePage(WebDriver driver){
        super(driver);
        driver.get("https://www.travelocity.com/");
    }

    private static final String DD_MM_YYYY = "MM/dd/yyyy";
    private static final String STORE_NAME_XPATH = "//li[@class='%s rc-tree-treenode-switcher-close']//span[@class='rc-tree-checkbox']";
    private static final String DATE_FROM = "flight-departing-hp-flight";
    private static final String DATE_TO = "flight-returning-hp-flight";
    private static final String DATE_CSS_SELECTOR = ".datepicker-cal-date";
    private static final String MIDDLE_LINK_CSS_SELECTOR = "%s .rdtSwitch";
    private static final String DAY_CSS_SELECTOR = "%s .rdtDay:not(.rdtNew):not(.rdtOld)[data-value=\"%s\"]";
    private static final String YEAR_CSS_SELECTOR = "%s .rdtYear[data-value=\"%s\"]";
    private static final String MONTH_CSS_SELECTOR = "%s .rdtMonth";


    @FindBy(id = "tab-hotel-tab-hp")
    public WebElement hotelsButton;

    @FindBy(id = "tab-flight-tab-hp")
    public WebElement flightsButton;

    @FindBy(id = "flight-origin-hp-flight")
    public WebElement flyFrom;

    @FindBy(id = "flight-destination-hp-flight")
    public WebElement flyTo;

    @FindBy(id = "flight-departing-hp-flight")
    public WebElement flyDepartureDate;

    @FindBy(id = "flight-returning-hp-flight")
    public WebElement flyReturnDate;

    @FindBy(id = "flight-adults-hp-flight")
    public WebElement flyAdults;

    @FindBy(id = "flight-children-hp-flight")
    public WebElement flyChildren;

    @FindBy(css = "datepicker-cal-date")
    public WebElement dayButton;

    //Flight+Hotel
    @FindBy(id = "tab-package-tab-hp")
    public WebElement packagesButton;

    @FindBy(id = "fh-fh-hp-package")
    public WebElement flightandhotelButton;

    @FindBy(id = "package-origin-hp-package")
    public WebElement packageFlyFrom;

    @FindBy(id = "package-destination-hp-package")
    public WebElement packageFlyTo;

    @FindBy(id = "package-departing-hp-package")
    public WebElement packageFlyDepartureDate;

    @FindBy(id = "package-returning-hp-package")
    public WebElement packageFlyReturnDate;

    @FindBy(css = "btn-secondary next")
    public WebElement nextMonthButton;

    // Hotels

    @FindBy(id = "hotel-destination-hp-hotel")
    public WebElement goingToInputField;

    @FindBy(id = "hotel-checkin-hp-hotel")
    public WebElement checkInField;

    @FindBy(id = "hotel-checkout-hp-hotel")
    public WebElement checkOutField;

    @FindBy(id = "hotel-1-adults-hp-hotel")
    public WebElement adultsField;

    @FindBy(id = "hotel-1-children-hp-hotel")
    public WebElement childrenField;

    @FindBy(id = "hotel-1-age-select-1-hp-hotel")
    public WebElement ageFirstChildField;

    @FindBy(css = ".on .btn-primary.btn-action.gcw-submit")
    public WebElement searchButton;

    //Cruises
    @FindBy(id="tab-cruise-tab-hp")
    public WebElement cruisesButton;

    @FindBy(id="cruise-destination-hp-cruise")
    public WebElement selectCruiseDestination;

    @FindBy(css = "[value='europe']")
    public WebElement europeDestination;

    @FindBy(id="length-10-14-ember1330")
    public WebElement tenTo14NightsRadioButton;

    @FindBy(className ="strikeout-price-card")
    public WebElement discount;

    @FindBy(className ="col sailing-details")
    public WebElement cruiseDetails;

    public TravelocityResultsPage performFlySearch(String goingFromName, String goingToName, String checkInDate, String checkOutDate, int adultsNumber) throws ParseException, InterruptedException {

        flightsButton.click();
        flyFrom.click();
        flyFrom.sendKeys(goingFromName);
        flyTo.click();
        flyTo.sendKeys(goingToName);
        datePickerFrom(checkInDate, DATE_FROM);
        datePickerTo(checkOutDate, DATE_TO);
        new Select(flyAdults).selectByValue(String.valueOf(adultsNumber));
        searchButton.click();
        //wait.until(ExpectedConditions.visibilityOf((WebElement) By.cssSelector("#resultsContainer article")));

        return new TravelocityResultsPage(getDriver());
    }

    public TravelocityResultsPage performFlyHotelSearch(String goingFromName, String goingToName, String checkInDate, String checkOutDate, int adultsNumber) throws ParseException, InterruptedException {

        packagesButton.click();
        packageFlyFrom.click();
        packageFlyFrom.sendKeys(goingFromName);
        packageFlyTo.click();
        packageFlyTo.sendKeys(goingToName);
        datePickerFrom(checkInDate, DATE_FROM);
        datePickerTo(checkOutDate, DATE_TO);
        new Select(flyAdults).selectByValue(String.valueOf(adultsNumber));
        searchButton.click();
        //wait.until(ExpectedConditions.visibilityOf((WebElement) By.cssSelector("#resultsContainer article")));

        return new TravelocityResultsPage(getDriver());
    }

    /**
     * Given a date select it from the calendar
     *
     * @param date - String Date to select
     * @param dateSelector - String Date selector from the calendar (From or To)
     * @return
     * @throws ParseException
     */
    public TravelocityHomePage datePickerFrom(String date, String dateSelector) throws ParseException, InterruptedException {
        Calendar calendar = convertStringToCalendar(DD_MM_YYYY, date);

        //WebElement selectDate = driver.findElement(By.cssSelector(String.format(DATE_CSS_SELECTOR, dateSelector)));
        WebElement selectDate = driver.findElement(By.id(dateSelector));
        selectDate.click();
        //WebElement middleLink = driver.findElement(By.cssSelector(String.format(MIDDLE_LINK_CSS_SELECTOR, dateSelector)));
        //selectYear(dateSelector, calendar);
        //selectMonth(dateSelector, calendar);
        selectDay(dateSelector, calendar);

        return this;
    }

    /**
     * Given a date select it from the calendar
     *
     * @param date - String Date to select
     * @param dateSelector - String Date selector from the calendar (From or To)
     * @return
     * @throws ParseException
     */
    public TravelocityHomePage datePickerTo(String date, String dateSelector) throws ParseException, InterruptedException {
        Calendar calendar = convertStringToCalendar(DD_MM_YYYY, date);

        //WebElement selectDate = driver.findElement(By.cssSelector(String.format(DATE_CSS_SELECTOR, dateSelector)));
        WebElement selectDate = driver.findElement(By.id(dateSelector));
        selectDate.click();
        //WebElement middleLink = driver.findElement(By.cssSelector(String.format(MIDDLE_LINK_CSS_SELECTOR, dateSelector)));
        WebElement nextMonth = driver.findElement(By.cssSelector(".btn-secondary.next"));
        nextMonth.click();

        //selectYear(dateSelector, calendar);
        //selectMonth(dateSelector, calendar);
        selectDay(dateSelector, calendar);

        return this;
    }

    /**
     * Select and click a year from the calendar
     *
     * @param dateSelector - String Date selector from the calendar (From or To)
     * @param calendar - Calendar with the given date
     * @return
     */
    private TravelocityHomePage selectYear(String dateSelector, Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int yearDiff = year - Calendar.getInstance().get(Calendar.YEAR);
        if (yearDiff != 0) {
            WebElement middleLink = driver.findElement(By.cssSelector(String.format(MIDDLE_LINK_CSS_SELECTOR, dateSelector)));
            middleLink.click();

            WebElement yearSelector = driver.findElement(By.cssSelector(String.format(YEAR_CSS_SELECTOR, dateSelector, year)));
            yearSelector.click();
        }
        return this;
    }

    /**
     * Select and click a month from the calendar
     *
     * @param dateSelector - String Date selector from the calendar (From or To)
     * @param calendar - Calendar with the given date
     * @return
     */
    private TravelocityHomePage selectMonth(String dateSelector, Calendar calendar) {
        int month = calendar.get(Calendar.MONTH);
        List<WebElement> listAllMonthToBook = driver
                .findElements(By.cssSelector(String.format(MONTH_CSS_SELECTOR, dateSelector)));
        listAllMonthToBook.get(month).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(String.format(MIDDLE_LINK_CSS_SELECTOR, dateSelector))));
        return this;
    }

    /**
     * Select and click a day from the calendar
     *
     * @param dateSelector - String Date selector from the calendar (From or To)
     * @param calendar - Calendar with the given date
     * @return
     */
    private TravelocityHomePage selectDay(String dateSelector, Calendar calendar) throws InterruptedException {
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String selectedDay = Integer.toString(day);
        List <WebElement> days= driver.findElements(By.cssSelector("[data-day='"+selectedDay+"']"));
        //WebElement dayElement = driver.findElement(By.cssSelector(String.format(DAY_CSS_SELECTOR, dateSelector, day)));
        WebElement dayElement = days.get(1);
        dayElement.click();
        Thread.sleep(3000);
        return this;
    }

    /**
     * Utility to get the actual date time
     *
     * @return String - Date & Time in YYMMDDHHMM format
     */
    public static String getDateTime() {
        String actualDateTime;
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        year = year % 100;
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        actualDateTime = Integer.toString(year) + String.format("%02d", month) + String.format("%02d", day)
                + String.format("%02d", hour) + String.format("%02d", minutes);
        return actualDateTime;
    }

    /**
     * Convert String date to Calendar
     *
     * @param formatDate - String format date
     * @param stringDate - String date given
     * @return Calendar with Date given
     * @throws ParseException
     */
    public static Calendar convertStringToCalendar(String formatDate, String stringDate) throws ParseException {
        SimpleDateFormat simpleDateFromat = new SimpleDateFormat(formatDate);
        Date date = simpleDateFromat.parse(stringDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public Calendar addDays(Calendar date, int days) throws ParseException {
        date.add(Calendar.DATE, days);
        return date;
    }

}
