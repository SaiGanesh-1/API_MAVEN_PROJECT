package datacreationUsingORgfile;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class PostRqst_OrgJson_Complex {
    public static void main(String[] args) {

        JSONObject AddressInfo= new JSONObject();
        AddressInfo.put("H.No","3752");
        AddressInfo.put("Street","Mahipala Street");
        AddressInfo.put("Age","24");


        JSONObject basicInfo= new JSONObject();
        basicInfo.put("FirstName","Managalam");
        basicInfo.put("LastName","Srinu");
        basicInfo.put("Age","39");
        basicInfo.put("Id","7642");
        basicInfo.put("Address",AddressInfo);

        Response res= given().
                contentType(ContentType.JSON)
                .body(basicInfo.toString())
                .when()
                .post("  http://localhost:3000/posts");

        System.out.println("Status Code is : "+res.getStatusCode());
        System.out.println("Data posted is : ");
        System.out.println(res.asString());

    }
}
