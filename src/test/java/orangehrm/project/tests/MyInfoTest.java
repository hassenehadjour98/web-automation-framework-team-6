package orangehrm.project.tests;

import base.CommonAPI;
import com.orangehrm.project.pages.HomePage;
import com.orangehrm.project.pages.LoginPage;
import com.orangehrm.project.pages.MyInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static orangehrm.project.tests.LoginPageTest.ValidPasswordOH;
import static orangehrm.project.tests.LoginPageTest.ValidUsernameOH;

public class MyInfoTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(MyInfoTest.class.getName());

    String Field = "My Info";

    @Test
    public void selectBloodType(){

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(ValidUsernameOH, ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Field);

        MyInfo myinfo = new MyInfo(getDriver());

        myinfo.selectBloodType();

        String ActualResult= myinfo.ToastMessage();
        String ExpectedResult = "Success";

        Assert.assertEquals(ActualResult,ExpectedResult);
        LOG.info("Test selectBloodType finished successfully");
    }

}
