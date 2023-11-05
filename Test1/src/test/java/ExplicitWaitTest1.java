import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.Duration;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExplicitWaitTest1 {
    WebDriver driver;
    WebElement image;
    WebDriverWait wait;
    Logger logger = Logger.getLogger(ExplicitWaitTest1.class.getName());
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.log(Level.INFO,"Driver Initiated");
    }
    @Test
    void test(){
        logger.log(Level.INFO,"Finding Element");
        image = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        assertThat(image.getAttribute("src")).containsIgnoringCase("landscape");
        logger.log(Level.INFO,"Element found");
    }
    @AfterAll
    void teardown(){
        driver.quit();
        logger.log(Level.INFO, "Driver teardown.");
    }
}
