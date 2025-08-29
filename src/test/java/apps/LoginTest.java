package apps;

import common.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.StartsActivity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest
{


    @BeforeAll
    static void addOptions() {
        options.setCapability("appPackage", "com.swaglabsmobileapp");
        options.setCapability("appActivity",".MainActivity");

    }


    @Test
    void validLogin() throws InterruptedException {
        Thread.sleep(8000);
        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();

        WebElement products =
                driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]"));
        assertEquals("PRODUCTS", products.getText());

        String activity = ((StartsActivity)driver).currentActivity();
        assertEquals(".MainActivity", activity);


    }
    @Test
    void invalidLogin() throws InterruptedException {
        Thread.sleep(8000);
        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("aaa");
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("bbb");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();

       WebElement error = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]"));
       String serror = error.getText();
        assertTrue(serror.contains(" do not match"));


    }


}
