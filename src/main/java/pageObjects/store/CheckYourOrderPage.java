package pageObjects.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageBase;

public class CheckYourOrderPage extends PageBase {

    @FindBy(className = "maintext")
    WebElement titlePage;

    @FindBy(id = "CheckOrderFrm_order_id")
    WebElement orderId;

    @FindBy(id = "CheckOrderFrm_email")
    WebElement eMail;

    @FindBy(xpath = "//*[@title='Continue']")
    WebElement continueButton;

    @FindBy(className = "contentpanel")
    WebElement orderStatusMessage;



    public CheckYourOrderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitlePage(){
        return titlePage.getText();
    }

    public void insertOrderInfo(String orderIdValue, String eMailValue){
        orderId.sendKeys(orderIdValue);
        eMail.sendKeys(eMailValue);
    }

    public String getOrderStatusMessage(){
        return orderStatusMessage.getText();
    }

    public void cLickContinueButton(){
        continueButton.click();
    }

}
