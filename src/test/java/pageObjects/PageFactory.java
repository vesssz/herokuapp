package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    public WebDriver driver;
    public HomePage homePage;
    public BasicAuthPage basicAuthPage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        homePage = new HomePage(driver);
        return homePage;
    }

    public BasicAuthPage getBasicAuthPage() {
        basicAuthPage = new BasicAuthPage(driver);
        return basicAuthPage;
    }

}
