import org.junit.jupiter.api.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.assertj.core.api.Assertions.*;
import java.util.logging.Logger;
import java.util.logging.Level;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DragAndDropTest {
    WebDriver driver;
    Actions action;
    WebElement draggable,target;
    Logger logger = Logger.getLogger(DragAndDropTest.class.getName());

    @BeforeAll
    void init(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop");
        action = new Actions(driver);
        logger.log(Level.INFO,"Initialization successful.");
    }
    @Test
    void setup(){
        draggable = driver.findElement(By.id("draggable"));
        Point initLocation = draggable.getLocation();
        action.dragAndDropBy(draggable,100,0).dragAndDropBy(draggable,0,100).dragAndDropBy(draggable,-100,0).dragAndDropBy(draggable,0,-100).build().perform();
        assertThat(draggable.getLocation()).isEqualTo(initLocation);
        logger.log(Level.INFO,"Moved and replaced.");

        target = driver.findElement(By.id("target"));
        action.dragAndDrop(draggable, target).build().perform();
        assertThat(target.getLocation()).isEqualTo(draggable.getLocation());
        logger.log(Level.INFO,"Successfully placed to the target location");
    }
    @AfterAll
    void teardown(){
        driver.quit();
        logger.log(Level.INFO,"Teardown successful.");
    }
}