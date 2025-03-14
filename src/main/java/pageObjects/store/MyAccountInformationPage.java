package pageObjects.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageBase;

public class MyAccountInformationPage extends PageBase {

    @FindBy(id = "AccountFrm_telephone")
    WebElement phoneTextBox;

    @FindBy(xpath = "//button[@title='Continue']")
    WebElement continueButton;

    public MyAccountInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillPhoneCell(String phoneValue) {
        if (phoneTextBox.getText().isEmpty())
            phoneTextBox.sendKeys(phoneValue);
    }
    public void clickOnContinueButoon(){
        continueButton.click();
    }

}
