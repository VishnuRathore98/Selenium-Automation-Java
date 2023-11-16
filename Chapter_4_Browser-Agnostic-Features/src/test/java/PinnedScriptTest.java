import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.Color;
import java.util.Set;
import java.util.logging.Logger;
import java.util.logging.Level;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PinnedScriptTest{
    WebDriver driver;
    WebElement picker;
    JavascriptExecutor js;
    String color, initPage;
    Logger logger = Logger.getLogger(PinnedScriptTest.class.getName());
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        initPage = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(initPage);
        js = (JavascriptExecutor) driver;

    }
    @Test
    void test(){
        String script = "return document.getElementsByTagName('a')[2];";
        ScriptKey linkkey = js.pin(script);
        ScriptKey firstArgKye = js.pin("return arguments[0];");

        Set<ScriptKey> pinnedScripts = js.getPinnedScripts();
        assertThat(pinnedScripts).hasSize(2);

        WebElement formLink = (WebElement) js.executeScript(linkkey);
        formLink.click();
        assertThat(driver.getCurrentUrl()).isNotEqualTo(initPage);

        String message = "Hello!";
        String executeScript = (String) js.executeScript(firstArgKye,message);
        assertThat(executeScript).isEqualTo(message);

        js.unpin(linkkey);
        assertThat(js.getPinnedScripts()).hasSize(1);

    }
    @AfterAll
    void teardown(){
        driver.quit();
    }
}