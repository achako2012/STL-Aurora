import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RESTTests {
    @Test
    public void test1() {
        given()
                .param("l","MAINTENANCE_ADMIN")
                .header("p","fd4e73e45a4a")
                .when()
                .post("https://backoffice.smarttraderlabs.com/edforex231-admin/admin-app/login")
                .then()
                .statusCode(200);
    }
}
