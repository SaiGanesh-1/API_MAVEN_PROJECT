package Sample;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostRqst_PojoArray_Main {
    public static void main(String[] args) {

        PostReqst_POJOComplex_Address[] Address= new PostReqst_POJOComplex_Address[2];
        Address[0]=new PostReqst_POJOComplex_Address();
        Address[1]=new PostReqst_POJOComplex_Address();

        Address[0].setH_No("321/2");
        Address[0].setStreet("Bhramnandam Street");
        Address[0].setZipCode("AU54143");

        Address[1].setH_No("986/12");
        Address[1].setStreet("Jambala Street");
        Address[1].setZipCode("TV66442");

        PostRqst_PojoArray_BasicInfo basicInfo= new PostRqst_PojoArray_BasicInfo();
        basicInfo.setFirstName("Ullipaya");
        basicInfo.setLastName("Raghava");
        basicInfo.setCourseName("cucumber");
        basicInfo.setDesignation("Team Members");
        basicInfo.setMentorName("Subba Rao");
        basicInfo.setId("2020");
        basicInfo.setAddress(Address);


        Response res= given().contentType(ContentType.JSON)
                .body(basicInfo)
                .when()
                .post("http://localhost:3000/posts");

        System.out.println("status code is : "+res.getStatusCode());
        System.out.println("Data posted is : ");
        System.out.println(res.asString());




    }
}
