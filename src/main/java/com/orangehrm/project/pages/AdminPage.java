package com.orangehrm.project.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Utility;

public class AdminPage extends CommonAPI {
    public String UsernameOH = Utility.getProperties().getProperty("UsernameOH");
    Logger LOG = LogManager.getLogger(AdminPage.class.getName());
    public AdminPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement userNameTxt;
    @FindBy(xpath = "(//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[text()='-- Select --'])[1]")
    WebElement userRoleDropDown;
    @FindBy(xpath = "//div[contains(text(),'-- Select --')]")//
    WebElement statusDropDown;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement SearchBtn;
    @FindBy(xpath = "(//button[@type='button'])/i[contains(@class, 'oxd-icon bi-pencil-fill')]")
    WebElement editBtn;
    @FindBy(css = ".oxd-icon.bi-check.oxd-checkbox-input-icon")
    WebElement passwordCheckBox;
    @FindBy(xpath= "//span[text()='Job ']")
    WebElement JobTitleDropDown;
    @FindBy(xpath="//a[text()='Job Titles']")
    WebElement JobTitle;
    @FindBy(xpath = "//div[@class='orangehrm-header-container']//button[@type='button']")
    WebElement AddBtn;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement JobTitleTxt;
    @FindBy(xpath = "//textarea[@placeholder='Type description here']")
    WebElement JobDescription;
    @FindBy(xpath = "//textarea[@placeholder='Add note']")
    WebElement Notetxt;
    @FindBy(xpath = "//button[text()=' Save ']")
    WebElement SaveBtn;
    @FindBy(xpath = "(//input[@type=\"checkbox\"])[2]")
    WebElement NewJobTitleCheckBox;
    @FindBy(xpath = "(//button[@type=\"button\"]/i[@class=\"oxd-icon bi-trash\"])[1]")
    WebElement DeleteBtn;
    @FindBy(xpath = "//button[text()=' Yes, Delete ']")
    WebElement YesDeleteBtn;
    @FindBy(xpath = "//p[text()='Success']")
    WebElement typeOfToastMsg;
    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    WebElement ToastMsgText;

    public void typeUserName(){
        type(userNameTxt, UsernameOH);
        LOG.info("text set to username");
    } // enter username
    public void userRoleDropDown(){
        clickOn(userRoleDropDown);
        userRoleDropDown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        LOG.info("Admin selected from dropdown");
    } // select Admin from UsersRole drop down
    public void statusDropDown(){
        clickOn(statusDropDown);
        statusDropDown.sendKeys(Keys.ARROW_DOWN, Keys.ESCAPE);
        LOG.info("Enable selected from dropdown");

    } // select enable from Status drop down
    public void clickSearch(){
        clickOn(SearchBtn);
        LOG.info("search button clicked");
    } // click search button
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
    public void jobTitleFromDropDown(){
        clickOn(JobTitleDropDown);
        clickOn(JobTitle);
        LOG.info("Job Titles is selected from JobDropDown");
    }//handel Job dropdown //select JobTitles
    public void clickOnAddBtn(){
       clickOn(AddBtn);
       LOG.info("Add button clicked");
    }//click on Add button
    public void typeJobTitle(String JobTitle){
        type(JobTitleTxt, JobTitle);
        LOG.info("JobTitle text typed");
    }//type job title
    public void addJobDescription(String Jobdescription){
        type(JobDescription, Jobdescription);
        LOG.info("Job description text typed");
    }//type job description
    public void typeNote(String Note){
        type(Notetxt, Note);
        LOG.info("Note text typed");
    }//type a note
    public void clickOnSave(){
        clickOn(SaveBtn);
        LOG.info("Save button clicked");
    }//click on save
    public void deleteTheCreatedJobTitle(String JobTitle){
        clickOn(DeleteBtn);
        clickOn(YesDeleteBtn);
        LOG.info("Delete button clicked");
    } // delete the created job title
    public String ToastMessage(){
        String message=getTextFromElement(ToastMsgText);
        LOG.info("Toast message captured");
        return message;
    }// step confirmation with toast message
}
