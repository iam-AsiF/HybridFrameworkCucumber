package App.Core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Helper {

    DesiredCapabilities dc = new DesiredCapabilities();
    static AndroidDriver driver;

    public AndroidDriver apkLaunch() throws MalformedURLException, InterruptedException {
        dc.setCapability(MobileCapabilityType.UDID, "299edc22");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "SAMSUNG-SM-G930A");
        dc.setCapability("platformVersion", "8.0");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        Thread.sleep(6000);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        return driver;
    }

}
