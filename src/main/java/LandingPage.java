import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private static LandingPage instance;
    WebDriver webDriver = TestBase.initialize();

    public static synchronized LandingPage getInstance() {
        if (instance == null) {
            instance = new LandingPage();
        }
        return instance;
    }

    public void navigateToSTL() {
        webDriver.get("https://smarttrader.com");
    }

    private void clickOnChartsPage() {
        webDriver.findElement(By.xpath(".//a[@class=\"landing-header__nav-link\"][text() = 'Charts']")).click();
    }

}
