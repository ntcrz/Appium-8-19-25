package apps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LaunchAppTest
{
    private AndroidDriver driver;
    static private UiAutomator2Options options;

    @BeforeAll
    static void oneTimeSetup()
    {
        options = new UiAutomator2Options();
        options.setPlatformName(MobilePlatform.ANDROID);
        options.setCapability("appPackage", "com.bsi.appinfo");
        options.setCapability("appActivity","" );
        options.setCapability("appActivity", ".ui.activity.MainActivity");
    }

    @BeforeEach
    void driverSetup() throws MalformedURLException
    {
        driver = new AndroidDriver(new URL("http://192.168.4.44:4723"), options);
    }


    @AfterEach
    void shutDriver()
    {
      driver.quit();

    }

    @Test
    void openApp() throws InterruptedException
    {
        System.out.println("App started....");
        Thread.sleep(8000);
    }
}
