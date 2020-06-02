package web_pages;

import utility.MailGenerator;
import utility.PasswordGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.MyProperty;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class TrashMailRegistration {
    WebDriver driver;
    private String propPath = "src/test/resources/booking/mail.properties";
    private Properties properties = MyProperty.getProperties(propPath);

    //TrashMail main page Quick
    @FindBy (xpath = "//*[@id='fe-name']")
    private WebElement newDisposableEmailAddress;

    @FindBy (xpath = "//*[@id='fe-forward']")
    private WebElement realEmail;

    @FindBy (xpath = "//*[@id='fe-fwd-nb']//following-sibling::div//option[@label='1 day']")
    private WebElement numberOfForwards;

    @FindBy (xpath = "//*[@id='fe-fwd-nb']//following-sibling::div//option[@label='10']")
    private WebElement lifeSpan;

    @FindBy (xpath = "//*[@id='fe-submit']")
    private WebElement createDisposableEmailAddress;

    //TrashMail main page, create new user
    @FindBy (xpath = "//*[@href='#tab-mob-register']")
    private WebElement newUserTab;

    @FindBy(xpath = "//div[@id='tab-mob-register']//descendant::input[@ng-model='user.name']")
    private WebElement userName;

    @FindBy(xpath = "//div[@id='tab-mob-register']//descendant::input[@ng-model='user.password']")
    private WebElement password;

    @FindBy(xpath = "//div[@id='tab-mob-register']//descendant::input[@ng-model='user.passwordRepeat']")
    private WebElement repeatPassword;

//    @FindBy(xpath = "//div[@id='tab-mob-register']//descendant::input[@ng-model='user.email']")
//    private WebElement realEmailNewUserTab;

    @FindBy(xpath = "//button[contains(@ng-click, 'true')]")
    private WebElement registrationFormSubmit;

    public TrashMailRegistration(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void createDisposableEmailAddress(WebDriver driver) throws IOException, InterruptedException {
        driver.navigate().to("https://trashmail.com/");
        Thread.sleep(10000);
        newDisposableEmailAddress.click();
        String disposableEmailAddress = MailGenerator.generateRandomMail();
        disposableEmailAddress = disposableEmailAddress.concat("@trashmail.com");
        OutputStream out = new FileOutputStream(propPath);
        properties.put("TRASHMAIL_USER", disposableEmailAddress);
        properties.store(out, null);
        newDisposableEmailAddress.sendKeys(disposableEmailAddress);
        realEmail.click();
        realEmail.sendKeys(properties.getProperty("REAL_MAIL"));
        numberOfForwards.click();
        lifeSpan.click();
        createDisposableEmailAddress.click();
    }

    public void createMail(WebDriver driver) throws InterruptedException {
        newUserTab.click();
        Thread.sleep(2000);
        userName.click();
        String trashMailUserName = MailGenerator.generateRandomMail();
        userName.sendKeys(trashMailUserName);
        properties.setProperty("TRASHMAIL_USER", trashMailUserName);
        System.out.println("prop TRASHMAIL_USER is: " + properties.getProperty("TRASHMAIL_USER"));
        password.click();
        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useDigits(true)
                .useLower(true)
                .useUpper(true)
                .build();
        String randomPassword = passwordGenerator.generate(15);
        properties.setProperty("TRASHMAIL_PSW", randomPassword);
        System.out.println("prop TRASHMAIL_PSW is: " + properties.getProperty("TRASHMAIL_PSW"));
        password.sendKeys(randomPassword);
        repeatPassword.click();
        repeatPassword.sendKeys(randomPassword);
        realEmail.click();
        realEmail.sendKeys("ee1vp@yandex.by");
        properties.setProperty("REAL_MAIL", "ee1vp@yandex.by");
        System.out.println("prop REAL_MAIL is: " + properties.getProperty("REAL_MAIL"));
        Thread.sleep(2000);
        registrationFormSubmit.click();
    }

}
