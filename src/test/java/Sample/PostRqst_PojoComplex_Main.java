package Sample;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostRqst_PojoComplex_Main {
    public static void main(String[] args) {
        PostReqst_POJOComplex_Address Address = new PostReqst_POJOComplex_Address();
        Address.setH_No("6354/10");
        Address.setStreet("Macharla Street");
        Address.setZipCode("ME24456");

        PostRqst_PojoComplex_BasicInfo BasicInfo = new PostRqst_PojoComplex_BasicInfo();

        BasicInfo.setFirstName("Rahul");
        BasicInfo.setLastName("Shetty");
        BasicInfo.setCourseName("Selenium");
        BasicInfo.setDesignation("Test Lead");
        BasicInfo.setMentorName("Samba");
        BasicInfo.setId("4028");
        BasicInfo.setAddress(Address);

        Response res=
        given().contentType(ContentType.JSON)
                .body(BasicInfo)
                .when()
                .post("http://localhost:3000/posts");

        System.out.println("status code of the post response : "+res.getStatusCode());
        System.out.println("data posted is  :");
        System.out.println(res.asString());
    }
}
