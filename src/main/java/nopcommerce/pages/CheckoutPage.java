package nopcommerce.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends CommonAPI {
    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    Logger log = LogManager.getLogger(CheckoutPage.class.getName());
    @FindBy (css = "#BillingNewAddress_CountryId")
    WebElement dropDownCountry;
    @FindBy (css = "#BillingNewAddress_City")
    WebElement txtCityField;
    @FindBy (css = "#BillingNewAddress_Address1")
    WebElement txtAddress1Field;
    @FindBy (css = "#BillingNewAddress_ZipPostalCode")
    WebElement txtZipCode;
    @FindBy (css = "#BillingNewAddress_PhoneNumber")
    WebElement txtPhoneNumber;
    @FindBy (xpath = "//div[@id='billing-buttons-container']/button[@class='button-1 new-address-next-step-button']")
    WebElement buttonContinueInBillingAddress;
    @FindBy (xpath = "//div[@id='shipping-method-buttons-container']/button")
    WebElement buttonContinueInShippingMethod;
    @FindBy (xpath = "//div[@id='payment-method-buttons-container']/button")
    WebElement buttonContinueInPaymentMethod;
    @FindBy (xpath = "//div[@id='payment-info-buttons-container']/button")
    WebElement buttonContinueInPaymentInformation;
    @FindBy (xpath = "//div[@id='confirm-order-buttons-container']/button")
    WebElement buttonConfirmOrder;
    @FindBy (xpath = "//div[@class='section order-completed']/div[@class='title']")
    WebElement msgConfirmation;
    public void SelectCountry (String country){
        selectOptionFromDropdown(dropDownCountry,country);
    }
    public void setCityName(String city){
        type(txtCityField,city);
    }
    public void setAddress1(String address1){
        type(txtAddress1Field,address1);
    }
    public void setZipCode(String zipCode){
        type(txtZipCode,zipCode);
    }
    public void setPhoneNumber(String phoneNumber){
        type(txtPhoneNumber,phoneNumber);
    }
    public void clickContinueButtonInBillingAddress(){
        clickOn(buttonContinueInBillingAddress);
    }
    public void clickContinueShippingMethod(){
        clickOn(buttonContinueInShippingMethod);
    }
    public void clickContinueInPaymentMethod(){
        clickOn(buttonContinueInPaymentMethod);
    }
    public void clickContinueInPaymentInformation(){
        clickOn(buttonContinueInPaymentInformation);
    }
    public void clickConfirm(){
        clickOn(buttonConfirmOrder);
    }
    public String getConfirmationSuccess(){
        return getTextFromElement(msgConfirmation);
    }


}
