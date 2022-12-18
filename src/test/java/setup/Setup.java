package setup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Setup {
    public AndroidDriver driver;
    public static final String PACKAGE_NAME ="com.continuum.emi.calculator";

    @BeforeTest
    public AndroidDriver setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "MyDeviceMyDevice");
        caps.setCapability("platformName", "Android");
        caps.setCapability("uuid", "emulator-5554");
        caps.setCapability("appPackage", "com.continuum.emi.calculator");
        caps.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");
        caps.setCapability("uuid", "emulator-5554");
        caps.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/emi-calculator.apk");
        caps.setCapability("autoGrantPermissions", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        System.out.println(path);

    }
}


