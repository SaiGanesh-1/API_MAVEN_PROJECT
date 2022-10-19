package dataCreationUsingExistingFile;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class JsonVariableFile {
    public static void main(String[] args) throws FileNotFoundException {

        File fe= new File("C:\\Users\\saiga\\API_MAVEN_PROJECT\\JsonVariableFile.json");
        FileReader fr= new FileReader(fe);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject jo=new JSONObject(jt);

//for entering the name during executing in console
        String firstname, id, Designation;
        Scanner Variables=new Scanner(System.in);
        id=Variables.next();
        firstname=Variables.next();
        Designation=Variables.next();
//
        String Data= jo.toString();
        //before entering in the console
      //  Data=Data.replaceAll(Pattern.quote("{{"+"id"+"}}"),"369_June32");
      //  Data=Data.replaceAll(Pattern.quote("{{"+"firstName"+"}}"),"Rajamatha");
      //  Data= Data.replaceAll(Pattern.quote("{{"+"Designation"+"}}"),"QA_Lead");

        Data=Data.replaceAll(Pattern.quote("{{"+"id"+"}}"),id);
        Data=Data.replaceAll(Pattern.quote("{{"+"firstName"+"}}"),firstname);
        Data= Data.replaceAll(Pattern.quote("{{"+"Designation"+"}}"),Designation);
        Response res= given().
                contentType(ContentType.JSON)
                .body(Data)
                .when()
                .post("http://localhost:3000/posts");

        System.out.println("Status Code is : "+res.getStatusCode());
        System.out.println("Data Posted Is :");
        System.out.println(res.asString());
    }
}
