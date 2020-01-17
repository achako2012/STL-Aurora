import org.openqa.selenium.WebDriver;

public class LandingPage {

    private static LandingPage instance;
    private static WebDriver driver = SetUp.getWebDriverInstance();

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

}
