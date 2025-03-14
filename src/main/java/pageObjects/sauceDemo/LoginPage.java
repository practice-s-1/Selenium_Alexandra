package pageObjects.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageBase;

public class LoginPage extends PageBase {

    @FindBy(id = "user-name")
    WebElement usernameTextBox;

    @FindBy(id = "password")
    WebElement passwordTextBox;


    @FindBy(id = "login-button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addCredentials(String usernameValue, String passwordValue) {
        usernameTextBox.sendKeys(usernameValue);
        passwordTextBox.sendKeys(passwordValue);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

}
