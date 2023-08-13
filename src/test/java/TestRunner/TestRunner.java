package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinitions", "Hooks"},
        tags = "@TrelloAutomation",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {

}
