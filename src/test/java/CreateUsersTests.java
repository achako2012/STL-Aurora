import org.testng.annotations.Test;

public class CreateUsersTests extends MainTest {

    LandingPage landingPage = LandingPage.getInstance();

    @Test
    public void navigateToCharts() {

        landingPage.navigateToSTL();
    }


}
