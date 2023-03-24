package App.StepDefinition;

import App.POM.AppElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static App.StepDefinition.EB1LoginStepDefs.driver;

public class EB3MortgageRequestStepDefs {

    AppElements app = new AppElements(driver);
    // we can call it outside as we only import single class driver

    @Given("user clicks on the mortgage request tab")
    public void userClicksOnTheMortgageRequestTab() throws InterruptedException {
        app.mortgageRequest();
    }

    @When("user inserts {string} and {string}")
    public void userInsertsFirstNameAndLastName(String firstName, String lastName) {
        app.dataName(firstName, lastName);
    }

    @And("user selects {string} and {string} and {string}")
    public void userSelectsAgeAndAddressAndAddress(String age, String address1, String address2) throws InterruptedException {
        app.ageAndAddress(age, address1, address2);
    }

    @And("selects country for mortgage")
    public void selectsCountryForMortgage() throws InterruptedException {
        app.selectCountryMortgage();
    }

    @And("press next button")
    public void pressNextButton() {
        app.nextButton();
    }


    @And("selects type of loan from dropdown")
    public void selectsTypeOfLoanFromDropdown() {
        app.typesOfLoan();
    }

    @And("selects number of years from dropdown")
    public void selectsNumberOfYearsFromDropdown() throws InterruptedException {
        app.numberOfYears();
    }

    @And("selects type of occupation from dropdown")
    public void selectsTypeOfOccupationFromDropdown() throws InterruptedException {
        app.typeOfOccupation();
    }

    @And("selects yearly income from dropdown")
    public void selectsYearlyIncomeFromDropdown() throws InterruptedException {
        app.yearlyIncome();
    }

    @Then("closes mortgage payment by clicking on save button")
    public void closesMortgagePaymentByClickingOnSaveButton() throws InterruptedException {
        app.saveMortgage();
    }
}
