package org.example;

import Data.ApiJsons;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class MapApiTest {
    @Test
    public void mapApi() throws IOException {
            RestAssured.baseURI = "https://rahulshettyacademy.com";
            //Add Place
            String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                    .body(new String(Files.readAllBytes(Paths.get("C:\\Users\\gunja\\IdeaProjects\\ApiProjectOnIntelij\\src\\main\\resources\\AddPlace.json"))))  //or u can use this .body(ApiJsons.addPlace1())
                    .when().post("maps/api/place/add/json")
                    .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
                    .header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();

            System.out.println(response);
            JsonPath js = new JsonPath(response);   //for parsing Json
            String placeId = js.getString("place_id");
            System.out.println(placeId);

            //Update Place
            String newAddress = "Pruthvi Apartment";
            given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(ApiJsons.updateAddressOfPlace(newAddress, placeId))
                    .when().put("maps/api/place/update/json")
                    .then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));

            //Get Place
            String getPlaceResponse = given().queryParam("key", "qaclick123").queryParam("place_id", placeId)
                    .when().get("maps/api/place/get/json")
                    .then().log().all().assertThat().statusCode(200).body("address", equalTo(newAddress)).header("Server", "Apache/2.4.41 (Ubuntu)")
                    .extract().response().asString();

            JsonPath js1 = ReusableMethods.rawToJson(getPlaceResponse);
            String actualAddress = js1.getString("address");
            Assert.assertEquals(actualAddress, newAddress);
        }
}