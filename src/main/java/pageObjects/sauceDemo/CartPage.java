package pageObjects.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageBase;

public class CartPage extends PageBase {

    @FindBy(className = "title")
    WebElement cartTitlePage;

    @FindBy(className = "inventory_item_name")
    WebElement productName;

    @FindBy(xpath = "//*[@class='inventory_item_price']")
    WebElement productPrice;

    @FindBy(id = "checkout")
    WebElement checkoutButton;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCartPageTitle() {
        return cartTitlePage.getText();
    }

    public String getProductName() {
        return productName.getText();
    }

    public boolean checkIfProductNameIsCorrect(String value) {
        boolean isValuePresent = false;
        if (productName.getText().contains(value))
            isValuePresent = true;
        return isValuePresent;
    }
/* sau

    // public boolean checkIfProductNameIsCorrect(String value) {
    return productName.getText().contains(value);
    } */

    public String getProductPrice() {                    //String???
        return productPrice.getText();
    }

    public void clickOnCheckoutButton() {
        checkoutButton.click();
    }
}