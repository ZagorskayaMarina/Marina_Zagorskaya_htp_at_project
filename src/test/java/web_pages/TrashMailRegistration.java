package web_pages;

import application_items.booking.MailGenerator;
import application_items.booking.PasswordGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.MyProperty;
import web_driver.Driver;

import java.util.Properties;

public class TrashMailRegistration {
    WebDriver driver;
    private String propPath = "src/test/resources/booking/mail.properties";
    private Properties properties = MyProperty.getProperties(propPath);

    //Mailbox main page, create new user
    @FindBy (xpath = "//*[@href='#tab-mob-register']")
    private WebElement newUserTab;

    @FindBy(xpath = "//div[@id='tab-mob-register']//descendant::input[@ng-model='user.name']")
    private WebElement userName;

    @FindBy(xpath = "//div[@id='tab-mob-register']//descendant::input[@ng-model='user.password']")
    private WebElement password;

    @FindBy(xpath = "//div[@id='tab-mob-register']//descendant::input[@ng-model='user.passwordRepeat']")
    private WebElement repeatPassword;

    @FindBy(xpath = "//div[@id='tab-mob-register']//descendant::input[@ng-model='user.email']")
    private WebElement realEmail;

    @FindBy(xpath = "//button[contains(@ng-click, 'true')]")
    private WebElement registrationFormSubmit;

    public TrashMailRegistration(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void createMail(WebDriver driver) throws InterruptedException {
        driver.navigate().to("https://trashmail.com/");
        newUserTab.click();
        Thread.sleep(2000);
        userName.click();
        String trashMailUserName = MailGenerator.generateRandomMail();
        userName.sendKeys(trashMailUserName);
        properties.setProperty("MAILBOX_USER", trashMailUserName);
        System.out.println(trashMailUserName + " is set to prop");
        password.click();
        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useDigits(true)
                .useLower(true)
                .useUpper(true)
                .build();
        String randomPassword = passwordGenerator.generate(15);
        properties.setProperty("MAILBOX_PSW", randomPassword);
        System.out.println(randomPassword + " is set to prop");
        password.sendKeys(randomPassword);
        repeatPassword.click();
        repeatPassword.sendKeys(randomPassword);
        realEmail.click();
        realEmail.sendKeys("ee1vp@yandex.by");
        Thread.sleep(2000);
        registrationFormSubmit.click();
    }

}
