import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DeleteCookiesTest {
    WebDriver driver;
    WebElement refresh;
    Options options;
    Set<Cookie> cookieSet;
    Cookie userName;
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/cookies.html");
        options = driver.manage();
    }
    @Test
    void test(){
        cookieSet = options.getCookies();
        userName = options.getCookieNamed("username");
        options.deleteCookie(userName);
        assertThat(options.getCookies()).hasSize(cookieSet.size()-1);
        driver.findElement(By.id("refresh-cookies")).click();
    }
    @AfterAll
    void teardown(){
//        driver.quit();
    }
}