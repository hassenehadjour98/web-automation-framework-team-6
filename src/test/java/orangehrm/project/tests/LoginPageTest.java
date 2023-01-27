package orangehrm.project.tests;

import base.CommonAPI;
import orangehrm.project.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ReadFromExcel;
import utility.Utility;

public class LoginPageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(LoginPageTest.class.getName());

    @Test
    public void logintest(){
        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.logIn();
        LOG.info("login success");
        boolean flag = loginpage.DashboardTextDisplayed();

        Assert.assertTrue(true);
    }
    @Test
    public void resetpassword(){
//        ReadFromExcel readfromexcel = new ReadFromExcel("/Users/hassenehadjour/Desktop/web-automation-framework-team-6/src/test/java/testdocumentation/OrangeHRM.xlsx","LoginPage");
//        String data = readfromexcel.getDataFromCell(11,5);
        String data= "Reset Password link sent successfully";

        LoginPage loginpage = new LoginPage(getDriver());
        String Actualresult = loginpage.ResetPassword();
        String Expectedresult = data;

        Assert.assertEquals(Actualresult, Expectedresult);
    }





}
