import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BrowserNavigationHistoryTest {
    WebDriver driver;
    String baseURL, firstPage, secondPage, thirdPage;
    @BeforeAll
    void setup(){
        baseURL = "https://bonigarcia.dev/selenium-webdriver-java/";
        firstPage = baseURL+"navigation1.html";
        secondPage = baseURL+"navigation2.html";
        thirdPage = baseURL+"navigation3.html";
        driver = new ChromeDriver();
    }
    @Test
    void test(){
        driver.get(firstPage);
        driver.navigate().to(secondPage);
        driver.navigate().to(thirdPage);
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        assertThat(driver.getCurrentUrl()).isEqualTo(thirdPage);
    }
    @AfterAll
    void teardown(){
        driver.quit();
    }
}
