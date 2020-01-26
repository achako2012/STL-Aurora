import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTests extends MainTest implements TestDates {
    private LandingPage landingPage = LandingPage.getInstance();
    private RegisterPage registerPage = RegisterPage.getInstance();
    private HTTPRequests http = HTTPRequests.getInstance();

    @Test
    public void registerNewUser() {
        landingPage.navigateToSTL(environment);
        Assert.assertEquals("Forex Trading Software & Stock Market Charting Software | SmartTrader", driver.getTitle());
        landingPage.agreeCookie();
        landingPage.navigateToJoinFree();
        registerPage.fillUpRegisterForms(fullName, email, password, phone);
        landingPage.navigateToCharts();
    }


    @Test
    public void assign360ProTag(){
        http.registerToBackOffice();
        http.findUserByEmail(SetUp.date);
        http.assigne360ProTag();
    }
}

