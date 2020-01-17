import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends MainTest implements TestDates {

    LandingPage landingPage = LandingPage.getInstance();
    RegisterPage registerPage = RegisterPage.getInstance();
    LogInPage logInPage = LogInPage.getInstance();

    /*@Test
    public void registerNewUser() {

        landingPage.navigateToSTL();
        Assert.assertEquals("Forex Trading Software & Stock Market Charting Software | SmartTrader", driver.getTitle());
        landingPage.agreeCookie();
        landingPage.navigateToJoinFree();
        registerPage.fillUpRegisterForms(fullName, email, password, phone);
    }*/

    @Test
    public void logIn() {
        landingPage.navigateToSTL();
        Assert.assertEquals("Forex Trading Software & Stock Market Charting Software | SmartTrader", driver.getTitle());
        landingPage.agreeCookie();
        landingPage.navigateToLogIn();
        logInPage.logIn(emailToLogin,passwordToLogin);

    }
}
