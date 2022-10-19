package Sample;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostRequest {
    public static void main(String[] args) {

        POJO_PostRequest data = new POJO_PostRequest();
        data.setFirstName("Gavara");
        data.setLastName("Narasingh Rao");
        data.setDesignation("Project Lead");
        data.setMentorName("Rahul");
        data.setCourseName("API Testing course");
        data.setId("326_9");


        Response res=given().contentType(ContentType.JSON)
                .body(data)
                .when()
                .post(" http://localhost:3000/posts");
        // .put("http://localhost:3000/friends/326_9")
        // .delete("http://localhost:3000/friends/326_9")

        System.out.println("Status code of Post Request : "+res.getStatusCode());
        System.out.println("Data Posted is : ");
        System.out.println(res.asString());//stored data




    }
}
