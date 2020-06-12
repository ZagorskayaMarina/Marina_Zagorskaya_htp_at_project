package runners.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"tests.booking"},
        features = {"src\\test\\resources\\features\\booking\\Paris.feature"}
)
public class RunnerParisTest {
}
