package pageObjects.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageBase;

public class SuccessfulOrderPage extends PageBase {

    @FindBy(className = "maintext")
    WebElement successfulOrderTitlePage;

    @FindBy(xpath = "//span[contains(text(), 'Account')]")
    WebElement accountTab;

    @FindBy(xpath = "//span[contains(text(), 'Check Your Order')]")
    WebElement checkYourOrderButton;

    public SuccessfulOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSuccessfulOrderTitlePage(){
        return successfulOrderTitlePage.getText();
    }

    public void hoverOverAccountTab(){
        Actions actions = new Actions(driver);
        actions.moveToElement(accountTab);
    }

    public void clickOncheckOrderButton(){
        checkYourOrderButton.click();
    }
}
