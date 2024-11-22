package pageObjects.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageBase;

public class ContactUsPage extends PageBase {
    @FindBy(id = "ContactUsFrm_first_name")
    WebElement firstNameTextbox;

    @FindBy(id = "ContactUsFrm_email")
    WebElement emailTextbox;

    @FindBy(id = "ContactUsFrm_enquiry")
    WebElement subjectTextbox;

    @FindBy(xpath = "//button[@title='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//p[contains(text(), 'successfully sent')]")
    WebElement successMessage;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void insertValues(String firstName, String email, String subject) {
        firstNameTextbox.sendKeys(firstName);
        emailTextbox.sendKeys(email);
        subjectTextbox.sendKeys(subject);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
