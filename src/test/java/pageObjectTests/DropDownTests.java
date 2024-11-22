package pageObjectTests;

import enums.Color;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.StateDDPage;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DropDownTests extends TestBase {

    static Logger log = Logger.getLogger(String.valueOf(DropDownTests.class));
    StateDDPage dropDownPage = new StateDDPage(driver);

    private final int NUMBER_OF_VALUES_FROM_OLD_SELECT_MENU = 11;
    private final String CAR_TYPE_AUDI = "Audi";


    /*
           1. Navigate to the Tools QA site -> https://demoqa.com/select-menu
           2. Assert that the Old Style Select Menu contains 11 values.
           3. Assert that the default value for Old Style Select Menu is Red.
           4. Assert that the Old Style Select Menu contains the White and Black value.
           Create a new list and store these two values. Make assert on size.
           5. Retrieve from the Standard multi select DD all the cars except the Audi one.
           6. Assert that the list doesn't contain the Audi car, the size should be 3.
           7. Assert false that the new list does not contain Audi.
    Note: use enum, page objects and add assert for each point.
    */
    @Test
    public void verifyIfTheDDsAreWorkingAsExpected() {
        driver.get("https://demoqa.com/select-menu");

        log.info("Assert that the Old Style Select Menu contains 11 values.");
        WebElement oldSelectMenuElement = driver.findElement(By.id("oldSelectMenu"));
        Select oldSelectMenuDD = new Select(oldSelectMenuElement);

        Assert.assertEquals("The number is wrong", NUMBER_OF_VALUES_FROM_OLD_SELECT_MENU, String.valueOf(oldSelectMenuDD.getOptions().size()));

        log.info("Assert that the default value for Old Style Select Menu is Red.");
        Assert.assertEquals("Default value is wrong", Color.RED.name(), oldSelectMenuDD.getFirstSelectedOption().getText());

        log.info("Assert that the Old Style Select Menu contains the White and Black value.");

        List<WebElement> allColors = oldSelectMenuDD.getOptions();
        List<String> selectedColors = new ArrayList<>();

        for (WebElement value : allColors) {
            if (value.getText().equals(Color.WHITE.name()) || value.getText().equals(Color.BLACK.name())) {
                selectedColors.add(value.getText());
            }
        }
        Assert.assertEquals(2, selectedColors.size(), "The size of list is wrong");

        log.info("Retrieve from the Standard multi select DD all the cars except the Audi one.");
        WebElement carsDDElement = driver.findElement(By.id("cars"));
        Select carsDD = new Select(carsDDElement);

        List<String> listOfCarsExceptAudi = new ArrayList<>();

        for (WebElement carValue : carsDD.getOptions()) {
            if (!carValue.getText().equals(CAR_TYPE_AUDI)) {
                listOfCarsExceptAudi.add(carValue.getText());
            }
        }
        System.out.println("List of cars: " + listOfCarsExceptAudi);

        // TEMA
        log.info("Assert that the list doesn't contain the Audi car, the size should be 3.");
        Assert.assertEquals(3, listOfCarsExceptAudi.size(), "The size of list is wrong");
        System.out.println("Cars list size " + listOfCarsExceptAudi.size());

        log.info("Assert false that the new list does not contain Audi.");
        Assert.assertFalse(listOfCarsExceptAudi.contains(CAR_TYPE_AUDI), "The list contains Audi");


    }
}
