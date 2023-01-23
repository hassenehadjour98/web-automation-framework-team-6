package orangehrm.project.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Utility;

public class LoginPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(LoginPage.class.getName());
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String UsernameOH = Utility.getProperties().getProperty("UsernameOH");
    public String PasswordOH = Utility.getProperties().getProperty("PasswordOH");

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
    public void logIn(){
        type(UserNametxt, UsernameOH);
        type(passwordtxt, PasswordOH);
        clickOn(loginButton);
        LOG.info("Login Successful");
    }
    public boolean DashboardTextDisplayed() {
        boolean flag = UserNameDisplayed.isDisplayed();
        LOG.info("User Name is Displayed");
        return flag;
    }
    public String ResetPassword(){
        clickOn(forgotassord);
        type(resetpasswordusernametxt, UsernameOH);
        clickOn(ResetPasswordBtn);
        LOG.info("Reset Password link sent successfully");
        String message = messagedisplay.getText();
        return message;
    }


 }
