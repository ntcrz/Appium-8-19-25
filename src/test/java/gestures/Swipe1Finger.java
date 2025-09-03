package gestures;

import common.BaseTest;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class Swipe1Finger extends BaseTest
{
    @BeforeAll
    static void loginCaps()
    {
        options.setCapability("appPackage", "com.bsi.appinfo");
        options.setCapability("appActivity",".ui.activity.MainActivity");
    }

    @Test
    void swipe() throws InterruptedException
    {
        Thread.sleep(8000);
        WebElement r6 = driver.findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.bsi.appinfo:id/recycler_view\"]/android.widget.FrameLayout[6]/android.widget.LinearLayout"));
        int height = r6.getRect().getHeight();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "indexFinger");
        Sequence swiping = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(r6), 0,0))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofSeconds(6), PointerInput.Origin.fromElement(r6),
                        0, -5 * height))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swiping));
        Thread.sleep(5000);
    }
}
