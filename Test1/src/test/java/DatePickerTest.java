import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DatePickerTest {
    WebDriver driver;
    WebElement datePicker, monthElement, arrowLeft, monthPastYear, dayElement;
    int currentYear, currentDay;
    String oneYearBack, expectedDate;
    LocalDate today, previousYear;
    DateTimeFormatter dateFormat;

    @BeforeAll
    void build(){
    driver = WebDriverManager.chromedriver().create();
    driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
    today = LocalDate.now();
    currentYear = today.getYear();
    currentDay = today.getDayOfMonth();
    }
    @BeforeEach
    void elements(){
        datePicker = driver.findElement(By.name("my-date"));
        monthElement = driver.findElement(By.xpath(String.format("//th[contains(text(),'%d']", 2022)));
        arrowLeft = driver.findElement(RelativeLocator.with(By.tagName("th")).toRightOf(monthElement));
        monthPastYear = driver.findElement(RelativeLocator.with(By.cssSelector("span[class$=focused]")).below(arrowLeft));
        dayElement = driver.findElement(By.xpath(String.format("//td[@class='day' and contains(text(),'%d')]",currentDay)));
        oneYearBack = datePicker.getAttribute("value");
        previousYear = today.minusYears(1);
        dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        expectedDate = previousYear.format(dateFormat);
    }
    @Test
    void test(){
        datePicker.click();
        monthElement.click();
        arrowLeft.click();
        monthPastYear.click();
        dayElement.click();
    }
    @AfterAll
    void teardown(){
//        driver.quit();
    }
}
