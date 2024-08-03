package org.example;

import Data.ApiJsons;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class ComplexJsonParse {
    public static void main(String[] args){
        JsonPath js=new JsonPath(ApiJsons.coursePrice());
        int count  = js.getInt("courses.size()");
        System.out.println(count);
        int sum=0;
        for(int i=0;i<count;i++) {
            String title = js.getString("courses["+i+"].title");
            System.out.println(title);
            int price = js.getInt("courses["+i+"].price");
            System.out.println(price);
            int copies = js.getInt("courses["+i+"].copies");
            if(title.equalsIgnoreCase("RPA")){
                System.out.println(copies);
            }
            sum=sum+(copies*price);
        }
        System.out.println(sum);
        Assert.assertEquals(js.getInt("dashboard.purchaseAmount"),sum);
    }
}
