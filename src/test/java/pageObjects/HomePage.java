package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Commons;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private static final Logger log = LoggerFactory.getLogger(HomePage.class);
    private static final By BASIC_AUTH_LINK = By.linkText("Basic Auth");

    /**
     * Method to click Basic Auth link on Home Page.
     */
    public void clickBasicAuthLink() {
        log.info("clickBasicAuthLink - called");
        Commons.click(BASIC_AUTH_LINK);
        log.info("clickBasicAuthLink - done");
    }
}
