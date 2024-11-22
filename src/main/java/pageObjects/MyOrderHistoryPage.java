package pageObjects.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.PageBase;

public class MyOrderHistoryPage extends PageBase {

    @FindBy(className = "maintext")
    WebElement orderHistoryPageTitle;

   @FindBy (xpath = "//div[b/text()='Status:']")
   WebElement orderStatus;

    public MyOrderHistoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getOrderHistoryPageTitle(){
        return orderHistoryPageTitle.getText();
    }

    public String getOrderStatus(){
        return orderStatus.getText();
    }

}
