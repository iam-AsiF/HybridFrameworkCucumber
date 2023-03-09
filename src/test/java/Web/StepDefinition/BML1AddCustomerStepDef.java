package Web.StepDefinition;

import Web.Core.Helper;
import Web.POM.XYZBankWebElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class BML1AddCustomerStepDef {
    static WebDriver driver;

    XYZBankWebElements xyz;

    @Given("Manager lands on the XYZ bank home page")
    public void managerLandsOnTheXYZBankHomePage() {
        Helper hlp = new Helper();
        driver = hlp.chromeLaunch(); // this driver = elementDriver
        driver.manage().window().maximize();
        driver = hlp.webUrl("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @When("manager clicks on bank manager login option")
    public void managerClicksOnBankManagerLoginOption() throws InterruptedException {
        xyz = new XYZBankWebElements(driver);
        xyz.BankManagerLoginOption();
    }

    @And("clicks on add customer tab")
    public void clicksOnAddCustomerTab() {
        xyz.addCustomerTab();
    }

    @And("sends customer {string} and {string} and {string}")
    public void sendsCustomerFirstNameAndLastNameAndPostCode(String firstName, String lastName, String postCode) throws InterruptedException {
        System.out.println("data verification=> first name: " + firstName + ", last Name: " + lastName + ", post code: " + postCode);
        xyz.customerData(firstName, lastName, postCode);
    }

    @And("clicks on add customer button")
    public void clicksOnAddCustomerButton() throws InterruptedException {
        xyz.addCustomerButton();
    }

    @Then("manager closes confirmation alert for newly added customer")
    public void managerClosesConfirmationAlertForNewlyAddedCustomer() throws InterruptedException {
        xyz.confirmationMsg1();
    }
}
