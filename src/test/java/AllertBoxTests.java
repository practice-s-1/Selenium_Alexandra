
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestBase;

import java.util.logging.Logger;

public class AllertBoxTests extends TestBase {

    static Logger log = Logger.getLogger(String.valueOf(AllertBoxTests.class));

    @Test
    public void alertTest() {
        driver.get("https://chandanachaitanya.github.io/selenium-practice-site/?languages=Java&enterText=");

        WebElement alertButton = driver.findElement(By.id("alertBox"));
        alertButton.click();

        Alert alertPopUp = driver.switchTo().alert(); //Obiect de tip Alert
        String actualMessage = alertPopUp.getText();
        String expectedMessage = "This is a simple alert box! \n" + "You can't escape from me until you click 'OK'!";
        Assert.assertEquals(actualMessage, expectedMessage, "The text inside popup is wrong");

        alertPopUp.accept(); // obiectul de tip Alert
    }


    // TEMA
    @Test
    public void confirmTest() {
        driver.get("https://chandanachaitanya.github.io/selenium-practice-site/?languages=Java&enterText=");

        WebElement confirmButton = driver.findElement(By.id("confirmBox"));
        confirmButton.click();

        Alert confirmPopUp = driver.switchTo().alert();
        String actualMessage = confirmPopUp.getText();
        String expectedMessage = "Click 'OK' or 'Cancel'.";
        Assert.assertEquals(actualMessage, expectedMessage, "The text inside popup is wrong");
        confirmPopUp.accept();


        confirmButton.click();
        Alert confirmPopUpButton = driver.switchTo().alert();
        actualMessage = confirmPopUpButton.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "The text inside popup is wrong");
        confirmPopUpButton.dismiss();
    }

    @Test
    public void promptTest() {
        driver.get("https://chandanachaitanya.github.io/selenium-practice-site/?languages=Java&enterText=");
        WebElement promptButton = driver.findElement(By.id("promptBox"));
        promptButton.click();

        Alert promptPopUp = driver.switchTo().alert();
        String actualMessage = promptPopUp.getText();
        String expectedMessage = "Which Selenium Tool do you like the most?";
        Assert.assertEquals(actualMessage, expectedMessage, "The text inside popup is wrong");

        promptPopUp.sendKeys("William Shakespeare\t");
        promptPopUp.accept();
    }
}
