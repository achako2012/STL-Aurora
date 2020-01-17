import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

    //Xpath Locators
    static By joinFreeButton = By.xpath(".//a[@class=\"landing-header__button\"]");
    static By fullNameField = By.xpath(".//input[@placeholder=\"Full Name\"]");
    static By emailAdressField = By.xpath(".//input[@placeholder=\"Email Address\"]");
    static By passwordField = By.xpath(".//input[@placeholder=\"Password\"]");
    static By confirmPasswordField = By.xpath(".//input[@placeholder=\"Confirm Password\"]");
    static By phoneField = By.xpath(".//input[@placeholder=\"Phone\"]");
    static By agreeTermsCheckBox = By.xpath(".//input[@id=\"EULACheckboxLogin\"]");
    static By confirmRegistrationButton = By.xpath(".//button[text()='JOIN FOR FREE']");

    private static LandingPage instance;
    private static WebDriver driver = SetUp.getWebDriverInstance();
    private static WebDriverWait driverWait = SetUp.getWebDriverWaitInstance();


    private LandingPage() {
    }

    public static synchronized LandingPage getInstance() {

        if (instance == null) {
            instance = new LandingPage();
        }
        return instance;
    }

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

    public static void fillUpRegisterForms(String fullName, String email, String password, String phone) {

        driver.findElement(fullNameField).clear();
        driver.findElement(fullNameField).sendKeys(fullName + SetUp.date);

        driver.findElement(emailAdressField).clear();
        driver.findElement(emailAdressField).sendKeys(SetUp.date + email);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password + SetUp.date);

        driver.findElement(confirmPasswordField).clear();
        driver.findElement(confirmPasswordField).sendKeys(password + SetUp.date);

        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);

        driver.findElement(agreeTermsCheckBox).click();

        driver.findElement(confirmRegistrationButton).click();
        SetUp.waitForPageLoaded();
    }

}
