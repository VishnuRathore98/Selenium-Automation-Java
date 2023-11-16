import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.junit.jupiter.api.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScreenshotPngTest{
    WebDriver driver;
    TakesScreenshot ts;
    Path destination;
    File screenshot;
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        ts = (TakesScreenshot) driver;
    }
    @Test
    void test(){
        try {
            screenshot = ts.getScreenshotAs(OutputType.FILE);
            destination = Paths.get("screenshot.png");
            Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        assertThat(destination).exists();

    }
    @AfterAll
    void teardown(){
        driver.quit();
    }
}
