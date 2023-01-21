package orangehrm.project.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utility.Utility;

public class HomePage extends CommonAPI {
    public String UsernameOH = Utility.getProperties().getProperty("UsernameOH");
    Logger LOG = LogManager.getLogger(HomePage.class.getName());
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement admin;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement userNameTxt;
    @FindBy(xpath = "(//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"]//div[text()='-- Select --'])[1]")
    WebElement userRoleDropDown;
    @FindBy(xpath = "//div[contains(text(),'-- Select --')]")//
    WebElement statusDropDown;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement SearchBtn;
    @FindBy(xpath = "(//button[@type='button'])/i[contains(@class, 'oxd-icon bi-pencil-fill')]")
    WebElement editBtn;
    @FindBy(css = ".oxd-icon.bi-check.oxd-checkbox-input-icon")
    WebElement passwordCheckBox;

    public void clickOnAdmin(){
        clickOn(admin);
        LOG.info("click Admin success");
    } // click on Admin
    public void typeUserName(){
        type(userNameTxt, UsernameOH);
        LOG.info("text inserted to username");
    } // enter username
    public void userRoleDropDown(){
        clickOn(userRoleDropDown);
        userRoleDropDown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        LOG.info("Admin selected from dropdown");
    } // select Admin drop down
    public void statusDropDown(){
        clickOn(statusDropDown);
        statusDropDown.sendKeys(Keys.ARROW_DOWN, Keys.ESCAPE);
        LOG.info("Enable selected from dropdown");

    } // select enable from second drop down
    public void clickSearch(){
        clickOn(SearchBtn);
        LOG.info("search button clicked");
    } // click search
    public void clickOnEdit(){
        clickOn(editBtn);
        LOG.info("edit button clicked");
    } // click edit button
    public boolean clickOnCheckBox(){
        clickOn(passwordCheckBox);
        boolean flag = passwordCheckBox.isEnabled();
        LOG.info("checkbox clicked, and it is displayed");
        return flag;
    } // check if change Password check box is available


}


