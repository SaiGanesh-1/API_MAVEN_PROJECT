package Org.Testing.TestCases;

import Org.Testing.Payloads.PojoBodyData;
import Org.Testing.Payloads.PojoSimpleBody;
import Org.Testing.TestResponseValidation.ResponseValidation;
import Org.Testing.TestSteps.HttpMethods;
import Org.Testing.TestUtilities.JsonResParsing;
import Org.Testing.TestUtilities.PropertiesFileLoad;
import datacreationUsingORgfile.PostRqst_OrgJson_Simple;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Properties;

public class TC_2_Post {
    static String JsonKeyValue;
    public void TestCase2() throws IOException {

        //Step:1 Loading the property file in Pr Object and will pass it in calling method
        Properties pr= PropertiesFileLoad.PropFileLoad("C:\\Users\\saiga\\API_MAVEN_PROJECT\\Env.properties");

        //Step:2 Initalize the Properties object of HttpMethods Class with pr of step1

        HttpMethods http = new HttpMethods(pr);

        //Step:3  Called GetBodyData method of classPojoSimpleBody which returns simple json data

        PojoBodyData Body= PojoSimpleBody.GetBodyData();

        /*Step:4 PostRequest method of HttpMethods class  is called passing Body data and URI  And
        Repsonse Returned  by this  method  is collected  in res  Object  of Response Class
         */
        Response res= http.PostRequest(Body,"QA_URI1");

        //Step:5 res is sent to the Response Validation method of class Response Validations

        ResponseValidation.ResponseStatusCodeValidatio(201,res);

        System.out.println("Status code checkd and found Ok");

        //Step 6: Storing the value of “id” in static variable of class parsing from Response
        JsonKeyValue= JsonResParsing.JsonResDataParsing(res,"id");
        System.out.println("The value of Json Key fecthed is :"+JsonKeyValue);
    }
}
