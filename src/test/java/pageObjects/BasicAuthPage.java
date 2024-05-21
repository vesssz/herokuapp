package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Commons;

import java.io.IOException;

public class BasicAuthPage {
    public WebDriver driver;

    public BasicAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final Logger log = LoggerFactory.getLogger(BasicAuthPage.class);
    private static final By AUTH_CONFIRM_PAGE_TITLE = By.xpath("//h3[text() = 'Basic Auth']");
    private static final By AUTH_CONFIRM_PAGE_TEXT = By.xpath("//p[contains(normalize-space(), 'Congratulations! You must have the proper credentials.')]");

    /**
     * Modifies url, so that page is opened with needed credentials
     *
     * @param username The username to send
     * @param password The password to send
     */
    public void authenticate(String username, String password) throws IOException {
        log.info("authenticate - called");
        String baseUrl = Commons.getTestURL();
        if (baseUrl.startsWith("https://")) {
            baseUrl = baseUrl.substring(8);
        } else if (baseUrl.startsWith("http://")) {
            baseUrl = baseUrl.substring(7);
        }

        String urlWithCredentials = "https://" + username + ":" + password + "@" + baseUrl + "basic_auth";
        driver.get(urlWithCredentials);
        log.info("authenticate - done... credentials used- username: {}, password: {} ", username, password);
    }

    /**
     * Verifies text on page to see if user is logged in
     *
     * @return boolean
     */
    public boolean isUserLoggedIn() {
        log.info("isUserLoggedIn - called...");
        return Commons.isElementDisplayed(AUTH_CONFIRM_PAGE_TEXT, AUTH_CONFIRM_PAGE_TITLE);
    }
}
