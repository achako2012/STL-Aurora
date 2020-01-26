import org.testng.annotations.Test;

public class ChartsTests extends MainTest implements TestDates {
    private ChartPage chartPage = ChartPage.getInstance();

    @Test
    public void addNewWorkspace(){
        chartPage.addNewWorkspace(templateName);
    }

}
