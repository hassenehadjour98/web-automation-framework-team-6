package com.orangehrm.project.tests;

import base.CommonAPI;
import com.orangehrm.project.pages.BuzzPage;
import com.orangehrm.project.pages.HomePage;
import com.orangehrm.project.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utility.ReadFromExcel;

public class BuzzPageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(BuzzPageTest.class.getName());
    SoftAssert SoftAssert = new SoftAssert();

    ReadFromExcel readfromexcel = new ReadFromExcel("./Data/orangehrm/OrangeHRM.xlsx","BuzzPage");
    String Field = readfromexcel.getDataFromCell(6,5);

    String PostText="Enjoy The Beautiful Nature";


    @Test(enabled = false)
    public void PostAnImage(){
        String filePath = "./Data/orangehrm/BuzzPageTest.png";
        String ToastMessage = readfromexcel.getDataFromCell(12,5);

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(LoginPageTest.ValidUsernameOH, LoginPageTest.ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualMenuField =homepage.FieldConfirmation();
        String ExpectedMenuField= Field.toLowerCase();

        SoftAssert.assertEquals(ActualMenuField,ExpectedMenuField);

        BuzzPage buzzpage = new BuzzPage(getDriver());
        buzzpage.clickOnSharePhotosButton();
        buzzpage.typeText(PostText);
        buzzpage.uploadImage(filePath);
        buzzpage.clickOnShareBtn();

        String ActualMessage= buzzpage.toastMessage();
        String ExpectedMessage= ToastMessage;

        Assert.assertEquals(ActualMessage, ExpectedMessage);

        LOG.info("Test PostAnImage finished successfully");
    }
    @Test
    public void addCommentToMostRecentPost(){
        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(LoginPageTest.ValidUsernameOH, LoginPageTest.ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualMenuField =homepage.FieldConfirmation();
        String ExpectedMenuField= Field.toLowerCase();

        Assert.assertEquals(ActualMenuField, ExpectedMenuField);

        BuzzPage buzzpage = new BuzzPage(getDriver());
        buzzpage.clickOnMostRecentPost();
        buzzpage.clickOnCommentIcon();
        buzzpage.publishComment("Hello World");

        String Status = buzzpage.toastMessage();
        String ExpectedResult= "Success";

        Assert.assertEquals(Status, ExpectedResult);
        LOG.info("Test addCommentToMostRecentPost finished successfully");
    }

}

