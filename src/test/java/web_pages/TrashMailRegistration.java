package web_pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utility.MailGenerator;
import utility.PasswordGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.MyProperty;
import java.util.Properties;

public class TrashMailRegistration {
    public static final Logger LOGGER = LogManager.getLogger(TrashMailRegistration.class);
    WebDriver driver;
    private String propPath = "src/test/resources/booking/mail.properties";
    private Properties properties = MyProperty.getProperties(propPath);

    //TrashMail main page Quick
    @FindBy (xpath = "//*[@id='fe-name']")
    private WebElement newDisposableEmailAddress;

    @FindBy (xpath = "//*[@id='fe-forward']")
    private WebElement realEmail;

    @FindBy(xpath = "//button[contains(., 'unlimited')]")
    private WebElement forwards;

    @FindBy(xpath = "//span[@class='ng-binding' and text()='10']")
    private WebElement setForwards;

    @FindBy(xpath = "//button[contains(., '1 week')]")
    private static WebElement life;

    @FindBy(xpath = "//span[@class='ng-binding' and text()='1 day']")
    private static WebElement setLife;

    @FindBy (xpath = "//*[@id='fe-submit']")
    private WebElement createDisposableEmailAddress;

    //TrashMail main page, create new user
    @FindBy (xpath = "//*[@href='#tab-register']")
    private WebElement newUserTab;

    @FindBy(xpath = "//div[@id='tab-register']//descendant::input[@ng-model='user.name']")
    private WebElement userName;

    @FindBy(xpath = "//div[@id='tab-register']//descendant::input[@ng-model='user.password']")
    private WebElement password;

    @FindBy(xpath = "//div[@id='tab-register']//descendant::input[@ng-model='user.passwordRepeat']")
    private WebElement repeatPassword;

    @FindBy(xpath = "//div[@id='tab-register']//descendant::input[@ng-model='user.email']")
    private WebElement realEmailNewUser;

    @FindBy(xpath = "//*[@id='tab-register']//div[@class='pull-right tm-home-page-button']/button")
    private WebElement register;

    public TrashMailRegistration(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void createTempEmail() throws InterruptedException {
        LOGGER.debug("Create Temporary Email");

        Thread.sleep(2000);
        LOGGER.debug(newDisposableEmailAddress);
        newDisposableEmailAddress.click();
        String disposableEmailAddress = MailGenerator.generateRandomMail();
        LOGGER.debug(newDisposableEmailAddress);
        newDisposableEmailAddress.clear();
        newDisposableEmailAddress.sendKeys(disposableEmailAddress);
        disposableEmailAddress = disposableEmailAddress.concat("@trashmail.com");
        MyProperty.setProperties(propPath, "TRASHMAIL", disposableEmailAddress);
        LOGGER.debug(realEmail);
        realEmail.click();
        MyProperty.setProperties(propPath, "REAL_MAIL", "ee1vp@yandex.by");
        LOGGER.debug(realEmail);
        realEmail.sendKeys(properties.getProperty("REAL_MAIL"));

        LOGGER.debug(forwards);
        forwards.click();
        Thread.sleep(3000);
        LOGGER.debug(setForwards);
        setForwards.click();
        LOGGER.debug(life);
        life.click();
        LOGGER.debug(setLife);
        setLife.click();

        LOGGER.debug(createDisposableEmailAddress);
        createDisposableEmailAddress.click();
        Thread.sleep(2000);

        //этот алерт не появляется если еще есть попытки, просто происходит редирект на Your alias was created successfully.
        if (driver.findElements(By.className("alert ng-scope top am-fade alert-danger")).size() > 0){
            createUser();
        }

    }

    public void createUser() throws InterruptedException {
        LOGGER.debug("createUser");
        LOGGER.debug(newUserTab);
        newUserTab.click();
        Thread.sleep(2000);
        LOGGER.debug(userName);
        userName.click();
        String trashMailUserName = MailGenerator.generateRandomMail();
        userName.sendKeys(trashMailUserName);
        MyProperty.setProperties(propPath, "TRASHMAIL_USER", trashMailUserName);
        LOGGER.debug(password);
        password.click();

        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder().useDigits(true).useLower(true).useUpper(true).build();

        String randomPassword = passwordGenerator.generate(15);
        LOGGER.debug(password);
        password.sendKeys(randomPassword);
        MyProperty.setProperties(propPath, "TRASHMAIL_PSW", randomPassword);
        LOGGER.debug(repeatPassword);
        repeatPassword.click();
        repeatPassword.sendKeys(randomPassword);
        Thread.sleep(2000);
        LOGGER.debug(register);
        register.click();
    }

}
