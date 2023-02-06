package com.freecrm.pages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AddUserPage extends CommonAPI {
    public AddUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //WebElement
    @FindBy(name = "first_name")
    WebElement inputFirstName;

    @FindBy(name = "last_name")
    WebElement inputLastName;

    @FindBy(name = "email")
    WebElement inputEmail;

    @FindBy(name = "password")
    WebElement inputPassword;

    @FindBy(name = "password_confirm")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@class='ui linkedin small button']")
    WebElement saveButton;

    @FindBy(xpath = "//tbody/tr//td[2]//a")
    List<WebElement> users;


    public void typeFirstName(String firstName) {
        type(inputFirstName, firstName);
    }

    public void typeLastName(String lastName) {
        type(inputLastName, lastName);

    }
    public void typeEmail(String email){
        type(inputEmail,email);
    }
    public void typePassword(String password){
        type(inputPassword,password);
    }
    public void typeConfirmPassword(String password){
       type(confirmPassword,password);
    }

    public void clickOnSavingButton(){
        clickOn(saveButton);
    }
    public List<String> getAllUsers(){
        List<String> allUsers = new ArrayList<>();
        for(WebElement element : users){
            allUsers.add(element.getText());
        }
        return allUsers;
    }
}
