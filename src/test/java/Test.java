import com.google.gson.Gson;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Test {

    @org.testng.annotations.Test
    public void registerToBackOffice() {

        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("l", "MAINTENANCE_ADMIN")
                .formParam("p", "fd4e73e45a4a")
                .when()
                .post("https://backoffice-prod01.smarttraderlabs.com/eforex231-admin/admin-app/login")
                .then().log().cookies()
                .statusCode(200);
    }

    @org.testng.annotations.Test
    public void findUserByEmail() {

                given()
                        .param("_dc", "1579519915033")
                        .param("query", "ochako@markettraders.com")
                        .param("cust_type", "TRADER")
                        .param("page", "1")
                        .param("start", "0")
                        .param("limit", "25")
                        .cookies("JSESSIONID", "DDCCE9104E788B6AD94F772FEA68E284")
                        .when()
                        .get("https://backoffice-prod01.smarttraderlabs.com/eforex231-admin/admin-app/json/user/find.json")
                        .then().log().body()
                        .statusCode(200);




    }

    @org.testng.annotations.Test
    public void set360ProTag() {

        given()
                .contentType("application/x-www-form-urlencoded")
                .param("len_type", "N")
                .param("start_date", "12/17/2019")
                .param("ref_id", "108975")
                .param("add", "1075")
                .cookies("JSESSIONID", "B0F86477758B60C9F1DAC49788B4DCDF")
                .when()
                .get("https://backoffice-prod01.smarttraderlabs.com/eforex231-admin/admin-app/json/mti/cust_tag_set.json")
                .then().log().body()
                .statusCode(200);

    }
}
