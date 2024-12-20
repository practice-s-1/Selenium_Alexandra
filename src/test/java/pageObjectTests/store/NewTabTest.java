package pageObjectTests.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestBase;

import java.time.Duration;
import java.util.ArrayList;

public class NewTabTest extends TestBase {

    @Test
    public void validateIfTheNewTabIsOpening(){

        driver.get("https://automationteststore.com/index.php?rt=account/create");

        WebElement facebookIcon = driver.findElement(By.xpath("//*[@class='twitter'][1]"));
        facebookIcon.click();

        // Get the handles of all open tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to the new tab
        driver.switchTo().window(tabs.get(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Assert.assertEquals(driver.getCurrentUrl(), "https://x.com/", "The URL is wrong");

        // Optionally, you can switch back to the original tab
        driver.switchTo().window(tabs.get(0));

        Assert.assertEquals(driver.getCurrentUrl(), "https://automationteststore.com/");
    }
}
