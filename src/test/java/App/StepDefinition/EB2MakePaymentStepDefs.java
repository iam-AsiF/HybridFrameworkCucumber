package App.StepDefinition;

import App.POM.AppElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static App.StepDefinition.EB1LoginStepDefs.driver;

public class EB2MakePaymentStepDefs {

    AppElements app = new AppElements(driver);
    // we can call it outside as we only import single class driver

    @Given("user clicks on thr make payment tab")
    public void userClicksOnThrMakePaymentTab() {
        app.makePaymentTab();
    }

    @When("user inserts {string} and {string} and {string}")
    public void userInsertsPhoneAndNameAndAmount(String phone, String name, String amount) throws InterruptedException {
        app.dataInsertion(phone, name, amount);
    }

    @And("user selects country")
    public void userSelectsCountry() throws InterruptedException {
        app.selectCountry();
    }

    @And("user clicks on send payment button")
    public void userClicksOnSendPaymentButton() {
        app.paymentButton();
    }

    @Then("user closes the alert selecting ok and confirms payment")
    public void userClosesTheAlertSelectingOkAndConfirmsPayment() {
        app.AlertForPayment();
    }
}
