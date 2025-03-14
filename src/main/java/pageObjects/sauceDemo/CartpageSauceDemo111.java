package pageObjects.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageBase;

public class CartpageSauceDemo111 extends PageBase {

    @FindBy(className = "title")
    WebElement pageTitle;

    @FindBy(className = "inventory_item_name")
    WebElement productName;


    public CartpageSauceDemo111(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getTheProductName() {
        return productName.getText();
    }

    public boolean checkIfProductNameIsCorrect(String value) {
        boolean isValuePresent = false;
        if (productName.getText().contains(value))
            isValuePresent = true;
        return isValuePresent;


    }
}
