package nopcommerce.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordRecoveryPage extends CommonAPI {
    public PasswordRecoveryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    Logger log = LogManager.getLogger(PasswordRecoveryPage.class.getName());
    @FindBy (css = ".email")
    WebElement txtEmailAddress;
    @FindBy (css = "button[name='send-email']")
    WebElement buttonRecover;
    @FindBy (css = ".content")
    WebElement notificationMessage;
    @FindBy (css = ".close")
    WebElement buttonCloseNotification;

    public void recoverPassword (String email){
        type(txtEmailAddress,email);
        log.info("Email entered success");
        clickOn(buttonRecover);
        log.info("Recover button clicked success");

    }
    public String getNotificationMessage(){
        return getTextFromElement(notificationMessage);
    }
    public void closeNotification (){
        clickOn(buttonCloseNotification);
    }
}
