package saucedemopages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepTwoPage extends CommonAPI {

    @FindBy (xpath = "//button[@id='finish']")
    public WebElement finishButton;

    @FindBy (xpath = "//button[@id='cancel']")
    public  WebElement cancelButton;

    public CheckOutStepTwoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void finishButton(){
        clickOn(finishButton);
    }
    public void cancelButton(){
        clickOn(cancelButton);
    }
}


