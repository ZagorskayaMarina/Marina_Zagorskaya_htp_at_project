package web_pages;

import application_items.Ingredient;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web_driver.Driver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HotelsPage {
    WebDriver driver = Driver.getDriver();
    Actions builder = new Actions(driver);

    String priceCategoryPattern = "//*[@id='filter_price']//a[%s]/label/div";
    public void selectPriceCategory(int idPriceCategory) {
        driver.findElement(By.xpath(String.format(priceCategoryPattern, idPriceCategory))).click();
    }

    public int retrievePriceFromCategory(int idPriceCategory) {
        String priceFromCategory = driver.findElement(By.xpath(String.format(priceCategoryPattern, idPriceCategory))).getText().replaceAll("[^0-9]+","");
        return Integer.parseInt(priceFromCategory);
    }

    public void sortByPrice() throws InterruptedException {
        driver.findElement(By.xpath("//*[contains(@class,'sort_category   sort_price')]/a")).click();
    }

    String hotelPricePattern = "//*[contains(@class,'bui-price-display__value')][1]";
    public int getPriceOfHotelPerNight(int hotelId, int numberOfNight) {
        String firstHotelPrice = driver.findElement(By.xpath(String.format(hotelPricePattern, hotelId))).getText();
        String firstHotelPriceReplace = firstHotelPrice.replaceAll("[^0-9]+","");
        int priceDay = Integer.parseInt(firstHotelPriceReplace)/numberOfNight;
        return priceDay;
    }

    String starsTreeXpathPattern = "//*[@id='filter_class']//*[contains(@data-id, 'class-%s')]";
    public void selectStarsOfHotel(int stars) throws InterruptedException {

        WebElement threeStars = driver.findElement(By.xpath(String.format(starsTreeXpathPattern, stars)));
        builder.click(threeStars).perform();
        
        Thread.sleep(2000);
    }

    String hotelIdPattern = "//*[@data-hotelid][%s]";
    public WebElement findHotelById(int hotelId) {
        return driver.findElement(By.xpath(String.format(hotelIdPattern, hotelId)));
    }

    String hotelIdAddressPattern = "//*[@data-hotelid][%s]//h3/a";
    public WebElement addressHotelById(int hotelId) {
        return driver.findElement(By.xpath(String.format(hotelIdAddressPattern, hotelId)));
    }

    public void scrollToElement(WebElement el) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", el);
    }

    public void focusMouse(WebElement address) {
        builder.moveToElement(address).build().perform();
    }

    public void changeBackgroundColor(WebElement el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", el);
    }

    public void changeTextColor(WebElement address) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", address);
    }
}
