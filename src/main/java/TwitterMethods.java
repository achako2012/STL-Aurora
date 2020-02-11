import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class TwitterMethods {

    public Response twitterRequest(String token) {
        Response response = given()
                .param("q", "@join")
                .param("result_type", "mixed")
                .param("count", "2")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.twitter.com/1.1/search/tweets.json");
        return response;
    }
}
