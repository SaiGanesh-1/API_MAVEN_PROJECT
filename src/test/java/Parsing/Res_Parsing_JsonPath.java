package Parsing;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Res_Parsing_JsonPath {
    public static void main(String[] args) {

        Response res= given().
                contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/friends");


        String firstname=res.jsonPath().get("[0].firstname");
        System.out.println(firstname);
        System.out.println(res.asString());



    }
}
