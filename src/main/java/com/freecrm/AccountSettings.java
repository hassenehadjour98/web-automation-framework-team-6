package com.freecrm;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSettings extends CommonAPI {
    public AccountSettings(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='right menu']/a")
    List<WebElement> settingLink;
    @FindBy(xpath = "//a[@href='/settings/user/']")
    WebElement addUserBtn;


    public void clickOnSettingOption(String button) {
        for (WebElement element : settingLink)
            if (element.getText().equalsIgnoreCase(button)) {
                clickOn(element);
                break;
            }
    }
    public void clickOnAddUser(){
        clickOn(addUserBtn);
    }
}