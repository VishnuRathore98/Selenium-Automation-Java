import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ModalTest {
    WebDriver driver;
    WebDriverWait wait;
    WebElement close;
    final String URL="https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html";
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Test
    void test() throws InterruptedException {
        driver.findElement(By.id("my-modal")).click();
        close = driver.findElement(By.xpath("//button[text()='Close']"));
        assertThat(close.getTagName()).isEqualTo("button");
        wait.until(ExpectedConditions.elementToBeClickable(close));
        Thread.sleep(2);
        close.click();
        Thread.sleep(2);
    }
    @AfterAll
    void teardown(){
        driver.quit();
    }
}
