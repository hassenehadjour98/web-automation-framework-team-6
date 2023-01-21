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
    @Test
    public void changepasswordcheckbox() throws InterruptedException {
        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.logIn();

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnAdmin();
        homepage.typeUserName();
        homepage.userRoleDropDown();
        homepage.statusDropDown();
        homepage.clickSearch();
        homepage.clickOnEdit();
        homepage.clickOnCheckBox();

        Assert.assertTrue(homepage.clickOnCheckBox());
    }


}
