import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContextAndDoubleClickTest {
    WebDriver driver;
    WebElement dropdown1, dropdown2, dropdown3, contextMenu1, contextMenu2, contextMenu3;
    Actions action;
    @BeforeAll
    void initialization(){
        driver = new ChromeDriver();
        action = new Actions(driver);
    }
    @BeforeEach
    void setup(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");
        dropdown1 = driver.findElement(By.id("my-dropdown-1"));
        dropdown2 = driver.findElement(By.id("my-dropdown-2"));
        dropdown3 = driver.findElement(By.id("my-dropdown-3"));
    }
    @Test
    void test(){
        dropdown1.click();
        contextMenu1 = driver.findElement(By.xpath("//ul[@class='dropdown-menu show']"));
        assertThat(contextMenu1.isDisplayed()).isTrue();

        action.contextClick(dropdown2).build().perform();
        contextMenu2 = driver.findElement(By.id("context-menu-2"));

        action.doubleClick(dropdown3).build().perform();
        contextMenu3 = driver.findElement(By.id("context-menu-3"));
    }
    @AfterEach
    void verify(){
        assertThat(contextMenu2.isDisplayed()).isTrue();
        assertThat(contextMenu3.isDisplayed()).isTrue();
    }
    @AfterAll
    void teardown(){
        driver.quit();
        System.out.println("All tests passed!");
    }
}
