package pageObjectTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import pageObjects.store.HomePage;
import pageObjects.store.RealHomePage;
import utils.TestBase;

import java.util.logging.Logger;

public class LogInTests extends TestBase {
    LogInPage logInPage = new LogInPage(driver);
    static Logger log = Logger.getLogger(String.valueOf(LogInTests.class));

    @Test
    public void logInWithValidCredentials() {
        driver.get("https://testare-manuala.locdejoacapentruitsti.com/blog/login/");

        log.info("Entering the valid credentials");
        logInPage.addCredentials("alexandra.hubencu2", "Alexandra123");

        log.info("Clicking on the LogIn button");
        logInPage.clickLoginButton();
    }

    @Test
    public void logInWithInvalidCredentials() throws InterruptedException {

        driver.get("https://testare-manuala.locdejoacapentruitsti.com/blog/login/");

        log.info("Entering invalid credentials");

        logInPage.addCredentials("alexandra.hubencu", "123");
        logInPage.clickLoginButton();
        Thread.sleep(3000);

        Assert.assertEquals(logInPage.displayErrorMessage(), "ERROR: Invalid username or email. Lost your password?",
                "Error message is not displayed");
    }
}
