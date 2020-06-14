package tests.cucumber;

import application_items.booking.BookingTestData;
import org.openqa.selenium.WebDriver;
import utility.GsonParser;
import web_pages.HotelsPage;
import web_pages.MainBookingPage;

public class StepData {
    public WebDriver driver;
    public String JSONBookingTests = "src/test/resources/booking/bookingTestsData";
    public MainBookingPage mainBookingPage;
    public HotelsPage hotelsPage;
    public GsonParser gsonParser;
    public BookingTestData test;
    int priceOfHotel;
    int budgetCategory;


}
