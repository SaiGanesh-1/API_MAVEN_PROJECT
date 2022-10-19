package Org.Testing.TestCases;

import Org.Testing.Payloads.PojoBodyData;
import Org.Testing.Payloads.PojoSimpleUpdatedData;
import Org.Testing.TestResponseValidation.ResponseValidation;
import Org.Testing.TestSteps.HttpMethods;
import Org.Testing.TestUtilities.JsonResParsing;
import Org.Testing.TestUtilities.PropertiesFileLoad;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Properties;

public class TC_4_Put {
    public void testcase4() throws IOException {
        //Step:1 Loading the property file in Pr Object and will pass it in calling method
        Properties pr = PropertiesFileLoad.PropFileLoad("C:\\Users\\saiga\\API_MAVEN_PROJECT\\Env.properties");
        //step:2 Called getUpdatedBodyData  method of class PojoSimpleupdatedData which returns simple Json Object
        PojoBodyData Body = PojoSimpleUpdatedData.GetUpdatedBodyData();

        //Step:3 Initializing the Http Methods class with  latest values of Properties Object
        HttpMethods http = new HttpMethods(pr);

        //Step:4  Calling the Put() request method ,Passing the URi Key, Updated Data  and Collecting Response
        Response res = http.PutRequest(Body, "QA_URI1", TC_2_Post.JsonKeyValue);
        System.out.println("Data Updated By put() http Request");

        //Step:5 Validating the Response by calling Response Validation  method and passing Response Data

        ResponseValidation.ResponseStatusCodeValidatio(200, res);

        String UpdatedData = JsonResParsing.JsonResDataParsing(res, "LastName");
        System.out.println("The value of Updated JSon key fetched is : " + UpdatedData);
        ResponseValidation.ResponseDataValidation("LGoswami", UpdatedData);

    }
}
