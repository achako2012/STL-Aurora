import org.testng.annotations.Test;

public class FirstTest extends MainTest {
    LandingPage x = LandingPage.getInstance();

    @Test
    public void navigateToCharts() {
        x.navigateToSTL()
                .clickOnChartsPage();

    }

}
