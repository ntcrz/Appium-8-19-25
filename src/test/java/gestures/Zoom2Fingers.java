package gestures;

import common.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class Zoom2Fingers extends BaseTest
{
    @BeforeAll
    static void loginCaps()
    {
        options.setCapability("appPackage", "com.dmitrybrant.android.multitouch");
        options.setCapability("appActivity",".MultiTouchActivity");
    }

    @Test
    void zoom2fingers() throws InterruptedException {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "indexFinger");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "thumb");

        Sequence indexFinger = new Sequence(finger1, 0);
        Sequence thumb = new Sequence(finger2,0);

        indexFinger.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),300, 500 ))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(10), PointerInput.Origin.viewport(),400, 500))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        thumb.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),400, 600 ))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger2.createPointerMove(Duration.ofSeconds(10), PointerInput.Origin.viewport(),500, 600))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(indexFinger, thumb));
        Thread.sleep(6000);
    }
}
