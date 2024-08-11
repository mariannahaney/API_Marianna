package utils;

import core.TestContext;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.Post;
import pojo.User;
import java.util.List;

public class ApiUtils {
    private TestContext testContext;
    public ApiUtils(TestContext testContext){
        this.testContext = testContext;
    }

    public void setUpConnection() {
        testContext.requestSpecification = RestAssured.given().
                baseUri(ConfigReader.readProperty("base-url"))
                .header("Authorization", "Bearer " + getBearerToken());
    }

    public String getBearerToken() {
        return ConfigReader.readProperty("token");
    }

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
