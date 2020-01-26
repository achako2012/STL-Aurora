import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    static By fullNameField = org.openqa.selenium.By.xpath(".//input[@placeholder=\"Full Name\"]");
    static By emailAdressField = org.openqa.selenium.By.xpath(".//input[@placeholder=\"Email Address\"]");
    static By passwordField = org.openqa.selenium.By.xpath(".//input[@placeholder=\"Password\"]");
    static By confirmPasswordField = org.openqa.selenium.By.xpath(".//input[@placeholder=\"Confirm Password\"]");
    static By phoneField = org.openqa.selenium.By.xpath(".//input[@placeholder=\"Phone\"]");
    static By agreeTermsCheckBox = org.openqa.selenium.By.xpath(".//input[@id=\"EULACheckboxLogin\"]");
    static By confirmRegistrationButton = org.openqa.selenium.By.xpath(".//button[text()='JOIN FOR FREE']");

    private static RegisterPage instance;
    private static WebDriver driver = SetUp.getWebDriverInstance();



    private RegisterPage() {
    }

    public static synchronized RegisterPage getInstance() {

        if (instance == null) {
            instance = new RegisterPage();
        }
        return instance;
    }
    public static void fillUpRegisterForms(String fullName, String email, String password, String phone) {

        SetUp.getCurrentDate();

        driver.findElement(fullNameField).clear();
        driver.findElement(fullNameField).sendKeys(fullName + SetUp.date);
        System.out.println(fullName + SetUp.date);

        driver.findElement(emailAdressField).clear();
        driver.findElement(emailAdressField).sendKeys(SetUp.date + email);
        System.out.println(SetUp.date + email);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password + SetUp.date);
        System.out.println(password + SetUp.date);

        driver.findElement(confirmPasswordField).clear();
        driver.findElement(confirmPasswordField).sendKeys(password + SetUp.date);

        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);

        driver.findElement(agreeTermsCheckBox).click();

        driver.findElement(confirmRegistrationButton).click();
        SetUp.waitForPageLoaded();
    }


}
