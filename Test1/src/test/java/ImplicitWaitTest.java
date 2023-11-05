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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ImplicitWaitTest {
    WebDriver driver;
    WebElement image;
    Actions action;
    Logger logger = Logger.getLogger(ImplicitWaitTest.class.getName());
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        action = new Actions(driver);
        logger.log(Level.INFO,"Instantiation Successful.");
    }
    @Test
    void test(){
        image = driver.findElement(By.id("landscape"));
        assertThat(image.getAttribute("id")).isEqualTo("landscape");
        assertThat(image.getAttribute("src")).containsIgnoringCase("landscape");
        logger.log(Level.INFO,"Image found and test successful.");
    }
    @AfterAll
    void teardown(){
        driver.quit();
        logger.log(Level.INFO, "Termination Successful.");
    }
}
