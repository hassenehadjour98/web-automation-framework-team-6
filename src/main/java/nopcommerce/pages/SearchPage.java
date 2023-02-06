package nopcommerce.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends CommonAPI {
    public SearchPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    Logger log = LogManager.getLogger(SearchPage.class.getName());

    @FindBy(xpath = "//h2[@class='product-title']/a")
    WebElement itemName;
    @FindBy(css = ".price.actual-price")
    WebElement itemPrice;
    @FindBy(css = ".button-2.add-to-wishlist-button")
    WebElement btnAddToWishlist;
    @FindBy(css = ".button-2.product-box-add-to-cart-button")
    WebElement btnAddToCart;
    @FindBy(css = ".no-result")
    WebElement SearchMessageNoResult;

    public String getItemName(){
        log.info("get item name success");
        return itemName.getText();
    }
    public void clickOnItemName (){
        clickOn(itemName);
        log.info("clicked on item successfully");
    }
    public String getItemPrice(){
        log.info("get item price success");
        return itemPrice.getText();
    }
    public void addToWishlist() {
        clickOn(btnAddToWishlist);
        log.info("added item to wishlist successfully");
    }
        public void addToCart(){
            clickOn(btnAddToCart);
            log.info("added item to cart successfully");
    }
    public String getTextNoResultSearch(){
        return getTextFromElement(SearchMessageNoResult);
    }
}
