package Api.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;


@CucumberOptions(tags = "@putApi",
        features = {"src/test/resources/Feature/Api/putApi.feature"},
        glue = {"Api/StepDefinition"},
        monochrome = true,
        dryRun = false, // runs feature file so false to stop
        plugin = {
                "pretty", "html:build/reports/feature.html"
        })
@Test
public class PutApiRunnerTests extends AbstractTestNGCucumberTests {

}