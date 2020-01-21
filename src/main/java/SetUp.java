import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SetUp {

    private static WebDriver driver;
    private static WebDriverWait driverWait;
    private static int timeOutSeconds = 10;
    //static String date;

    //Constructor
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

    //Methods
    static String date;
    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date currentDate = new Date();
        return date = dateFormat.format(currentDate);
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
    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            getWebDriverWaitInstance().until(expectation);
        } catch (Throwable error) {
            Assert.assertFalse(Boolean.parseBoolean("Timeout waiting for Page Load Request to complete."));
        }
    }


}
