package orangehrm.project.tests;

import base.CommonAPI;
import orangehrm.project.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        LoginPage loginpage = new LoginPage(getDriver());
        String Actualresult = loginpage.ResetPassword();
        String Expectedresult = "Reset Password link sent successfully";

        Assert.assertEquals(Actualresult, Expectedresult);
    }





}
