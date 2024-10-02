package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    protected static WebDriver driver;

    @BeforeClass
    public static void beforeClassImplementation() {
        System.setProperty("webdriver.chrome.driver", "./src/main/browsers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @BeforeClass // @BeforeTest()
    public static void beforeMethodImplementation() {

          /*
        examples:
         createAccount();
         login();
         addProductsToCart();
         openTheCart();
         */
    }

    @AfterClass
    public static void tearDown() {
        driver.quit(); // close the browser/session
        // driver.close(); // close the browser
    }
}
