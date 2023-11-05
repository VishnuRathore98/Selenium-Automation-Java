import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class KeyboardActionsTest {
    WebDriver driver;
    String text = "Hello, this is test.";
    WebElement textArea;

    @BeforeAll
    @DisplayName("Setting up web-driver.")
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
    }
    @BeforeEach
    @DisplayName("Finding text area element.")
    void initialize(){
        textArea = driver.findElement(By.id("my-text-id"));
    }
    @Test
    @DisplayName("Sending data to text area.")
    void test(){
        textArea.sendKeys(text);
    }
    @AfterEach
    @DisplayName("Checking sent data at text area and clearing it.")
    void testResult(){
        assertThat(textArea.getAttribute("value")).isEqualTo(text);
        textArea.clear();
        assertThat(textArea.getAttribute("value")).isEmpty();
    }
    @AfterAll
    @DisplayName("Now quitting the web-driver instance.")
    void teardown(){
        driver.quit();
    }
}
