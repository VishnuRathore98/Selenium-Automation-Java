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
    Set<Cookie> cookieSet;
    

    @BeforeAll
    void setup(){

    }
    @Test
    void test(){

    }
    @AfterAll
    void teardown(){

    }
}