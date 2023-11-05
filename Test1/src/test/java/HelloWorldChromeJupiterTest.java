import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldChromeJupiterTest{
    private WebDriver driver;
    @BeforeAll
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setup2(){
        driver = new ChromeDriver();
    }
    @Test
    void test(){
        String URL ="https://www.google.com";
        driver.get(URL);
        String title = driver.getTitle();
        System.out.println(title);
        assertEquals("Google", title);
    }
    @AfterEach
    void teardown(){
        driver.quit();
    }


}
