package App.StepDefinition;

import App.POM.AppElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static App.StepDefinition.EB1LoginStepDefs.driver;

public class EB4ExpenseReportStepDefs {

    AppElements app = new AppElements(driver); //making it remember to continue EB1 driver

    @Given("user taps on the expense report button")
    public void userTapsOnTheExpenseReportButton() throws InterruptedException {
        app.expenseReport();
    }

    @When("user adds two  expense report")
    public void userAddsTwoExpenseReport() throws InterruptedException {
        app.addExpense();
    }

    @And("removes one report")
    public void removesOneReport() {
        app.removeExpense();
    }


    @Then("user goes back and logs out and quits the app")
    public void userGoesBackAndLogsOutAndQuitsTheApp() throws InterruptedException {
        app.backAndLogOut();
    }
}
