package saucedemopages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepOnePage extends CommonAPI {


    @FindBy (id = "first-name")
    private WebElement firstname;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy (id = "postal-code")
    private WebElement postalCode;

    @FindBy (id = "continue")
    WebElement continueButton;


    public CheckOutStepOnePage(WebDriver driver){
        PageFactory.initElements(driver, this);


    }

   public void enterContactInfo(String enterFirstName, String enterLastName, String enterPostalCode){
        type(firstname, enterFirstName);
        type(lastName, enterLastName);
        type(postalCode, enterPostalCode);

   }

   public void clickContinueButton(){
        clickOn(continueButton);
   }

}

