import io.restassured.response.Response;

import java.util.ArrayList;

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

    private static String autorizationToken;
    private static String traderId;


    //Methods
    public static void registerToBackOffice() {

        autorizationToken = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("l", "MAINTENANCE_ADMIN")
                .formParam("p", "fd4e73e45a4a")
                .when()
                .post("https://backoffice-prod01.smarttraderlabs.com/eforex231-admin/admin-app/login")
                .then().log().cookies()
                .statusCode(302)
                .extract()
                .cookie("JSESSIONID");

        System.out.println(autorizationToken);
    }


    public static void findUserByEmail(String userEmail) {

        ArrayList<String> response = given()
                .param("_dc", "1579519915033")
                .param("query", userEmail)
                .param("cust_type", "TRADER")
                .param("page", "1")
                .param("start", "0")
                .param("limit", "25")
                .cookies("JSESSIONID", autorizationToken)
                .when()
                .get("https://backoffice-prod01.smarttraderlabs.com/eforex231-admin/admin-app/json/user/find.json")
                .then().log().body()
                .statusCode(200)
                .extract()
                .response()
                .path("data.id");

        traderId = response.get(0);
        System.out.println(traderId);
    }

    public static void assigne360ProTag() {

        given()
                .contentType("application/x-www-form-urlencoded")
                .param("len_type", "N")
                .param("start_date", "12/17/2019")
                .param("ref_id", traderId)
                .param("add", "1075")
                .cookies("JSESSIONID", autorizationToken)
                .when()
                .get("https://backoffice-prod01.smarttraderlabs.com/eforex231-admin/admin-app/json/mti/cust_tag_set.json")
                .then().log().body()
                .statusCode(200);

    }
}