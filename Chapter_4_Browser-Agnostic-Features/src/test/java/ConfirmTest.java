import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConfirmTest {
    WebDriver driver;
    String URL="https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html";
    WebDriverWait wait;
    Alert confirm;

    @BeforeAll
    void setup(){
    driver = new ChromeDriver();
    driver.get(URL);
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Test
    void test(){
        driver.findElement(By.id("my-confirm")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        confirm = driver.switchTo().alert();
        assertThat(confirm.getText()).isEqualTo("Is this correct?");
        confirm.dismiss();
    }
    @AfterAll
    void teardown(){
//        driver.quit();
    }
    
}
