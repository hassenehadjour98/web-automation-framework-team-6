package orangehrm.project.tests;

import base.CommonAPI;
import orangehrm.project.pages.AdminPage;
import orangehrm.project.pages.HomePage;
import orangehrm.project.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminPageTest extends CommonAPI {
    @Test
    public void changepasswordcheckbox() throws InterruptedException {
        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.logIn();

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnAdmin();

        AdminPage adminpage = new AdminPage(getDriver());
        adminpage.typeUserName();
        adminpage.userRoleDropDown();
        adminpage.statusDropDown();
        adminpage.clickSearch();
        adminpage.clickOnEdit();
        adminpage.clickOnCheckBox();

        Assert.assertTrue(adminpage.clickOnCheckBox());
    }
    @Test
    public void addThenDeleteJobTitle() throws InterruptedException {
        String JobTitle= "abcdeftest";  String Jobdescription = "abcdeftest";  String Note = "abcdeftest";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.logIn();

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnAdmin();

        AdminPage adminpage = new AdminPage(getDriver());
        adminpage.jobTitleFromDropDown();
        adminpage.clickOnAddBtn();
        adminpage.typeJobTitle(JobTitle);
        adminpage.addJobDescription(Jobdescription);
        adminpage.typeNote(Note);
        adminpage.clickOnSave();
        adminpage.deleteTheCreatedJobTitle();
    }
}
