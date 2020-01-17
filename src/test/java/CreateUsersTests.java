import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUsersTests extends MainTest implements TestDates {

    LandingPage landingPage = LandingPage.getInstance();

    @Test
    public void registerNewUser() {

        landingPage.navigateToSTL();
        Assert.assertEquals("Forex Trading Software & Stock Market Charting Software | SmartTrader", driver.getTitle());
        landingPage.navigateToJoinFree();

        landingPage.fillUpRegisterForms(fullName, email, password, phone);
    }
}
