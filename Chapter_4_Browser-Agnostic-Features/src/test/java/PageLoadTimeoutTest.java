import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PageLoadTimeoutTest {
    WebDriver driver;
    static final String URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().scriptTimeout(Duration.ofMillis(1));
    }

    @Test
    void test(){
        assertThatThrownBy( () -> driver.get(URL)).isInstanceOf(TimeoutException.class);
    }

    @AfterAll
    void teardown(){
        driver.quit();
    }
}

