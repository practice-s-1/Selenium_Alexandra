package pageObjectTests.store;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import pageObjects.store.MyAccountInformationPage;
import utils.TestBase;

public class EditAccountDetailsTest extends TestBase {

    AccountPage accountPage = new AccountPage(driver);
    LogInPage logInPage = new LogInPage(driver);
    MyAccountInformationPage myAccountInformationPage = new MyAccountInformationPage(driver);

    @Test
    public void verifyIfAccountDetailsAreCorrectlyUpdated() {

        driver.get("https://automationteststore.com/");

        accountPage.clickOnAccountMenu();

        logInPage.addCredentials("alexandra.hubencu2", "Alexandra123");

        logInPage.clickLoginButton();

        accountPage.clickOnEditAccountIcon();

        myAccountInformationPage.fillPhoneCell("+40727551428");

        myAccountInformationPage.clickOnContinueButoon();

        Assert.assertEquals(accountPage.getSuccessfulMessage(), "Success: Your account has been successfully updated.", "The success message is not displayed");

    }

}
