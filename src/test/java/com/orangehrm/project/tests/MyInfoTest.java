package com.orangehrm.project.tests;

import base.CommonAPI;
import com.orangehrm.project.pages.HomePage;
import com.orangehrm.project.pages.LoginPage;
import com.orangehrm.project.pages.MyInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ReadFromExcel;

public class MyInfoTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(MyInfoTest.class.getName());

    ReadFromExcel readfromexcel = new ReadFromExcel("./Data/orangehrm/OrangeHRM.xlsx","MyInfoPage");
    String Field=readfromexcel.getDataFromCell(7,5);

    @Test
    public void selectBloodType(){

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(LoginPageTest.ValidUsernameOH, LoginPageTest.ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        MyInfo myinfo = new MyInfo(getDriver());

        myinfo.selectBloodType();

        String ActualResult= myinfo.ToastMessage();
        String ExpectedResult = readfromexcel.getDataFromCell(10,5);

        Assert.assertEquals(ActualResult,ExpectedResult);

        LOG.info("Test selectBloodType finished successfully");
    }

}
