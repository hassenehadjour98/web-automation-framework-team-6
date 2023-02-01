package orangehrm.project.tests;

import base.CommonAPI;
import com.github.javafaker.Faker;
import orangehrm.project.pages.AdminPage;
import orangehrm.project.pages.HomePage;
import orangehrm.project.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static orangehrm.project.tests.LoginPageTest.ValidPasswordOH;
import static orangehrm.project.tests.LoginPageTest.ValidUsernameOH;

public class AdminPageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(AdminPageTest.class.getName());
    String Field="Admin";
    Faker faker = new Faker();
    @Test
    public void ChangePasswordCheckBox(){
        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(ValidUsernameOH, ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        AdminPage adminpage = new AdminPage(getDriver());
        adminpage.typeUserName();
        adminpage.userRoleDropDown();
        adminpage.statusDropDown();
        adminpage.clickSearch();
        adminpage.clickOnEdit();

        Assert.assertTrue(adminpage.clickOnCheckBox());
        LOG.info("change password check box test finished");
    }
    @Test
    public void AddJobTitle() {
        String JobTitle= faker.job().title();  String Jobdescription = faker.weather().description();  String Note = faker.expression("This is Java faker");

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(ValidUsernameOH, ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        AdminPage adminpage = new AdminPage(getDriver());
        adminpage.jobTitleFromDropDown();
        adminpage.clickOnAddBtn();
        adminpage.typeJobTitle(JobTitle);
        adminpage.addJobDescription(Jobdescription);
        adminpage.typeNote(Note);
        adminpage.clickOnSave();

        String ActualResult1= adminpage.ToastMessage();
        Assert.assertEquals(ActualResult1, "Successfully Saved");
        LOG.info("Job Title successfully Added");
        LOG.info("Add Job Title test Finished");
    }

}
