package App.StepDefinition;

import App.Core.Helper;
import App.POM.AppElements;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class EB1LoginStepDefs {
    static AndroidDriver driver;

    @Given("app apk is there")
    public void appApkIsThere() throws MalformedURLException, InterruptedException {
        Helper hlp = new Helper(); // should put inside function
        driver = hlp.apkLaunch();
    }

    @When("user enters {string}and {string}")
    public void userEntersUsernameAndPass(String userName, String password) throws InterruptedException {
        AppElements app = new AppElements(driver); // should put inside function
        // else it will mix the individual class driver
        app.login(userName, password);
    }

    @Then("user will navigate to home screen")
    public void userWillNavigateToHomeScreen() {
        System.out.println("Ta Da!!");
    }
}
