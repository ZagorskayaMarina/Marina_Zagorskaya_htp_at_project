package web_pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HotelsPage {
    public static final Logger LOGGER = LogManager.getLogger(HotelsPage.class);
    WebDriver driver;
    Actions builder;

    @FindBy(xpath = "//nav[@aria-label='Pagination']//li[contains(@class, 'pages')]//ul/li[10]")
    private WebElement lastHotelsPage;

    public HotelsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    String priceCategoryPattern = "//*[@id='filter_price']//a[%s]/label/div";
    public void selectPriceCategory(int idPriceCategory) {
        LOGGER.debug("Select price category of hotels");
        LOGGER.debug(priceCategoryPattern);
        driver.findElement(By.xpath(String.format(priceCategoryPattern, idPriceCategory))).click();
    }

    public int retrievePriceFromCategory(int idPriceCategory) {
        LOGGER.debug("Retrieve Value of Price From Category");
        String priceFromCategory = driver.findElement(By.xpath(String.format(priceCategoryPattern, idPriceCategory))).getText().replaceAll("[^0-9]+","");
        return Integer.parseInt(priceFromCategory);
    }

    public void sortByPrice() throws InterruptedException {
        LOGGER.debug("Sort price from smallest to largest");
        driver.findElement(By.xpath("//*[contains(@class,'sort_category   sort_price')]/a")).click();
    }

    String hotelPricePattern = "//*[contains(@class,'bui-price-display__value')][1]";
    public int getPriceOfHotelPerNight(int hotelId, int numberOfNight) {
        LOGGER.debug("Get Price Of Hotel Per Night");
        LOGGER.debug(hotelPricePattern);
        String firstHotelPrice = driver.findElement(By.xpath(String.format(hotelPricePattern, hotelId))).getText();
        String firstHotelPriceReplace = firstHotelPrice.replaceAll("[^0-9]+","");
        int priceDay = Integer.parseInt(firstHotelPriceReplace)/numberOfNight;
        return priceDay;
    }

    String starsTreeXpathPattern = "//*[@id='filter_class']//*[contains(@data-id, 'class-%s')]";
    public void selectStarsOfHotel(int stars) throws InterruptedException {
        LOGGER.debug("Select Stars Of Hotel");
        LOGGER.debug(starsTreeXpathPattern);
        builder = new Actions(driver);
        WebElement threeStars = driver.findElement(By.xpath(String.format(starsTreeXpathPattern, stars)));
        builder.click(threeStars).perform();
        
        Thread.sleep(2000);
    }

    String hotelIdPattern = "//*[@data-hotelid][%s]";
    public WebElement findHotelById(int hotelId) {
        LOGGER.debug("find Hotel By Id");
        LOGGER.debug(hotelIdPattern);
        return driver.findElement(By.xpath(String.format(hotelIdPattern, hotelId)));
    }

    String hotelIdAddressPattern = "//*[@data-hotelid][%s]//h3/a";
    public WebElement addressHotelById(int hotelId) {
        LOGGER.debug("Select address Hotel By Id");
        LOGGER.debug(hotelIdAddressPattern);
        return driver.findElement(By.xpath(String.format(hotelIdAddressPattern, hotelId)));
    }

    public void scrollToElement(WebElement el) throws InterruptedException {
        LOGGER.debug("Scroll to element");
        TimeUnit.SECONDS.sleep(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", el);
    }

    public void focusMouse(WebElement address) {
        LOGGER.debug("focusMouse");
        builder = new Actions(driver);
        builder.moveToElement(address).build().perform();
    }

    public void changeBackgroundColor(WebElement el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", el);
    }

    public void changeTextColor(WebElement address) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", address);
    }

    String heartOfElement = "//div[@id='hotellist_inner']//div[contains(@class, 'photo')]['%s']//button[@type='button']";
    public void saveHotel(String i){
        LOGGER.debug("Save hotel");
        LOGGER.debug(heartOfElement);
        driver.findElement(By.xpath(String.format(heartOfElement, i))).click();
    }

    String numberOfPageInPagination = "//*[contains(@class, 'bui-pagination__item')][10]";// //nav[@aria-label='Pagination']//li[contains(@class, 'pages')]//ul/li[last()]
    public void selectLastPage(){
        LOGGER.debug("Select Last Page");
        LOGGER.debug(numberOfPageInPagination);
        driver.findElement(By.xpath(numberOfPageInPagination)).click();
    }

    public String getColor(){
        LOGGER.debug("Retrieve color of heart");
        String heartColor = driver.findElement(By.xpath(heartOfElement)).getAttribute("style");
        return heartColor;
    }

}
