import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SetUp {

    private static WebDriver driver;
    private static WebDriverWait driverWait;
    private static int timeOutSeconds = 10;

    private SetUp() {
    }

    public static WebDriver getWebDriverInstance() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    public static WebDriverWait getWebDriverWaitInstance() {
        if (driverWait == null) {
            driverWait = new WebDriverWait(driver, timeOutSeconds);
        }
        return driverWait;
    }

    //Wait method with JS
    public static void waitForPageLoaded(){
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            getWebDriverWaitInstance().until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }


}
