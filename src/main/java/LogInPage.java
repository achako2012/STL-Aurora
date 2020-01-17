import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {

    //Xpaths
    static By emailAdress = By.xpath(".//input[@placeholder=\"Email Address\"]");
    static By password = By.xpath(".//input[@placeholder=\"Password\"]");
    static By confirmLogIn = By.xpath(".//button[text()='CONTINUE']");

    //Class Fields
    private static LogInPage instance;
    private static WebDriver driver = SetUp.getWebDriverInstance();
    private static WebDriverWait driverWait = SetUp.getWebDriverWaitInstance();

    //Constructor
    private LogInPage() {
    }

    public static synchronized LogInPage getInstance() {

        if (instance == null) {
            instance = new LogInPage();
        }
        return instance;
    }


    public static void logIn(String emailToLogin, String passwordToLogin) {

        driver.findElement(emailAdress).clear();
        driver.findElement(emailAdress).sendKeys(emailToLogin);

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(passwordToLogin);

        driver.findElement(confirmLogIn).click();
        SetUp.waitForPageLoaded();
    }

}
