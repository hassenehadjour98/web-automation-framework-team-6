package orangehrm.project.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class MyInfo extends CommonAPI {
    Logger LOG = LogManager.getLogger(MyInfo.class.getName());
    public MyInfo(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // Login
    //click on My Info
    @FindBy(xpath = "//span[text()='My Info']")
    WebElement MyInfo;
    // scroll down to element Blood Type
    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[3]")
    WebElement BloodType;
    @FindBy(xpath = "//span[text()='O+']")
    WebElement Opositivetype;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    WebElement SaveBtn;
    @FindBy(xpath = "//p[text()='Success']")
    WebElement ToastMsgText;

    // catch success message for confirmation
    public void clickOnMyInfo(){
        clickOn(MyInfo);
        LOG.info("My Info Clicked");
    }
    public void selectBloodType(){
        clickOn(BloodType);
        clickOn(Opositivetype);

//        clickWithJavascript(BloodType);

        LOG.info("blood type selected");
    }
    public void clickOnSave(){
        clickOn(SaveBtn);
        LOG.info("Save button clicked");
    }
    public String ToastMessage(){
        String message = getTextFromElement(ToastMsgText);
        LOG.info("Toast message captured");
        return message;
    }






}
