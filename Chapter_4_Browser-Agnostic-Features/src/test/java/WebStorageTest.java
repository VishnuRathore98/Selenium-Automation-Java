import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebStorageTest {
    WebDriver driver;
    WebElement displayLocalStorage1, displaySessionStorage1,displayLocalStorage2, displaySessionStorage2;
    WebStorage webStorage1,webStorage2 ;
    LocalStorage localStorage1,localStorage2;
    SessionStorage sessionStorage1,sessionStorage2;
    final String URL="https://bonigarcia.dev/selenium-webdriver-java/web-storage.html";


    @BeforeAll
    @DisplayName("Driver Instance Created")
    void setup(){
        driver = new ChromeDriver();
//        driver.get(URL);
//        displayLocalStorage = driver.findElement(By.id("display-local"));
//        displaySessionStorage = driver.findElement(By.id("display-session"));
//        webStorage = (WebStorage) driver;
//        localStorage = webStorage.getLocalStorage();
//        log.debug("Local storage element: {}", localStorage.size());
//        sessionStorage = webStorage.getSessionStorage();
//        log.debug("Session storage element: {}",sessionStorage);
    }

    @Test
    @Order(1)
    @DisplayName("First entry in local and session storage.")
    void test1(){
        driver.get(URL);
        displayLocalStorage1 = driver.findElement(By.id("display-local"));
        displaySessionStorage1 = driver.findElement(By.id("display-session"));
        webStorage1 = (WebStorage) driver;
        localStorage1 = webStorage1.getLocalStorage();
        sessionStorage1 = webStorage1.getSessionStorage();
        assertThat(sessionStorage1.size()).isEqualTo(2);
        sessionStorage1.setItem("key1","value1");
        assertThat(sessionStorage1.size()).isEqualTo(3);
        displaySessionStorage1.click();

        assertThat(localStorage1.size()).isEqualTo(0);
        localStorage1.setItem("key1","value1");
        displayLocalStorage1.click();
        assertThat(localStorage1.size()).isEqualTo(1);

    }

    @Test
    @Order(2)
    @DisplayName("Checking if local storage maintains persistence.")
    void test2(){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);
        displayLocalStorage2 = driver.findElement(By.id("display-local"));
        displaySessionStorage2 = driver.findElement(By.id("display-session"));
        webStorage2 = (WebStorage) driver;
        localStorage2 = webStorage2.getLocalStorage();
        sessionStorage2 = webStorage2.getSessionStorage();

        assertThat(sessionStorage2.size()).isEqualTo(2);
        sessionStorage2.setItem("key2","value2");
        assertThat(sessionStorage2.size()).isEqualTo(3);
        displaySessionStorage2.click();

        assertThat(localStorage2.size()).isEqualTo(1);
        localStorage2.setItem("key2","value2");
        displayLocalStorage2.click();
        assertThat(localStorage2.size()).isEqualTo(2);
    }

    @AfterAll
    void teardown() throws InterruptedException {
//        Thread.sleep(5);
//        driver.quit();
    }
}
