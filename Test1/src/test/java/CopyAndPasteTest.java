import org.apache.commons.lang3.SystemUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.assertj.core.api.Assertions.*;
import java.util.logging.Logger;
import java.util.logging.Level;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CopyAndPasteTest {
    WebDriver driver;
    WebElement inputText, textArea;
    Actions action ;
    Logger logger = Logger.getLogger(DragAndDropTest.class.getName());

    @BeforeAll
    void init(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form");
        action = new Actions(driver);
        logger.log(Level.INFO,"Initialization successful.");
    }

    @Test
    void test(){
     inputText = driver.findElement(By.name("my-text"));
     textArea = driver.findElement(By.name("my-textarea"));
     Keys modifier = SystemUtils.IS_OS_MAC ? Keys.COMMAND:Keys.CONTROL;
     action.sendKeys(inputText,"Hello world").keyDown(modifier).sendKeys(inputText,"a").sendKeys(inputText,"c").sendKeys(textArea,"v").build().perform();
     assertThat(inputText.getAttribute("value")).isEqualTo(textArea.getAttribute("value"));
     logger.log(Level.INFO,"Test success");
    }

    @AfterAll
    void teardown(){
//        driver.quit();
//        logger.log(Level.INFO,"Teardown successful.");
    }


}
