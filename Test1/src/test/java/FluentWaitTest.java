import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FluentWaitTest {
    WebDriver driver;
    WebElement image;
    Wait<WebDriver> wait;
    Logger logger = Logger.getLogger(FluentWaitTest.class.getName());
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        logger.log(Level.INFO,"Driver Initiated");
    }
    @Test
    void test(){
        image = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("landscape")));
        assertThat(image.getAttribute("src")).containsIgnoringCase("landscape");
        logger.log(Level.INFO,"Element found.");
    }
    @AfterAll
    void teardown(){
        driver.quit();
        logger.log(Level.INFO, "Driver teardown.");
    }
}


