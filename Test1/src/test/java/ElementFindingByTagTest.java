import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ElementFindingByTagTest {
    WebDriver driver;
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
    }
    @Test
    void execution(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form");
        WebElement textarea = driver.findElement(By.tagName("textarea"));
        assertThat(textarea.getDomAttribute("rows")).isEqualTo("3");
    }
    @AfterAll
    void teardown(){
        driver.quit();
    }
}
