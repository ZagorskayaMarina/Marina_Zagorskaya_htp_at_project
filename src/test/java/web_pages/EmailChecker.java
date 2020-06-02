package web_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.MyProperty;

import java.util.Properties;

public class EmailChecker {
    WebDriver driver;
    private String propPath = "src/test/resources/booking/mail.properties";
    private Properties properties = MyProperty.getProperties(propPath);

    @FindBy(xpath = "//a[@data-statlog='notifications.mail.logout.title']")
    private WebElement postLink;

    @FindBy(xpath = "//a[contains(@class, '_sign-in-button')]")
    private WebElement signInPostAcc;

    @FindBy(xpath = "//input[contains(@id, 'passp-field-login')]")
    private WebElement login;

    @FindBy(xpath = "//div[contains(@class, 'passp-sign-in-button')]//button[@type='submit']")
    private WebElement submitLogin;

    @FindBy(xpath = "//input[contains(@id, 'passp-field-passwd')]")
    private WebElement passwordField;

    @FindBy(xpath = "//div[contains(@class, 'passp-button passp-sign-in-button')]//button[@type='submit']")
    private WebElement passwordSubmit;

    @FindBy(xpath = "//span[contains(@title, 'TrashMail.com - E-Mail Registration')][1]")
    private WebElement letterSearch;

    @FindBy(xpath = "//a[contains(@href,'confirm_email')]")
    private WebElement confirmation;

    public EmailChecker(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void loginInPost(WebDriver driver){
        driver.navigate().to("https://yandex.by/");
        postLink.click();
        signInPostAcc.click();
        login.click();
        login.sendKeys("ee1vp@yandex.by");
        submitLogin.click();
        passwordField.click();
        passwordField.sendKeys("MarEE1!");
        passwordSubmit.click();
    }

    public void confirmRegistration(WebDriver driver){
        letterSearch.click();
        confirmation.click();
    }
}
