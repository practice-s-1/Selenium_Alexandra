package pageObjectTests.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestBase;

public class CheckOrderTest extends TestBase {
    @BeforeClass
    public static void beforeClass() {
        driver.get("https://automationteststore.com/");
    }

    @Test
    public void checkOrderStateTest() {

        WebElement accountTab = driver.findElement(By.xpath("//span[contains(text(), 'Account')][1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(accountTab).perform();

        WebElement checkYourOrderOption = driver.findElement(By.xpath("//span[contains(text(), 'Check Your Order')][1]"));
        checkYourOrderOption.click();

        WebElement titlePage = driver.findElement(By.className("maintext"));
        Assert.assertEquals(titlePage.getText(), "ORDER DETAILS", "");
    }

    @Test
    public void test() {

    }
}
