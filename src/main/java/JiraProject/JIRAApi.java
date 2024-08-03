package JiraProject;
import Data.ApiJsons;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.example.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class JIRAApi {
    String username = "okahate";
    String password = "Onkar1210@";
    String projectKey = "API";
    String cookie;
    String issueId;
    @Test(priority = 1)
    public void createNewSession(){
        RestAssured.baseURI = "http://localhost:8080/";
        String createNewSessionResponse = given().log().all().header("Content-Type","application/json").body(ApiJsons.createNewSession(username,password)).
                when().post("rest/auth/1/session")
                .then().log().all().statusCode(200).extract().response().asString();
        JsonPath js= ReusableMethods.rawToJson(createNewSessionResponse);
        cookie = js.getString("session.value");
    }

    @Test(priority = 2)
    public void createIssue(){
        RestAssured.baseURI = "http://localhost:8080/";
        String summary = "Issue created using restassured";
        String description = "Issue created using restassured";
        String createIssueResponse = given().log().all().header("Cookie","JSESSIONID="+cookie).header("Content-Type","application/json").body(ApiJsons.createIssue(projectKey, summary, description)).
                when().post("rest/api/2/issue")
                .then().log().all().statusCode(201).extract().response().asString();
        JsonPath js= ReusableMethods.rawToJson(createIssueResponse);
        issueId = js.getString("id");
    }
    @Test(priority = 3)
    public void addComment(){
        RestAssured.baseURI = "http://localhost:8080/";
        String expectedComment="Its a new comment";
        String addCommentResponse = given().log().all().header("Content-Type","application/json").header("Cookie","JSESSIONID="+cookie).body(ApiJsons.addComment(expectedComment)).
                when().post("rest/api/2/issue/"+issueId+"/comment")
                .then().log().all().statusCode(201).extract().response().asString();

        JsonPath js= ReusableMethods.rawToJson(addCommentResponse);
        String actualComment = js.getString("body");
        Assert.assertEquals(actualComment,expectedComment);
    }
}
