package tests.booking;
import cucumber.api.java.en.And;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;


public class MoscowSteps {
    private static final Logger LOGGER = LogManager.getLogger(MoscowSteps.class);
    int priceOfHotel;
    int budgetCategory;

    @And("I compare price Moscow")
    public void comparePriceMoscow(){
        ParisSteps parisSteps = new ParisSteps();
        priceOfHotel = parisSteps.getPriceOfHotel();
        budgetCategory = parisSteps.budgetCategory;
        System.out.println("priceOfHotel is: " + priceOfHotel + " budgetCategory is: " + budgetCategory);
        Assert.assertTrue("Verify that the price per night in hotel more than priseOfCathegory", priceOfHotel < budgetCategory);
    }
}
