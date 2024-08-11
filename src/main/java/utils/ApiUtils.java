package utils;

import core.TestContext;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.Post;
import pojo.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ApiUtils {
    private TestContext testContext;
    public ApiUtils(TestContext testContext){
        this.testContext = testContext;
    }

    public void setUpConnection() {
        testContext.requestSpecification = RestAssured.given().
                baseUri(ConfigReader.readProperty("base-url"))
                .header("Authorization", "Bearer " + ConfigReader.readProperty("token"));
    }

//    public String getBearerToken(String property) {
//        return switch (property) {
//            case "token" ->
//                    System.getenv("API_TOKEN") != null ? System.getenv("API_TOKEN") : new ConfigReader().getPropertyFromFile(property);
//            default -> new ConfigReader().getPropertyFromFile(property);
//        };
//    }


    public List<User> getUsers(){
        testContext.requestSpecification.basePath("public/v2/users");
        testContext.response = testContext.requestSpecification.get();
        JsonPath jsonPath = testContext.response.jsonPath();
        return jsonPath.getList("", User.class);
    }
    public List<Post> getPosts(){
        testContext.requestSpecification.basePath("public/v2/posts");
        testContext.response = testContext.requestSpecification.get();
        JsonPath jsonPath = testContext.response.jsonPath();
        return jsonPath.getList("", Post.class);
    }
}
