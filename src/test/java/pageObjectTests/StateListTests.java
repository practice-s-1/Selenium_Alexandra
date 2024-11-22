package pageObjectTests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.StateDDPage;
import utils.TestBase;

public class StateListTests extends TestBase {

    /*
    1. Open the link -> https://automationteststore.com/index.php?rt=account/login
    2. Click on 'Continue' button.
    3. Assert that the page title is 'CREATE ACCOUNT'.
    4. Assert that the title page is '--- Please Select ---'.
    5. Assert that the list contains 5 states that start with 'A'.
    Create a new list and store these 4 values.
    6. Assert that the last value from the list is 'Wrexham'.
    7. Check if the 'Bristol' value is on the list. If the value is present click on the value and assert
    that the selected value is Bristol now.
    --- use Page Object and Page Factory design patterns ---.
     */

    @Test
    public void stateDropDownTest() {
        driver.get("https://automationteststore.com/index.php?rt=account/login");

        StateDDPage dropDownPage = new StateDDPage(driver);

        dropDownPage.clickContinueButton();

        Assert.assertEquals("", "CREATE ACCOUNT", dropDownPage.getTitlePage());



        Assert.assertEquals("The default value is wrong", "--- Please Select ---",
                dropDownPage.getSelectedOption());

        System.out.println("The list is: " + dropDownPage.getTheListWithStatesStartingWithA());
        Assert.assertEquals(5, dropDownPage.getTheListWithStatesStartingWithA().size());

        dropDownPage.selectDropdownOption("Bristol");
        Assert.assertEquals("", "Bristol", dropDownPage.getSelectedOption());

        System.out.println("The last state is: " + dropDownPage.getTheLastStateFromTheList());
        Assert.assertEquals("", "Wrexham", dropDownPage.getTheLastStateFromTheList());
    }

    private void doTheScroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
    }
}
