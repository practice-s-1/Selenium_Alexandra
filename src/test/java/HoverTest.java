import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestBase;

public class HoverTest extends TestBase {

    @Test
    public void hoverTest() {

        driver.get("https://testare-manuala.locdejoacapentruitsti.com/blog/login/");

        WebElement titlePage = driver.findElement(By.linkText("My CMS"));
        // By.xpath("//a[@href='https://testare-manuala.locdejoacapentruitsti.com/blog/contact/']")
        // //p[contains(text(),'Practice website')] -> xpath


        String initialColor = titlePage.getCssValue("color"); // gri inchis
        // gri inchis #303030 -> rgba -> rgba(48, 48, 48, 1)
        String expectedColor = convertCodesToString("48, 48, 48", "1");// -> convert to String

        System.out.println("The initial color is: " + initialColor);

        Assert.assertEquals(expectedColor, initialColor);

        Actions hover = new Actions(driver);

        Action mouseOver = hover.moveToElement(titlePage).build();
        mouseOver.perform();

        String hoverColor = titlePage.getCssValue("color"); // initial after hover
        // rgba(238, 51, 51, 1)
        String expectedHoverColor = convertCodesToString("238, 51, 51", "1");

        Assert.assertEquals(expectedHoverColor, hoverColor);
    }

    private String convertCodesToString(String colorCodes, String number) {
        return "rgba(" + colorCodes + ", " + number + ")";
    }
}
