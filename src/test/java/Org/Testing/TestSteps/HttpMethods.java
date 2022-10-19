package Org.Testing.TestSteps;

import Org.Testing.Payloads.PojoBodyData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class HttpMethods {
    static Properties pr;
    public HttpMethods(Properties pr)
    {
        this.pr=pr;
    }
    public Response GetRequest(String id,String URI)
    {
        Response res=
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get(pr.getProperty(URI));
        return res;
    }
    public Response PostRequest(PojoBodyData Body,String URI)
    {
        Response res=
                given().
                        contentType(ContentType.JSON)
                        .body(Body)
                        .when()
                        .post(pr.getProperty(URI));
        return res;
    }
    public Response DeleteData(String id,String URI)
    {
        String FinalUri=(String) pr.getProperty(URI)+"/"+id;
        Response res=
                given().contentType(ContentType.JSON)
                         .when()
                        .delete(FinalUri);
    return res;
    }
    public Response PutRequest(PojoBodyData Body,String URI,String id)
    {
        String FinalUri=(String) pr.getProperty(URI)+"/"+id;
        Response res=
                given()
                        .contentType(ContentType.JSON)
                        .body(Body)
                        .when()
                        .put(FinalUri);
        return res;
    }

}
