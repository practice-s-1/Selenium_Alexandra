package pageObjects.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class CheckoutInformationPage extends PageBase {

    @FindBy(className = "title")
    WebElement pageTitle;


    public CheckoutInformationPage(WebDriver driver){
        this.driver = driver;


        

    }

}
