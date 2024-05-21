package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.HomePage;
import utils.TestSetUp;

public class HomePageStepDef {

    TestSetUp testSetUp;
    HomePage homePage;
    private static final Logger log = LoggerFactory.getLogger(HomePageStepDef.class);

    public HomePageStepDef(TestSetUp testSetUp) {
        this.testSetUp = testSetUp;
        this.homePage = testSetUp.pageFactory.getHomePage();
    }

    @Given("user is on landing page")
    public void user_is_on_landing_page() {
        log.info("Opening landing page");
    }

    @When("user clicks Basic Auth link")
    public void user_clicks_basic_auth_link() {
        homePage.clickBasicAuthLink();
    }
}
