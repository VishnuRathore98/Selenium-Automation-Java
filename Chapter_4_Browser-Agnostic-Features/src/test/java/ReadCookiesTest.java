import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReadCookiesTest {
    WebDriver driver;
    Options options;
    Set<Cookie> cookieSet;
    Cookie username;

    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/cookies.html");
        options = driver.manage();
    }

    @Test
    void test(){
        cookieSet = options.getCookies();
        assertThat(cookieSet).hasSize(2);
        username = options.getCookieNamed("username");
        assertThat(username.getValue()).isEqualTo("John Doe");
        assertThat(username.getPath()).isEqualTo("/");
        driver.findElement(By.id("refresh-cookies")).click();
    }

    @AfterAll
    void teardown(){
        driver.quit();
    }
}
