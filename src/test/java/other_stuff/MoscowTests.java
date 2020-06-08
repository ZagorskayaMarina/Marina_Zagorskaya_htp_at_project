package other_stuff;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MoscowTests {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\user\\Java\\webdrivers\\chrome\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        driver.navigate().to("https://booking.com/");

        WebElement el = driver.findElement(By.cssSelector(".c-autocomplete__input"));
        Actions builder = new Actions(driver);
        builder.click(el).sendKeys("Москва").click().perform();

        WebElement date = driver.findElement(By.xpath("//*[@id='frm']//descendant::div[@class='xp__dates xp__group']"));
        builder.click(date).perform();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        Date tenDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date fifteenDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusTenDays = dateFormat.format(tenDays);
        String dateFifteenTenDays = dateFormat.format(fifteenDays);
        WebElement dateFrom=driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusTenDays)));
        builder.click(dateFrom).perform();
        WebElement dateTo=driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", dateFifteenTenDays)));
        builder.click(dateTo).perform();
        WebElement adults = driver.findElement(By.xpath("//*[contains(@for, 'xp__guests__input')]"));
        builder.click(adults).perform();
        //
        WebElement plusAdult = driver.findElement(By.xpath("//*[contains(@aria-describedby, 'group_adults_desc')][2]"));
        builder.click(plusAdult).click(plusAdult).perform();

        WebElement plusRoom = driver.findElement(By.xpath("//*[contains(@aria-describedby, 'no_rooms_desc')][2]"));
        builder.click(plusRoom).perform();

        WebElement search = driver.findElement(By.xpath("//*[contains(@class, 'sb-searchbox__button')]"));
        builder.click(search).perform();

        //*[contains(@class, 'filter_label')]
        // why I can't find element by Xpath //*div[@id='filter_price'], but I can find by Xpath //*[@id='filter_price']
        Thread.sleep(2000);

        WebElement minPriceCategory = driver.findElement(By.xpath("//*[@id='filter_price']//a[1]/label/div"));
        builder.click(minPriceCategory).perform();
        Thread.sleep(2000);

        String priceFromCategory = minPriceCategory.getText();
        System.out.println(priceFromCategory);

        priceFromCategory = priceFromCategory.replaceAll("[^0-9]+","");
        int price = Integer.parseInt(priceFromCategory);

        WebElement sortData = driver.findElement(By.xpath("//*[contains(@class,'sort_category   sort_price')]/a"));
        sortData.click();
        Thread.sleep(4000);

        WebElement betterPriceHotel = driver.findElement(By.xpath("//*[contains(@class,'bui-price-display__value')][1]"));

        String export = betterPriceHotel.getText();
        System.out.println(export);

        export = export.replaceAll("[^0-9]+","");
        int priceDay = Integer.parseInt(export)/7;
        System.out.println(priceDay);
        Assert.assertTrue(priceDay <= price);
        //I can't get error message if test was failed
        //assert priceDay >= price: "No way";

        driver.close();
        driver.quit();

    }
}