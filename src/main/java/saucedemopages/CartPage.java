package saucedemopages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonAPI {

    @FindBy (xpath = "//button[@id='checkout']")
     WebElement  checkoutButton;

    @FindBy (xpath = "//button[@id='continue-shopping']")
    WebElement continueShoppingButton;


    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
     public void checkOutButton(){
         clickOn(checkoutButton);
        }
 }
