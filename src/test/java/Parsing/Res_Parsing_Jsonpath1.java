package Parsing;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Res_Parsing_Jsonpath1 {
    public static void main(String[] args) {

        Response res=
                given().contentType(ContentType.JSON)
                        .when()
                        .get("http://localhost:3000/posts");

      //  http://dummy.restapiexample.com/api/v1/employees
        System.out.println(res.asString());


    }
}
