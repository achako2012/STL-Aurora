import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class practiceTwitter {

    Response response = new TwitterMethods().twitterRequest("AAAAAAAAAAAAAAAAAAAAANRILgAAAAAAnNwIzUejRCOuH5E6I8xnZz4puTs%3D1Zv7ttfk8LF81IUq16cHjhLTvJu4FA33AGWWjCpTnA");

    @Test
    public void Test1() {
        response.then().statusCode(200);
        System.out.println("Status code - 200");
    }

    @Test
    public void Test2() {
        Assert.assertFalse(response.body().asString().isEmpty(), "Empty response body");
        System.out.println("Response doesn't empty");
    }

    @Test
    public void Test4() {
        response.then().assertThat().body(matchesJsonSchemaInClasspath("products-schema.json"));
    }
}

