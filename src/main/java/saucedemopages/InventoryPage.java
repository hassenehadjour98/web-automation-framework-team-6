package saucedemopages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends CommonAPI {

    @FindBy(xpath = "//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[2]/div[2]/span[1]/select[1]")
    private WebElement sortDropDown;

    @FindBy(xpath = "//a[contains(text(),'Twitter')]")
    private WebElement twitter;

    @FindBy(xpath = "//a[contains(text(),'Facebook')]")
    private WebElement facebook;

    @FindBy(xpath = "//a[contains(text(),'LinkedIn')]")
    private WebElement linkedIn;

    @FindBy(css = "#react-burger-menu-btn")
    private WebElement menuBar;

    @FindBy(xpath = "//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]")
    private WebElement cart;

    @FindBy(css = "#inventory_sidebar_link")
    private WebElement allItems;

    @FindBy(css = "#about_sidebar_link")
    private WebElement about;

    @FindBy(css = "#logout_sidebar_link")
    private WebElement logOut;

    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    private WebElement backPack;

    @FindBy(css = "#add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLight;

    @FindBy(css = "#add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement boltTshirt;

    @FindBy(css = "#add-to-cart-sauce-labs-fleece-jacket")
    private WebElement fleeceJacket;

    @FindBy(css = "#add-to-cart-sauce-labs-onesie")
    private WebElement onesie;

    @FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
    private WebElement redTshirt;

    @FindBy(css = "#reset_sidebar_link")
    private WebElement resetAppState;

    @FindBy(css = "#remove-sauce-labs-backpack")
    private WebElement removeBackPack;

    @FindBy(css = "#remove-sauce-labs-bolt-t-shirt")
    private WebElement removeBoltShirt;

    @FindBy(css = "#remove-sauce-labs-fleece-jacket")
    private WebElement removeFleeceJacket;

    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    private WebElement removeRedTshirt;

    @FindBy(css = "#remove-sauce-labs-bike-light")
    private WebElement removeBikeLight;

    @FindBy(css = "div.page_wrapper div.header_container:nth-child(1) div.header_secondary_container div.right_component span.select_container > select.product_sort_container")
    private List<WebElement> sortDropDownOptions;
    public InventoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addBackPack() {
        clickOn(backPack);
    }

    public void addBikeLight() {
        clickOn(bikeLight);
    }

    public void addBoltTshirt() {
        clickOn(boltTshirt);
    }

    public void addFleeceJacket() {
        clickOn(fleeceJacket);
    }

    public void addOnesie() {
        clickOn(onesie);
    }

    public void addRedTshirt(){
        clickOn(redTshirt);
    }



    public void selectSortDropDown(String text) {
        selectOptionFromDropdown(sortDropDown, text);
    }

//    public List<String> getSortDropDownOptions() {
//        List<String> options = new ArrayList<>();
//        List<WebElement> elements = getSortDropDownOptions(sortDropDown);
//        for (WebElement element : elements) {
//            options.add(element.getText());
//        }
//        return options;
//    }

    public void selectOptionFromDropDownWithDropDownOption(String option){
        List<WebElement> ele = sortDropDownOptions;
        for (WebElement element : ele) {
            if (element.getText().equalsIgnoreCase(option)){
                element.click();
            }
        }
    }
    public void menuBarButton(){
        clickOn(menuBar);
    }
    public void allItemsSideBar(){
        clickOn(allItems);
    }
    public void aboutSideBar(){
        clickOn(about);
    }
    public void logOutSideBar(){
        clickOn(logOut);
    }
    public void goToCart(){
        clickOn(cart);
    }

    public void resetCart(){
        clickOn(resetAppState);
    }

    public void clickTwitterIcon(){
        clickOn(twitter);
    }

    public void clickFacebookIcon(){
        clickOn(facebook);
    }

    public void clickLinkedInIcon(){
        clickOn(linkedIn);
    }

    public String removeBackPack(){
        return getTextFromElement(removeBackPack);
    }

    public String removeBoltShirt(){
        return getTextFromElement(removeBoltShirt);
    }

    public String removeRedShirt(){
        return getTextFromElement(removeRedTshirt);
    }

    public String removeFleeceJacket(){
        return getTextFromElement(removeFleeceJacket);
    }

    public String removeBikeLight(){
        return getTextFromElement(removeBikeLight);
    }


}