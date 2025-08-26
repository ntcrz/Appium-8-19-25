package apps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest
{
    private AndroidDriver driver;
    static private UiAutomator2Options options;

    @BeforeAll
    static void oneTimeSetup()
    {
        options = new UiAutomator2Options();
        options.setPlatformName(MobilePlatform.ANDROID);
        options.setCapability("appPackage", "com.google.android.calculator");
        options.setCapability("appActivity","com.android.calculator2.Calculator" );
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
    void multiply8x9() throws InterruptedException
    {
        WebElement k8 = driver.findElement(AppiumBy.accessibilityId("8"));
        WebElement kx = driver.findElement(AppiumBy.accessibilityId("multiply"));
        WebElement k9 = driver.findElement(AppiumBy.accessibilityId("9"));
        k8.click();
        kx.click();
        k9.click();

        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        WebElement result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final"));
        String resultString = result.getText().split(" ")[0];
        assertEquals("72",resultString);
        int resultInt = Integer.parseInt(resultString);
        assertEquals(72, resultInt);

        Thread.sleep(8000);
    }

    @Test
    void topButtons() throws InterruptedException {
        List<WebElement> buttons =  driver.findElements(AppiumBy.className("android.widget.ImageButton"));
        buttons.get(4).click();
        Thread.sleep(4000);

        driver.navigate().back();
        Thread.sleep(4000);



    }
}
