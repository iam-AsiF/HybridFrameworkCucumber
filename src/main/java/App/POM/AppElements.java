package App.POM;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class AppElements {
    static AndroidDriver driver;

    public AppElements(AndroidDriver driver) {
        AppElements.driver = driver;
    }

    // default swipe function - using pointOption and longPress
    public void swipeScreen() {
        // first to get the page dimension
        Dimension dimension = driver.manage().window().getSize();
        int height = dimension.getHeight();
        int width = dimension.getWidth();

        // now to decide the point where we want to touch and hold first
        int startX = width / 2, startY = (int) (height * 0.6);
        // then the point where we will scroll and release touch
        int endX = width / 2, endY = (int) (height * 0.1);

        // now the scroll method with pointOption
        TouchAction touchAction = new TouchAction<>(driver);
        touchAction
                .longPress(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    // login
    public void login(String userName, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@text='Username']")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@text='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@text='Login']")).click();
    }

    // Make payment
    public void makePaymentTab() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@text='Make Payment']")).click();
    }

    public void dataInsertion(String phone, String name, String amount) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        By PhnNumber = By.xpath("//*[@text='Phone']");
        driver.findElement(PhnNumber).sendKeys(phone);
        By cusName = By.xpath("//*[@text='Name']");
        driver.findElement(cusName).sendKeys(name);
        By money = By.xpath("//*[@text='Amount']");
        driver.findElement(money).sendKeys(amount);
    }

    public void selectCountryPayment() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@text='Select']")).click();
        // using touchScroll method until an Element is visible
        Thread.sleep(1500); // need fixed wait here
        for (int i = 0; i < 2; i++) {
            swipeScreen();
        }
        driver.findElement(By.xpath("//*[@text='Bangladesh']")).click();
    }

    // scroll with dimension for selectCountry


    public void paymentButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@text='Send Payment']")).click();
    }

    public void AlertForPayment() throws InterruptedException {
        Thread.sleep(1500);
        driver.switchTo().alert().accept();
    }

    // Mortgage Request
    public void mortgageRequest() throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@text='Mortgage Request']")).click();
    }

    public void dataName(String firstName, String lastName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@text='First Name']")).sendKeys(firstName);
        driver.findElement(By.xpath("//*[@text='Last Name']")).sendKeys(firstName);
    }

    public void ageAndAddress(String age, String address1, String address2) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@text='Age']")).sendKeys(age);
        driver.findElement(By.xpath("//*[@text='Address 1']")).sendKeys(address1);
        driver.findElement(By.xpath("//*[@text='Address 2']")).sendKeys(address2);
    }


    public void selectCountryMortgage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@text='Select']")).click();
        // using touchScroll method until an Element is visible
        Thread.sleep(1500); // need fixed wait here
        for (int i = 0; i < 2; i++) {
            swipeScreen();
        }
        driver.findElement(By.xpath("//*[@text='Bangladesh']")).click();
    }

    public void nextButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
    }

    public void typesOfLoan() {
        driver.findElement(By.xpath("//*[@text='Education']")).click();
    }

    public void numberOfYears() throws InterruptedException {
        Thread.sleep(1500);
        swipeScreen();
        driver.findElement(By.xpath("//*[@text='5']")).click();
    }

    public void typeOfOccupation() throws InterruptedException {
        Thread.sleep(1500);
        swipeScreen();
        driver.findElement(By.xpath("//*[@text='Private Job']")).click();
    }

    public void yearlyIncome() throws InterruptedException {
        Thread.sleep(1500);
        swipeScreen();
        driver.findElement(By.xpath("//*[@text='10,00,000']")).click();
    }

    public void saveMortgage() throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@text='Save']")).click();
        Thread.sleep(1500);
    }

    // Expense report tav
    public void expenseReport() throws InterruptedException {
        driver.findElement(By.xpath("//*[@text='Expense Report']")).click();
        Thread.sleep(1500);
    }

    public void addExpense() throws InterruptedException {
        // adding two - clicking on the add button
        for (int i = 0; i < 2; i++) {
            driver.findElement(By.xpath("//*[@text='Add']")).click();
        }
        Thread.sleep(1500);
    }

    public void removeExpense() {
        // removing one - by clicking on any of them
        driver.findElement(By.xpath("//*[@text='Expense : 3']")).click();
    }

    public void backAndLogOut() throws InterruptedException {
        // back button
        driver.findElement(By.xpath("//*[@text='Back']")).click();
        Thread.sleep(1500);
        // logout button
        driver.findElement(By.xpath("//*[@text='Logout']")).click();
        Thread.sleep(1500);
        driver.closeApp();
    }

}

