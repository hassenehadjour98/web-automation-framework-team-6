package nopcommerce.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends CommonAPI {
    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    Logger log = LogManager.getLogger(RegistrationPage.class.getName());

    @FindBy(css = "#gender-male")
    WebElement btnMale;
    @FindBy(css = "#gender-female")
    WebElement btnFemale;
    @FindBy(css = "#FirstName")
    WebElement txtFirstName;
    @FindBy(css = "#LastName")
    WebElement txtLastName;
    @FindBy(css = "select[name='DateOfBirthDay']")
    WebElement dayOfBirth;
    @FindBy(css = "select[name='DateOfBirthMonth']")
    WebElement monthOfBirth;
    @FindBy(css = "select[name='DateOfBirthYear']")
    WebElement yearOfBirth;
    @FindBy(css = "#Email")
    WebElement txtEmail;
    @FindBy(css = "#Company")
    WebElement txtCompanyName;
    @FindBy(css = "input#Newsletter")
    WebElement cbNewsletter;
    @FindBy(css = "#Password")
    WebElement txtPassword;
    @FindBy(css = "#ConfirmPassword")
    WebElement txtConfirmPassword;
    @FindBy(css = "#register-button")
    WebElement btnRegister;
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']/ul/li")
    WebElement msgEmailExists;
    @FindBy(css = "div.result")
    WebElement msgRegistrationSuccess;
    @FindBy(css = "#Email")
    WebElement txtRegisteredEmail;
    @FindBy(css = "#FirstName-error")
    WebElement msgFNameReq;
    @FindBy(css = "#LastName-error")
    WebElement msgLNameReq;
    @FindBy(css = "#Email-error")
    WebElement msgEmailReq;
    @FindBy(css = "#Password-error")
    WebElement msgPasswordReq;
    @FindBy(css = "#ConfirmPassword-error")
    WebElement msgConfPasswordReq;

    public void clkOnMale() {
        clickOn(btnMale);
        log.info("clicked on male success");
    }

    public void clkOnFemale() {
        clickOn(btnFemale);
        log.info("clicked on female success");
    }

    public void setFirstName(String firstName) {
        type(txtFirstName, firstName);
        log.info("First name set successfully");
    }

    public void setLastName(String lastName) {
        type(txtLastName, lastName);
        log.info("Last name set successfully");
    }

    public void selectDayOfBirth(String day) {
        selectOptionFromDropdown(dayOfBirth, day);
        log.info("Day of Birth set successfully");
    }

    public void selectMonthOfBirth(String month) {
        selectOptionFromDropdown(monthOfBirth, month);
        log.info("Month of Birth set successfully");
    }

    public void selectYearOfBirth(String year) {
        selectOptionFromDropdown(yearOfBirth, year);
        log.info("year of Birth set successfully");
    }

    public void setEmail(String email) {
        type(txtEmail, email);
        log.info("Email set successfully");
    }

    public void setCompanyName(String name) {
        type(txtCompanyName, name);
        log.info("Company name set successfully");
    }

    public void selectNewsletter() {
        if (!cbNewsletter.isSelected()) {
            clickOn(cbNewsletter);
        }
        log.info("Newsletter checked successfully");
    }

    public void setPassword(String password) {
        type(txtPassword, password);
        log.info("Password set successfully");
    }

    public void setConfirmPassword(String password) {
        type(txtConfirmPassword, password);
        log.info("Password confirmation set successfully");
    }

    public void clkOnRegister() {
        clickOn(btnRegister);
        log.info("Click on register successful");
    }

    public String readReturnedMessage() {
        try {
            return getTextFromElement(msgRegistrationSuccess);
        } catch (Exception e) {
            return getTextFromElement(msgEmailExists);
        }
    }

    public String registeredEmail() {
        String attributeName = "value";
        return getAttributeValue(txtRegisteredEmail, attributeName);
    }

    public String getFNameReqMsg() {
        return getTextFromElement(msgFNameReq);
    }

    public String getLNameReqMsg() {
        return getTextFromElement(msgLNameReq);
    }

    public String getEmailReqMsg() {
        return getTextFromElement(msgEmailReq);
    }

    public String getPasswordReqMsg() {
        return getTextFromElement(msgPasswordReq);
    }

    public String getPasswordConfReqMsg() {
        return getTextFromElement(msgConfPasswordReq);
    }

}
