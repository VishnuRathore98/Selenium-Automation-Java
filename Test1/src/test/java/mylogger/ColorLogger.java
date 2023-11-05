package mylogger;
import java.util.logging.*;
import org.junit.platform.commons.logging.LoggerFactory;


public class ColorLogger {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ColorLogger.class);

    public static void logInfo(String logging) {
        LOGGER.info("\u001B[34m" + logging + "\u001B[0m");
    }
    public static void logWarn(String logging) {
        LOGGER.warning("\u001B[32m" + logging + "\u001B[0m");
    }

    public static void logSevere(String logging) {
        LOGGER.severe("\u001B[31m" + logging + "\u001B[0m");
    }
}
