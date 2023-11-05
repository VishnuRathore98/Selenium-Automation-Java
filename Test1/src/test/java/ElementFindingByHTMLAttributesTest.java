import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ElementFindingByHTMLAttributesTest {
    WebDriver driver;
    WebElement textByName,textByID;
    List<WebElement> textByClass;

    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
    }

    @BeforeEach
    void getAndFind(){
        driver.get("https://www.bonigarcia.dev/selenium-webdriver-java/web-form");
        // By Name
        textByName = driver.findElement(By.name("my-text"));
        // By ID
        textByID = driver.findElement(By.id("my-text-id"));
        // By Class Name
        textByClass = driver.findElements(By.className("form-control"));
    }

    @Test
    void testingForName(){
        assertThat(textByName.isEnabled()).isTrue();
    }

    @Test
    void testForID(){
        assertThat(textByID.getAttribute("type")).isEqualTo("text");
        assertThat(textByID.getDomAttribute("type")).isEqualTo("text");
        assertThat(textByID.getDomProperty("type")).isEqualTo("text");

        assertThat(textByID.getAttribute("myprop")).isEqualTo("myvalue");
        assertThat(textByID.getDomAttribute("myprop")).isEqualTo("myvalue");
        assertThat(textByID.getDomProperty("myprop")).isNull();
    }

    @Test
    void testForClass(){
        assertThat(textByClass.size()).isPositive();
        assertThat(textByClass.get(0).getAttribute("name")).isEqualTo("my-text");
    }

    @AfterAll
    void teardown(){
        driver.quit();
    }
}
