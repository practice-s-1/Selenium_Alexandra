package pageObjects.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.PageBase;

public class CheckoutConfirmationPage extends PageBase {

    @FindBy(className = "//*[@class='maintext']")
    WebElement pageTitle;

    @FindBy(id="checkout_btn")
    WebElement confirmOrderButton;


    public CheckoutConfirmationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String checkTitleCheckoutConfirmationPage(){
       return pageTitle.getText();
    }

    public void clickOnConfirmOrderButton(){
        confirmOrderButton.click();
    }

}
