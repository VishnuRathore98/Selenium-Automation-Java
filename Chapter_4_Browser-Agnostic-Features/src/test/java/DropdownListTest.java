import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DropdownListTest {
    WebDriver driver;
    Select select;
    String optionLabel="Three";
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
    }
    @Test
    void test(){
        select = new Select(driver.findElement(By.name("my-select")));
        select.selectByVisibleText(optionLabel);
        assertThat(select.getFirstSelectedOption().getText()).isEqualTo(optionLabel);
    }
    @AfterAll
    void teardown(){
//        driver.quit();
    }
}