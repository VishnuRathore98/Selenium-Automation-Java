import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Arrays;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MouseOverTest {
    private static Logger logger = Logger.getLogger(MouseOverTest.class.getName());
    WebDriver driver;
    WebElement image, caption;
    String xpathh;
    List<String> imageList = Arrays.asList("compass","calendar","award","landscape");
    Actions action;
    @BeforeAll
    void init(){
        driver = new ChromeDriver();
        logger.log(Level.INFO,"Driver Instantiated.");

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");
        logger.log(Level.INFO,"Fetched Webpage.");

        action = new Actions(driver);
        logger.log(Level.INFO,"Action Instantiated");
    }
    @Test
    void setup(){
        for (String img : imageList)
        {
            xpathh = String.format("//img[@src='img/%s.png']",img);
            image = driver.findElement(By.xpath(xpathh));
            logger.log(Level.INFO,"WebElement Fetched.");

            action.moveToElement(image).build().perform();
            logger.log(Level.INFO,"Mouse moved to image.");

            caption = driver.findElement(RelativeLocator.with(By.tagName("div")).near(image));
            logger.log(Level.INFO,"Found image caption.");

            assertThat(caption.getText()).containsIgnoringCase(img);
            logger.log(Level.INFO,"Image caption is same as expected.");

        }
    }
    @AfterAll
    void teardown(){
        driver.quit();
        logger.log(Level.INFO,"WebDriver destroyed.");

    }

}
