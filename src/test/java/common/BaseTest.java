package common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest
{
    protected AndroidDriver driver;
    static protected UiAutomator2Options options;

    @BeforeAll
    static void commonOptions()
    {
        options = new UiAutomator2Options();
        options.setPlatformName(MobilePlatform.ANDROID);
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


}
