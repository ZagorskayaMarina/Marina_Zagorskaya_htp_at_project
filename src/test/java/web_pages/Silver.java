package web_pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.MyProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Silver {
    public static final Logger LOGGER = LogManager.getLogger(Silver.class);
    WebDriver driver;
    private String propPath = "src/test/resources/booking/mail.properties";
    private Properties properties = MyProperty.getProperties(propPath);

    @FindBy(xpath = "//*[@id=\"svg-icon-search\"][1]")
    private WebElement search;

    @FindBy(xpath = "//*[contains(@placeholder, \"Поиск\")]")
    private WebElement searchField;

    @FindBy(xpath = "//span[contains(text(), 'Вход и привилегии')]")
    private WebElement entry;

    @FindBy(xpath = "//*[contains(@placeholder, 'E-mail')]")
    private WebElement email;

    @FindBy(xpath = "//*[contains(@placeholder, 'Пароль')]")
    private WebElement psw;

    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    private WebElement submit;

    @FindBy(xpath = "//div[contains(@style, 'animation')]")
    private WebElement clubLabel;

    public Silver(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void searchWord(String word) throws InterruptedException {
        search.click();
        searchField.sendKeys(word);
        Thread.sleep(2000);
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    public List<Boolean> containWord(String word){
        List<WebElement> movieTitles = driver.findElements(By.xpath("//a[contains(@href, 'afisha')]/span"));
        List<WebElement> movieDescriptions = driver.findElements(By.xpath("//a[contains(@href, 'afisha')]/following-sibling::div/div[1]"));
        List<Boolean> labels = new ArrayList<Boolean>();
        Boolean label;
        for (int i = 0; i < movieTitles.size(); i++){
            String textOfTitle = movieTitles.get(i).getText().toLowerCase();

            String textOfDescription = movieDescriptions.get(i).getText().toLowerCase();

            label = textOfTitle.contains(word) || textOfDescription.contains(word);
            labels.add(label);
            System.out.println(label);
        }
        return labels;
    }

}
