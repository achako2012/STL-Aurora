public class ChartPage {

    //Class fields
    private static ChartPage instance;

    //Class constructor
    private ChartPage() {
    }

    public static synchronized ChartPage getInstance() {
        if (instance == null) {
            instance = new ChartPage();
        }
        return instance;
    }

    /**Methods**/

    public void addNewWorkspace() {

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
