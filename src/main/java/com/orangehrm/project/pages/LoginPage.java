package com.orangehrm.project.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Utility;

import java.util.List;

public class LoginPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(LoginPage.class.getName());
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    protected String ValidUsernameOH = Utility.getProperties().getProperty("UsernameOH").trim();
    protected String ValidPasswordOH = Utility.getProperties().getProperty("PasswordOH").trim();

    @FindBy(xpath = "//input[@name=\"username\"]")
    WebElement UserNametxt;
    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement passwordtxt;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement loginButton;
    @FindBy(xpath = "//h6[text() = 'Dashboard']")
    WebElement UserNameDisplayed;
    @FindBy(xpath = "//p[text()='Forgot your password? ']")
    WebElement forgotassord;
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement resetpasswordusernametxt;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement ResetPasswordBtn;
    @FindBy(xpath = "//h6[text()='Reset Password link sent successfully']")
    WebElement messagedisplay;
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    WebElement errorMessage;
    @FindBy(tagName = "a")
    List<WebElement> pageLinks;

// Reusable methods
    public void setUsername(String Username){
        type(UserNametxt,Username);
        LOG.info("Username set");
    }
    public void setPassword(String Password){
        type(passwordtxt, Password);
        LOG.info("Password set");
    }
    public void clkOnLogin(){
        clickOn(loginButton);
        LOG.info("Login button clicked");
    }
    public void LoginAsAdmin(String username, String password){
        setUsername(username);
        setPassword(password);
        clkOnLogin();
        LOG.info("Login Successful");
    }
    public void clkForgotPassword(){
        clickOn(forgotassord);
        LOG.info("ForgotPassword link clicked");
    }
    public boolean DashboardTextDisplayed(){
        boolean flag = UserNameDisplayed.isDisplayed();
        LOG.info("User Name is Displayed");
        return flag;
    }
    public String ResetPassword(){
        clkForgotPassword();
        type(resetpasswordusernametxt, ValidUsernameOH);
        clickOn(ResetPasswordBtn);
        LOG.info("Reset Password link sent successfully");
        String message = messagedisplay.getText();
        return message;
    }
    public String getErrorMessage(){
        String errorMsg = getTextFromElement(errorMessage);
        LOG.info("Error message captured");
        return errorMsg;
    }
    public void clkOnSocialMediaLink(String Platform){
        List<WebElement> list = pageLinks;
        for (WebElement element : pageLinks){
            String links = getAttributeValue(element, "href");
            if(links.toLowerCase().contains(Platform.toLowerCase())){
                element.click();
                LOG.info("Social media "+Platform+" icon clicked successfully");
                break;
//            }else{
//                System.out.println("Link does not exist on OrangeHRM LoginPage");
            }
        }
    }
    public boolean isTitleContains(String Title, String ExpectedTitle){
        boolean flag= Title.contains(ExpectedTitle);
        return flag;
    }

//  Links classes
    public static class LinkedinPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(LinkedinPage.class.getName());

        public LinkedinPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }
        public String switchToLinkedinWindow(WebDriver driver, String Title){
            switchToChildWindow(driver, Title);
            LOG.info("Focus successfully switched to "+Title);
            String pageTitle= driver.getTitle();
            LOG.info(Title + " title successfully captured");
            return pageTitle;
        }

    }
    public static class FacebookPage extends CommonAPI {
        Logger LOG = LogManager.getLogger(FacebookPage.class.getName());

        public FacebookPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }
        public String switchToFacebookWindow(WebDriver driver, String Title){
            switchToChildWindow(driver, Title);
            LOG.info("Focus successfully switched to "+Title);
            String pageTitle= driver.getTitle();
            LOG.info(Title + " title successfully captured");
            return pageTitle;
        }

    }
    public static class YouTubePage extends CommonAPI {
        Logger LOG = LogManager.getLogger(YouTubePage.class.getName());

        public YouTubePage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        public String switchToYouTubeWindow(WebDriver driver, String Title) {
            switchToChildWindow(driver, Title);
            LOG.info("Focus successfully switched to "+Title);
            String pageTitle= driver.getTitle();
            LOG.info(Title + " title successfully captured");
            return pageTitle;
        }
    }
    public static class TweeterPage extends CommonAPI {
        Logger LOG = LogManager.getLogger(TweeterPage.class.getName());
        public TweeterPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }
        public String switchToTweeterWindow(WebDriver driver, String Title){
            switchToChildWindow(driver, Title);
            LOG.info("Focus successfully switched to "+Title);
            String pageTitle= driver.getTitle();
            LOG.info(Title + " title successfully captured");
            return pageTitle;
        }

    }
    public static class OrangeHrmInc extends CommonAPI {
        Logger LOG = LogManager.getLogger(LinkedinPage.class.getName());

        public OrangeHrmInc(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }
        public String switchToOrangeHrmIncWindow(WebDriver driver, String Title){
            switchToChildWindow(driver, Title);
            LOG.info("Focus successfully switched to "+Title);
            String pageTitle= driver.getTitle();
            LOG.info(Title + " title successfully captured");
            return pageTitle;
        }

    }




 }
