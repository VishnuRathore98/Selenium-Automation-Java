import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.TestInstance;
//import org.junit.platform.commons.logging.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v118.target.model.SessionID;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.invoke.MethodHandles.lookup;
import static org.apache.logging.log4j.LogManager.getLogger;

//import static org.junit.platform.commons.logging.LoggerFactory.getLogger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyEventListener implements WebDriverListener {
    static final Logger log = getLogger(lookup().lookupClass());

    @Override
    public void afterGet(WebDriver driver, String URL){
        WebDriverListener.super.afterGet(driver,URL);
        takeScreenshot(driver);
    }

    @Override
    public void beforeQuit(WebDriver driver){
        takeScreenshot(driver);
    }

    private void takeScreenshot(WebDriver driver){
        TakesScreenshot ts = (TakesScreenshot) driver;
        log.debug("Log called");
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        SessionId sessionId = ((RemoteWebDriver)driver).getSessionId();
        Date today = new Date();
        log.debug("Log called again");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss.SSS");
        String screenshotFileName = String.format("%s-%s.png",dateFormat.format(today), sessionId.toString());
        Path destination = Paths.get(screenshotFileName);
        try {
            Files.move(screenshot.toPath(),destination);
        }catch (IOException ioException){
            log.error("Exception moving screenshot from {} to {}",screenshot,destination,ioException);
        }
    }
}
