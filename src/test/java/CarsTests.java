import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;


public class CarsTests extends TestBase {

    /**
     1. Navigate to the Tools QA site -> https://demoqa.com/select-menu
     2. Assert that the Old Style Select Menu contains 11 values.

     3. Assert that the default value for Old Style Select Menu is Red.
     4. Assert that the Old Style Select Menu contains the White and Black value.
     ---- Create a new list and store these two values. Make assert on size.

     5. Retrieve from the Standard multi select DD all the cars except the Audi one.
     6. Assert that the list doesn't contain the Audi car, the size should be 3.
     Note: use enum and add assert for each point.
     */

    @Test
    public void verifyIfTheDDsAreWorkingAsExpected() {
        // 1. Navigate to the Tools QA site -> https://demoqa.com/select-menu
        driver.get("https://demoqa.com/select-menu");

        // 2. Assert that the Old Style Select Menu contains 11 values.
        WebElement oldSelectMenuElement = driver.findElement(By.id("oldSelectMenu"));
        Select oldSelectMenuDD = new Select(oldSelectMenuElement);

        Assert.assertEquals(11, oldSelectMenuDD.getOptions().size());

        // 3. Assert that the default value for Old Style Select Menu is Red.
        Assert.assertEquals("The default color is not red!", "Red", oldSelectMenuDD.getFirstSelectedOption().getText());

        // 4. Assert that the Old Style Select Menu contains the White and Black value.
        List<WebElement> allColors = oldSelectMenuDD.getOptions();
        List<String> selectedColors = new ArrayList<>();

        for (WebElement currentColor : allColors) {
            if (currentColor.getText().equals("White") || currentColor.getText().equals("Black")) {
                selectedColors.add(currentColor.getText());
            }
        }
        Assert.assertEquals(2, selectedColors.size());

        //  5. Retrieve from the Standard multi select DD all the cars except the Audi one.
        WebElement carsDDElement = driver.findElement(By.name("cars"));
        Select carsDD = new Select(carsDDElement);

        List<String> listOfCarsExceptAudi = new ArrayList<>();

        for (WebElement currentCar : carsDD.getOptions()) {
            if (!currentCar.getText().equals("Audi")) {
                System.out.println("The retrive car is: " + currentCar.getText());
                listOfCarsExceptAudi.add(currentCar.getText());
            }
        }

        // 6. Assert that the list doesn't contain the Audi car, the size should be 3.
        Assert.assertEquals(3, listOfCarsExceptAudi.size());
        Assert.assertFalse(listOfCarsExceptAudi.contains("Audi"));
    }
}
