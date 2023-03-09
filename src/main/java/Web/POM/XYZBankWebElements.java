package Web.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;

public class XYZBankWebElements {

    static WebDriver driver;

    public XYZBankWebElements(WebDriver driver) {
        XYZBankWebElements.driver = driver;
    }

    public void BankManagerLoginOption() throws InterruptedException {
        driver.findElement(By.xpath("//button[(text()='Bank Manager Login')]")).click();
        Thread.sleep(2000);
    }

    public void addCustomerTab() {
        driver.findElement(By.xpath("(//div[@class=\"ng-scope\"]//descendant::button)[3]")).click();
    }

    public void customerData(String firstName, String lastName, String postCode) throws InterruptedException {
        By fName = By.xpath("//input[@placeholder=\"First Name\"]");
        driver.findElement(fName).sendKeys(firstName);
        By lName = By.xpath("//input[@placeholder=\"Last Name\"]");
        driver.findElement(lName).sendKeys(lastName);
        By pCode = By.xpath("//input[@placeholder=\"Post Code\"]");
        driver.findElement(pCode).sendKeys(postCode);
        Thread.sleep(1500);
    }

    public void addCustomerButton() throws InterruptedException {
        driver.findElement(By.xpath("(//div[@class=\"ng-scope\"]//descendant::button)[6]")).click();
        Thread.sleep(1500);
    }

    public void confirmationMsg1() throws InterruptedException {
        // handle alert contained 'ok' button - getting text as well
        String message = driver.switchTo().alert().getText();
        System.out.println(message);
        driver.switchTo().alert().accept();
        Thread.sleep(1500);
    }


    // Manger opens account with the newly created customer
    public void openAccountTab() throws InterruptedException {
        By account = By.xpath("(//div[@class=\"ng-scope\"]//descendant::button)[4]");
        driver.findElement(account).click();
        Thread.sleep(1500);
    }

    public void selectCustomer() throws InterruptedException {
//        WebElement dropdown1 = driver.findElement(By.xpath("(//div[@class=\"ng-scope\"]//descendant::select)[1]"));
//        Select sl = new Select(dropdown1);
//        sl.selectByVisibleText("john test");

        // or

//        WebElement dropdown1 = driver.findElement(By.xpath("(//div[@class=\"ng-scope\"]//descendant::select)[1]"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(dropdown1).perform();
//        actions.click().perform();
//        for (int i=0; i<=8; i++){
//            actions.sendKeys(Keys.ARROW_DOWN).perform();
//        }
//        actions.sendKeys(Keys.ENTER).perform();

        // or

        // open dropdown
        WebElement dropdownCustomer = driver.findElement(By.xpath("(//div[@class=\"ng-scope\"]//descendant::select)[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdownCustomer).perform();
        actions.click().perform();
        actions.click().perform();
        // put all elements in a list - all the options - with ArrayList
        ArrayList<WebElement> list = new ArrayList<>(driver.findElements(By.xpath("((//div[@class=\"ng-scope\"]//descendant::select)[1]//option)")));
        int size = list.size(); // get list size
        System.out.println(size);
        // merge list size with the incomplete xpath
        // example - by.xpath("address"+mergeValue+"address")
        WebElement newCustomer = driver.findElement(By.xpath("((//div[@class=\"ng-scope\"]//descendant::select)[1]//option)[" + size + "]"));
        // verify the final xpath
        System.out.println("final xpath: " + newCustomer);
        newCustomer.click();
        actions.click().perform();
        Thread.sleep(1500);
    }

    public void selectCurrency() {
        WebElement dropdownCurrency = driver.findElement(By.xpath("(//div[@class=\"ng-scope\"]//descendant::select)[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdownCurrency).perform();
        actions.click().perform();
        // send down arrow key as input
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void processButton() throws InterruptedException {
        driver.findElement(By.xpath("(//div[@class=\"ng-scope\"]//descendant::button)[6]")).click();
        Thread.sleep(1500);
    }

    public void confirmationMsg2() throws InterruptedException {
        // handle alert contained 'ok' button - getting text as well
        String message = driver.switchTo().alert().getText();
        System.out.println(message);
        driver.switchTo().alert().accept();
        Thread.sleep(1500);
    }


    // Manger deletes the newly created customer
    public void customersTab() throws InterruptedException {
        By customer = By.xpath("(//div[@class=\"ng-scope\"]//descendant::button)[5]");
        driver.findElement(customer).click();
        Thread.sleep(1500);
    }

    public void searchCustomer() throws InterruptedException {
        By searchName = By.xpath("(//input[@placeholder=\"Search Customer\"])");
        driver.findElement(searchName).sendKeys("john");
        Thread.sleep(1500);
    }

    public void deleteCustomer() throws InterruptedException {
        driver.findElement(By.xpath("//table[@class=\"table table-bordered table-striped\"]//descendant::button")).click();
        Thread.sleep(1500);
        // clear search box
        WebElement searchBox = driver.findElement(By.xpath("(//input[@placeholder=\"Search Customer\"])"));
        Actions actions = new Actions(driver);
        actions.doubleClick(searchBox).perform();
        actions.sendKeys(Keys.BACK_SPACE).perform();
        Thread.sleep(2000);
    }

}
