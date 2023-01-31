package nopcommerce.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPageNop extends CommonAPI {
    public LogInPageNop(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    Logger log = LogManager.getLogger(LogInPageNop.class.getName());
    @FindBy (css = "#Email")
    WebElement txtEmail;
    @FindBy (css = ".password")
    WebElement txtPassword;
    @FindBy (xpath = "//Button[text()='Log in']")
    WebElement btnLogIn;
    @FindBy (css = "#RememberMe")
    WebElement cbRememberMe;
    @FindBy (xpath = "//a[text()='Forgot password?']")
    WebElement lnkForgotPassword;
    @FindBy (xpath = "//div[contains(text(),'unsuccessful')]")
    WebElement msgLogInError;



    public void logIn (String email, String password){
        type(txtEmail,email);
        type(txtPassword,password);
        clickOn(btnLogIn);
        log.info("Email and Password set, successfully clicked on log in");
    }
    public String getMessageLogInError (){
        return getTextFromElement(msgLogInError);
    }



}
