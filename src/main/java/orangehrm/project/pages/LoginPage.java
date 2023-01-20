package orangehrm.project.pages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonAPI {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name=\"username\"]")
    WebElement UserNameField;
    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement passwordField;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement loginButton;
    public void logIn (String userName, String password){
        UserNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
