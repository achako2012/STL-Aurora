import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class MainTest {

    @BeforeTest
    public void setUp() {
        SetUp.getWebDriverInstance();
    }

    @AfterTest
    public void close() {
        SetUp.quitDriver();
    }
}
