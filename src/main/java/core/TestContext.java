package core;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ApiUtils;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    public ApiUtils ApiUtils;
    public RequestSpecification requestSpecification;
    public Response response;

    public TestContext(){
        ApiUtils = new ApiUtils(this);
    }



}
