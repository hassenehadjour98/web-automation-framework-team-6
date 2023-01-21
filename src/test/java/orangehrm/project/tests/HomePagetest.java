package orangehrm.project.tests;

import base.CommonAPI;
import orangehrm.project.pages.HomePage;
import orangehrm.project.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePagetest extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    @Test(priority = 0, invocationCount = 1)
    public void AdminFromMenu(){
        String Field = "admin";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.logIn();

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Admin exist on the main menu and it is clickable --AdminFromMenu test-- Finished");
    }
    @Test(priority = 1, dependsOnMethods ={"AdminFromMenu"} )
    public void PIMFromMenu(){
        String Field = "PIM";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.logIn();

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("PIM exist on the main menu and it is clickable --PIMFromMenu test-- Finished");
    }
    @Test(priority = 2)
    public void LeaveFromMenu(){
        String Field = "Leave";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.logIn();

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Leave exist on the main menu and it is clickable --LeaveFromMenu test-- Finished");
    }
    @Test(priority = 3)
    public void TimeFromMenu() {
        String Field = "Time";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.logIn();

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Time exist on the main menu and it is clickable --TimeFromMenu test-- Finished");
    }
    @Test(priority = 4)
    public void RecruitmentFromMenu() {
        String Field = "Recruitment";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.logIn();

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Recruitment exist on the main menu and it is clickable --RecruitmentFromMenu test-- Finished");
    }
    @Test(priority = 6)
    public void PerformanceFromMenu() {
        String Field = "Performance";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.logIn();

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Performance exist on the main menu and it is clickable --PerformanceFromMenu test-- Finished");
    }
    @Test(priority = 7)
    public void DashboardFromMenu() {
        String Field = "Dashboard";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.logIn();

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Dashboard exist on the main menu and it is clickable --DashboardFromMenu test-- Finish");
    }
    @Test(priority = 8)
    public void DirectoryFromMenu() {
        String Field = "Directory";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.logIn();

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Directory exist on the main menu and it is clickable");
    }
    @Test(priority = 10)
    public void BuzzFromMenu() {
        String Field = "Buzz";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.logIn();

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        String ActualHeadlight = homepage.FieldConfirmation().toLowerCase();
        String ExpectedHeadlight = Field.toLowerCase();

        Assert.assertEquals(ActualHeadlight, ExpectedHeadlight);
        LOG.info("Buzz exist on the main menu and it is clickable --BuzzFromMenu test-- Finished");
    }
}
