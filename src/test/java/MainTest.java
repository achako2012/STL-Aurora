import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class MainTest {

    protected static WebDriver driver = SetUp.getWebDriverInstance();
    protected static WebDriverWait driverWait = SetUp.getWebDriverWaitInstance();

    @BeforeTest
    public void setUp() {
        SetUp.getWebDriverInstance();
    }

    @AfterTest
    public void close() {
        SetUp.quitDriver();
    }
}
