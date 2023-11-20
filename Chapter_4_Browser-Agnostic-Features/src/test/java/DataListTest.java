import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DataListTest {
    WebDriver driver;
    WebElement option, dataList;
    String optionValue, URL = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get(URL);
    }
    @Test
    void test(){
//        dataList = driver.findElement(By.name("my-datalist"));
//        dataList.click();
        option = driver.findElement(By.xpath("//datalist/option[5]"));
        optionValue = option.getAttribute("value");
//        dataList.sendKeys(optionValue);
        assertThat(optionValue).isEqualTo("Chicago");
    }
    @AfterAll
    void teardown(){
//        driver.quit();
}
}
