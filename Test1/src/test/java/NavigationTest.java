import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NavigationTest {
    WebDriver driver;
    @BeforeAll
    void init(){
        driver = new ChromeDriver();
    }
    @BeforeEach
    void setup(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
    }
    @Test
    void test(){
        driver.findElement(By.xpath("//a[text()='Navigation']")).click();
        driver.findElement(By.xpath("//a[text()='Next']")).click();
        driver.findElement(By.xpath("//a[text()='3']")).click();
        driver.findElement(By.xpath("//a[text()='2']")).click();
        driver.findElement(By.xpath("//a[text()='Previous']")).click();

        String text = driver.findElement(By.tagName("body")).getText();
        assertThat(text).contains("Lorem ipsum");
    }
    @AfterAll
    void teardown(){
        driver.quit();
        System.out.println("All tests Passed!");
    }

}
