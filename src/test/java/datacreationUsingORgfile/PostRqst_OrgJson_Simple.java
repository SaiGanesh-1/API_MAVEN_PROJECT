package datacreationUsingORgfile;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class PostRqst_OrgJson_Simple {
    public void  request()
    {
        JSONObject basicInfo = new JSONObject();

        basicInfo.put("FirstName","Raghava");
        basicInfo.put("LastName","Swamy");
        basicInfo.put("Age","35");
        basicInfo.put("Id","1267");


        Response res= given().contentType(ContentType.JSON)
                .body(basicInfo.toString())
                .when()
                .post("http://localhost:3000/posts");

        System.out.println("Status Code is : "+res.getStatusCode());
        System.out.println("Data Posted is : ");
        System.out.println(res.asString());

    }
}