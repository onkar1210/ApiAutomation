package org.example;

import Data.ApiJsons;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexJsonParse {

    public static void main(String[] args){
        JsonPath js=new JsonPath(ApiJsons.coursePrice());

        //Number of courses return by API
        System.out.println("Number of courses return by API");
        int count  = js.getInt("courses.size()");
        System.out.println(count);

        //Total purchase amount
        System.out.println("Total purchase amount");
        System.out.println(js.getInt("dashboard.purchaseAmount"));

        //Print title of the first course
        System.out.println("Print title of the first course");
        System.out.println(js.getString("courses[0].title"));

        //Print the all courses titles and their respective prices
        System.out.println("Print the all courses titles and their respective prices");
        for(int i = 0 ; i < count ; i++) {
            String title = js.getString("courses["+ i +"].title");
            System.out.println(title);
            int price = js.getInt("courses["+ i +"].price");
            System.out.println(price);
        }

        //Print number of copies sold by RPA course
        System.out.println("Print number of copies sold by RPA course");
        for(int i = 0 ; i < count ; i++) {
            String title = js.get("courses["+ i +"].title");  //get methods gives Integer or String value whichever is given in JSON
            if(title.trim().equals("RPA")){
                //System.out.println(js.get("courses["+i+"].copies").toString());
                int copies = js.get("courses["+ i +"].copies");
                System.out.println(copies);
                break;
            }
        }

        //Verify if sum of all courses prices matches with purchase amount
        System.out.println("Verify if sum of all courses prices matches with purchase amount");
        int sum = 0;
        for(int i = 0 ; i < count ; i++) {
            int price = js.getInt("courses["+ i +"].price");
            int copies = js.getInt("courses["+ i +"].copies");
            sum = sum + (copies * price);
        }
        System.out.println("sum of all courses prices : " + sum);
        Assert.assertEquals(js.getInt("dashboard.purchaseAmount"), sum);
    }
}
