import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)// Used so that only one instance of the class is created for the whole test.
public class DriverSetupTest {
    WebDriver driver;
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
    }

    @Test
    void begun(){
        driver.get("https://www.google.com");
        System.out.println("Title of webpage: "+driver.getTitle());
        System.out.println("URL of current webpage: "+driver.getCurrentUrl());
        System.out.println("Unique handler for current window: "+driver.getWindowHandle());// Unique identifier for the current window
        System.out.println("Session ID: "+ ((RemoteWebDriver)driver).getSessionId());
    }

    @AfterAll
    void teardown(){
        driver.quit();
    }
}
