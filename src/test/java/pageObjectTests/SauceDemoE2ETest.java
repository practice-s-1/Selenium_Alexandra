package pageObjectTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.sauceDemo.CartPage;
import pageObjects.sauceDemo.LoginPage;
import pageObjects.sauceDemo.ProductsPage;
import utils.TestBase;

public class SauceDemoE2ETest extends TestBase {

    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeClass
    public void openApp() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void verifyE2EflowForSauceDemoApp() {


        loginPage = new LoginPage(driver);

        loginPage.addCredentials("standard_user", "secret_sauce");

        loginPage.clickOnLoginButton();

        productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getTitlePage(), "Products", "The title page is wrong");

        productsPage.clickOnAddToCartButton();

        productsPage.clickOnCart();

        cartPage = new CartPage(driver);

        Assert.assertEquals(cartPage.getCartPageTitle(), "Your Cart", "The cart page title is wrong");

        Assert.assertTrue(cartPage.checkIfProductNameIsCorrect("Backpack"), "The product name is wrong");

        //Assert.assertEquals(cartPage.getProductPrice(), "$29.99", "The product's price is wrong");

        cartPage.clickOnCheckoutButton();






    }

}
