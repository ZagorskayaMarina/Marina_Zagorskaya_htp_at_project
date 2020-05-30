package runners.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"tests.base", "tests.qui", "tests"},
        features = {
                "src\\test\\resources\\features\\ApiTest.feature"
        },
        //tags = {"@qa or @prod"}, //для того чтобы включался и исключался тест из ApiTest.feature
        monochrome = false, // красивая печать в консоль
        snippets = SnippetType.CAMELCASE, // сам генерирует
        strict = false
)
public class RunTests {
}
