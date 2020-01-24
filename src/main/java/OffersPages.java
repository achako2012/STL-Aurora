import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OffersPages {

    /**
     * Class fields
     **/
    private static OffersPages instance;
    private static WebDriver driver = SetUp.getWebDriverInstance();
    private static WebDriverWait driverWait = SetUp.getWebDriverWaitInstance();

    /**
     * Class constructor
     **/
    private OffersPages() {
    }

    public static synchronized OffersPages getInstance() {
        if (instance == null) {
            instance = new OffersPages();
        }
        return instance;
    }

    /**
     * Xpath Locators
     **/
    static By startTrialButton = By.xpath("");
    static By stayFreeButton = By.xpath("");

    /**
     * Methods
     **/
    public void startTrialButton() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(startTrialButton));
        driverWait.until(ExpectedConditions.elementToBeClickable(startTrialButton));
        driver.findElement(startTrialButton).click();
    }

    public void stayFreeButton() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(stayFreeButton));
        driverWait.until(ExpectedConditions.elementToBeClickable(stayFreeButton));
        driver.findElement(stayFreeButton).click();
    }

}