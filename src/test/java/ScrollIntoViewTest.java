import org.junit.jupiter.api.*;
import java.time.Duration;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScrollIntoViewTest {
    WebDriver driver;
    WebElement lastElement;
    String script;
    static Logger logger = Logger.getLogger(ScrollIntoViewTest.class.getName());
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
        logger.log(Level.INFO,"Driver Initialized");
    }
    @Test
    void test(){
        script = "arguments[0].scrollIntoView();";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        lastElement = driver.findElement(By.cssSelector("p:last-child"));
        js.executeScript(script,lastElement);
        logger.log(Level.INFO,"Scrolling successful.");
    }
    @AfterAll
    void teardown(){
        driver.quit();
        logger.log(Level.INFO,"Driver teardown success.");
    }
}
