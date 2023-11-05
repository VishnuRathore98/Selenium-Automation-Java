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
public class ExplicitWaitTest2 {
    WebDriver driver;
    WebElement one,three,plus,equal, answer;
    WebDriverWait wait;
    Logger logger = Logger.getLogger(ExplicitWaitTest1.class.getName());
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.log(Level.INFO,"Driver Initiated");
    }
    @Test
    void test(){
        one = driver.findElement(By.xpath("//span[text()='1']"));
        one.click();

        plus = driver.findElement(By.xpath("//span[text()='+']"));
        plus.click();

        three = driver.findElement(By.xpath("//span[text()='3']"));
        three.click();

        equal = driver.findElement(By.xpath("//span[text()='=']"));
        equal.click();

        wait.until(ExpectedConditions.textToBe(By.className("screen"),"4"));

        logger.log(Level.INFO,"Answer found");
    }
    @AfterAll
    void teardown(){
        driver.quit();
        logger.log(Level.INFO, "Driver teardown.");
    }
}

