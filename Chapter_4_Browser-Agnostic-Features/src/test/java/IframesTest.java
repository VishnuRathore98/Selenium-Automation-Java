import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *Frames and iframes are both used in web development,
 *to divide a web page into multiple sections.
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IframesTest {
    WebDriverWait wait;
    WebDriver driver;
    By pName;
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/iframes.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        pName = By.tagName("p");
    }
    @Test
    void test(){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("my-iframe"));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pName, 0));
        List<WebElement> paragraphs = driver.findElements(pName);
        assertThat(paragraphs).hasSize(20);

    }

}
