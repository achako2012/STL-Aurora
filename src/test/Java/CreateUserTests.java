import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTests extends MainTest implements TestDates {
    LandingPage landingPage = LandingPage.getInstance();
    RegisterPage registerPage = RegisterPage.getInstance();
    HTTPRequests http = HTTPRequests.getInstance();

    @Test
    public void registerNewUser() {
        landingPage.navigateToSTL();
        Assert.assertEquals("Forex Trading Software & Stock Market Charting Software | SmartTrader", driver.getTitle());
        landingPage.agreeCookie();
        landingPage.navigateToJoinFree();
        registerPage.fillUpRegisterForms(fullName, email, password, phone);
        landingPage.navigateToCharts();
    }


    @Test
    public void assigne360ProTag(){
        http.registerToBackOffice();
        http.findUserByEmail(SetUp.date);
        http.assigne360ProTag();
    }
}

