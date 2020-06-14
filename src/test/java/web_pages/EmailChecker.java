package web_pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.MyProperty;

import java.util.Properties;

public class EmailChecker {

    public static final Logger LOGGER = LogManager.getLogger(EmailChecker.class);
    WebDriver driver;
    private String propPath = "src/test/resources/booking/mail.properties";
    private Properties properties = MyProperty.getProperties(propPath);

    @FindBy(xpath = "//a[@data-statlog='notifications.mail.logout.title']")
    private WebElement postLink;

    @FindBy(css = "input[name=\"login\"]")
    private WebElement login;

    @FindBy(xpath = "//div[contains(@class, 'passp-sign-in-button')]//button[@type='submit']")
    private WebElement submitLogin;

    @FindBy(xpath = "//input[contains(@id, 'passp-field-passwd')]")
    private WebElement passwordField;

    @FindBy(xpath = "//div[contains(@class, 'passp-button passp-sign-in-button')]//button[@type='submit']")
    private WebElement passwordSubmit;

    @FindBy(xpath = "//span[contains(@title, 'TrashMail.com - E-Mail Registration')][1]")
    private WebElement letterSearch;

    @FindBy(xpath = "//")
    private WebElement bookingLeterSearch;

    @FindBy(xpath = "//a[contains(@href,'confirm_email')]")
    private WebElement confirmation;

    public EmailChecker(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void loginInPost() throws InterruptedException {
        LOGGER.debug("Login in real email");
        driver.navigate().to("https://yandex.by/");
        LOGGER.debug(postLink);
        postLink.click();
        Thread.sleep(3000);
        String parentHandle = driver.getWindowHandle();
        for(String childHandle : driver.getWindowHandles()){
            if (!childHandle.equals(parentHandle)){
                driver.switchTo().window(childHandle);
            }
        }
        LOGGER.debug(login);
        login.click();
        login.sendKeys(MyProperty.getProperties(propPath).getProperty("REAL_MAIL"));
        //login.sendKeys("maryna2424@yandex.by"); //КОСТЫЛИ! БРАТЬ ИЗ mail.properties
        LOGGER.debug(submitLogin);
        submitLogin.click();
        Thread.sleep(3000);
        LOGGER.debug(passwordField);
        passwordField.click();
        passwordField.sendKeys(MyProperty.getProperties(propPath).getProperty("REAL_PSW"));
        LOGGER.debug(passwordSubmit);
        passwordSubmit.click();
    }

    public void comfirmTrushRegistration() throws InterruptedException {
        Thread.sleep(2000);
        LOGGER.debug("Confirm TrushEmail Registration");
        LOGGER.debug(letterSearch);
        letterSearch.click();
        Thread.sleep(2000);
        LOGGER.debug(letterSearch);
        confirmation.click();
    }
}
