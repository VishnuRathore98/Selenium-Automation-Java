import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScriptTimeoutTest {
    WebDriver driver;
    JavascriptExecutor js;
    String URL,script;
    long waitMills;

    @BeforeAll
    void setup(){
        URL = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver = new ChromeDriver();
        driver.get(URL);
        js = (JavascriptExecutor) driver;
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(3));
    }

    @Test
    void test(){
        assertThatThrownBy( () -> {
        waitMills = Duration.ofSeconds(5).toMillis();
        script = "const callback = arguments[arguments.length - 1];"
                +"window.setTimeout(callback,' + waitMills ');";
        js.executeAsyncScript(script);}).isInstanceOf(ScriptTimeoutException.class);
    }

    @AfterAll
    void teardown(){
        driver.quit();
    }
}
