package com.orangehrm.project.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfo extends CommonAPI {
    Logger LOG = LogManager.getLogger(MyInfo.class.getName());
    public MyInfo(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='My Info']")
    WebElement MyInfo;
    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[3]")
    WebElement BloodType;
    @FindBy(xpath = "//span[text()='O+']")
    WebElement Opositivetype;
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    WebElement SaveBtn;
    @FindBy(xpath = "//p[text()='Success']")
    WebElement ToastMsgText;


    public void selectBloodType(){
        if(BloodType.getText().equalsIgnoreCase("O+")){
            clickOn(SaveBtn);
            LOG.info("blood type already selected as O+");
        }else {
            clickOn(BloodType);
            clickOn(Opositivetype);
            clickOn(SaveBtn);
            LOG.info("blood type successfully selected and saved");
        }
    } //select O+ from blood type drop down and click on save


    public String ToastMessage(){
        String message = getTextFromElement(ToastMsgText);
        LOG.info("Toast message captured");
        return message;
    }// catch success message for confirmation




}
