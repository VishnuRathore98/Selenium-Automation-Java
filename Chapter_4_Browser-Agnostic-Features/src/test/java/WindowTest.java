import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WindowTest {
    WebDriver driver;
    WebDriver.Window window;
    Point initialPosition, maximisedPosition;
    Dimension initialSize, maximisedSize;
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        window = driver.manage().window();
    }
    @Test
    void test(){
        initialPosition = window.getPosition();
        initialSize = window.getSize();
        window.maximize();
//        window.fullscreen();
        System.out.println("Initial window position: "+initialPosition+" , size: "+initialSize);
        maximisedPosition = window.getPosition();
        maximisedSize = window.getSize();
        System.out.println("Maximized window position: "+maximisedPosition+", size: "+maximisedSize);
        assertThat(initialPosition).isNotEqualTo(maximisedPosition);
        assertThat(initialSize).isNotEqualTo(maximisedSize);
    }
//    @AfterAll
//    void teardown(){
//        driver.quit();
//    }
}
