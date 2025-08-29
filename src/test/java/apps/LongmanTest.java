package apps;

import common.BaseTest;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongmanTest extends BaseTest
{
    @BeforeAll
    static void appOptions()
    {
        options.setCapability("appPackage", "advanced3nd.ofamerican.english");
        options.setCapability("appActivity",".view.SplashActivity");
        options.setCapability("appWaitActivity","view.MainTabActivity");
    }

    @Test
    void longman() throws InterruptedException {
        Thread.sleep(8000);
        driver.findElement(AppiumBy.id("advanced3nd.ofamerican.english:id/etValueSearch")).sendKeys("selenium");
        WebElement result = driver.findElement(AppiumBy.id("advanced3nd.ofamerican.english:id/tvWord"));
        assertEquals("selenium", result.getText());
    }

}
