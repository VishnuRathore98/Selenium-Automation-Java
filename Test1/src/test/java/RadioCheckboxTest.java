import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RadioCheckboxTest {
    private static final Logger log = LogManager.getLogger(RadioCheckboxTest.class);
    WebDriver driver;
    WebElement radio, check;
    @BeforeAll
    void init(){
        driver = new ChromeDriver();
    }
    @BeforeEach
    void setup(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form");
        radio = driver.findElement(By.id("my-check-2"));
        check = driver.findElement(By.id("my-radio-2"));

    }
    @Test
    void test(){
        radio.click();
        check.click();
    }
    @AfterEach
    void verify(){
        assertThat(radio.isSelected()).isTrue();
        log.warn("Radio button selected.\n");
        assertThat(check.isSelected()).isTrue();
        log.warn("Checkbox selected.\n");
    }
    @AfterAll
    void teardown(){
        driver.quit();
        log.warn("All tests passed!");
    }
}
