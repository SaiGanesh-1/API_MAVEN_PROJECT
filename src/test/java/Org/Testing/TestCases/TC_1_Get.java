package Org.Testing.TestCases;

import Org.Testing.TestResponseValidation.ResponseValidation;
import Org.Testing.TestSteps.HttpMethods;
import Org.Testing.TestUtilities.JsonResParsing;
import Org.Testing.TestUtilities.PropertiesFileLoad;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Properties;

public class TC_1_Get {
    public void testcase1() throws IOException {
        System.out.println("Executing Test case1");
        //Step:1 Loading the property file in Pr Object and will pass it in calling method
        Properties pr= PropertiesFileLoad.PropFileLoad("C:\\Users\\saiga\\API_MAVEN_PROJECT\\Env.properties");

        //Step:2 Initalizing the Http Methods class with latest value of properties object

        HttpMethods http = new HttpMethods(pr);

        //Step:3 Calling the get request method , Passing Uri key and collecting the Response

        Response res= http.GetRequest(TC_2_Post.JsonKeyValue,"QA_URI1");

        //Step:4 validating the Response by calling ResponseValidation method and passing response data

        ResponseValidation.ResponseStatusCodeValidatio(200,res);

        //Step :5  Printing the Response Data on the Console for Particular Id

        String ParseData = JsonResParsing.JsonResDataParsing(res, "FirstName");
        System.out.println("The Value of JSon Key Fetched  is : "+ParseData);

        ResponseValidation.ResponseDataValidation("Mashatm",ParseData);
        System.out.println(res.asString()+"\n");
    }
}
