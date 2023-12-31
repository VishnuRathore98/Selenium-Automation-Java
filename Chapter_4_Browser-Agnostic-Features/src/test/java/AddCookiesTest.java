import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddCookiesTest {
    WebDriver driver;
    Options options;
    Cookie newCookie;
    String readValue;

    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/cookies.html");
        options = driver.manage();
        newCookie = new Cookie("new-cookie-key", "new-cookie-value");
    }
    @Test
    void test(){
        options.addCookie(newCookie);
        readValue = options.getCookieNamed(newCookie.getName()).getValue();
        assertThat(newCookie.getValue()).isEqualTo(readValue);
        driver.findElement(By.id("refresh-cookies")).click();
    }
    @AfterAll
    void teardown(){
        driver.quit();
    }
}