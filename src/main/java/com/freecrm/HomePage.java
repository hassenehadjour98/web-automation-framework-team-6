package com.freecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonAPI {

    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@name='email']")
    WebElement inputEmail;

   @FindBy(xpath = "//input[@name='password']")
    WebElement inputPassword;

   @FindBy(xpath = "//div[text()='Login']")
    WebElement loginBtn;

    @FindBy(xpath = "//div[text()='Something went wrong...']")
    WebElement errorLogin;



   public void setInputEmail(String email){
       type(inputEmail, email);
   }

   public void setInputPassword(String password){
       type(inputPassword, password);
   }
   public void clickOnLoginBtn(){
       clickOn(loginBtn);
    }

   public String getErrorLogin(){
      return getTextFromElement(errorLogin);
   }



}
