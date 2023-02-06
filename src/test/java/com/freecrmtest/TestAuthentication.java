package com.freecrmtest;

import base.CommonAPI;

import com.freecrm.pages.HomePage;
import com.freecrm.pages.MyAccountPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ReadFromExcel;

import java.io.File;

public class TestAuthentication extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePage.class.getName());
    HomePage homePage;
    MyAccountPage myAccountPage;
    String path = System.getProperty("user.dir") + File.separator + "Data" + File.separator + "freecrm" + File.separator + "testdata.xlsx";
    ReadFromExcel read = new ReadFromExcel(path, "dorina");

    String validEmail = "dorina.cungu@gmail.com";
    String validPassword = "abcd1234";

    String invalidEmail = "dorina.cungu@yahoo.com";
    String invalidPassword = "abcd1235";
    /*
    1 _ open application with chrome
    2  type email
    3  type password
    4  click on log in
    5 validate that the title is Cogmento CRM




    */

    @Test
    public void testValidLogin()  {

        homePage = new HomePage(getDriver());
        String expectedTitle = "Cogmento CRM";

        homePage.setInputEmail(validEmail);
        LOG.info("set email success");
        homePage.setInputPassword(validPassword);
        LOG.info("set password successful");
        homePage.clickOnLoginBtn();
        LOG.info("set login successful");
        Assert.assertEquals(getCurrentTitle(), expectedTitle);


    }



    @Test
    public void testInvalidLogin() throws InterruptedException {
        String expectedError = "Something went wrong...";


        homePage = new HomePage(getDriver());
        homePage.setInputEmail(invalidEmail);
        LOG.info("set invalid email success");
        homePage.setInputPassword(invalidPassword);
        LOG.info("set invalid password successful");
        homePage.clickOnLoginBtn();
        LOG.info("set login successful");
        Assert.assertEquals(homePage.getErrorLogin(), expectedError);

    }
    //1 open the app with the chrome
    //2 type email
    //3 type password
    //4  click on log in
    //5 click on setting menu
    //6 click on log out link
    //7 validate the logout tittle

    @Test
    public void testLogout() throws InterruptedException {
        // first we need to login

        homePage = new HomePage(getDriver());
        myAccountPage = new MyAccountPage(getDriver());


        homePage.setInputEmail(validEmail);
        LOG.info("set email success");
        homePage.setInputPassword(validPassword);
        LOG.info("set password successful");
        homePage.clickOnLoginBtn();
        LOG.info("set login successful");
        myAccountPage.clickOnSettingButton();
        Thread.sleep(1000);
        myAccountPage.clickSettingLinks("Log Out");
       Assert.assertEquals(getCurrentTitle(),"Cogmento CRM");

    }


}

