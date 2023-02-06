package orangehrm.project.tests;

import base.CommonAPI;
import com.github.javafaker.Faker;
import com.orangehrm.project.pages.AdminPage;
import com.orangehrm.project.pages.HomePage;
import com.orangehrm.project.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static orangehrm.project.tests.LoginPageTest.ValidPasswordOH;
import static orangehrm.project.tests.LoginPageTest.ValidUsernameOH;

public class AdminPageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(AdminPageTest.class.getName());
    String Field="Admin";
    static Faker faker = new Faker();
    protected static String JobTitle= faker.job().title();
    protected static String Jobdescription = faker.weather().description();
    protected static String Note = faker.expression("This is Java faker");
    
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
    @DataProvider(name = "Add a job title")
    public Object[][] getData(){
        Object[][] data={
                {JobTitle, Jobdescription, Note}
        };return data;
    }
    @Test(dataProvider = "Add a job title")
    public void AddJobTitle(String JobTitle, String Jobdescription, String Note) {
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
