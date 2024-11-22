package pageObjects.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.PageBase;

public class SearchComponent extends PageBase {

    @FindBy(id="filter_keyword")
    WebElement searchTextBox;

    @FindBy(className = "fa fa-search")
    WebElement searchButton;

    @FindBy(xpath = "//*[contains(text(), 'Instant Extensions Lengthening Mascara')]")
    WebElement productName;


    public SearchComponent(WebDriver driver){
        this.driver=driver;
        //PageFactory.initElements(driver, this);
    }

    public void openPage(){
        driver.get("https://automationteststore.com/index.php?rt=account/create");
    }

    public void searchText(String text){
        searchTextBox.sendKeys(text);
        searchButton.click();
    }

    public boolean isProductReturned(){

        boolean isProductReturned = false;

        if(productName.getText().contains("mascara")){
            isProductReturned = true;
        }

       return isProductReturned;

    }

}
