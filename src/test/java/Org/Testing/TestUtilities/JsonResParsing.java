package Org.Testing.TestUtilities;

import io.restassured.response.Response;

public class JsonResParsing {

    public static String JsonResDataParsing(Response res, String JsonPath)
    {
        String JsonParseKeyValue = res.jsonPath().get(JsonPath).toString();

        return JsonParseKeyValue;
    }
}
