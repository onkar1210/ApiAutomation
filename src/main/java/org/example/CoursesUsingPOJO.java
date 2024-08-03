package org.example;

import POJO.GetCourses;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.*;

public class CoursesUsingPOJO {

    public static void main(String[] args){

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials")
                .formParam("scope", "trust")
                .when().post("/oauthapi/oauth2/resourceOwner/token")
                .then().log().all().statusCode(200).extract().response().asString();

        System.out.println(response);

        JsonPath js = new JsonPath(response);
        String accessToken = js.getString("access_token");

        GetCourses gc = given().log().all().formParam("access_token", accessToken)
                .when().log().all().get("/oauthapi/getCourseDetails").as(GetCourses.class);

        System.out.println(gc.getInstructor());
        List<String> title = gc.getCourses().getWebAutomation().getCourseTitle();






    }

}
