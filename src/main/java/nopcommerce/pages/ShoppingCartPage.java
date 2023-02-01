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
    WebElement cbAgreeToTermsOfService;
    @FindBy(css = ".button-1.checkout-button")
    WebElement btnCheckout;

    public String getCartProductName(){
        return getTextFromElement(productName);
    }
    public void checkAgreeToTermsOfService(){
        clickOn(cbAgreeToTermsOfService);
    }
    public void clickOnCheckout(){
        clickOn(btnCheckout);
    }

}
