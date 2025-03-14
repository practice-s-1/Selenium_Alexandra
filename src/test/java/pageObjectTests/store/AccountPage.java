package pageObjectTests.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageBase;

public class AccountPage extends PageBase {

    @FindBy(xpath = "//span[contains(text(), 'Account')][1]")
    WebElement accountMenu;

    @FindBy(xpath = "//*[contains(text(), 'Edit account')][1]")
    WebElement editAccountIcon;

    @FindBy(className = "alert-success")
    WebElement successfulMessage;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAccountMenu(){
        accountMenu.click();
    }
    public void clickOnEditAccountIcon(){
        editAccountIcon.click();
    }
    public String getSuccessfulMessage(){
        return successfulMessage.getText();
    }



}
