import org.junit.jupiter.api.*;
import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InfiniteScrollTest {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    String script,path;
    static Logger logger = Logger.getLogger(InfiniteScrollTest.class.getName());
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html");
//        path = System.getProperty("web-driver.chrome.driver");
//        logger.log(Level.WARNING,path);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;

        logger.log(Level.INFO,"Driver Initialized");
    }
    @Test
    void test(){
        script = "arguments[0].scrollIntoView();";
        By pLocator = By.tagName("p");
        List<WebElement> paragraphs = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pLocator,0));
        int initParagraphsNumber = paragraphs.size();
        WebElement lastParagraph = driver.findElement(By.xpath(String.format("//p[%d]",initParagraphsNumber)));
        js.executeScript(script,lastParagraph);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pLocator, initParagraphsNumber));
        logger.log(Level.INFO,"Scrolling successful.");
    }
    @AfterAll
    void teardown(){
        driver.quit();
        logger.log(Level.INFO,"Driver teardown success.");
    }
}
