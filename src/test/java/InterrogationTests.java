import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.time.Duration;
import java.util.logging.Logger;

public class InterrogationTests extends TestBase {

    static Logger log = Logger.getLogger(String.valueOf(InterrogationTests.class));

    @Test
    public void returnSourcePageForeMAG() {
        driver.get("https://www.emag.ro");

        log.info("Getting the source page of the application. " + driver.getPageSource());
        driver.getPageSource();
    }

    @Test
    public void checkTheCartWhenThereAreNoProductsAdded() throws InterruptedException {
        final String MESSAGE_FOR_EMPTY_CART = "There are no items in your cart.";

        log.info("Getting the application page");
        driver.get("https://www.limeroad.com/");

        WebElement womenButton = driver.findElement(By.id("shopWomen"));
        womenButton.click();

        log.info("Getting the cart element");
        WebElement cartButton = driver.findElement(By.id("DesktopCart"));

        log.info("Clicking on the cart button in order to get the cart page.");
        cartButton.click();

        log.info("Asserting that we are in the right page.");
        Thread.sleep(2000);

        Assert.assertEquals("The Urls are different!", "https://www.limeroad.com/shopping_cart",
                driver.getCurrentUrl());

        WebElement messageForEmptyCartElement = driver.findElement(By.xpath("//*[contains(text(), 'in your cart')]"));
        String messageForEmptyCart = messageForEmptyCartElement.getText(); // "There are no items in your cart."

        log.info("Asserting that the right message is displayed when the cart is empty.");

        Assert.assertEquals("The message for empty cart is wrong", MESSAGE_FOR_EMPTY_CART,
                messageForEmptyCart);
    }

    @Test
    public void checkTheCartWhenThereAreProductsAdded() throws InterruptedException {
        log.info("Getting the application page");
        driver.get("https://www.limeroad.com/");

        WebElement womenButton = driver.findElement(By.id("shopWomen"));
        womenButton.click();

        Thread.sleep(5000);
        log.info("Clicking on the bag tab in order to get the products sub-categories");
        WebElement chicSelectsSection = driver.findElement(By.xpath("//*[contains(text(), 'Chic Selects')]"));
        chicSelectsSection.click();

        Thread.sleep(5000);
        WebElement firstProduct = driver.findElement(By.id("21034131"));
        firstProduct.click();

        Thread.sleep(5000);
        log.info("Clicking on the 'M' size button");
        WebElement sizeButton = driver.findElement(By.id("size_37288529"));
        sizeButton.click();

        Thread.sleep(5000);
        log.info("Clicking on the 'Add to Cart' button");
        WebElement addToCartButoon = driver.findElement(By.xpath("//*[contains(text(), 'ADD TO CART')]"));
        addToCartButoon.click();

        Thread.sleep(5000);
        log.info("Asserting that we are on the correct page");
        Assert.assertEquals("The Urls are different!", "https://www.limeroad.com/shopping_cart?src_id=merge_feed_story__2",
                driver.getCurrentUrl());

        log.info("Asserting that the product name is correct ");
        WebElement productName = driver.findElement(By.xpath("//*[contains(text(), 'women round neck sleeveless layered kurta')]"));
        Assert.assertEquals("The product name is different", "women round neck sleeveless layered kurta", productName.getText());

        log.info("Asserting that the displayed price is the correct");
        WebElement productPrice = driver.findElement(By.xpath("//*[contains(text(), '₹ 1939')]"));
        Assert.assertEquals("The price is different", "₹ 1939", productPrice.getText());

        log.info("Clicking on 'BUY NOW' button");
        WebElement buyNow = driver.findElement(By.xpath("//*[contains(text(), 'BUY NOW')]"));
        buyNow.click();

        Thread.sleep(3000);
        log.info("Asserting that the notification form is displayed");
        WebElement notificationForm = driver.findElement(By.id("signinnewForm"));
        Assert.assertTrue("The notification form is not displayed", notificationForm.isDisplayed());

        Thread.sleep(3000);
        WebElement expectedText = driver.findElement(By.xpath("//*[contains(text(), 'We will send you an')]"));
        Assert.assertTrue("The expected text is not found in the notification form", expectedText.isDisplayed());

    }

    @Test
    public void checkIfTheLogoIsDisplayedOnHomePage() {
        log.info("Getting the application page");
        driver.get("https://www.limeroad.com/");

        WebElement womenButton = driver.findElement(By.id("shopWomen"));
        womenButton.click();

        log.info("Asserting that logo element is displayed on every page");
        WebElement logoElement = driver.findElement(By.id("DeskLogo"));
        Assert.assertTrue("The logo element is not displayed", logoElement.isDisplayed());
    }

    @Test
    public void checkTheTitleOfFirstPage() {
        log.info("Getting the application page");
        driver.get("https://www.limeroad.com/");

        WebElement womenButton = driver.findElement(By.id("shopWomen"));
        womenButton.click();

        log.info("Asserting that first page title is 'Online Shopping Site - Shop Men & Women Fashion Online in India'");
        String actualTitle = driver.getTitle();

        if (actualTitle.equals("Online Shopping Site - Shop Men & Women Fashion Online in India")) {
            log.info("Test passed");
        } else {
            log.info("Test failed");
        }

    }

    @Test
    public void checkProductSearchFunctionality() throws InterruptedException {
        log.info("Getting the application page");
        driver.get("https://www.limeroad.com/");

        WebElement womenButton = driver.findElement(By.id("shopWomen"));
        womenButton.click();

        WebElement searchButton = driver.findElement(By.id("deskSearch"));
        searchButton.click();

        log.info("Searching for products");

        WebElement searchBar = driver.findElement(By.xpath("//*[@id='srcInpu']"));
        searchBar.click();


        log.info("Searching for specific product using product code");
        searchBar.sendKeys("21313885");
        searchBar.sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        WebElement product = driver.findElement(By.xpath("//img[@id='21313885']"));

        log.info("Using an explicit wait that waits until the button becomes clickable.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(product));

        log.info("Asserting that is displayed the correct page");
        Assert.assertEquals("The Urls are different!", "https://www.limeroad.com/search/21313885",
                driver.getCurrentUrl());
    }
}
