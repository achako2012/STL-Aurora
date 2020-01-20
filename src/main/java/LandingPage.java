import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

    //Xpath Locators
    static By joinFreeButton = By.xpath(".//a[@class=\"landing-header__button\"]");
    static By logInButton = By.xpath(".//a[text()='Log in']");
    static By chartsPage = By.xpath(".//a[@href=\"/charts/\"][text()='Charts'][@class=\"landing-header__nav-link\"]");

    static By agreeCookie = By.xpath(".//button[text()='Agree']");

    //Class fields
    private static LandingPage instance;
    private static WebDriver driver = SetUp.getWebDriverInstance();
    private static WebDriverWait driverWait = SetUp.getWebDriverWaitInstance();


    //Class constructor
    private LandingPage() {
    }

    //Singleton realization
    public static synchronized LandingPage getInstance() {

        if (instance == null) {
            instance = new LandingPage();
        }
        return instance;
    }

    //Methods
    public static void navigateToSTL() {
        driver.get("https://smarttrader.com");
        SetUp.waitForPageLoaded();
    }

    public static void navigateToJoinFree() {

        driverWait.until(ExpectedConditions.presenceOfElementLocated(joinFreeButton));
        driverWait.until(ExpectedConditions.elementToBeClickable(joinFreeButton));
        driver.findElement(joinFreeButton).click();
        SetUp.waitForPageLoaded();

    }

    public static void navigateToLogIn() {

        driverWait.until(ExpectedConditions.presenceOfElementLocated(logInButton));
        driverWait.until(ExpectedConditions.elementToBeClickable(logInButton));
        driver.findElement(logInButton).click();
        SetUp.waitForPageLoaded();
    }


    public static void agreeCookie() {

        driverWait.until(ExpectedConditions.presenceOfElementLocated(agreeCookie));
        driver.findElement(agreeCookie).click();
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(agreeCookie));
    }

    public static void navigateToCharts() {

        driverWait.until(ExpectedConditions.presenceOfElementLocated(chartsPage));
        driver.findElement(chartsPage).click();
        SetUp.waitForPageLoaded();
    }

}
