import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.assertj.core.api.Assertions.*;
import java.util.logging.Logger;
import java.util.logging.Level;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClickAndHoldTest {
    Logger logger = Logger.getLogger(ClickAndHoldTest.class.getName());
    WebDriver driver;
    WebElement canvas;
    Actions action;
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/draw-in-canvas");
        action = new Actions(driver);
        logger.log(Level.INFO,"Initialization successful.");
    }
    @Test
    void test(){
        canvas = driver.findElement(By.tagName("canvas"));
        action.moveToElement(canvas).clickAndHold();

        int numPoints = 10;
        int radius = 30;
        for (int i = 0; i <= numPoints; i++) {
            double angle = Math.toRadians((double) (360 * i) /numPoints);
            double x = Math.sin(angle)*radius;
            double y = Math.cos(angle)*radius;
            action.moveByOffset((int) x,(int) y);
        }
        action.release(canvas).build().perform();
    }
    @AfterAll
    void teardown(){
        driver.quit();
    }
}
