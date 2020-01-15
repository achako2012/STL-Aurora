import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MainTest {

    @BeforeTest
    public void setUp() {
        TestBase.initialize();
    }

    @AfterTest
    public void close() {

        TestBase.quit();
    }
}
