package runners.cucumber.silver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"tests.cucumber.silver"},
        features = {"src\\test\\resources\\features\\silver\\Silver.feature"}
)
public class SilverRunner {
}
