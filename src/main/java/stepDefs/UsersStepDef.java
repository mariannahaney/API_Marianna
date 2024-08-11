package stepDefs;

import core.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UsersStepDef {
    private TestContext testContext;

    public UsersStepDef(TestContext testContext){this.testContext = testContext;}

    @Given("I establish a connection to the api service")
    public void iEstablishAConnectionToTheApiService() {
        testContext.ApiUtils.setUpConnection();
    }

    @And("The result should have more than {int} user")
    public void theResultShouldHaveMoreThanUser(int number) {
        Assert.assertTrue(testContext.ApiUtils.getUsers().size() > 1);
    }

    @When("I send get request to {string}")
    public void iSendGetRequestTo(String resource) {
        switch (resource) {
            case "public/v2/users":
                testContext.ApiUtils.getUsers();
                break;
            case "public/v2/posts":
                testContext.ApiUtils.getPosts();
                break;
            default:
                Assert.fail();
        }
    }

        @Then("Status code should bee {int}")
        public void statusCodeShouldBee(int statusCode) {
            Assert.assertEquals(statusCode, testContext.response.statusCode());
        }

}
