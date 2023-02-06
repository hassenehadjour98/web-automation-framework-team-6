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

public class HomePage extends CommonAPI {
    public String UsernameOH = Utility.getProperties().getProperty("UsernameOH");
    Logger LOG = LogManager.getLogger(HomePage.class.getName());
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement admin;
    @FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper']")
    List<WebElement> optionsList;
    @FindBy(css = ".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module")
    WebElement FieldConfi;

    public void clickOnAdmin(){
        clickOn(admin);
        LOG.info("click Admin success");
    } // click on Admin
    public String FieldConfirmation(){
        String txt = FieldConfi.getText().toLowerCase();
        return txt;
    }
    public void clickOnMenuField(String Field){
        List<WebElement> list = optionsList;
        for (WebElement element : optionsList) {
            String FieldText = element.getText();
            if (FieldText.equalsIgnoreCase(Field)) {
                element.click();
                LOG.info("Click on "+Field+" successful");
                break;

            }
        }
    }
}


