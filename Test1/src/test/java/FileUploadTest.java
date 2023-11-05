import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FileUploadTest {
    WebDriver driver;
    WebElement inputField;
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
    }
    @Test
    void test() throws IOException {
        inputField = driver.findElement(By.name("my-file"));
        Path tempFile = Files.createTempFile("tempFiles",".tmp");
        String fileName = tempFile.toAbsolutePath().toString();
        inputField.sendKeys(fileName);
        driver.findElement(By.tagName("form")).submit();
    }
    @AfterAll
    void teardown(){
        driver.quit();
    }

}
