package pageObjects;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends PageBase {

    @FindBy(xpath = "//*[@id='username']")
    WebElement textBoxUsername;

    @FindBy(xpath = "//*[@id='email']")
    WebElement textBoxEmail;

    @FindBy(xpath = "//*[@id='passw1']")
    WebElement textBoxPassword;

    @FindBy(xpath = "//*[@id='passw2']")
    WebElement textBoxRepeatPassword;

    @FindBy(xpath = "//*[@id='register']")
    WebElement registerButton;

    @FindBy(id = "wppb_form_success_message")
    WebElement successMessage;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterRequiredFields(String usernameValue, String emailValue, String password, String repeatPassword) {
        textBoxUsername.sendKeys(usernameValue);
        textBoxEmail.sendKeys(emailValue);
        textBoxPassword.sendKeys(password);
        textBoxRepeatPassword.sendKeys(repeatPassword);
    }

  /*
   public void enterUsername(String usernameValue) {
        textBoxUsername.sendKeys(usernameValue);
    }

    public void enterEmail(String emailValue) {
        textBoxEmail.sendKeys(emailValue);
    }

    public void enterPassword(String password) {
        textBoxPassword.sendKeys(password);
    }

    public void repeatPassword(String repeatPassword) {
        textBoxRepeatPassword.sendKeys(repeatPassword);
    }

   */

    public void clickRegisterButton() {
        registerButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public String getUserName() {
        return textBoxUsername.getText();
    }

}
