import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    public static WebDriver driver;

    public static WebDriver initialize() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quit() {
        driver.quit();
    }

}
