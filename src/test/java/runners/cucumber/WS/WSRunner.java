package runners.cucumber.WS;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"tests.cucumber.WS"},
        features = {"src\\test\\resources\\features\\WS\\FindingUsers.feature"}
)
public class WSRunner {
}
