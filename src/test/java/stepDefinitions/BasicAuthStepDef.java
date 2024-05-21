package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageObjects.BasicAuthPage;
import utils.TestSetUp;

import java.io.IOException;

public class BasicAuthStepDef {

    TestSetUp testSetUp;
    BasicAuthPage basicAuthPage;
    private static final Logger log = LoggerFactory.getLogger(HomePageStepDef.class);

    public BasicAuthStepDef(TestSetUp testSetUp) {
        this.testSetUp = testSetUp;
        this.basicAuthPage = testSetUp.pageFactory.getBasicAuthPage();
    }

    @When("user enters username {string} and password {string} in the form")
    public void user_enters_username_and_password_in_the_form(String username, String password) throws IOException {
        basicAuthPage.authenticate(username, password);
    }

    @Then("user is logged in and a confirmation message appears")
    public void user_is_logged_in_and_a_confirmation_message_appears() throws IOException {
        Assert.assertTrue(basicAuthPage.isUserLoggedIn());
        log.info("Step 4");
    }

    @Then("user is not logged in")
    public void user_is_not_logged_in() {
        Assert.assertFalse(basicAuthPage.isUserLoggedIn());

    }
}
