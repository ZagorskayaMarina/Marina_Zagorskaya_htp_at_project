package runners.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"tests.cucumber"},
        features = {"src\\test\\resources\\features\\booking\\AddingToFavorite.feature"}
)

public class AddToFavoriteRunner {
}
