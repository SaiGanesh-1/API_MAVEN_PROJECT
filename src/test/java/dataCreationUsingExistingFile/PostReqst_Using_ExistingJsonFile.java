package dataCreationUsingExistingFile;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class PostReqst_Using_ExistingJsonFile {
    public static void main(String[] args) throws FileNotFoundException {
        File fe= new File("C:\\Users\\saiga\\API_MAVEN_PROJECT\\Body.json");

        FileReader fr= new FileReader(fe);
        JSONTokener jt= new JSONTokener(fr);
        JSONObject jo = new JSONObject(jt);

        Response res= given().contentType(ContentType.JSON)
                .body(jo.toString())
                .when()
                .post(" http://localhost:3000/posts");

        System.out.println("Status Code is : "+res.getStatusCode());
        System.out.println("Data Posted is : ");
        System.out.println(res.asString());
    }
}
