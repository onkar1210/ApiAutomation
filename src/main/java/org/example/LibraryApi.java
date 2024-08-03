package org.example;

import Data.ApiJsons;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LibraryApi{
    String ID;
    @Test(dataProvider="BooksData")
    public void addBook(String isbn, String aisle){
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().log().all().header("Content-Type","application/json").body(ApiJsons.addBook(isbn,aisle))
                .when().post("Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = ReusableMethods.rawToJson(response);
        ID = js.getString("ID");
        System.out.println(ID);
    }
    @DataProvider(name="BooksData")
    public Object[][] getData(){

        return new Object[][] {{"fstr","673"},{"fsik","865"},{"nbvs","986"}};
    }

    @Test(dataProvider="BooksData")
    public void deleteBook(String isbn, String aisle){
        RestAssured.baseURI = "http://216.10.245.166";
        given().log().all().header("Content-Type","application/json").body(ApiJsons.deleteBook(isbn+aisle))
                .when().delete("Library/DeleteBook.php")
                .then().log().all().assertThat().statusCode(200).body("msg",equalTo("book is successfully deleted"));
    }
}
