import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class ChartPage {


    //Class fields

    private static ChartPage instance;
    private static WebDriver driver = SetUp.getWebDriverInstance();
    private static WebDriverWait driverWait = SetUp.getWebDriverWaitInstance();

    // Class constructor

    private ChartPage() {
    }

    public static synchronized ChartPage getInstance() {
        if (instance == null) {
            instance = new ChartPage();
        }
        return instance;
    }


    //Xpath Locators

    static By exploreMySelf = By.xpath("");

    static By addWorkspaceButton = By.xpath("");
    static By addWorkspaceDropDown = By.xpath("");
    static By newWorkspaceButton = By.xpath("");
    static By newWorkspaceParametersModal = By.xpath("");
    static By workspaceNameField = By.xpath("");
    static By enterSymbolField = By.xpath("");
    static By listOfAllSymbols = By.xpath("");
    static By timeFrameButton = By.xpath("");
    static By timeFrameDropDown = By.xpath("");
    static By timeFrame1M = By.xpath("");
    static By templateDropDown = By.xpath("");
    static By sumbitWorkspaceButton = By.xpath("");



     //Methods


    public void skipNagModals() {

        driver.findElement(exploreMySelf).click();
    }


    public void addNewWorkspace(String templateName) {

        //Enter Workspace Name
        driverWait.until(ExpectedConditions.elementToBeClickable(addWorkspaceButton));
        driver.findElement(addWorkspaceButton).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(addWorkspaceDropDown));
        driver.findElement(newWorkspaceButton).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(newWorkspaceParametersModal));

        driver.findElement(workspaceNameField).click();
        driver.findElement(workspaceNameField).clear();
        driver.findElement(workspaceNameField).sendKeys("workspace"+SetUp.date);


        //Chose Symbol
        driver.findElement(enterSymbolField).click();
        driver.findElement(enterSymbolField).clear();

        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listOfAllSymbols));
        List<WebElement> listOfSymbols = driver.findElements(listOfAllSymbols);

        List<WebElement> listOfFOREX = new ArrayList<WebElement>();
        List<WebElement> listOfNASDAQ = new ArrayList<WebElement>();
        List<WebElement> listOfBITFINEX = new ArrayList<WebElement>();

        for (int i = 0; i < listOfSymbols.size(); i++) {
            String currency = listOfSymbols.get(i).getAttribute("data-scxexchange");
            WebElement exchange = listOfSymbols.get(i);
            String forex = "FOREX";
            String nasdaq = "NASDAQ";

            if (currency.equals(forex)) {
                listOfFOREX.add(exchange);
            } else if (currency.equals(nasdaq)) {
                listOfNASDAQ.add(exchange);
            } else {
                listOfBITFINEX.add(exchange);
            }
        }

        Random randomExchange = new Random();
        Random randomSymbol = new Random();
        int rEx = (randomExchange.nextInt(3) + 1);

        switch (rEx) {
            case 1:
                int randomFOREX = randomSymbol.nextInt(listOfFOREX.size() + 1);
                WebElement forexElement = listOfFOREX.get(randomFOREX);
                forexElement.click();
                break;
            case 2:
                int randomNASDAQ = randomSymbol.nextInt(listOfNASDAQ.size() + 1);
                WebElement nasdaqElement = listOfNASDAQ.get(randomNASDAQ);
                nasdaqElement.click();
                break;
            case 3:
                int randomBITFINEX = randomSymbol.nextInt(listOfBITFINEX.size() + 1);
                WebElement bitfinexElement = listOfBITFINEX.get(randomBITFINEX);
                bitfinexElement.click();
                break;
        }

        //Select TimeFrame
        driverWait.until(ExpectedConditions.elementToBeClickable(timeFrameButton));
        try {
            driver.findElement(timeFrameButton).click();
            driverWait.until(ExpectedConditions.presenceOfElementLocated(timeFrameDropDown));
            driverWait.until(ExpectedConditions.elementToBeClickable(timeFrame1M));
            driver.findElement(timeFrame1M).click();
        } catch (WebDriverException e) {
            System.out.println("Timeframe doesen't visible");
        }

        //Select Template
        driverWait.until(ExpectedConditions.elementToBeClickable(templateDropDown));
        try {
            if(templateName.equals("none")){
                System.out.println("Template doesn't selected!");
            }else {
                Select template = new Select(driver.findElement(templateDropDown));
                template.selectByVisibleText(templateName);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Template doesen't visible");
        }

        //Sumbit add new workspace
        driverWait.until(ExpectedConditions.elementToBeClickable(sumbitWorkspaceButton));
        try {
            driver.findElement(sumbitWorkspaceButton).click();
        } catch (NoSuchElementException e) {
            System.out.println("sumbitWorkspaceButton doesn't visible!");
        }

    }


    public void addNewChart() {

    }

    public void shareWorkspace() {

    }

    public void shareChart() {

    }

    public void changeChartColor() {

    }

    public void downloadIdea() {

    }

    public void delleteIdeas() {

    }

    public void delleteSession() {
    }


}
