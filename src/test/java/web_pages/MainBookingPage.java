package web_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_driver.Config;
import web_driver.Driver;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainBookingPage {
    WebDriver driver = Driver.getDriver();

    public void navigateToPage() {
        driver.navigate().to("https://booking.com/");
    }

    public void enterCity(String city) {
        driver.findElement(By.cssSelector(".c-autocomplete__input")).sendKeys(city);
    }

    public void enterDate(int dayBeforeStartDate, int dayOfStay) {
        driver.findElement(By.xpath("//*[@id='frm']//descendant::div[@class='xp__dates xp__group']")).click();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, dayBeforeStartDate);
        Date threeDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, dayOfStay);
        Date tenDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays = dateFormat.format(threeDays);
        String datePlusTenDays = dateFormat.format(tenDays);
        driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusThreeDays))).click();
        driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusTenDays))).click();
    }
// //*[@class = 'bui-stepper__display']
    public void enterGuestData(int adults, int children, int rooms) {
        WebElement guestField = driver.findElement(By.xpath("//*[contains(@for, 'xp__guests__input')]"));
        guestField.click();
        WebElement adultPlus = driver.findElement(By.xpath("//*[contains(@aria-describedby, 'group_adults_desc')][2]"));
        WebElement childrenPlus = driver.findElement(By.xpath("//*[contains(@aria-describedby, 'group_children_desc')][2]"));
        WebElement roomPlus = driver.findElement(By.xpath("//*[contains(@aria-describedby, 'no_rooms_desc')][2]"));
        if (adults > 2) {
            for (int i = 3; i <= adults; i++) {
                adultPlus.click();
            }
        }
        if (children > 0) {
            for (int i = 1; i <= children; i++) {
                childrenPlus.click();
            }
        }
        if (rooms > 1) {
            for (int i = 2; i <= rooms; i++) {
                roomPlus.click();
            }
        }
    }

    public void search() throws InterruptedException {
        driver.findElement(By.xpath("//*[contains(@class, 'sb-searchbox__button')]")).click();
        Thread.sleep(2000);
    }

}
