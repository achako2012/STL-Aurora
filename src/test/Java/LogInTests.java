import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTests extends MainTest implements TestDates {

    private LandingPage landingPage = LandingPage.getInstance();
    private LogInPage logInPage = LogInPage.getInstance();



    @Test
    public void logIn() {
        landingPage.navigateToSTL(environment);
        Assert.assertEquals("Forex Trading Software & Stock Market Charting Software | SmartTrader", driver.getTitle());
        landingPage.agreeCookie();
        landingPage.navigateToLogIn();
        logInPage.logIn(emailToLogin, passwordToLogin);
    }
}
