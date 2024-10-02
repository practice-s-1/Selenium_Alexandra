package pageObjectTests;

import org.junit.Assert;
import org.junit.Test;
import pageObjects.RegisterPage;
import utils.TestBase;

import java.util.logging.Logger;

public class RegisterTests extends TestBase {

    RegisterPage registerPage = new RegisterPage(driver);
    static Logger log = Logger.getLogger(String.valueOf(RegisterTests.class));

    @Test

    public void registerWithAllRequiredFieldsCompleted() {
        driver.get("https://testare-manuala.locdejoacapentruitsti.com/blog/register/");

        log.info("Entering the required fields");
        registerPage.enterRequiredFields("Alina1234", "alina1234@gmail.com", "Alina12345", "Alina12345");

        log.info("Clicking on the Register button");
        registerPage.clickRegisterButton();

        RegisterPage registerPage1 = new RegisterPage(driver);

        log.info("Verifying the success message");
        //log.info(registerPage.getUserName());
        Assert.assertEquals("The account has not been successfully created!", "The account Ioana11121 has been successfully created!", registerPage.getSuccessMessage());


    }
}
