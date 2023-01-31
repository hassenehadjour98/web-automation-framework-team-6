package com.freecrmtest;

import base.CommonAPI;
import com.freecrm.AccountSettings;
import com.freecrm.AddUserPage;
import com.freecrm.HomePage;
import com.freecrm.MyAccountPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.GenerateData;

public class TestSetting extends CommonAPI {

    HomePage homePage;

    MyAccountPage myAccountPage;
    AccountSettings accountSettings;

    AddUserPage addUserPage;
    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    String validEmail = "dorina.cungu@gmail.com";
    String validPassword = "abcd1234";

    String firstName = GenerateData.firstName();
    String lastName = GenerateData.lastName();
    String email = GenerateData.email();
    String password = GenerateData.password();

    @Test
    public void testAddNewUser() throws InterruptedException {

        homePage = new HomePage(getDriver());
        myAccountPage = new MyAccountPage(getDriver());
        accountSettings = new AccountSettings(getDriver());
        addUserPage = new AddUserPage(getDriver());
        homePage.setInputEmail(validEmail);
        LOG.info("set email success");
        homePage.setInputPassword(validPassword);
        LOG.info("set password successful");
        homePage.clickOnLoginBtn();
        LOG.info("set login successful");
        Thread.sleep(1000);
        myAccountPage.clickOnSettingButton();
        LOG.info(" successful click on drop down");
        myAccountPage.clickSettingLinks("Settings");
        Thread.sleep(1000);
        accountSettings.clickOnSettingOption("User Manager");
        Thread.sleep(1000);
        accountSettings.clickOnAddUser();
        Thread.sleep(1000);
        addUserPage.typeFirstName(firstName);
        addUserPage.typeLastName(lastName);
        addUserPage.typeEmail(email);
        addUserPage.typePassword(password);
        addUserPage.typeConfirmPassword(password);
        addUserPage.clickOnSavingButton();
        System.out.println(addUserPage.getAllUsers());
        Assert.assertTrue(addUserPage.getAllUsers().contains(firstName+" "+lastName));
        //Thread.sleep(20000);


    }

}
