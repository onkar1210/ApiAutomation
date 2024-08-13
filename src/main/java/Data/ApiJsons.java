package Data;

public class ApiJsons {
    static public String addPlace1(){
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }
    static public String updateAddressOfPlace(String address, String placeId){
        return "{\n" +
                "\"place_id\":\""+placeId+"\",\n" +
                "\"address\":\""+address+"\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
    }

    public static String deletePlace(String placeId){
        return "{\n" +
                "    \"place_id\":\""+ placeId +"\"\n" +
                "}\n";
    }

    public static String coursePrice(){
        /*
        {

        "dashboard": {

        "purchaseAmount": 910,

        "website": "rahulshettyacademy.com"

        },

        "courses": [

            {

            "title": "Selenium Python",

            "price": 50,

            "copies": 6

            },

            {

            "title": "Cypress",

            "price": 40,

            "copies": 4

            },

            {

            "title": "RPA",

            "price": 45,

            "copies": 10

            }

            ]

         }   */

        return "{\n" +
                "\n" +
                "\"dashboard\": {\n" +
                "\n" +
                "\"purchaseAmount\": 910,\n" +
                "\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "\"courses\": [\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\n" +
                "\"price\": 50,\n" +
                "\n" +
                "\"copies\": 6\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Cypress\",\n" +
                "\n" +
                "\"price\": 40,\n" +
                "\n" +
                "\"copies\": 4\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"RPA\",\n" +
                "\n" +
                "\"price\": 45,\n" +
                "\n" +
                "\"copies\": 10\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}";
    }

    static public String addBook(String isbn, String aisle) {
        return "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}";
    }

    static public String deleteBook(String ID){
        return "{\n" +
                " \n" +
                "\"ID\" : \""+ID+"\"\n" +
                " \n" +
                "}";
    }

    static public String createNewSession(String username, String password) {
        return "{ \"username\": \""+username+"\", \"password\": \""+password+"\" }";
    }

    static public String createIssue(String projectKey, String summary, String description) {
        return "{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"key\": \""+projectKey+"\"\n" +
                "        },\n" +
                "        \"summary\": \""+summary+"\",\n" +
                "        \"description\": \""+description+"\",\n" +
                "        \"issuetype\":{\n" +
                "            \"name\": \"Bug\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }

    static public String addComment(String comment) {
        return "{\n" +
                "    \"body\": \""+comment+"\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}";
    }

}
