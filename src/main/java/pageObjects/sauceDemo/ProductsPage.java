package pageObjects.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageBase;

public class ProductsPage extends PageBase {

     @FindBy(className = "title")
    WebElement pageTitle;

     @FindBy(id="add-to-cart-sauce-labs-backpack")
     WebElement addToCartButton;

     @FindBy(className = "shopping_cart_link")
     WebElement cartIcon;

     public ProductsPage(WebDriver driver){
         this.driver = driver;
         PageFactory.initElements(driver, this);
     }

    public String getTitlePage(){
        return pageTitle.getText();
     }

     public void clickOnAddToCartButton(){
         addToCartButton.click();
     }

     public void clickOnCart(){
         cartIcon.click();
     }
}
