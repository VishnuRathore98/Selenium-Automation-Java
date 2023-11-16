import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AsyncScriptTest{
    WebDriver driver;
    JavascriptExecutor js;
    Duration pause, elapsed;
    String script;
    long initMills;

    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        js = (JavascriptExecutor) driver;
    }

    @Test
    void test(){
        pause = Duration.ofSeconds(2);
        script = "const callback = arguments[arguments.length - 1];"
        + "window.setTimeout(callback,'+ pause toMillis() +')";
        initMills = System.currentTimeMillis();
        js.executeAsyncScript(script);
        elapsed = Duration.ofMillis(System.currentTimeMillis() - initMills);

        assertThat(elapsed).isGreaterThanOrEqualTo(pause);

    }

    @AfterAll
    void teardown(){
        driver.quit();
    }
}
