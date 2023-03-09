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

    public void login(String userName, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@text='Username']")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@text='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@text='Login']")).click();
    }

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

    public void selectCountry() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@text='Select']")).click();
        // using touchScroll method until an Element is visible
        Thread.sleep(3000); // need fixed wait here
        swipeScreen();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@text='Bangladesh']")).click();
    }

    // scroll with dimension for selectCountry
    private void swipeScreen() {
        // first to get the page dimension
        Dimension dimension = driver.manage().window().getSize();
        int height = dimension.getHeight();
        int width = dimension.getWidth();

        // now to decide the point where we want to touch and hold first
        int startX = width / 2, startY = (int) (height * 0.8);
        // then the point where we will scroll and release touch
        int endX = width / 2, endY = (int) (height * 0.1);

        // now the scroll method with pointOption
        TouchAction touchAction = new TouchAction<>(driver);
        touchAction.press(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    public void paymentButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@text='Send Payment']")).click();
    }

    public void AlertForPayment() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().alert().accept();
    }
}

