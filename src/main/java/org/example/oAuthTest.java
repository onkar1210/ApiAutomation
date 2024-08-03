package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class oAuthTest {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials")
                .formParam("scope", "trust")
                .when().post("/oauthapi/oauth2/resourceOwner/token")
                .then().log().all().statusCode(200).extract().response().asString();

        System.out.println(response);

        JsonPath js = new JsonPath(response);
        String accessToken = js.getString("access_token");

        String response2 = given().log().all().formParam("access_token", accessToken)
                .when().log().all().get("/oauthapi/getCourseDetails").asString();

        System.out.println(response2);



    }
}
