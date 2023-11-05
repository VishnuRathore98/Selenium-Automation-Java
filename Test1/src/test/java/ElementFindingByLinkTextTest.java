import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ElementFindingByLinkTextTest {
    WebDriver driver;
    WebElement linkByText,linkByPartialText;
    @BeforeAll
    void setupDriver(){
        driver = new ChromeDriver();
    }
    @BeforeEach
    void getPage(){
        driver.get("https://www.bonigarcia.dev/selenium-webdriver-java/web-form");
    }
    @Test
    void findElementByLink(){
        linkByText = driver.findElement(By.linkText("Return to index"));
        assertThat(linkByText.getTagName()).isEqualTo("a");
        assertThat(linkByText.getCssValue("cursor")).isEqualTo("pointer");

        linkByPartialText = driver.findElement(By.partialLinkText("index"));
        assertThat(linkByPartialText.getLocation()).isEqualTo(linkByText.getLocation());
        assertThat(linkByPartialText.getRect()).isEqualTo(linkByText.getRect());

    }
    @Test
    void findElementByPartialLink(){
    }
    @Test
    void linkTest(){}
    @Test
    void partialLinkTest(){}
    @AfterAll
    void teardown(){
        driver.quit();
    }

}
