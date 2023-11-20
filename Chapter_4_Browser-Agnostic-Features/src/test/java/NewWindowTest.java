/**
 * A tab opens in the current window only,
 * on the other hand a window opens separately.
 */

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NewWindowTest {
    WebDriver driver;
    String URL1 = "https://bonigarcia.dev/selenium-webdriver-java", URL2 = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html", initHandle;
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get(URL1);
        initHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(URL2);

    }
    @Test
    void test() throws InterruptedException {
        assertThat(driver.getWindowHandles().size()).isEqualTo(2);
        driver.switchTo().window(initHandle);
        Thread.sleep(Duration.ofSeconds(3));
        driver.close();
        assertThat(driver.getWindowHandles().size()).isEqualTo(1);
    }
    @AfterAll
    void teardown(){
//        driver.quit();
    }
}