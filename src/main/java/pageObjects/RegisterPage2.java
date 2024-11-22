package pageObjects.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.PageBase;

public class RegisterPage2 extends PageBase {

    @FindBy(id = "AccountFrm_firstname")
    WebElement firstName;

    @FindBy(id = "AccountFrm_lastname")
    WebElement lastName;

    @FindBy(id = "AccountFrm_lastname")
    WebElement eMail;

    @FindBy(id = "AccountFrm_address_1")
    WebElement address;

    @FindBy(id = "AccountFrm_city")
    WebElement city;

    @FindBy(id = "AccountFrm_zone_id")
    WebElement regionDd;

    @FindBy(id = "AccountFrm_postcode")
    WebElement zipCode;

    @FindBy(id = "AccountFrm_country_id")
    WebElement countryDd;

    @FindBy(id = "AccountFrm_loginname")
    WebElement loginName;

    @FindBy(id = "AccountFrm_password")
    WebElement password;

    @FindBy(id = "AccountFrm_confirm")
    WebElement passwordConfirm;

    @FindBy(id = "AccountFrm_newsletter1")
    WebElement radioButton;

    @FindBy(id = "AccountFrm_agree")
    WebElement privacyPolicy;

    @FindBy(className = "btn btn-orange pull-right lock-on-click")
    WebElement continueButton;

    @FindBy(className = "maintext")
    WebElement registrationMessage;


    public RegisterPage2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void insertRegisterAccountValues(String firstNameValue, String lastNameValue, String eMailValue, String addressValue, String cityValue,
                                            String zipCodeValue, String loginNameValue, String passwordValue, String passwordConfirmValue) {
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        eMail.sendKeys(eMailValue);
        address.sendKeys(addressValue);
        city.sendKeys(cityValue);
        zipCode.sendKeys(zipCodeValue);
        loginName.sendKeys(loginNameValue);
        password.sendKeys(passwordValue);
        passwordConfirm.sendKeys(passwordConfirmValue);
    }

    public void selectOptionRegionDropDown(String regionValue) {
        Select dropDown = new Select(regionDd);
        dropDown.selectByVisibleText(regionValue);

    }

    public void selectOptionCountryDropDown(String countryValue) {
        Select dropDown = new Select(countryDd);
        dropDown.selectByVisibleText(countryValue);
    }

    public void clickOnYesRadioButton() {
        radioButton.click();
    }

    public void clickOnPrivacyPolicyButton() {
        privacyPolicy.click();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public String verifySuccessfulRegistrationMessage(){
        return registrationMessage.getText();
    }


}
