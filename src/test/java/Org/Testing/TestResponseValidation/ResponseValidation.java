package Org.Testing.TestResponseValidation;

import io.restassured.response.Response;
import org.apache.commons.math3.analysis.function.Exp;
import org.testng.Assert;

public class ResponseValidation {
    public static void ResponseStatusCodeValidatio(int ExpStatusCode,Response res)
    {

        Assert.assertEquals(res.getStatusCode(),ExpStatusCode);
        System.out.println("Response Status Validated");

    }
    public static void ResponseDataValidation(String ExpData,String ActualData)
    {
        Assert.assertEquals(ExpData,ActualData);
        System.out.println("Response Data Validated");
    }
}
