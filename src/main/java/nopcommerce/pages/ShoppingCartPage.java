package nopcommerce.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends CommonAPI {
    public ShoppingCartPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());
    @FindBy(css = ".product-name")
    WebElement productName;
    @FindBy (xpath = "//div[@class='terms-of-service']/input")
    WebElement checkboxAgreeToTermsOfService;
    @FindBy(css = ".button-1.checkout-button")
    WebElement btnCheckout;
    @FindBy(css = ".remove-btn")
    WebElement btnRemoveProduct;
    @FindBy(css = ".no-data")
    WebElement msgShoppingCartEmpty;
    @FindBy(css = "div#terms-of-service-warning-box")
    WebElement msgTermsOfServiceBox;


    public String getCartProductName(){
        return getTextFromElement(productName);
    }
    public void checkAgreeToTermsOfService(){
        clickOn(checkboxAgreeToTermsOfService);
        log.info("Checked agree to terms of service Successfully");
    }
    public void clickOnCheckout(){
        clickOn(btnCheckout);
        log.info("Clicked on checkout Successfully");
    }
    public void clickOnRemoveProduct(){
        clickOn(btnRemoveProduct);
        log.info("Clicked on remove product Successfully");
    }
    public String getTextEmptyShoppingCart(){
        return getTextFromElement(msgShoppingCartEmpty);
    }
    public String getTextTermsOfServiceBox(){
        return getTextFromElement(msgTermsOfServiceBox);
    }

}
