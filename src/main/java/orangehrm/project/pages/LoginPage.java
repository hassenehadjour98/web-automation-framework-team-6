package orangehrm.project.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonAPI {
    public Logger log = LogManager.getLogger(this.getClass());
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name=\"username\"]")
    WebElement usernamefield;
    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement passwordfield;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement loginbutton;
    @FindBy(xpath = "//p[text()='Forgot your password? ']")
    WebElement forgotassord;
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement resetpasswordusernameFeild;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement ResetPasswordBtn;
    @FindBy(xpath = "//h6[text()='Reset Password link sent successfully']")
    WebElement messagedisplay;
    @FindBy(css = ".oxd-text.oxd-text--h5.orangehrm-login-title")
    WebElement loginWord;


}
