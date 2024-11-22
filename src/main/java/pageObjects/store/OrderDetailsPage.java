package pageObjects.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageBase;

public class OrderDetailsPage extends PageBase {

    @FindBy(className = "maintext")
    WebElement pageTitle;

    @FindBy(id = "CheckOrderFrm_order_id")
    WebElement orderIdTextBox;

    @FindBy(id = "CheckOrderFrm_email")
    WebElement eMailTextBox;

    @FindBy(className = "btn btn-orange pull-right")
    WebElement continueButton;

    public OrderDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitlePage() {
        return pageTitle.getText();
    }

    public void insertOrderDetailsValues(String orderIdValue, String eMailValue) {
        orderIdTextBox.sendKeys(orderIdValue);
        eMailTextBox.sendKeys(eMailValue);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

}
