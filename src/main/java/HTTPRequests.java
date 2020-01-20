import static io.restassured.RestAssured.given;

public class HTTPRequests {


    //Class fields
    private static HTTPRequests instance;

    //Class constructor
    private HTTPRequests() {
    }

    public static synchronized HTTPRequests getInstance() {
        if (instance == null) {
            instance = new HTTPRequests();
        }
        return instance;
    }

    //Methods
    public static void registerToBackOffice() {

        given()
                .param("l", "MAINTENANCE_ADMIN")
                .header("p", "fd4e73e45a4a")
                .when()
                .post("https://backoffice-prod01.smarttraderlabs.com/eforex231-admin/admin-app/login")
                .then().log().cookies()
                .statusCode(200);
    }

    public static void findUserByEmail() {

        given()
                .param("_dc", "1579519915033")
                .param("query", "ochako@markettraders.com")
                .param("cust_type", "TRADER")
                .param("page", "1")
                .param("start", "0")
                .param("limit", "25")
                .cookies("JSESSIONID", "604C0148F6CF7B61F8B40259F7D82B3C")
                .when()
                .get("https://backoffice-prod01.smarttraderlabs.com/eforex231-admin/admin-app/json/user/find.json")
                .then().log().body()
                .statusCode(200);
    }
}

