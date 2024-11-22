package pageObjectTests.store;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.store.ContactUsPage;
import utils.TestBase;

public class ContactUsTest extends TestBase {

    ContactUsPage contactUsPage;

    @Test
    public void verifyTheContactUsFunctionality() {
        driver.get("https://automationteststore.com/index.php?rt=content/contact");

        contactUsPage = new ContactUsPage(driver);
        contactUsPage.insertValues("Alina", "Alisa@gmail.com",
                "I need help to create account!");
        contactUsPage.clickSubmitButton();

        Assert.assertEquals(contactUsPage.getSuccessMessage(), "Your enquiry has been successfully sent to the store owner!",
                "The submit is not working!");

    }
}
