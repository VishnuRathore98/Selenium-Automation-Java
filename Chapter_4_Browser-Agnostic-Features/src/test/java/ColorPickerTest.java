import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.Color;
import java.util.logging.Logger;
import java.util.logging.Level;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ColorPickerTest{
    WebDriver driver;
    WebElement picker;
    JavascriptExecutor js;
    String color;
    Logger logger = Logger.getLogger(ColorPickerTest.class.getName());
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
    }
    @Test
    void test(){
        picker = driver.findElement(By.name("my-colors"));
        color = picker.getAttribute("value");
        js = (JavascriptExecutor) driver;

        logger.log(Level.INFO,String.format("The value for picker is %s",color));
        Color red = new Color(255,0,0,1);
        String script = String.format("arguments[0].setAttribute('value','%s')",colorToHex(red));
        js.executeScript(script,picker);
        String finalColor = picker.getAttribute("value");
        logger.log(Level.INFO,String.format("The value for new picker is %s",finalColor));
        assertThat(finalColor).isNotEqualTo(color);
//        assertThat(Color.getColor(finalColor)).isEqualTo(red);
    }
    @AfterAll
    void teardown(){
        driver.quit();
    }

    /**
     * @param color
     * @return Hexcode
     */
    public static String colorToHex(@org.jetbrains.annotations.NotNull Color color) {
        return String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
    }
}