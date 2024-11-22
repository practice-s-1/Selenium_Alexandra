package temaAlex;

/*1. Navigate to https://www.mediacollege.com/internet/samples/html/country-list.html.
        2. Assert that the default value from the dropdown is <<Country...>>
        3. Assert that France is on the list.
        4. Check the entire dropdown an create a new list that contains all the
         countries that start with 'K'. Assert that the size of the new list is 7.
         Use the method startWith().
        5. Asserting that the last option on the list is Zimbabwe. */


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;

public class PracticeDropdown extends TestBase {

    @Test

    public void verifyDefaultValue(){

        driver.get("https://www.mediacollege.com/internet/samples/html/country-list.html");

        WebElement dropDownElement = driver.findElement(By.name("country"));

        Select dropDown = new Select(dropDownElement);
        Assert.assertEquals("The default value is wrong", "Country...", dropDown.getFirstSelectedOption().getText());

        List<WebElement> allCountries = dropDown.getOptions();

        boolean isFranceOnTheList = false;
        for(WebElement currentValue : allCountries){
            if(currentValue.getText().equals("France")){
                isFranceOnTheList = true;
                break;
            }
        }

        Assert.assertTrue("France is not on the list", isFranceOnTheList);

        List<String>listOfCountriesThatStartsWithZ = new ArrayList<>();

        for(WebElement currentValue2 : allCountries){
            if(currentValue2.getText().startsWith("K")){
                listOfCountriesThatStartsWithZ.add(currentValue2.getText());

            }
        }
        Assert.assertEquals("The size of the list is not correct", 7, listOfCountriesThatStartsWithZ.size());

        int lastIndex = allCountries.size()-1;
        String lastCountryName = allCountries.get(lastIndex).getText();

        Assert.assertEquals("The last country from the list is not correct", "Zimbabwe", lastCountryName);
        








    }

}
