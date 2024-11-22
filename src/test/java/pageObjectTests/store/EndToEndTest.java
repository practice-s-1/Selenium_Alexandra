package pageObjectTests.store;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.store.*;
import utils.TestBase;

public class EndToEndTest extends TestBase {

    RegisterPage2 registerPage2;
    RealHomePage realHomePage = new RealHomePage(driver);
    CheckoutConfirmationPage checkoutConfirmationPage = new CheckoutConfirmationPage(driver);
    SuccessfulOrderPage successfulOrderPage = new SuccessfulOrderPage(driver);
    MyOrderHistoryPage myOrderHistoryPage = new MyOrderHistoryPage(driver);

    private final String CHECKOUT_CONFIRMATION_TITLE_PAGE = "CHECKOUT CONFIRMATION";
    private final String ORDER_SUCCESSFUL_MESSAGE = "YOUR ORDER HAS BEEN PROCESSED!";
    private final String MY_ORDER_HISTORY_PAGE_TITLE = "MY ORDER HISTORY";

    @Test
    public void registerNewAccount() {
        driver.get("https://automationteststore.com/index.php?rt=account/create");
        registerPage2 = new RegisterPage2(driver);

        registerPage2.insertRegisterAccountValues("Cristina-Alexandra", "Hubencu", "alexandrahubencu123@yahoo.com", "Voinesti rd",
                "Iasi", "700562", "alexandra.hubencu2", "Alexandra123", "Alexandra123");

        registerPage2.selectOptionCountryDropDown("Romania");

        registerPage2.selectOptionRegionDropDown("Iasi");

        registerPage2.clickOnYesRadioButton();

        registerPage2.clickOnPrivacyPolicyButton();

        registerPage2.clickOnContinueButton();
    }

    @Test
    public void createNewOrder() {

        driver.get("https://automationteststore.com/index.php?rt=account/success");

        Assert.assertEquals("The registration message is not displayed", "YOUR ACCOUNT HAS BEEN CREATED!", registerPage2.verifySuccessfulRegistrationMessage());

        realHomePage.hoverOverSkinCareTab();

        realHomePage.selectFaceSubcategory();

        realHomePage.selectProductToAddInCart();

        realHomePage.addProductToCart();

        realHomePage.clickOnCheckout();
    }

    @Test
    public void checkOutConfirmation() {

        driver.get("https://automationteststore.com/index.php?rt=checkout/confirm");

        Assert.assertEquals(checkoutConfirmationPage.checkTitleCheckoutConfirmationPage(), CHECKOUT_CONFIRMATION_TITLE_PAGE,
                "The title of the page is wrong");

        checkoutConfirmationPage.clickOnConfirmOrderButton();
    }

    @Test
    public void checkSuccessfulOrderRegistrationMessage() {

        driver.get("https://automationteststore.com/index.php?rt=checkout/success");

        Assert.assertEquals(successfulOrderPage.getSuccessfulOrderTitlePage(), ORDER_SUCCESSFUL_MESSAGE,
                "Order successful message is not displayed");

        successfulOrderPage.hoverOverAccountTab();
        successfulOrderPage.clickOncheckOrderButton();
    }

    @Test
    public void checkOrderStatus() {

        driver.get("https://automationteststore.com/index.php?rt=account/history");

        Assert.assertEquals(myOrderHistoryPage.getOrderHistoryPageTitle(), MY_ORDER_HISTORY_PAGE_TITLE,
                "The page title is wrong");

        Assert.assertEquals(myOrderHistoryPage.getOrderStatus(), "Status: Pending", "The order status is not Pending");
    }
}
