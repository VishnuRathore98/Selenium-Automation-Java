import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RangeSliderTest {
    WebDriver driver;
    WebElement slider;
    String initValue, endValue;
    private static final Logger log = LogManager.getLogger(RangeSliderTest.class);


    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
    }
    @Test
    void test(){
        slider = driver.findElement(By.name("my-range"));
        initValue = slider.getAttribute("value");
        log.debug("The initial value of slider is: {}", initValue);
        for (int i=0;i<5;i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        endValue = slider.getAttribute("value");
        log.debug("The final value of the slider is: {}",endValue);
        assertThat(initValue).isNotEqualTo(endValue);
    }
    @AfterAll
    void teardown(){
        driver.quit();
    }
}
