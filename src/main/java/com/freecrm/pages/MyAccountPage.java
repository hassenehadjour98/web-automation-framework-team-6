package com.freecrm.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAccountPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='ui basic button floating item dropdown']")
    WebElement settingButton;

    @FindBy(xpath = "//a[@role='option']")
    List<WebElement> settingLink;


    public void clickOnSettingButton(){
        clickOn(settingButton);
    }

    public void clickSettingLinks(String link){
        for(WebElement element : settingLink){     //if this element from the list equals to the txt that we pass as parameter
            if(element.getText().equalsIgnoreCase(link)){ //click on it
                clickOn(element);
                break;
            }
        }

    }


}
