import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class practiceTwitter {

    Response response;





    @Test(description = "Test with valid credentials")
    public void Test1() {
        response = new TwitterMethods().twitterRequest("AAAAAAAAAAAAAAAAAAAAANRILgAAAAAAnNwIzUejRCOuH5E6I8xnZz4puTs%3D1Zv7ttfk8LF81IUq16cHjhLTvJu4FA33AGWWjCpTnA");
        response.then().statusCode(200);
        Assert.assertFalse(response.body().asString().isEmpty(), "Empty response body");
        response.then().assertThat().body(matchesJsonSchemaInClasspath("products-schema.json"));
        System.out.println("Status code - 200");
    }

    @Test(description = "Test with invalid credentials")
    public void Test2() {
        response = new TwitterMethods().twitterRequest("test" + "AAAAAAAAAAAAAAAAAAAAANRILgAAAAAAnNwIzUejRCOuH5E6I8xnZz4puTs%3D1Zv7ttfk8LF81IUq16cHjhLTvJu4FA33AGWWjCpTnA");
        response.then().statusCode(404);
    }

    @Test(description = "Test without token")
    public void Test3(){
        response = new TwitterMethods().twitterRequest("");
        response.then().statusCode(404);
    }
}

