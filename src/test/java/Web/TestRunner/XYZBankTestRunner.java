package Web.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        tags = "@addCustomer or @openAccount or @deleteCustomer",

        features = {"src/test/resources/Feature/Web/bml1AddCustomer.feature",
                "src/test/resources/Feature/Web/bml2OpenAccount.feature",
                "src/test/resources/Feature/Web/bml3DeleteCustomer.feature"},

        glue = {"Web/StepDefinition"},

        monochrome = true, dryRun = false, // runs feature file from class, so false to stop

        plugin = {
                "pretty", "html:build/reports/feature.html"
        }
)

@Test
public class XYZBankTestRunner extends AbstractTestNGCucumberTests {

}
