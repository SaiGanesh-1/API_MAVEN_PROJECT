package Org.Testing.TestCases;

import Org.Testing.TestResponseValidation.ResponseValidation;
import Org.Testing.TestSteps.HttpMethods;
import Org.Testing.TestUtilities.PropertiesFileLoad;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Properties;

public class TC_3_Delete {
    public  void TestCase3() throws IOException {

        //Step:1 Load the property file in the  Object od property class pr
        Properties pr= PropertiesFileLoad.PropFileLoad("C:\\Users\\saiga\\API_MAVEN_PROJECT\\Env.properties");

        //Step:2 initalize the Properties  Object  of Http Method  class  with pr  of step 1
        HttpMethods http= new HttpMethods(pr);

        /*Step:3 Called Delete Data method of class Http Method which will delete the data and will return
        the response of delete Request
         */
        //String id="400";
        Response res= http.DeleteData(TC_2_Post.JsonKeyValue,"QA_URI1");

        //Step:4 res is send into the Response Validation METHOD OF response validation
        ResponseValidation.ResponseStatusCodeValidatio(200,res);
        System.out.println("Data Deleted Successfully : "+res.getStatusCode());
    }
}
