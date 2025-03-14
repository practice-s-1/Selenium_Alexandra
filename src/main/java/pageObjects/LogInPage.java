package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageBase;

public class LogInPage extends PageBase {
    // Page Factory

    @FindBy(xpath = "//*[@id='user_login']")
    WebElement textBoxUserName;

    @FindBy(xpath = "//*[@id='user_pass']")
    WebElement textBoxPassword;

    @FindBy(id = "wppb-submit")
    WebElement logInButton;

    @FindBy(xpath = "//*[@class='wppb-error']")
    WebElement errorMessage;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void addCredentials(String usernameValue, String passwordValue) {
        textBoxUserName.sendKeys(usernameValue);
        textBoxPassword.sendKeys(passwordValue);
    }

    public void clickLoginButton() {
        logInButton.click();
    }

    public String displayErrorMessage() {
        return errorMessage.getText();
    }


}
