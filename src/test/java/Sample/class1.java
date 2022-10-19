package Sample;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class class1 {
    public static void main(String[] args) {
        Response res=
                given().contentType(ContentType.JSON)
                        .when()
                        .get(" http://localhost:3000/friends");
        System.out.println("Status Code  : "+res.getStatusCode());
        System.out.println("Data is ");
        System.out.println(res.asString());
    }
}
