import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.TestBase;

import java.util.List;
import java.util.logging.Logger;

public class DropDownDemo extends TestBase {

    static Logger log = Logger.getLogger(String.valueOf(DropDownDemo.class));

    @Test
    public void dropDownDemo() {

        driver.get("https://www.mediacollege.com/internet/samples/html/country-list.html");

        WebElement countryElement = driver.findElement(By.name("country"));
        Select countryDropDown = new Select(countryElement);

        log.info("Asserting that de default value is 'Country...'");
        String defaultValue = countryDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals("The default value is not correct", "Country...", defaultValue);

        log.info("Checking if Romania is part of the list");
        List<WebElement> dropDownOptions = countryDropDown.getOptions();

        boolean isRomaniaInList = false;
        for (WebElement currentValueFromDD : dropDownOptions) {
            if (currentValueFromDD.getText().equals("Romania")) {
                isRomaniaInList = true;
                break;
            }
        }

        Assert.assertTrue("Romania is not part of the list", isRomaniaInList);

        log.info("Asserting that the last option of the list is Zimbabwe");
        //int lastIndex = dropDownOptions.size()-1;
        //String lastCountryName = dropDownOptions.get(lastIndex).getText();

        //Assert.assertEquals("Zimbabwe is not part of the list", lastCountryName,"Zimbabwe");
        Assert.assertEquals("Zimbabwe is not part of the list", "Zimbabwe",
                dropDownOptions.get(dropDownOptions.size() - 1).getText());

        log.info("Checking that there are no countries starting with x");
        log.info("Checking if the list contains countries with text 'nce'");
    }

    @Test
    public void multipleDropDownDemo(){
        driver.get("https://output.jsbin.com/osebed/2");
        WebElement dropDownFruitsElement = driver.findElement(By.id("fruits"));

        Select fruitsDD = new Select(dropDownFruitsElement);
        fruitsDD.deselectAll();
        fruitsDD.selectByValue("banana");
        fruitsDD.selectByIndex(1);
        List<WebElement> selectedFruits = fruitsDD.getAllSelectedOptions();

        for(WebElement fruit : selectedFruits) {
            log.info("The selected fruit is " + fruit.getText());
        }

        Assert.assertEquals("Apple", selectedFruits.get(1).getText());

        log.info("Select all fruits from the list and assert that the list size si 4");
        fruitsDD.deselectAll();
    }
}
