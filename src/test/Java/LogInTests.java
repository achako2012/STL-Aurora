import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTests extends MainTest implements TestDates {

    LandingPage landingPage = LandingPage.getInstance();
    LogInPage logInPage = LogInPage.getInstance();


    @Test
    public void logIn() {
        landingPage.navigateToSTL();
        Assert.assertEquals("Forex Trading Software & Stock Market Charting Software | SmartTrader", driver.getTitle());
        landingPage.agreeCookie();
        landingPage.navigateToLogIn();
        logInPage.logIn(emailToLogin, passwordToLogin);
    }
}
