package orangehrm.project.tests;

import base.CommonAPI;
import orangehrm.project.pages.AdminPage;
import orangehrm.project.pages.HomePage;
import orangehrm.project.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminPageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(AdminPageTest.class.getName());
    @Test
    public void changePasswordCheckBox(){
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
        LOG.info("change password check box test finished");
    }
    @Test
    public void addThenDeleteJobTitle() {
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

        String Actualresult1= adminpage.ToastMessage();
        Assert.assertEquals(Actualresult1, "Successfully Saved");

        adminpage.deleteTheCreatedJobTitle();

        String Actualresult2= adminpage.ToastMessage();
        Assert.assertEquals(Actualresult2, "Successfully Deleted");
        LOG.info("add Then Delete a Job Title test Finished");
    }

}
