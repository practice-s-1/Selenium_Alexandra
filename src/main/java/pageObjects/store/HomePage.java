package pageObjects.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageBase;

public class HomePage extends PageBase {

    @FindBy(xpath = "//span[contains(text(), 'Account')][1]")
    WebElement accountTab;

    @FindBy(xpath = "//span[contains(text(), 'Check Your Order')][1]")
    WebElement checkYourOrderOption;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverOverAccountTab(){
        Actions actions = new Actions(driver);
        actions.moveToElement(accountTab).perform();
    }

    public void openCheckYourOrderStatusSection(){
        checkYourOrderOption.click();
    }







}
