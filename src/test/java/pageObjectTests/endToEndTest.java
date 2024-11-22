import org.junit.Assert;
import org.junit.Test;
import pageObjects.store.*;
import utils.TestBase;

public class endToEndTest extends TestBase {

    RegisterPage2 registerPage2 = new RegisterPage2(driver);

    HomePage2 homePage2 = new HomePage2(driver);

    CheckoutConfirmationPage checkoutConfirmationPage = new CheckoutConfirmationPage(driver);

    OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);

    SuccessfulOrderPage successfulOrderPage = new SuccessfulOrderPage(driver);

    MyOrderHistoryPage myOrderHistoryPage = new MyOrderHistoryPage(driver);

    private final String CHECKOUT_CONFIRMATION_TITLE_PAGE = "CHECKOUT CONFIRMATION";

    private final String ORDER_DETAILS_PAGE_TITLE = "ORDER DETAILS";

    private final String ORDER_SUCCESSFUL_MESSAGE = "YOUR ORDER HAS BEEN PROCESSED!";

    private final String MY_ORDER_HISTORY_PAGE_TITLE = "MY ORDER HISTORY";

    @Test
    public void registerNewAccount() {
        driver.get("https://automationteststore.com/index.php?rt=account/create");


        registerPage2.insertRegisterAccountValues("Cristina-Alexandra", "Hubencu", "alexandrahubencu123@yahoo.com", "Voinesti rd",
                "Iasi", "700562", "alexandra.hubencu2", "Alexandra123", "Alexandra123");

        registerPage2.selectOptionCountryDropDown("Romania");

        registerPage2.selectOptionRegionDropDown("Iasi");

        registerPage2.clickOnYesRadioButton();

        registerPage2.clickOnPrivacyPolicyButton();

        registerPage2.clickOnContinueButton();

    }
        @Test
        public void createNewOrder(){

            driver.get("https://automationteststore.com/index.php?rt=account/success");

            Assert.assertEquals("The registration message is not displayed", "YOUR ACCOUNT HAS BEEN CREATED!", registerPage2.verifySuccessfulRegistrationMessage());

            homePage2.hoverOverSkinCareTab();

            homePage2.selectFaceSubcategory();

            homePage2.selectProductToAddInCart();

            homePage2.addProductToCart();

            homePage2.clickOnCheckout();

        }

        @Test
        public void checkOutConfirmation(){

            driver.get("https://automationteststore.com/index.php?rt=checkout/confirm");

            Assert.assertEquals("The title of the page is wrong", CHECKOUT_CONFIRMATION_TITLE_PAGE, checkoutConfirmationPage.checkTitleCheckoutConfirmationPage());

            checkoutConfirmationPage.clickOnConfirmOrderButton();

        }

        @Test
        public void checkSuccessfulOrderRegistrationMessage(){

            driver.get("https://automationteststore.com/index.php?rt=checkout/success");

            Assert.assertEquals("Order successful message is not displayed", ORDER_SUCCESSFUL_MESSAGE, successfulOrderPage.getSuccessfulOrderTitlePage());

            successfulOrderPage.hoverOverAccountTab();
            successfulOrderPage.clickOncheckOrderButton();
        }

        @Test
        public void checkOrderStatus(){

            driver.get("https://automationteststore.com/index.php?rt=account/history");

            Assert.assertEquals("The page title is wrong", MY_ORDER_HISTORY_PAGE_TITLE, myOrderHistoryPage.getOrderHistoryPageTitle());

            Assert.assertEquals("The order status is not Pending", "Status: Pending", myOrderHistoryPage.getOrderStatus());

        }

}
