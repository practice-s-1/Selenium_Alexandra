package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StateDDPage extends PageBase {

    @FindBy(xpath = "//*[@title='Continue']")
    WebElement continueButton;

    @FindBy(id = "AccountFrm_zone_id")
    WebElement stateDropDownElement;

    @FindBy(className = "maintext")
    WebElement titlePageElement;


    public StateDDPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public String getTitlePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(titlePageElement));
        return titlePageElement.getText();
    }

    // Method to select an option from the dropdown
    public void selectDropdownOption(String optionText) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.visibilityOf(stateDropDownElement));

        // Create a Select object and select the option by visible text
        Select dropdown = new Select(stateDropDownElement);
        dropdown.selectByVisibleText(optionText);
    }

    // Method to get the currently selected option
    public String getSelectedOption() {
        Select dropdown = new Select(stateDropDownElement);
        return dropdown.getFirstSelectedOption().getText(); // Get selected option text
    }

    public List<String> getTheListWithStatesStartingWithA() {
        Select dropdown = new Select(stateDropDownElement);
        List<WebElement> listOfStateElements = dropdown.getOptions();
        List<String> stateNamesList = new ArrayList<>();
        for (WebElement currentValue : listOfStateElements) {
            if (currentValue.getText().startsWith("A")) {
                stateNamesList.add(currentValue.getText());
            }
        }
        return stateNamesList;
    }

    public String getTheLastStateFromTheList() {
        Select dropdown = new Select(stateDropDownElement);
        List<WebElement> listOfStateElements = dropdown.getOptions();
        return dropdown.getOptions().get(listOfStateElements.size() - 1).getText();
    }
}
