import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EditCookiesTest {
    WebDriver driver;
    WebElement refresh;
    Options options;
    Cookie userName, editedCookie, readCookie;
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/cookies.html");
        options = driver.manage();
    }
    @Test
    void test(){
        userName = options.getCookieNamed("username");
        editedCookie = new Cookie(userName.getName(),"new-value");
        options.addCookie(editedCookie);
        readCookie = options.getCookieNamed(userName.getName());
        assertThat(editedCookie).isEqualTo(readCookie);
        driver.findElement(By.id("refresh-cookies")).click();
    }
    @AfterAll
    void teardown(){
        driver.quit();
    }

}