package pageObjects.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageBase;

public class RealHomePage extends PageBase {


    @FindBy(linkText = "  Skincare")
    WebElement skinCareCategoryTab;

    @FindBy(linkText = "https://automationteststore.com/index.php?rt=product/category&path=43_46")
    WebElement faceSubcategory;

    @FindBy(linkText = "//automationteststore.com/image/thumbnails/18/6d/demo_product41_jpg-100058-250x250.jpg")
    WebElement bodyCreamProduct;

    @FindBy(className = "cart")
    WebElement addToCart;

    @FindBy(id = "cart_checkout1")
    WebElement checkout;

    // Aici sunt elementele care apar dupa ce am trimis comanda pentru a incepe verificarea statusului comenzii, esteok sa le pun in continuarea acestora?
    @FindBy(xpath = "//span[contains(text(), 'Account')]")
    WebElement accountTab;

    @FindBy(xpath = "//span[contains(text(), 'Check Your Order')][1]")
    WebElement checkYourOrderButton;

    public RealHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void hoverOverSkinCareTab() {
        Actions actions = new Actions(driver);
        actions.moveToElement(skinCareCategoryTab).perform();
    }

    public void selectFaceSubcategory() {
        faceSubcategory.click();
    }

    public void selectProductToAddInCart() {
        bodyCreamProduct.click();
    }

    public void addProductToCart(){
        addToCart.click();
    }

    public void clickOnCheckout(){
        checkout.click();
    }
}
