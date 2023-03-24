package App.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        tags = "@login or @makePayment or @mortgageRequest or @expenseReport",

        features = {"src/test/resources/Feature/App/EB1Login.feature",
                "src/test/resources/Feature/App/EB2MakePayment.feature",
                "src/test/resources/Feature/App/EB3MortgageRequest.feature",
                "src/test/resources/Feature/App/EB4ExpenseReport.feature"
        },

        glue = {"App/StepDefinition"},

        monochrome = true, dryRun = false, // runs feature file from class, so false to stop

        plugin = {
                "pretty", "html:build/reports/feature.html"
        }
)

@Test
public class ExperiBankTestRunner extends AbstractTestNGCucumberTests {


}

