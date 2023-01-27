package nopcommerce.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonAPI {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(css = ".ico-register")
    WebElement lnkRegister;
    @FindBy(css = ".ico-login")
    WebElement lnkLogin;
    @FindBy(css = ".wishlist-label")
    WebElement lnkWishlist;
    @FindBy(css = "span.wishlist-qty")
    WebElement wishlistQuantity;
    @FindBy(css = ".cart-label")
    WebElement lnkShoppingCart;
    @FindBy(css = "span.cart-qty")
    WebElement shoppingCartQuantity;
    @FindBy(css = "input#small-searchterms")
    WebElement txtSearchItem;
    @FindBy(css = "button[type='submit']")
    WebElement btnSearch;
    @FindBy(xpath = "//div[@class='header-logo']/a/img")
    WebElement logoNopCommerce;
    @FindBy(css = "#customerCurrency")
    WebElement dropDownCurrency;

    @FindBy(xpath = "//option[contains(text(),'US Dollar')]")
    WebElement drpUsDollarOpt;
    @FindBy(xpath = "//option[contains(text(),'Euro')]")
    WebElement drpEuroOpt;
    @FindBy(css = ".ico-logout")
    WebElement lnkLogout;

    public void clkOnLnkRegister() {
        clickOn(lnkRegister);
        log.info("click on register link success");
    }

    public void clkOnLnkLogin() {
        clickOn(lnkLogin);
        log.info("click on log in link success");
    }

    public void clkOnLnkWishlist() {
        clickOn(lnkWishlist);
        log.info("click on whishlist link success");
    }

    public String getWishlistQuantity() {
        log.info("Whishlist quantity success");
        return getTextFromElement(wishlistQuantity);
    }

    public void clkOnShoppingCart() {
        clickOn(lnkShoppingCart);
        log.info("click on shopping cart success");
    }

    public String getShoppingCartQuantity() {
        log.info("Shopping cart quantity success");
        return getTextFromElement(shoppingCartQuantity);
    }

    public void searchItem(String item) {
        type(txtSearchItem, item);
        log.info("Item type success");
    }

    public void clkSearchBtn() {
        clickOn(btnSearch);
        log.info("click on search success");
    }

    public Boolean logoNopCommerceIsDisplayed() {
        log.info("logo verified");
        return elementIsDisplayed(logoNopCommerce);

    }

    public void clkLogoNopCommerce() {
        clickOn(logoNopCommerce);
        log.info("click on nopcommerce logo success");
    }

    public void selectCurrency(String option) {
        selectOptionFromDropdown(dropDownCurrency, option);
        log.info("select currency success");
    }
    public void clickOnLnkLogout(){
        clickOn(lnkLogout);
        log.info("click on logout success");
    }
    public boolean usDollarIsSelected (){
        return elementIsSelected(drpUsDollarOpt);
    }
    public boolean euroIsSelected (){
        return elementIsSelected(drpEuroOpt);
    }






}
