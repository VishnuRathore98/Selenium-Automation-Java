import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScreenshotBase64Test{
    WebDriver driver;
    TakesScreenshot ts;
    String screenshot;
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        ts = (TakesScreenshot) driver;
    }
    @Test
    void test(){
        screenshot = ts.getScreenshotAs(OutputType.BASE64);
        System.out.println("data:image/png;base64,"+screenshot);
    }
    @AfterAll
    void teardown(){
        driver.quit();
    }
}
