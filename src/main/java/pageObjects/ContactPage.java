package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageBase;

public class ContactPage extends PageBase {

    @FindBy(xpath = "//*[@name='your-name']")
    WebElement textBoxName;

    @FindBy(xpath = "//*[@name='your-email']")
    WebElement textBoxEmail;

    @FindBy(xpath = "//*[@name='tel-437']")
    WebElement textBoxPhone;

    @FindBy(xpath = "//*[@name='your-subject']")
    WebElement textBoxSubject;

    @FindBy(xpath = "//*[@name='your-message']")
    WebElement textBoxMessage;

    @FindBy(xpath = "//*[@value='Online media']")
    WebElement onlineMediaCheckBox;

    @FindBy(xpath = "//*[@value='IT']")
    WebElement itRadioButton;

    @FindBy(xpath = "//*[@value='Send']")
    WebElement sendButton;

    @FindBy(xpath = "//*[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
    WebElement errorMessage;


    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterYourName(String nameValue) {
        textBoxName.sendKeys(nameValue);
    }

    public void enterYourEmail(String emailValue) {
        textBoxEmail.sendKeys(emailValue);
    }

    public void enterYourPhone(String phoneValue) {
        textBoxPhone.sendKeys(phoneValue);
    }

    public void enterSubject(String subjectValue) {
        textBoxSubject.sendKeys(subjectValue);
    }

    public void enterYourMessage(String messageValue) {
        textBoxMessage.sendKeys(messageValue);
    }

    public void clickOnWhereDidYouFindUs() {
        onlineMediaCheckBox.click();
    }

    public void clickOnYourProfessionArea() {
        itRadioButton.click();
    }

    public void clickSendButton() {
        sendButton.click();
    }

    public String displayErrorMessage(){
        return errorMessage.getText();
    }


}
