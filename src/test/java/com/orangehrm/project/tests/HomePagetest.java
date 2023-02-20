package com.orangehrm.project.tests;

import base.CommonAPI;
import com.orangehrm.project.pages.HomePage;
import com.orangehrm.project.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ReadFromExcel;

public class HomePagetest extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    ReadFromExcel readfromexcel = new ReadFromExcel("./Data/orangehrm/OrangeHRM.xlsx","HomePage");


    @Test(priority = 0, invocationCount = 1)
    public void AdminFromMenu(){
        String Field = readfromexcel.getDataFromCell(7,5);

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(LoginPageTest.ValidUsernameOH, LoginPageTest.ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Admin exist on the main menu and it is clickable --AdminFromMenu test--successfully finished");
    }
    @Test(priority = 1, dependsOnMethods ={"AdminFromMenu"} )
    public void PIMFromMenu(){
        String Field = readfromexcel.getDataFromCell(9,5);

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(LoginPageTest.ValidUsernameOH, LoginPageTest.ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("PIM exist on the main menu and it is clickable --PIMFromMenu test--successfully finished");
    }
    @Test(priority = 2)
    public void LeaveFromMenu(){
        String Field = readfromexcel.getDataFromCell(11,5);

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(LoginPageTest.ValidUsernameOH, LoginPageTest.ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Leave exist on the main menu and it is clickable --LeaveFromMenu test-- successfully finished");
    }
    @Test(priority = 3)
    public void TimeFromMenu() {
        String Field = readfromexcel.getDataFromCell(13,5);

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(LoginPageTest.ValidUsernameOH, LoginPageTest.ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Time exist on the main menu and it is clickable --TimeFromMenu test-- successfully finished");
    }
    @Test(priority = 4)
    public void RecruitmentFromMenu() {
        String Field = readfromexcel.getDataFromCell(15,5);

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(LoginPageTest.ValidUsernameOH, LoginPageTest.ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Recruitment exist on the main menu and it is clickable --RecruitmentFromMenu test-- successfully finished");
    }
    @Test(priority = 6)
    public void PerformanceFromMenu() {
        String Field = readfromexcel.getDataFromCell(17,5);

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(LoginPageTest.ValidUsernameOH, LoginPageTest.ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Performance exist on the main menu and it is clickable --PerformanceFromMenu test--successfully finished");
    }
    @Test(priority = 7)
    public void DashboardFromMenu() {
        String Field = readfromexcel.getDataFromCell(19,5);

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(LoginPageTest.ValidUsernameOH, LoginPageTest.ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Dashboard exist on the main menu and it is clickable --DashboardFromMenu test-- successfully finished");
    }
    @Test(priority = 8)
    public void DirectoryFromMenu() {
        String Field = readfromexcel.getDataFromCell(21,5);

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(LoginPageTest.ValidUsernameOH, LoginPageTest.ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Directory exist on the main menu and it is clickable, test DirectoryFromMenu successfully finished");
    }
    @Test(priority = 10)
    public void BuzzFromMenu() {
        String Field = readfromexcel.getDataFromCell(23,5);

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(LoginPageTest.ValidUsernameOH, LoginPageTest.ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Buzz exist on the main menu and it is clickable --BuzzFromMenu test-- Finished");
    }
}
