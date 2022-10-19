package datacreationUsingORgfile;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class PostRqst_OrgJson_Array {
    public static void main(String[] args) {
        JSONArray Address = new JSONArray();
        JSONObject Primary_address= new JSONObject();
        Primary_address.put("H.No","2826/1");
        Primary_address.put("StreetName","Garapati Street");
        Primary_address.put("Zip","AO1234");

        JSONObject Secondary_Address= new JSONObject();
        Secondary_Address.put("H.No","9741/32");
        Secondary_Address.put("StreetName","Ravanam Street");
        Secondary_Address.put("Zip","GT615151");

        Address.put(0,Primary_address);
        Address.put(1,Secondary_Address);


        JSONObject basicInfo = new JSONObject();
        basicInfo.put("FirstName","Jilebi");
        basicInfo.put("LastName","Raju");
        basicInfo.put("Age","29");
        basicInfo.put("id","8762");
        basicInfo.put("Address",Address);


        Response res= given().
                contentType(ContentType.JSON)
                .body(basicInfo)
                .when()
                .post("http://localhost:3000/posts");


        System.out.println("Status Code is : "+res.getStatusCode());
        System.out.println("Data Posted is : ");
        System.out.println(res.asString());
        
    }
}
