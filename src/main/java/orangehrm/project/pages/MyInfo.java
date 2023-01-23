package orangehrm.project.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(xpath = "//div[text()='-- Select --']")
    WebElement BloodType;
    //select O+ from the dropdown
    // click save
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    WebElement SaveBtn;
    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    WebElement ToastMsgText;

    // catch success message for confirmation
    public void clickOnMyInfo(){
        clickOn(MyInfo);
        LOG.info("My Info Clicked");
    }
    public void selectBloodType(){
//        scrollDownToElement(BloodType);
//        clickOn(BloodType);
        BloodType.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,
                Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ENTER);
        LOG.info("blood type selected");
    }
    public void clickOnSave(){
        clickOn(SaveBtn);
        LOG.info("Save button clicked");
    }
    public String ToastMessage(){
        String message=getTextFromElement(ToastMsgText);
        LOG.info("Toast message captured");
        return message;
    }






}
